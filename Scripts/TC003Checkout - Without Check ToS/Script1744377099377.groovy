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
import com.kms.katalon.core.testobject.ConditionType as ConditionType

WebUI.callTestCase(findTestCase('ReusableTC/Login'), [:], FailureHandling.STOP_ON_FAILURE)
//pilih kategori
String category = category
String xpathCategory = "//a[contains(text(), \"${category}\")]"
TestObject dynamicCategory = new TestObject('Object Repository/Checkout/DynamicCategory')
dynamicCategory.addProperty('xpath', ConditionType.EQUALS, xpathCategory)
WebUI.click(dynamicCategory)

//Pilih sub category
//String xpathSubCategory = "//a[contains(text(), \"${subCategory}\")]"
String subCategory = subCategory
String xpathSubCategory = "//a[contains(@title, 'Show products in category') and contains(text(), '${subCategory}') ]"
TestObject dynamicSubCategory = new TestObject('Object Repository/Checkout/DynamicSubCategory')
dynamicSubCategory.addProperty('xpath', ConditionType.EQUALS, xpathSubCategory)
WebUI.waitForElementClickable(dynamicSubCategory, 1)
WebUI.doubleClick(dynamicSubCategory)

//Pilih product tittle
String productUrl = productUrl
//String xpathProductLink = "//h2[contains(@class, 'product-title')]//a[contains(@href, '" + productUrl + "')]";
String xpathProductLink = "//h2[contains(@class, 'product-title')]//a[text()='" + productUrl + "']"
TestObject dynamicProductUrl = new TestObject('Object Repository/Checkout/DynamicProductUrl')
dynamicProductUrl.addProperty('xpath', ConditionType.EQUALS, xpathProductLink)
WebUI.waitForElementClickable(dynamicProductUrl, 1)
WebUI.doubleClick(dynamicProductUrl)

//Add to chart
WebUI.click(findTestObject('Checkout/qty'))
WebUI.clearText(findTestObject('Checkout/qty'))
WebUI.setText(findTestObject('Checkout/qty'), qty)
WebUI.click(findTestObject('Checkout/btn_AddToChart'))

//tunggu notif berhasil tambah barang
WebUI.waitForElementVisible(findTestObject('Object Repository/Checkout/successAddToChart'), 10)
String notificationText = WebUI.getText(findTestObject('Object Repository/Checkout/successAddToChart'))
if (notificationText.startsWith("The product has been added to your")) {
	println('Test Passed')
} else {
	assert false : 'Test failed: Element notification for success add to chart are not found'
}
WebUI.click(findTestObject('Checkout/btn_ShoppingCart'))


//Pilih negara dan set state
WebUI.waitForElementVisible(findTestObject('Object Repository/Checkout/ddlCountry'), 10)
WebUI.selectOptionByLabel(findTestObject('Object Repository/Checkout/ddlCountry'), countryName, false)

if (countryName == "United States") {
	WebUI.waitForElementVisible(findTestObject('Object Repository/Checkout/state'), 10)
	WebUI.selectOptionByLabel(findTestObject('Object Repository/Checkout/state'), stateName, false)
} else {
	stateName = "Other (Non US)"
	WebUI.waitForElementVisible(findTestObject('Object Repository/Checkout/state'), 10)
	WebUI.selectOptionByLabel(findTestObject('Object Repository/Checkout/state'), stateName, false)
}

WebUI.setText(findTestObject('Checkout/zipCode'), zipCode)
WebUI.uncheck(findTestObject("Checkout/termOfServices"))
WebUI.click(findTestObject("Checkout/btn_CheckOut"))

boolean isTermOfSservicesUncheck = WebUI.verifyElementPresent(findTestObject('Checkout/termOfServicesWindow'), 0, FailureHandling.OPTIONAL)
if (isTermOfSservicesUncheck) {
		println('Test Passed')
	} else {
		assert false : 'Test failed: Element order detail are not found'
	}

WebUI.takeFullPageScreenshot()
WebUI.closeBrowser()
	
//
//
////Cek apakah sudah ada pada halaman order
//WebUI.waitForElementPresent(findTestObject('Object Repository/Checkout/successCheckout'), 10)
//String notificationTextOrder = WebUI.getText(findTestObject('Object Repository/Checkout/successCheckout'))
//if (notificationTextOrder.startsWith("Checkout")) {
//	println('Test Passed')
//} else {
//	assert false : 'Test failed: Element notification for success order are not found'
//}
//
//
////Pilih billing Address
//WebUI.waitForElementVisible(findTestObject('Object Repository/Checkout/billing'), 10)
//if (billing == "3947873") {
//	WebUI.click(findTestObject('Object Repository/Checkout/btn_Billing'))
//} else {
//	WebUI.waitForElementVisible(findTestObject('Object Repository/Checkout/billingNewAddress'), 10)
//	WebUI.selectOptionByLabel(findTestObject('Object Repository/Checkout/billing'),'New Address', false)
//	WebUI.selectOptionByLabel(findTestObject('Object Repository/Checkout/billingNewAddress'), countryName, false)
//	
//	if (countryName == "United States") {
//		WebUI.waitForElementVisible(findTestObject('Object Repository/Checkout/billingNewState'), 10)
//		WebUI.selectOptionByLabel(findTestObject('Object Repository/Checkout/billingNewState'), stateName, false)
//	} else {
//		stateName = "Other (Non US)"
//		WebUI.waitForElementVisible(findTestObject('Object Repository/Checkout/billingNewState'), 10)
//		WebUI.selectOptionByLabel(findTestObject('Object Repository/Checkout/billingNewState'), stateName, false)
//	}
////	String city = city
////	String newAddress = newAddress
//	WebUI.setText(findTestObject('Object Repository/Checkout/city'), city)
//	WebUI.setText(findTestObject('Object Repository/Checkout/newAddress'), newAddress)
//	WebUI.setText(findTestObject('Object Repository/Checkout/newZipCode'), zipCode)
//	WebUI.setText(findTestObject('Object Repository/Checkout/phone'), phone)
//	WebUI.click(findTestObject('Object Repository/Checkout/btn_Billing'))	
//}
//
//WebUI.check(findTestObject('Object Repository/Checkout/pickUpInStore'))
//WebUI.click(findTestObject('Object Repository/Checkout/btn_Shipping'))
// 
//TestObject paymentMethod = new TestObject('dynamicPaymentMethod')
//paymentMethod.addProperty('xpath', ConditionType.EQUALS, "//*[@id='checkout-payment-method-load']//label[contains(text(), '${paymentMethodText}')]")
//WebUI.click(paymentMethod)
//WebUI.click(findTestObject('Object Repository/Checkout/btn_PaymentMethod'))
//WebUI.click(findTestObject('Object Repository/Checkout/btn_PaymentInfo'))
//WebUI.click(findTestObject('Object Repository/Checkout/btn_ConfirmOrder'))
//
//
////Check notifikasi berhasil order
//boolean isOrderSuccessNotification = WebUI.verifyElementPresent(findTestObject('Checkout/successCheckoutNotification'), 0, FailureHandling.OPTIONAL)
//if (isOrderSuccessNotification) {
//		println('Test Passed')
//	} else {
//		assert false : 'Test failed: Element order success notification are not found'
//	}
//
//WebUI.click(findTestObject('Object Repository/Checkout/link_OrderDetail'))
//
////Cek apakah detail pesanan tampil
//boolean isOrderDetailSucess = WebUI.verifyElementPresent(findTestObject('Checkout/orderInformation'), 0, FailureHandling.OPTIONAL)
//if (isOrderDetailSucess) {
//		println('Test Passed')
//	} else {
//		assert false : 'Test failed: Element order detail are not found'
//	}
//
//WebUI.takeFullPageScreenshot()
//WebUI.closeBrowser()
//	
//
//
//
