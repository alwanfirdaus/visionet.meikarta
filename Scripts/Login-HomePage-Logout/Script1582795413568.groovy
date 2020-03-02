import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.Keys as Keys

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable



WebUI.openBrowser("http://innodev.vnetcloud.com/meikarta/")

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Object Repository/Login-Logout/input_Meikarta_form-control ng-untouched ng-valid ng-dirty'), "meikarta12345")

WebUI.setText(findTestObject('Object Repository/Login-Logout/input_Meikarta_form-control ng-valid ng-dirty ng-touched'), "12345")

WebUI.sendKeys(findTestObject('Object Repository/Login-Logout/button_SIGN IN'), Keys.chord(Keys.ENTER))

WebUI.delay(10)

WebUI.click(findTestObject('Object Repository/Login-Logout/i_Notification_fas fa-bars'))

WebUI.click(findTestObject('Object Repository/Login-Logout/a_Superdmin'))

WebUI.click(findTestObject('Object Repository/Login-Logout/a_Sign Out'))

//WebUI.takeScreenshot()

WebUI.closeBrowser()