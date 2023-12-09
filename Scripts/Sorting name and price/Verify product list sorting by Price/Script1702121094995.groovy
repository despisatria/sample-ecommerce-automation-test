import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// Open browser, open website, and go to product list page
WebUI.openBrowser("")
WebUI.navigateToUrl(GlobalVariable.url)
WebUI.click(findTestObject("HomePage_AllProductButton"))

// Verify default sorting may not be by price
List<Double> actualProductPrices = WebUI.getAttributeList(findTestObject("ProductListing_ProductPrice"), "textContent").collect { it.toDouble() }
List<Double> expectedProductPrices = Arrays.asList(10.00, 20.00, 30.00) // Modify as needed

for (int i = 0; i < actualProductPrices.size(); i++) {
	WebUI.verifyMatch(actualProductPrices[i], expectedProductPrices[i])
}

// Click Sort by Price button
WebUI.click(findTestObject("ProductListing_SortByPriceButton"))

// Verify product order after sorting
actualProductPrices = WebUI.getAttributeList(findTestObject("ProductListing_ProductPrice"), "textContent").collect { it.toDouble() }
expectedProductPrices.sort() // Sort expected prices

for (int i = 0; i < actualProductPrices.size(); i++) {
	WebUI.verifyMatch(actualProductPrices[i], expectedProductPrices[i])
}
