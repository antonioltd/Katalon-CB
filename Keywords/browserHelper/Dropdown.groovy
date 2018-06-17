package browserHelper

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
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
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class Dropdown {

	WebDriver driver = DriverFactory.getWebDriver()
	WebDriverWait wait = new WebDriverWait(driver, 15)

	@Keyword
	public void SelectOption(String option){

		//		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'"+option+"')]")))
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='"+ option +"']")))
		element.click()
	}

	@Keyword
	public void DropdownHelper(TestObject dropdownObject, String itemToSelect){

		WebUI.waitForElementVisible(dropdownObject, 5)
		WebUI.waitForElementClickable(dropdownObject, 5)
		WebUI.click(dropdownObject)
		WebUI.delay(1)
		WebElement itemElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='" + itemToSelect + "']")))
		itemElement.click()
		
		WebElement element = null
		try {
			if (driver.findElements(By.xpath("//span[text()='" + itemToSelect + "']/ancestor::div[@class='el-select-dropdown is-multiple']")).size() > 0) {
				WebUI.click(dropdownObject)
				}
					
			} catch (Exception e) { }
	}

	@Keyword
	public void AutoSuggestHelper(TestObject obj, String itemToSelect){
		WebUI.setText(obj, itemToSelect)
		WebElement itemElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[normalize-space()='" + itemToSelect + "']")))
	}
}
