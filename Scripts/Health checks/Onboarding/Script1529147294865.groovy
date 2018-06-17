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

//change01

WebUI.openBrowser(findTestData('Environment').getValue(GlobalVariable.environment, 1))

CustomKeywords.'browserHelper.Users.Login'('CB', 'primary')

CustomKeywords.'browserHelper.Navigation.NavigateToOnboardingPage'()

WebUI.verifyElementVisible(findTestObject('QA/3. Page_Admin/Onboarding/1.Page_Institution Details/section_Detail'))

CustomKeywords.'browserHelper.Dropdown.DropdownHelper'(findTestObject('Object Repository/QA/3. Page_Admin/Onboarding/1.Page_Institution Details/dropdown_InsitutionType'), 
    'Bank FCA Registered')

WebUI.setText(findTestObject('Object Repository/QA/3. Page_Admin/Onboarding/1.Page_Institution Details/input_TradingName'), 
    'Some Institution')

WebUI.setText(findTestObject('Object Repository/QA/3. Page_Admin/Onboarding/1.Page_Institution Details/input_RegisteredName'), 
    'Some Institution')

CustomKeywords.'browserHelper.Payments.SetIndividualSortCode'('500000')

CustomKeywords.'browserHelper.Payments.SetOrganisationSortCode'('500001')

WebUI.setText(findTestObject('Object Repository/QA/3. Page_Admin/Onboarding/1.Page_Institution Details/input_BankCode'), 
    '1234')

WebUI.setText(findTestObject('Object Repository/QA/3. Page_Admin/Onboarding/1.Page_Institution Details/input_Bic'), 'CLRBGB12312')

WebUI.setText(findTestObject('Object Repository/QA/3. Page_Admin/Onboarding/1.Page_Institution Details/input_ClearingMemberID'), 
    'someid')

CustomKeywords.'browserHelper.Dropdown.DropdownHelper'(findTestObject('Object Repository/QA/3. Page_Admin/Onboarding/1.Page_Institution Details/dropdown_ClearingSystemIdentificationType'), 
    'Swiss BC Code')

WebUI.scrollToElement(findTestObject('QA/3. Page_Admin/Onboarding/1.Page_Institution Details/button_Logo_2_1_File'), 2)

CustomKeywords.'browserHelper.Upload._upload'(findTestObject('Object Repository/QA/3. Page_Admin/Onboarding/1.Page_Institution Details/button_Logo_1_1_MobileFile'), 
    'C:\\Users\\customer\\Katalon Studio\\Sample\\Files\\Logo\\clearbank-2to1.png')

CustomKeywords.'browserHelper.Upload._upload'(findTestObject('Object Repository/QA/3. Page_Admin/Onboarding/1.Page_Institution Details/button_Logo_1_1_File'), 
    'C:\\Users\\customer\\Katalon Studio\\Sample\\Files\\Logo\\clearbank-2to1.png')

CustomKeywords.'browserHelper.Upload._upload'(findTestObject('Object Repository/QA/3. Page_Admin/Onboarding/1.Page_Institution Details/button_Logo_2_1_File'), 
    'C:\\Users\\customer\\Katalon Studio\\Sample\\Files\\Logo\\clearbank-2to1.png')

CustomKeywords.'browserHelper.Upload._upload'(findTestObject('Object Repository/QA/3. Page_Admin/Onboarding/1.Page_Institution Details/button_Logo_2_1_MobileFile '), 
    'C:\\Users\\customer\\Katalon Studio\\Sample\\Files\\Logo\\clearbank-2to1.png')

CustomKeywords.'browserHelper.Button.ClickOnNextButton'()

WebUI.verifyElementVisible(findTestObject('QA/3. Page_Admin/Onboarding/2.Page_Liquidity Details/section_Detail'))

WebUI.click(findTestObject('QA/3. Page_Admin/Onboarding/2.Page_Liquidity Details/input_MinimumReserveBalance'))

WebUI.setText(findTestObject('QA/3. Page_Admin/Onboarding/2.Page_Liquidity Details/input_MinimumReserveBalance'), '100000')

WebUI.click(findTestObject('QA/3. Page_Admin/Onboarding/2.Page_Liquidity Details/input_MinimumReserveBalance'))

WebUI.setText(findTestObject('QA/3. Page_Admin/Onboarding/2.Page_Liquidity Details/input_MaximumLiquidityBalance'), '10000000')

WebUI.click(findTestObject('QA/3. Page_Admin/Onboarding/2.Page_Liquidity Details/input_MaximumLiquidityBalance'))

CustomKeywords.'browserHelper.Button.ClickOnNextButton'()

WebUI.verifyElementVisible(findTestObject('QA/3. Page_Admin/Onboarding/3.Page_Institution Limit Sets/section_Detail'))

CustomKeywords.'browserHelper.Dropdown.DropdownHelper'(findTestObject('QA/3. Page_Admin/Onboarding/3.Page_Institution Limit Sets/dropdown_TransactionLimitType'), 
    'Visa')

CustomKeywords.'browserHelper.Dropdown.DropdownHelper'(findTestObject('QA/3. Page_Admin/Onboarding/3.Page_Institution Limit Sets/dropdown_TransactionLimitTrackType'), 
    'Single Transaction')

WebUI.setText(findTestObject('QA/3. Page_Admin/Onboarding/3.Page_Institution Limit Sets/input_MinimumAmount'), '1')

WebUI.setText(findTestObject('QA/3. Page_Admin/Onboarding/3.Page_Institution Limit Sets/input_MaximumAmount'), '5000000')

WebUI.click(findTestObject('QA/3. Page_Admin/Onboarding/3.Page_Institution Limit Sets/button_AddLimitSet'))

CustomKeywords.'browserHelper.Button.ClickOnNextButton'()

WebUI.verifyElementVisible(findTestObject('QA/3. Page_Admin/Onboarding/4.Page_Contact Details/section_Detail'))

WebUI.setText(findTestObject('QA/3. Page_Admin/Onboarding/4.Page_Contact Details/input_ContactNumber'), '0789654123')

WebUI.setText(findTestObject('QA/3. Page_Admin/Onboarding/4.Page_Contact Details/input_EmailAddress'), 'test@test.test')

WebUI.setText(findTestObject('QA/3. Page_Admin/Onboarding/4.Page_Contact Details/input_Website'), 'http://www.test.test')

CustomKeywords.'browserHelper.Button.ClickOnNextButton'()

WebUI.verifyElementVisible(findTestObject('QA/3. Page_Admin/Onboarding/5.Page_OperatingOrganisationDetails 1/section_Detail'))

WebUI.setText(findTestObject('QA/3. Page_Admin/Onboarding/5.Page_OperatingOrganisationDetails 1/input_DataUniversalNumberingSystem'), 
    '123456789')

WebUI.setText(findTestObject('QA/3. Page_Admin/Onboarding/5.Page_OperatingOrganisationDetails 1/input_LegalEntityIdentifier'), 
    '12345678901234567890')

CustomKeywords.'browserHelper.Dropdown.DropdownHelper'(findTestObject('QA/3. Page_Admin/Onboarding/5.Page_OperatingOrganisationDetails 1/dropdown_OrganisationType'), 
    'Sole Trader')

CustomKeywords.'browserHelper.Dropdown.DropdownHelper'(findTestObject('QA/3. Page_Admin/Onboarding/5.Page_OperatingOrganisationDetails 1/dropdown_CountryIncorporated'), 
    'GB')

CustomKeywords.'browserHelper.Dropdown.DropdownHelper'(findTestObject('QA/3. Page_Admin/Onboarding/5.Page_OperatingOrganisationDetails 1/dropdown_CountryLiability'), 
    'GB')

WebUI.setText(findTestObject('QA/3. Page_Admin/Onboarding/5.Page_OperatingOrganisationDetails 1/input_SICCode'), '1234o')

CustomKeywords.'browserHelper.Button.ClickOnNextButton'()

