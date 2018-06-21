package browserHelper

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.junit.After
import org.openqa.selenium.By

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

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

public class Approval {


	WebDriver driver = DriverFactory.getWebDriver()
	WebDriverWait wait = new WebDriverWait(driver, 30)

	@Keyword
	public void ApproveCreateUserRequest(String fName, String lName, String emailAdd){

		WebUI.waitForElementNotPresent(findTestObject('Object Repository/QA/loading_Mask'), 3)

		WebUI.delay(1)

		List<WebElement> elements = driver.findElements(By.xpath("//div[normalize-space()='Create institution user']"))
		for (WebElement element in elements) {

			element.click()
			WebUI.waitForElementNotPresent(findTestObject('Object Repository/QA/loading_Mask'), 3)


			if ((driver.findElement(By.xpath("//div[normalize-space()='Email Address']/following-sibling::div[normalize-space()='"
			+ emailAdd + "']"))) && (driver.findElement(By.xpath("//div[normalize-space()='Surname']/following-sibling::div[normalize-space()='"
			+ lName + "']")))  && (driver.findElement(By.xpath("//div[normalize-space()='First Name']/following-sibling::div[normalize-space()='"
			+ fName + "']")))) {

				driver.findElement(By.xpath("//span[text()='Approve']")).click()
				break;
			}
		}
	}
}
