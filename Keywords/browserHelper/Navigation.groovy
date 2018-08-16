package browserHelper

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.junit.After
import org.openqa.selenium.By

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

class Navigation {

	WebDriver driver = DriverFactory.getWebDriver()
	WebDriverWait wait = new WebDriverWait(driver, 10)

	@Keyword
	public void NavigateToAccount(String accoundId){

		WebUI.waitForElementNotVisible(findTestObject('Object Repository/QA/loading_Mask'), 5);

		WebUI.navigateToUrl("https://institution-" + GlobalVariable.environment + ".clearbank.co.uk/#/institution/accounts/" + accoundId)
	}

	@Keyword
	public void SelectSideMenu(String sideMenu){

		WebUI.waitForElementNotVisible(findTestObject('Object Repository/QA/loading_Mask'), 5);

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='"+ sideMenu +"']")))
		element.click()
	}


	@Keyword
	public void SelectSideLink(String sideLink){
		//return sideMenu

		//click on side menu specified in the parameter
		WebUI.waitForElementNotVisible(findTestObject('Object Repository/QA/loading_Mask'), 5);


		//		obj.addProperty("xpath",ConditionType.EQUALS,"//a[contains(text(),'" + sideLink + "')]")

		List<WebElement> elements = driver.findElements(By.xpath("//a[contains(text(),'" + sideLink + "')]"))
		for (WebElement element in elements) {
			if (element.displayed) {
				wait.until(ExpectedConditions.elementToBeClickable(element))
				element.click();
			}
		}

	}
	
	@Keyword
	public void NavigateToInterestProductManagementPage(){
		
		
		SelectSideMenu("Treasury Management")
		
		WebUI.waitForElementVisible(findTestObject('Object Repository/QA/Page_TreasuryManagement/link_InterestProductManagement'), 5)
		WebUI.waitForElementClickable(findTestObject('Object Repository/QA/Page_TreasuryManagement/link_InterestProductManagement'), 5)
		WebUI.click(findTestObject('Object Repository/QA/Page_TreasuryManagement/link_InterestProductManagement'))
		
	
	}
	@Keyword
	public void NavigateToInterestRateManagementPage(){
		
		
		SelectSideMenu("Treasury Management")
		
		WebUI.waitForElementVisible(findTestObject('Object Repository/QA/Page_TreasuryManagement/link_InterestRateManagement'), 5)
		WebUI.waitForElementClickable(findTestObject('Object Repository/QA/Page_TreasuryManagement/link_InterestRateManagement'), 5)
		WebUI.click(findTestObject('Object Repository/QA/Page_TreasuryManagement/link_InterestRateManagement'))
		
	}
	
	@Keyword
	public void NavigateToTreasuryDashboard(){
		
		SelectSideMenu("Treasury")

		WebUI.waitForElementVisible(findTestObject('QA/2. Page_Treasury/link_TreasuryDashboard'), 5)
		WebUI.waitForElementClickable(findTestObject('QA/2. Page_Treasury/link_TreasuryDashboard'), 5)
		WebUI.click(findTestObject('QA/2. Page_Treasury/link_TreasuryDashboard'))

	}

	@Keyword
	public void  NavigateToActiveThrottlingPage(){

		SelectSideMenu("Admin")

		WebUI.waitForElementVisible(findTestObject('QA/3. Page_Admin/link_ActiveThrottlings'), 5)
		WebUI.waitForElementClickable(findTestObject('QA/3. Page_Admin/link_ActiveThrottlings'), 5)
		WebUI.click(findTestObject('QA/3. Page_Admin/link_ActiveThrottlings'))

		SelectSideMenu("Admin")
	}

	@Keyword
	public void  NavigateToOnboardingPage(){https://institution-qa.clearbank.co.uk/#/admin/four-eye/permissions

		SelectSideMenu("Admin")
		TestObject obj = findTestObject('QA/3. Page_Admin/link_InstitutionOnboarding')

		WebUI.waitForElementVisible(obj, 5)
		WebUI.waitForElementClickable(findTestObject('QA/3. Page_Admin/link_InstitutionOnboarding'), 5)
		WebUI.click(findTestObject('QA/3. Page_Admin/link_InstitutionOnboarding'))
		SelectSideMenu("Admin")
	}

	@Keyword
	public void  Navigate4EyeCheckPermissionPage(){
		SelectSideMenu("Admin")

		WebUI.waitForElementVisible(findTestObject('QA/3. Page_Admin/link_FourEyeCheck'), 5)
		WebUI.waitForElementClickable(findTestObject('QA/3. Page_Admin/link_FourEyeCheck'), 5)
		WebUI.click(findTestObject('QA/3. Page_Admin/link_FourEyeCheck'))

		WebUI.waitForElementVisible(findTestObject('QA/3. Page_Admin/Page_FourEyeCheck/link_Permissions'), 4)
		WebUI.waitForElementClickable(findTestObject('QA/3. Page_Admin/Page_FourEyeCheck/link_Permissions'), 4)
		WebUI.click(findTestObject('QA/3. Page_Admin/Page_FourEyeCheck/link_Permissions'))
		SelectSideMenu("Admin")

	}



	//Navigating CRM pages

	@Keyword
	public void  NavigateToCRMInstitutionsPage(){

		SelectSideMenu("CRM")

		WebUI.waitForElementVisible(findTestObject('QA/4. Page_CRM/link_Institutions'), 5)
		WebUI.waitForElementClickable(findTestObject('QA/4. Page_CRM/link_Institutions'), 5)
		WebUI.click(findTestObject('QA/4. Page_CRM/link_Institutions'))
		SelectSideMenu("CRM")
	}

	@Keyword
	public void  NavigateToCRMQueryPage(){

		SelectSideMenu("CRM")

		WebUI.waitForElementVisible(findTestObject('QA/4. Page_CRM/input_Query'), 5)
		WebUI.waitForElementClickable(findTestObject('QA/4. Page_CRM/input_Query'), 5)
		WebUI.click(findTestObject('QA/4. Page_CRM/input_Query'))
		SelectSideMenu("CRM")
	}


	//Navigating to Institution pages

	@Keyword
	public void NavigateToDeviceSoftwarePage(){

		SelectSideMenu("Institution")

		WebUI.waitForElementVisible(findTestObject('QA/5. Page_Institution/link_DeviceSoftware'), 5)
		WebUI.waitForElementClickable(findTestObject('QA/5. Page_Institution/link_DeviceSoftware'), 5)
		WebUI.click(findTestObject('QA/5. Page_Institution/link_DeviceSoftware'))

		SelectSideMenu("Institution")
	}
	@Keyword
	public void NavigateToCertificateAndTokenPage(){
		SelectSideMenu("Institution")

		WebUI.waitForElementVisible(findTestObject('QA/link_CertificateAndToken'), 5)
		WebUI.waitForElementClickable(findTestObject('QA/link_CertificateAndToken'), 5)
		WebUI.click(findTestObject('QA/link_CertificateAndToken'))
		SelectSideMenu("Institution")
	}
	@Keyword
	public void NavigateToEarmarkingPage(){

		SelectSideMenu("Institution")

		WebUI.waitForElementVisible(findTestObject('QA/5. Page_Institution/link_Earmarking'), 5)
		WebUI.waitForElementClickable(findTestObject('QA/5. Page_Institution/link_Earmarking'), 5)
		WebUI.click(findTestObject('QA/5. Page_Institution/link_Earmarking'))

		WebUI.refresh()
		//		SelectSideMenu("Institution")
	}
	@Keyword
	public void NavigateToInstitutionAccountsPage(){

		SelectSideMenu("Institution")

		WebUI.waitForElementVisible(findTestObject('QA/5. Page_Institution/link_InstitutionAccounts'), 5)
		WebUI.waitForElementClickable(findTestObject('QA/5. Page_Institution/link_InstitutionAccounts'), 5)
		WebUI.click(findTestObject('QA/5. Page_Institution/link_InstitutionAccounts'))
		SelectSideMenu("Institution")
	}
	@Keyword
	public void NavigateToInstitutionNominatedBICPage(){

		SelectSideMenu("Institution")

		WebUI.waitForElementVisible(findTestObject('QA/5. Page_Institution/link_InstitutionNominatedBIC'), 5)
		WebUI.waitForElementClickable(findTestObject('QA/5. Page_Institution/link_InstitutionNominatedBIC'), 5)
		WebUI.click(findTestObject('QA/5. Page_Institution/link_InstitutionNominatedBIC'))
		SelectSideMenu("Institution")

	}
	@Keyword
	public void NavigateToInstitutionUsersPage(){

		SelectSideMenu("Institution")

		WebUI.waitForElementVisible(findTestObject('QA/5. Page_Institution/link_InstitutionUsers'), 5)
		WebUI.waitForElementClickable(findTestObject('QA/5. Page_Institution/link_InstitutionUsers'), 5)
		WebUI.click(findTestObject('QA/5. Page_Institution/link_InstitutionUsers'))

		SelectSideMenu("Institution")
	}



	//Navigate to Workstreams pages

	@Keyword
	public void NavigateToWorkstreamsPage(){

		SelectSideLink("Workstreams")

		WebUI.waitForElementVisible(findTestObject('QA/6. Page_Workstreams/tab_Workstreams'), 5)
		WebUI.waitForElementClickable(findTestObject('QA/6. Page_Workstreams/tab_Workstreams'), 5)
		WebUI.click(findTestObject('QA/6. Page_Workstreams/tab_Workstreams'))

	}

	@Keyword
	public void NavigateToWorkItemsPage(){

		SelectSideLink("Workstreams")

		WebUI.waitForElementVisible(findTestObject('QA/6. Page_Workstreams/tab_WorkItems'), 5)
		WebUI.waitForElementClickable(findTestObject('QA/6. Page_Workstreams/tab_WorkItems'), 5)
		WebUI.click(findTestObject('QA/6. Page_Workstreams/tab_WorkItems'))

	}

	@Keyword
	public void NavigateToWorkstreamUsersPage(){

		SelectSideLink("Workstreams")

		WebUI.waitForElementVisible(findTestObject('QA/6. Page_Workstreams/tab_Users'), 5)
		WebUI.waitForElementClickable(findTestObject('QA/6. Page_Workstreams/tab_Users'), 5)
		WebUI.click(findTestObject('QA/6. Page_Workstreams/tab_Users'))

	}

	@Keyword
	public void NavigateToWorkstreamsDashboardPage(){

		SelectSideMenu("Operations")

		WebUI.waitForElementVisible(findTestObject('QA/7. Page_Operations/link_WorkstreamsDashboard'), 5)
		WebUI.waitForElementClickable(findTestObject('QA/7. Page_Operations/link_WorkstreamsDashboard'), 5)
		WebUI.click(findTestObject('QA/7. Page_Operations/link_WorkstreamsDashboard'))
		SelectSideMenu("Operations")

	}

	@Keyword
	public void NavigateToThrougputDashboardPage(){

		SelectSideMenu("Operations")

		WebUI.waitForElementVisible(findTestObject('QA/7. Page_Operations/link_ThroughputDashboard'), 5)
		WebUI.waitForElementClickable(findTestObject('QA/7. Page_Operations/link_ThroughputDashboard'), 5)
		WebUI.click(findTestObject('QA/7. Page_Operations/link_ThroughputDashboard'))
		SelectSideMenu("Operations")

	}

	@Keyword
	public void NavigateToPendingApprovalsPage(){

		SelectSideLink("Approvals")

		WebUI.waitForElementNotPresent(findTestObject('Object Repository/QA/loading_Mask'), 5)

		WebUI.waitForElementVisible(findTestObject('Object Repository/QA/Page_Approvals/tab_Pending'), 5)
		WebUI.waitForElementClickable(findTestObject('Object Repository/QA/Page_Approvals/tab_Pending'), 5)
		WebUI.click(findTestObject('Object Repository/QA/Page_Approvals/tab_Pending'))

	}

	@Keyword
	public void NavigateToActionedApprovalsPage(){

		SelectSideLink("Approvals")

		WebUI.waitForElementVisible(findTestObject('Object Repository/QA/Page_Approvals/tab_Actioned'), 5)
		WebUI.waitForElementClickable(findTestObject('Object Repository/QA/Page_Approvals/tab_Actioned'), 5)
		WebUI.click(findTestObject('Object Repository/QA/Page_Approvals/tab_Actioned'))

	}

	@Keyword
	public void NavigateToMySubmissionsApprovalsPage(){

		SelectSideLink("Approvals")

		WebUI.waitForElementVisible(findTestObject('Object Repository/QA/Page_Approvals/tab_My_Submissions'), 5)
		WebUI.waitForElementClickable(findTestObject('Object Repository/QA/Page_Approvals/tab_My_Submissions'), 5)
		WebUI.click(findTestObject('Object Repository/QA/Page_Approvals/tab_My_Submissions'))

	}

	@Keyword
	public void NavigateToCreateUserPage(){

		WebUI.navigateToUrl("https://institution-" + GlobalVariable.environment + ".clearbank.co.uk/#/institution/users/create-user")
	}



}

