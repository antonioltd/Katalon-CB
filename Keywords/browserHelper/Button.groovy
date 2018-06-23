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

public class Button {

	WebDriver driver = DriverFactory.getWebDriver()
	WebDriverWait wait = new WebDriverWait(driver, 15)

	@Keyword
	public void ClickOnNextButton(){

		ClickOnDisplayedButton("Next")
	}

	@Keyword
	public void ClickOnNextPageButton(){


		ClickOnDisplayedButton("Next Page")
	}

	@Keyword
	public void ClickOnPreviousPageButton(){


		ClickOnDisplayedButton("Previous Page")
	}

	@Keyword
	public void ClickOnResetButton(){


		ClickOnDisplayedButton("Reset")
	}

	@Keyword
	public void ClickOnCreateRuleButton(){


		ClickOnDisplayedButton("Create Rule")
	}

	private void ClickOnDisplayedButton(String buttonName){

		List<WebElement> matches = driver.findElements(By.xpath("//span[normalize-space()='" + buttonName + "']"))


		for(WebElement ele in  matches){

			if (ele.displayed) {
				ele.click()
				break;
			}
		}
	}
}