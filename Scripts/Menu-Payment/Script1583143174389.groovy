import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.Keys

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.SelectorMethod
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.SelectorMethod


WebUI.openBrowser("http://innodev.vnetcloud.com/meikarta/")

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Object Repository/Login-Logout/input_Meikarta_form-control ng-untouched ng-valid ng-dirty'), "meikarta12345")

WebUI.setText(findTestObject('Object Repository/Login-Logout/input_Meikarta_form-control ng-valid ng-dirty ng-touched'), "12345")

WebUI.sendKeys(findTestObject('Object Repository/Login-Logout/button_SIGN IN'), Keys.chord(Keys.ENTER))

WebUI.delay(10)

WebUI.click(findTestObject('Object Repository/Login-Logout/i_Notification_fas fa-bars'))

WebUI.click(findTestObject('Object Repository/Page-Payment/p_ Payment'))



'untuk mengambil object dari elementnya'
TestObject to = findTestObject('Object Repository/Page-Payment/span_Click for detail')

'fungsi random nya'
int randomInt = new Random().nextInt(13 - 9 + 1) + 9

'Change value of CSS selector'
to.setSelectorValue(SelectorMethod.CSS, 'body > div > app-root > app-admin-payment > div.container > div:nth-child(2) > div:nth-child('+randomInt+') > div > div > p:nth-child(3) > small > span')

WebUI.click(to)



WebUI.delay(5)

//new_btn = WebUI.modifyObjectProperty(findTestObject('Object Repository/Page-Payment/span_Click for detail'), 'num', 'equals', "1", true)
//
//WebUI.click(new_btn)

WebUI.click(findTestObject('Object Repository/Page-Payment/button_'))

WebUI.click(findTestObject('Object Repository/Login-Logout/a_Superdmin'))

WebUI.click(findTestObject('Object Repository/Login-Logout/a_Sign Out'))

WebUI.takeScreenshot()

WebUI.closeBrowser()