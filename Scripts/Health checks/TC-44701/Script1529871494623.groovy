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
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser(findTestData('Environment').getValue(GlobalVariable.environment, 1))

//CustomKeywords.'browserHelper.Users.Login'('Auto FPS', 'primary')
CustomKeywords.'browserHelper.Users.Login'('AutoCHAPS01', 'secondary')

CustomKeywords.'browserHelper.Navigation.NavigateToAccount'('521087b1-986d-468d-b8a6-223a94e406a8')

WebUI.waitForElementVisible(findTestObject('QA/5. Page_Institution/Accounts/button_SendPayments'), 5)

WebUI.click(findTestObject('QA/5. Page_Institution/Accounts/button_SendPayments'))

WebUI.delay(2)

if (WebUiCommonHelper.findWebElement(findTestObject('Object Repository/QA/5. Page_Institution/Accounts/popup_WelcomeBack'), 
    3).displayed) {
    CustomKeywords.'browserHelper.Payments.PreviousPaymentTemplateAction'('close')
}

CustomKeywords.'browserHelper.Dropdown.DropdownHelper'(findTestObject('QA/5. Page_Institution/Accounts/dropdown_PaymentMethod'), 
    'Chaps')

CustomKeywords.'browserHelper.Date.SetDate'()

CustomKeywords.'browserHelper.Payments.EnterPayment'(1, 'Holder01', '200318', '24681012', '2', 'ref1')

CustomKeywords.'browserHelper.Payments.EnterPayment'(2, 'Holder02', '200318', '24681013', '3', 'ref2')

CustomKeywords.'browserHelper.Payments.EnterPayment'(3, 'Holder01', '200318', '24681012', '2', 'ref1')

CustomKeywords.'browserHelper.Payments.EnterPayment'(4, 'Holder02', '200318', '24681013', '3', 'ref2')

CustomKeywords.'browserHelper.Payments.EnterPayment'(5, 'Holder01', '200318', '24681012', '2', 'ref1')

CustomKeywords.'browserHelper.Payments.EnterPayment'(6, 'Holder02', '200318', '24681013', '3', 'ref2')

CustomKeywords.'browserHelper.Payments.EnterPayment'(7, 'Holder01', '200318', '24681012', '2', 'ref1')

CustomKeywords.'browserHelper.Payments.EnterPayment'(8, 'Holder02', '200318', '24681013', '3', 'ref2')

CustomKeywords.'browserHelper.Payments.EnterPayment'(9, 'Holder01', '200318', '24681012', '2', 'ref1')

CustomKeywords.'browserHelper.Payments.EnterPayment'(10, 'Holder02', '200318', '24681013', '3', 'ref2')

CustomKeywords.'browserHelper.Payments.EnterPayment'(11, 'Holder01', '200318', '24681012', '2', 'ref1')

WebUI.click(findTestObject('Object Repository/QA/5. Page_Institution/Accounts/button_ConfirmCreditors'))

WebUI.waitForElementNotVisible(findTestObject('QA/loading_Mask'), 5)

WebUI.click(findTestObject('QA/5. Page_Institution/Accounts/button_SubmitForApproval'))

WebUI.waitForElementVisible(findTestObject('QA/popup_Message'), 5)

WebUI.verifyElementText(findTestObject('QA/popup_Message'), 'Success')

WebUI.closeBrowser()

