package browserHelper

import groovy.json.JsonSlurper

import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.http.util.EntityUtils
import org.jsoup.Jsoup

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import io.restassured.path.xml.XmlPath as XmlPath
import io.restassured.path.xml.XmlPath.CompatibilityMode as CompatibilityMode
import jdk.nashorn.internal.runtime.regexp.joni.Regex

class Users {

	TestData environmentData = findTestData('Data Files/Environment')
	TestData usersData;




	@Keyword
	public String GetUrl(){

		return environmentData.getValue(GlobalVariable.environment, 1)
	}

	@Keyword
	public String GetUser1(String institution){

		usersData = findTestData('Data Files/'+GlobalVariable.environment);

		for(int i=1; i<=usersData.getRowNumbers(); i++){
			if (usersData.getValue("Bank name", i).equalsIgnoreCase(institution)) {
				return usersData.getValue("User1", i)
			}
		}
	}

	@Keyword
	public String GetUser2(String institution){

		usersData = findTestData('Data Files/'+GlobalVariable.environment);

		for(int i=1; i<=usersData.getRowNumbers(); i++){
			if (usersData.getValue("Bank name", i).equalsIgnoreCase(institution)) {
				return usersData.getValue("User2", i)
			}
		}
	}


	@Keyword
	public String Get4thUser(String institution){

		usersData = findTestData('Data Files/'+GlobalVariable.environment);

		for(int i=1; i<=usersData.getRowNumbers(); i++){
			if (usersData.getValue("Bank name", i).equalsIgnoreCase(institution)) {
				return usersData.getValue("User4", i)
			}
		}
	}


	@Keyword
	public String Get4thPassword(String institution){

		//		usersData = findTestData('Data Files/'+GlobalVariable.environment+' Data');
		usersData = findTestData('Data Files/'+GlobalVariable.environment)

		for(int i=1; i<=usersData.getRowNumbers(); i++){
			if (usersData.getValue("Bank name", i).equalsIgnoreCase(institution)) {
				return usersData.getValue("Password4", i)
			}
		}
	}


	@Keyword
	public String GetUser1Password(String institution){

		//		usersData = findTestData('Data Files/'+GlobalVariable.environment+' Data');
		usersData = findTestData('Data Files/'+GlobalVariable.environment)

		for(int i=1; i<=usersData.getRowNumbers(); i++){
			if (usersData.getValue("Bank name", i).equalsIgnoreCase(institution)) {
				return usersData.getValue("Password1", i)
			}
		}
	}

	@Keyword
	public String GetUser2Password(String institution){

		usersData = findTestData('Data Files/'+GlobalVariable.environment);

		for(int i=1; i<=usersData.getRowNumbers(); i++){
			if (usersData.getValue("Bank name", i).equalsIgnoreCase(institution)) {
				return usersData.getValue("Password2", i)
			}
		}
	}


	@Keyword
	public void Login(String inst, String user){

		String username = "";
		String password = "";
		switch (user.toLowerCase()){

			case "primary":
				username = GetUser1(inst)
				password = GetUser1Password(inst)
				break;
			case "secondary":
				username = GetUser2(inst)
				password = GetUser2Password(inst)
				break;

			case "4th":
				username = Get4thUser(inst)
				password = Get4thPassword(inst)
				break;
			default:
				username = GetUser1(inst)
				password = GetUser1Password(inst)
				break;

		}

		try {
			WebUI.verifyElementNotPresent(findTestObject('Object Repository/QA/Page_Landing/link_UseAnotherAccount'), 5)

		}

		catch (Exception e)

		{
			WebUI.click(findTestObject('Object Repository/QA/Page_Landing/link_UseAnotherAccount'))
		}

		WebUI.waitForElementVisible(findTestObject('QA/Page_Login/input_Username'), 5)

		WebUI.clearText(findTestObject('QA/Page_Login/input_Username'), FailureHandling.STOP_ON_FAILURE)

		WebUI.sendKeys(findTestObject('QA/Page_Login/input_Username'),username)

		WebUI.clearText(findTestObject('QA/Page_Login/input_Password'), FailureHandling.STOP_ON_FAILURE)

		WebUI.sendKeys(findTestObject('QA/Page_Login/input_Password'),password)

		WebUI.click(findTestObject('QA/Page_Login/button_SignIn'))

		WebUI.verifyElementVisible(findTestObject('QA/Page_Login/Page_TwoFactorAuthencation/button_Verify'))

		//String code = CustomKeywords.'browserHelper.TOTP.getCode'(findTestData(GlobalVariable.environment).getValue('User1', 1), findTestData(GlobalVariable.environment).getValue('Password1',1))

		def code =getCode(username, password)

		WebUI.maximizeWindow(FailureHandling.STOP_ON_FAILURE)

		WebUI.waitForElementVisible(findTestObject('Object Repository/QA/Page_Login/Page_TwoFactorAuthencation/input_AuthenticationCode'),
				5)

		WebUI.sendKeys(findTestObject('Object Repository/QA/Page_Login/Page_TwoFactorAuthencation/input_AuthenticationCode'), code)

		WebUI.click(findTestObject('Object Repository/QA/Page_Login/Page_TwoFactorAuthencation/button_Verify'))

		WebUI.verifyElementPresent(findTestObject('Object Repository/QA/Page_Landing/link_SignOut'), 5)

	}


	@Keyword
	public String getCode(String username, String password){

		RequestObject reqObj = findTestObject('HTTP Methods/CodeRequest');

		reqObj.setRestUrl("https://telper-"+ GlobalVariable.environment +".cbinfrastructure.com/InstitutionTotpGenerator");

		List<TestObjectProperty> params = new ArrayList<>();

		params.add(new TestObjectProperty('Username',ConditionType.EQUALS, username));
		params.add(new TestObjectProperty('Password',ConditionType.EQUALS, password));
		reqObj.setRestParameters(params);

		def response = WS.sendRequest(reqObj);

		//def fullText = Jsoup.parse(response.getResponseText()).toString()

		XmlPath xmlPath = new XmlPath(CompatibilityMode.HTML, response.getResponseText());

		String code = xmlPath.getString("html.body.div[1].div[0].div[0].div[0].h1[1].text()");

		return code.substring(code.length() - 8);
	}
}
