package browserHelper

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

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.junit.After
import org.openqa.selenium.By

public class Generic {

	WebDriver driver = DriverFactory.getWebDriver()
	WebDriverWait wait = new WebDriverWait(driver, 10)



	@Keyword
	public boolean VerifyUserExist(String firstName, String surname){

		boolean res = false;

		WaitUntilLoadingComplete()

		WebElement element = null;

		for (int i = 0; i < 5;  i++) {

			WebUI.delay(1)

			List<WebElement> elements = driver.findElements(By.xpath("//div[contains(text(),'Users')]/ancestor::div[@class='el-card__header']/following::div/div//tr/td[1]/div"))
			if (elements.size() > 0) {

				for (WebElement ele in elements) {

					if (ele.text==firstName + " " + surname) {
						res = true;
					}
				}

				if (res == true) {

					break;
				}
			}
			driver.navigate().refresh();
		}

		return res;
	}

	@Keyword
	public String GetTempEmail(){

		return GetRandomString(4)+GetRandomNumber(6) + "@grr.la"
	}

	@Keyword
	public String GetRandomNumber(int length){

		String strs = "123456789";

		StringBuilder builder = new StringBuilder();
		while (length-- != 0) {
			int character = (int)(Math.random()*strs.length());
			builder.append(strs.charAt(character));
		}

		return builder.toString();
	}

	@Keyword
	public String GetRandomString(int length = 5) {

		String strs = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		StringBuilder builder = new StringBuilder();
		while (length-- != 0) {
			int character = (int)(Math.random()*strs.length());
			builder.append(strs.charAt(character));
		}

		return builder.toString();
	}

	@Keyword
	public void WaitUntilLoadingComplete(){

		WebElement element = null
		try {

			element = driver.findElement(By.xpath("//div[contains(@class,'el-loading-mask')]"))
			wait.until(ExpectedConditions.invisibilityOf(element))
		} catch (Exception e) {

			e.printStackTrace()
		}
	}
}
