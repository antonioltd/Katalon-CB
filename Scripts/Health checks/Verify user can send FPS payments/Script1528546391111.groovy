import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser(findTestData('Environment').getValue(GlobalVariable.environment, 1))

CustomKeywords.'browserHelper.Users.Login'('Auto FPS' , 'primary')

CustomKeywords.'browserHelper.Navigation.NavigateToAccount'(accountId)

WebUI.waitForElementVisible(findTestObject('Object Repository/QA/5. Page_Institution/Accounts/button_SendPayments'), 5)

WebUI.click(findTestObject('Object Repository/QA/5. Page_Institution/Accounts/button_SendPayments'))

WebUI.delay(2)


	try {
		
		CustomKeywords.'browserHelper.Payments.PreviousPaymentTemplateAction'('Discard')
		
	} catch (Exception e) {
	
		println (e.message)
	}

CustomKeywords.'browserHelper.Dropdown.DropdownHelper'(findTestObject('Object Repository/QA/5. Page_Institution/Accounts/dropdown_PaymentMethod'), "Faster Payments")

CustomKeywords.'browserHelper.Date.GetDate'("Today")

CustomKeywords.'browserHelper.Payments.EnterPayment'()

WebUI.waitForElementVisible(findTestObject('Object Repository/QA/5. Page_Institution/Accounts/button_ConfirmCreditors'), 1)

WebUI.click(findTestObject('Object Repository/QA/5. Page_Institution/Accounts/button_ConfirmCreditors'))

WebUI.waitForElementVisible(findTestObject('Object Repository/QA/5. Page_Institution/Accounts/button_SubmitForApproval'),5)

WebUI.click(findTestObject('Object Repository/QA/5. Page_Institution/Accounts/button_SubmitForApproval'))

















