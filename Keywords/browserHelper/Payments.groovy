package browserHelper

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class Payments {

	WebDriver driver = DriverFactory.getWebDriver()
	WebDriverWait wait = new WebDriverWait(driver, 15)



	private String GetLeftValues(String sortcode){

		return sortcode.substring(0,2)
	}

	private String GetMiddleValues(String sortcode ){

		return sortcode.substring(2,4)
	}

	private String GetRightValues(String sortcode ){

		return sortcode.substring(4,6)
	}

	@Keyword
	public void SetCreditorSortCode(int row, String sortcode){

		WebElement SCLeft=null;
		WebElement SCMiddle =null;
		WebElement SCRight = null;


		if (driver.findElement(By.xpath("//form[@class='el-form u-space--m']")).displayed) {

			SCLeft = driver.findElement(By.xpath("//form[@class='el-form u-space--m']/div[" + row.toString() +"]//div[@class='sort-code']/div[1]//input"));
			SCMiddle = driver.findElement(By.xpath("//form[@class='el-form u-space--m']/div[" + row.toString() +"]//div//div[@class='sort-code']/div[2]//input"));
			SCRight = driver.findElement(By.xpath("//form[@class='el-form u-space--m']/div[" + row.toString() +"]//div[@class='sort-code']/div[3]//input"));
		}


		SCLeft.sendKeys(GetLeftValues(sortcode))

		SCMiddle.sendKeys(GetMiddleValues(sortcode))

		SCRight.sendKeys(GetRightValues(sortcode))
	}


	@Keyword
	public void SetIndividualSortCode(String sortcode){

		WebElement SCLeft = driver.findElement(By.xpath("//label[text()='Individual Sort Code']/following-sibling::div//div[@class='sort-code']/div[1]//input"));
		SCLeft.sendKeys(GetLeftValues(sortcode))

		WebElement SCMiddle = driver.findElement(By.xpath("//label[text()='Individual Sort Code']/following-sibling::div//div[@class='sort-code']/div[2]//input"));
		SCMiddle.sendKeys(GetMiddleValues(sortcode))

		WebElement SCRight = driver.findElement(By.xpath("//label[text()='Individual Sort Code']/following-sibling::div//div[@class='sort-code']/div[3]//input"));
		SCRight.sendKeys(GetRightValues(sortcode))
	}

	@Keyword
	public void SetOrganisationSortCode(String sortcode){

		WebElement SCLeft = driver.findElement(By.xpath("//label[text()='Organisation Sort Code']/following-sibling::div//div[@class='sort-code']/div[1]//input"));
		SCLeft.sendKeys(GetLeftValues(sortcode))

		WebElement SCMiddle = driver.findElement(By.xpath("//label[text()='Organisation Sort Code']/following-sibling::div//div[@class='sort-code']/div[2]//input"));
		SCMiddle.sendKeys(GetMiddleValues(sortcode))

		WebElement SCRight = driver.findElement(By.xpath("//label[text()='Organisation Sort Code']/following-sibling::div//div[@class='sort-code']/div[3]//input"));
		SCRight.sendKeys(GetRightValues(sortcode))
	}



	@Keyword
	public void EnterPayment(int row = 1, String accountHolderName = "Holder", String sortcode="200318", String accountNumber="10000001", String amount = "5.00", String reference="Payment Reference"){



		if (row > 1) {

			WebUI.click(findTestObject('Object Repository/QA/5. Page_Institution/Accounts/button_AddCreditor'))
		}


		if (row%10 == 1 ) {

			WebUI.waitForElementNotVisible(findTestObject('Object Repository/QA/5. Page_Institution/Page_Users/button_CreateUser'), 5)
		}

		if (row > 10) {

			row = row%10

			if (row == 0) {

				row = 10;
			}
		}

		//Account Holder Name
		By accountHolderTextbox = By.xpath("//form[@class='el-form u-space--m']/div[" + row.toString() + "]//input[@placeholder='Account Holder Name']");
		WebElement accountHolderTextboxElement = driver.findElement(accountHolderTextbox)
		accountHolderTextboxElement.sendKeys(accountHolderName)

		//Sort Code
		SetCreditorSortCode(row, sortcode)

		//Account Number
		By accountNumberTextbox = By.xpath("//form[@class='el-form u-space--m']/div[" + row.toString() + "]//input[@placeholder='Account Number']");
		WebElement accountNumberTextboxElement = driver.findElement(accountNumberTextbox)
		accountNumberTextboxElement.sendKeys(accountNumber)

		//Amount
		By amountTextbox = By.xpath("//form[@class='el-form u-space--m']/div[" + row.toString() + "]//input[@placeholder='Amount']");
		WebElement amountTextboxElement = driver.findElement(amountTextbox)
		amountTextboxElement.sendKeys(amount)

		//Reference
		By referenceTextbox = By.xpath("//form[@class='el-form u-space--m']/div[" + row.toString() + "]//input[@placeholder='Reference']");
		WebElement referenceTextboxElement = driver.findElement(referenceTextbox)
		referenceTextboxElement.sendKeys(reference)

	}

	@Keyword
	public void PreviousPaymentTemplateAction(String action){
		
		
		WebUI.waitForElementNotVisible(findTestObject('Object Repository/QA/loading_Mask'), 5)
		
		By locator = null;
		WebElement  ele = null;
		
		switch(action.toLowerCase()){
			
			case "close":
				locator = By.xpath("//span[text()='Welcome Back']/following-sibling::button");
			  break;
			  
			case "discard":
				locator = By.xpath("//span[text()='" +  action + "']/parent::button");
			  break;
			  
			case "resume":
				locator = By.xpath("//span[text()='" +  action + "']/parent::button");
			  break;
		}
		
		
		ele = driver.findElement(locator)
		wait.until(ExpectedConditions.elementToBeClickable(ele))
		
		ele.click()		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator))
	
	}
}
