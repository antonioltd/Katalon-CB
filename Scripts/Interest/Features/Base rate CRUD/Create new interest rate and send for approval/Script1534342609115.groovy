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

CustomKeywords.'browserHelper.Users.Login'('CB', 'primary')

CustomKeywords.'browserHelper.Navigation.NavigateToInterestRateManagementPage'()

WebUI.delay(2)

WebUI.verifyElementVisible(findTestObject('Object Repository/QA/Page_TreasuryManagement/Page_InterestRateManagement/header'))

WebUI.waitForElementVisible(findTestObject('Object Repository/QA/Page_TreasuryManagement/Page_InterestRateManagement/button_AddNewRate'), 
    5)

WebUI.mouseOver(findTestObject('Object Repository/QA/Page_TreasuryManagement/Page_InterestRateManagement/button_AddNewRate'))

WebUI.click(findTestObject('Object Repository/QA/Page_TreasuryManagement/Page_InterestRateManagement/button_AddNewRate'))

WebUI.setText(findTestObject('Object Repository/QA/Page_TreasuryManagement/Page_InterestRateManagement/Window_CreateRate/input_RateName'), 
    'Auto001')

WebUI.setText(findTestObject('Object Repository/QA/Page_TreasuryManagement/Page_InterestRateManagement/Window_CreateRate/input_InterestRate'), 
    '-0.33')

WebUI.click(findTestObject('QA/Page_TreasuryManagement/Page_InterestRateManagement/Window_CreateRate/calendar_EffectiveFrom'))

WebUI.click(findTestObject('QA/Page_TreasuryManagement/Page_InterestRateManagement/Window_CreateRate/calendar_EffectiveFrom'))

WebUI.waitForElementClickable(findTestObject('Object Repository/QA/Page_TreasuryManagement/Page_InterestRateManagement/Window_CreateRate/calendar_EffectiveFrom'), 
    3)

WebUI.click(findTestObject('QA/Page_TreasuryManagement/Page_InterestRateManagement/Window_CreateRate/pre-stage/august15'))

WebUI.click(findTestObject('Object Repository/QA/Page_TreasuryManagement/Page_InterestRateManagement/Window_CreateRate/button_Create'))

String successMessage = WebUI.getText(findTestObject('Object Repository/QA/Page_TreasuryManagement/Page_InterestRateManagement/message_Notification'))

WebUI.verifyElementText(successMessage, 'The interest rate has been successfully sent to collective approval.')

