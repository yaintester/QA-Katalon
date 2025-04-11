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

WebUI.callTestCase(findTestCase('ReusableTC/OpenWeb'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Register/navbar_register_in_home'))

String gender = gender

if (gender == 'M') {
    WebUI.click(findTestObject('Register/genderMale'))
} else if (gender == 'F') {
    WebUI.click(findTestObject('Register/genderFemale'))
}

WebUI.setText(findTestObject('Register/firstName'), firstName)

WebUI.setText(findTestObject('Register/lastName'), lastName)

WebUI.setText(findTestObject('Register/email'), email)

WebUI.setEncryptedText(findTestObject('Register/password'), password)

WebUI.setEncryptedText(findTestObject('Register/confirmationPassword'), password)

WebUI.click(findTestObject('Register/btn_register'))

WebUI.takeFullPageScreenshot()

boolean isEmailAlreadyUsed = WebUI.verifyElementPresent(findTestObject('Register/emailAlreadyUsed'), 0, FailureHandling.OPTIONAL)

try {
	if (isEmailAlreadyUsed) {
		println('Test Passed')
	} else {
		assert false : 'Test failed:  Notification for email that has already been used is not found'
	}
} catch (Exception e) {
	println("Exception: " + e.getMessage())
} finally {
	WebUI.closeBrowser() 
}


