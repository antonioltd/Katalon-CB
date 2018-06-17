import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.main.CustomKeywordDelegatingMetaClass as CustomKeywordDelegatingMetaClass
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

user1 = CustomKeywords.'browserHelper.Users.GetUser1'(institution)

password1 = CustomKeywords.'browserHelper.Users.GetUser1Password'(institution)

user2 = CustomKeywords.'browserHelper.Users.GetUser1'(institution)

password2 = CustomKeywords.'browserHelper.Users.GetUser2Password'(institution)

WebUI.openBrowser(findTestData('Environment').getValue(GlobalVariable.environment, 1))

WebUI.waitForElementVisible(findTestObject('QA/Page_Login/input_Username'), 5)

WebUI.clearText(findTestObject('QA/Page_Login/input_Username'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('QA/Page_Login/input_Username'), findTestData(GlobalVariable.environment).getValue('User1', 
        1))

WebUI.clearText(findTestObject('QA/Page_Login/input_Password'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('QA/Page_Login/input_Password'), findTestData(GlobalVariable.environment).getValue('Password1', 
        1))

WebUI.click(findTestObject('QA/Page_Login/button_SignIn'))

WebUI.verifyElementVisible(findTestObject('QA/Page_Login/Page_TwoFactorAuthencation/button_Verify'))

//String code = CustomKeywords.'browserHelper.TOTP.getCode'(findTestData(GlobalVariable.environment).getValue('User1', 1), findTestData(GlobalVariable.environment).getValue('Password1',1))
//String code = CustomKeywords.'browserHelper.TOTP.getCode'(user1, password1)
String code = CustomKeywords.'browserHelper.Users.getCode'(user1, password1)

WebUI.maximizeWindow(FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Object Repository/QA/Page_Login/Page_TwoFactorAuthencation/input_AuthenticationCode'), 
    5)

WebUI.sendKeys(findTestObject('Object Repository/QA/Page_Login/Page_TwoFactorAuthencation/input_AuthenticationCode'), code)

WebUI.click(findTestObject('Object Repository/QA/Page_Login/Page_TwoFactorAuthencation/button_Verify'))

not_run: CustomKeywords.'browserHelper.Navigation.NavigateToTreasuryDashboard'()

not_run: CustomKeywords.'browserHelper.Navigation.NavigateToActiveThrottlingPage'()

not_run: CustomKeywords.'browserHelper.Navigation.Navigate4EyeCheckPermissionPage'()

not_run: CustomKeywords.'browserHelper.Navigation.NavigateToCRMInstitutionsPage'()

not_run: CustomKeywords.'browserHelper.Navigation.NavigateToCRMQueryPage'()

not_run: CustomKeywords.'browserHelper.Navigation.NavigateToDeviceSoftwarePage'()

not_run: CustomKeywords.'browserHelper.Navigation.NavigateToInstitutionUsersPage'()

not_run: CustomKeywords.'browserHelper.Navigation.NavigateToInstitutionAccountsPage'()

not_run: CustomKeywords.'browserHelper.Navigation.NavigateToCertificateAndTokenPage'()

not_run: CustomKeywords.'browserHelper.Navigation.NavigateToInstitutionNominatedBICPage'()

not_run: CustomKeywords.'browserHelper.Navigation.NavigateToEarmarkingPage'()

not_run: CustomKeywords.'browserHelper.Navigation.NavigateToWorkstreamsPage'()

not_run: CustomKeywords.'browserHelper.Navigation.NavigateToWorkItemsPage'()

not_run: CustomKeywords.'browserHelper.Navigation.NavigateToWorkstreamUsersPage'()

not_run: CustomKeywords.'browserHelper.Navigation.NavigateToPendingApprovalsPage'()

not_run: CustomKeywords.'browserHelper.Navigation.NavigateToActionedApprovalsPage'()

not_run: CustomKeywords.'browserHelper.Navigation.NavigateToWorkstreamsDashboardPage'()

not_run: CustomKeywords.'browserHelper.Navigation.NavigateToThrougputDashboardPage'()

CustomKeywords.'browserHelper.Navigation.NavigateToOnboardingPage'()

not_run: WebUI.click(findTestObject('QA/3. Page_Admin/Onboarding/1.Page_Institution Details/dropdown_InsitutionType'))

not_run: CustomKeywords.'browserHelper.Dropdown.SelectOption'('Bank EEA Passported')

not_run: WebUI.click(findTestObject('QA/3. Page_Admin/Onboarding/1.Page_Institution Details/dropdown_ClearingSystemIdentificationType'))

not_run: CustomKeywords.'browserHelper.Dropdown.SelectOption'('Swiss BC Code')

not_run: WebUI.click(findTestObject('QA/Page_ActiveThrottlings/dropdown_PaymentMethod'))

not_run: CustomKeywords.'browserHelper.Dropdown.SelectOption'('Transfer')

WebUI.click(findTestObject('QA/3. Page_Admin/Onboarding/1.Page_Institution Details/dropdown_InsitutionType'))

CustomKeywords.'browserHelper.Dropdown.SelectOption'('Bank EEA Passported')

WebUI.setText(findTestObject('QA/3. Page_Admin/Onboarding/1.Page_Institution Details/input_TradingName'), 'My Bank')

WebUI.setText(findTestObject('QA/3. Page_Admin/Onboarding/1.Page_Institution Details/input_RegisteredName'), 'My Bank')

CustomKeywords.'browserHelper.Payments.SetIndividualSortCode'('112233')

CustomKeywords.'browserHelper.Payments.SetOrganisationSortCode'('500001')

WebUI.setText(findTestObject('QA/3. Page_Admin/Onboarding/1.Page_Institution Details/input_BankCode'), '9523')

WebUI.setText(findTestObject('QA/3. Page_Admin/Onboarding/1.Page_Institution Details/input_ClearingMemberID'), 'someclearing')

WebUI.sendKeys(findTestObject('QA/3. Page_Admin/Onboarding/1.Page_Institution Details/input_Bic'), 'CLRBGB09876')

WebUI.click(findTestObject('QA/3. Page_Admin/Onboarding/1.Page_Institution Details/dropdown_ClearingSystemIdentificationType'))

CustomKeywords.'browserHelper.Dropdown.SelectOption'('Swiss BC Code')

WebUI.click(findTestObject('QA/3. Page_Admin/Onboarding/1.Page_Institution Details/button_Logo_1_1_MobileFile'))

CustomKeywords.'browserHelper.Upload._upload'('C:\\Users\\customer\\Katalon Studio\\Sample\\Files\\Logo\\clearbank-2to1.png')

not_run: CustomKeywords.'browserHelper.Upload.FileUpload'('C:\\Users\\customer\\Katalon Studio\\Sample\\Files\\Logo\\clearbank-2to1.png')

not_run: WebUI.click(findTestObject('QA/3. Page_Admin/Onboarding/1.Page_Institution Details/button_Logo_2_1_File'))

not_run: CustomKeywords.'browserHelper.Upload.FileUpload'('C:\\Users\\customer\\Katalon Studio\\Sample\\Files\\Logo\\clearbank-2to1.png')

not_run: WebUI.click(findTestObject('QA/3. Page_Admin/Onboarding/1.Page_Institution Details/button_Logo_1_1_File'))

not_run: CustomKeywords.'browserHelper.Upload.FileUpload'('C:\\Users\\customer\\Katalon Studio\\Sample\\Files\\Logo\\clearbank-2to1.png')

not_run: WebUI.click(findTestObject('QA/3. Page_Admin/Onboarding/1.Page_Institution Details/button_Logo_2_1_MobileFile '))

not_run: CustomKeywords.'browserHelper.Upload.FileUpload'('C:\\Users\\customer\\Katalon Studio\\Sample\\Files\\Logo\\clearbank-2to1.png')

not_run: WebUI.delay(3)

not_run: CustomKeywords.'browserHelper.Button.ClickOnNextButton'()

