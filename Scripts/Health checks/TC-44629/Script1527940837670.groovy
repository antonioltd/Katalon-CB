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

//CustomKeywords.'browserHelper.Users.Login'('Auto FPS', 'primary')
CustomKeywords.'browserHelper.Users.Login'('Create User', 'primary')

CustomKeywords.'browserHelper.Navigation.NavigateToCreateUserPage'()

CustomKeywords.'browserHelper.Navigation.NavigateToInstitutionUsersPage'()

//WebUI.waitForElementVisible(findTestObject('Object Repository/QA/5. Page_Institution/Page_Users/button_CreateUser'), 5)
CustomKeywords.'browserHelper.Generic.WaitUntilLoadingComplete'()

WebUI.waitForElementClickable(findTestObject('Object Repository/QA/5. Page_Institution/Page_Users/button_CreateUser'), 5)

WebUI.click(findTestObject('Object Repository/QA/5. Page_Institution/Page_Users/button_CreateUser'))

TestData createUserData = findTestData('Data Files/Test Data/Create User')

int size = createUserData.getRowNumbers()

String first_name

String surname

String email_address

for (int i = 1; i <= createUserData.getRowNumbers(); i++) {
    WebUI.refresh()

    WebUI.waitForElementVisible(findTestObject('QA/5. Page_Institution/Page_Users/radio_NewContact'), 5)

    WebUI.click(findTestObject('QA/5. Page_Institution/Page_Users/radio_NewContact'))

    CustomKeywords.'browserHelper.Dropdown.DropdownHelper'(findTestObject('QA/3. Page_Admin/Onboarding/Page_Primary Contact Details/1.Page_Basic User Details/dropdown_Title'), 
        createUserData.getValue('Title', i))

    CustomKeywords.'browserHelper.Button.ClickOnCreateRuleButton'()

    first_name = createUserData.getValue('First Name', i)

    first_name = first_name.equals('random') ? CustomKeywords.'browserHelper.Generic.GetRandomString'(5) : first_name

    surname = createUserData.getValue('Surname', i)

    surname = surname.equals('random') ? CustomKeywords.'browserHelper.Generic.GetRandomString'(5) : surname

    email_address = createUserData.getValue('Email Address', i)

    email_address = email_address.equals('random') ? CustomKeywords.'browserHelper.Generic.GetTempEmail'() : email_address

    WebUI.setText(findTestObject('QA/3. Page_Admin/Onboarding/Page_Primary Contact Details/1.Page_Basic User Details/input_FirstName'), 
        first_name)

    WebUI.setText(findTestObject('QA/3. Page_Admin/Onboarding/Page_Primary Contact Details/1.Page_Basic User Details/input_Surname'), 
        surname)

    WebUI.setText(findTestObject('QA/3. Page_Admin/Onboarding/4.Page_Contact Details/input_EmailAddress'), email_address)

    WebUI.setText(findTestObject('QA/3. Page_Admin/Onboarding/Page_Primary Contact Details/1.Page_Basic User Details/calendar_DateOfBirth'), 
        createUserData.getValue('Date of Birth', i))

    WebUI.setText(findTestObject('QA/3. Page_Admin/Onboarding/Page_Primary Contact Details/1.Page_Basic User Details/input_TelephoneNumber'), 
        '0789654123')

    WebUI.setText(findTestObject('QA/3. Page_Admin/Onboarding/Page_Primary Contact Details/1.Page_Basic User Details/input_JobTitle'), 
        'Tester')

    WebUI.setText(findTestObject('QA/3. Page_Admin/Onboarding/Page_Primary Contact Details/1.Page_Basic User Details/input_Profession'), 
        'Manager')

    CustomKeywords.'browserHelper.Dropdown.AutoSuggestHelper'(findTestObject('QA/3. Page_Admin/Onboarding/Page_Primary Contact Details/1.Page_Basic User Details/autosuggest_Language'), 
        'English')

    CustomKeywords.'browserHelper.Dropdown.DropdownHelper'(findTestObject('QA/3. Page_Admin/Onboarding/Page_Primary Contact Details/1.Page_Basic User Details/dropdown_ResidentialStatus'), 
        'Resident')

    WebUI.setText(findTestObject('QA/3. Page_Admin/Onboarding/Page_Primary Contact Details/2.Page_User Identity Numbers/input_NationalInsuranceNumber'), 
        'dfg15')

    WebUI.setText(findTestObject('QA/3. Page_Admin/Onboarding/7.Page_OrganisationAddress/input_BuildingNumber'), '123')

    WebUI.setText(findTestObject('QA/3. Page_Admin/Onboarding/7.Page_OrganisationAddress/input_StreetName'), 'street')

    WebUI.setText(findTestObject('QA/3. Page_Admin/Onboarding/7.Page_OrganisationAddress/input_City'), 'London')

    WebUI.setText(findTestObject('QA/3. Page_Admin/Onboarding/7.Page_OrganisationAddress/input_PostalCode'), 'rt674lj')

    CustomKeywords.'browserHelper.Dropdown.AutoSuggestHelper'(findTestObject('QA/3. Page_Admin/Onboarding/7.Page_OrganisationAddress/autosuggest_CountryName'), 
        'United Kingdom')

    CustomKeywords.'browserHelper.Dropdown.DropdownHelper'(findTestObject('Object Repository/QA/5. Page_Institution/Page_Users/dropdown_Approval'), 
        'View All Approvals')

    CustomKeywords.'browserHelper.Dropdown.DropdownHelper'(findTestObject('Object Repository/QA/5. Page_Institution/Page_Users/dropdown_Approval'), 
        'View Pending Approvals')

    //    CustomKeywords.'browserHelper.Dropdown.DropdownHelper'(findTestObject('Object Repository/QA/5. Page_Institution/Page_Users/dropdown_Approval'), 
    //        'Respond To Pending Approval')
    //
    //    CustomKeywords.'browserHelper.Dropdown.DropdownHelper'(findTestObject('Object Repository/QA/5. Page_Institution/Page_Users/dropdown_Approval'), 
    //        'Manage Approvers')
    //
    //    CustomKeywords.'browserHelper.Dropdown.DropdownHelper'(findTestObject('Object Repository/QA/5. Page_Institution/Page_Users/dropdown_Approval'), 
    //        'Get Detailed Approval')
    WebUI.setText(findTestObject('Object Repository/QA/5. Page_Institution/Page_Users/input_Password'), 'Password123')

    WebUI.setText(findTestObject('Object Repository/QA/5. Page_Institution/Page_Users/input_ConfirmPassword'), 'Password123')
}

WebUI.delay(2)

WebUI.scrollToElement(findTestObject('QA/5. Page_Institution/Page_Users/button_Create'), 5)

WebUI.click(findTestObject('QA/5. Page_Institution/Page_Users/button_Create'))

WebUI.waitForElementVisible(findTestObject('QA/popup_Message'), 20)

WebUI.verifyElementText(findTestObject('QA/popup_Message'), 'Success')

WebUI.click(findTestObject('QA/Page_Landing/link_SignOut'))

CustomKeywords.'browserHelper.Users.Login'('Create User', 'secondary')

CustomKeywords.'browserHelper.Navigation.NavigateToPendingApprovalsPage'()

CustomKeywords.'browserHelper.Approval.ApproveCreateUserRequest'(first_name, surname, email_address)

WebUI.waitForElementVisible(findTestObject('QA/popup_Message'), 20)

WebUI.verifyElementText(findTestObject('Object Repository/QA/popup_Message'), 'Success')

WebUI.navigateToUrl('https://institution-qa.clearbank.co.uk/#/institution/users')

WebUI.waitForElementNotVisible(findTestObject('Object Repository/QA/loading_Mask'), 5)

WebUI.refresh()

WebUI.verifyEqual(CustomKeywords.'browserHelper.Generic.VerifyUserExist'(first_name, surname), true)

WebUI.closeBrowser()

