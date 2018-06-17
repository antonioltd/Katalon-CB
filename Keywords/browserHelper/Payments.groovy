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
	public void SetSortCode(String sortcode){

		WebElement SCLeft = driver.findElement(By.xpath("//div[@class='sort-code']/div[1]//input"));
		SCLeft.sendKeys(GetLeftValues(sortcode))

		WebElement SCMiddle = driver.findElement(By.xpath("//div//div[@class='sort-code']/div[2]//input"));
		SCMiddle.sendKeys(GetMiddleValues(sortcode))

		WebElement SCRight = driver.findElement(By.xpath("//div[@class='sort-code']/div[3]//input"));
		SCRight.sendKeys(GetRightValues(sortcode))
	}

	@Keyword
	public void EnterPayment(String accountHolderName = "Holder", String sortcode="200318", String accountNumber="10000001", String amount = "5.00", String reference="Payment Reference"){

		WebUI.setText(findTestObject('Object Repository/QA/5. Page_Institution/Accounts/input_AccountHolderName'), accountHolderName)

		SetSortCode(sortcode)

		WebUI.setText(findTestObject('Object Repository/QA/5. Page_Institution/Accounts/input_AccountNumber'), accountNumber)

		WebUI.setText(findTestObject('Object Repository/QA/5. Page_Institution/Accounts/input_Amount'), amount)

		WebUI.setText(findTestObject('Object Repository/QA/5. Page_Institution/Accounts/input_Reference'), reference)
	}

	@Keyword
	public void PreviousPaymentTemplateAction(String action){
		//		WebElement discardElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Discard']/parent::button")))
		//		discardElement.click()
		
		By locator = By.xpath("//span[text()='" +  action + "']/parent::button");
		WebElement element = driver.findElement(locator)
		element.click()
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator))
	}
		
	
}
