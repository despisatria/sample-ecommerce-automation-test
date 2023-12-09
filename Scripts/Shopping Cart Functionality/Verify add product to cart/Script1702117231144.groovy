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

WebUI.callTestCase(findTestCase('Login/Verify Login Success using valid account'), [:], FailureHandling.STOP_ON_FAILURE)

def productToAdd = "iPhone 15 Pro"

// Go to product list page
WebUI.click(findTestObject("HomePage_AllProductButton"))

// Search Product "iPhone 15 Pro"
WebUI.setText(findTestObject("AllProduct_SearchField"), productToAdd)
WebUI.click(findTestObject("AllProduct_SearchButton"))

// Get data and add to cart
def productName = WebUI.getText(findTestObject("ProductSearchResult_ProductName"))
def productPrice = WebUI.getText(findTestObject("ProductSearchResult_ProductPrice"))
WebUI.click(findTestObject("ProductSearchResult_AddToCartButton"))

// Verify product added to cart
WebUI.verifyElementPresent(findTestObject("ProductSearchResult_ProductAdded"), 5)

// Verify product on cart
WebUI.click(findTestObject("AllProduct_CartButton"))
WebUI.verifyElementText(findTestObject("CartPage_ProductName"), productName)
WebUI.verifyElementText(findTestObject("CartPage_ProductPrice"), productPrice)
