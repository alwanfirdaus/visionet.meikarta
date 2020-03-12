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
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.SelectorMethod
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.RestRequestObjectBuilder
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.util.KeywordUtil

import groovy.json.JsonSlurper
import groovy.util.logging.Log

import org.json.JSONException
import org.json.JSONObject
import groovy.json.JsonBuilder
import groovy.json.JsonParser
import com.kms.katalon.core.exception.StepErrorException as StepErrorException





WebUI.openBrowser("http://innodev.vnetcloud.com/meikarta/")

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Object Repository/Login-Logout/input_Meikarta_form-control ng-untouched ng-valid ng-dirty'), "meikarta12345")

WebUI.setText(findTestObject('Object Repository/Login-Logout/input_Meikarta_form-control ng-valid ng-dirty ng-touched'), "12345")

WebUI.sendKeys(findTestObject('Object Repository/Login-Logout/button_SIGN IN'), Keys.chord(Keys.ENTER))

WebUI.delay(10)

WebUI.click(findTestObject('Object Repository/Login-Logout/i_Notification_fas fa-bars'))

WebUI.click(findTestObject('Object Repository/Page-Payment/p_ Payment'))




public class SampleRequestObject {
	
	   String endpoint = "http://innodev.vnetcloud.com/liveinpaymentMeikarta/paymenthistory"
	   String requestMethod = "POST"

	   TestObjectProperty header2 = new TestObjectProperty("Content-Type", ConditionType.EQUALS, "application/json")
	   TestObjectProperty header3 = new TestObjectProperty("Accept", ConditionType.EQUALS, "application/json, text/plain, */*")
	   ArrayList defaultHeaders = Arrays.asList(header2, header3)
	   
////	   Jika tidak segaris, tambahkan tanda "\"
	   String body = '{\
			"orgid": "1",\
			"email": "wahyu_zulkarnaen@gmail.com",\
			"payment_method": "",\
			"start_number_of_unit": "",\
			"end_number_of_unit": "",\
			"start_date": "",\
			"end_date": ""\
		}'
	
	   /**
	   * POST requests
	   * @return
	   */
		
////		Jika ingin mendapatkan response dengan request object normal
	   public ResponseObject buildPostApiRequest1() {
		   RequestObject ro = new RequestObject("objectId")
		   ro.setRestUrl(endpoint)
		   ro.setHttpHeaderProperties(defaultHeaders)
		   ro.setRestRequestMethod(requestMethod)
		   ro.setBodyContent(new HttpTextBodyContent(body))
			
		   ResponseObject respObj = WS.sendRequest(ro)
		   return respObj
	   }
	   	   
////	   Jika ingin mendapatkan response dengan request object builder
//	   public ResponseObject buildPostApiRequest2() {
//		   RequestObject ro = new RestRequestObjectBuilder()
//		   .withRestUrl(endpoint)
//		   .withHttpHeaders(defaultHeaders)
//		   .withRestRequestMethod("POST")
//		   .withTextBodyContent(body)
//		   .build()
//			
//		   ResponseObject respObj = WS.sendRequest(ro)
//		   return respObj
//	   }
}

SampleRequestObject sro = new SampleRequestObject()
ResponseObject response = sro.buildPostApiRequest1()
println(response.getResponseText())


responseText = response.getResponseText()
Object json = new JsonSlurper().parseText(responseText)
//println ("Jumlah data = "+json.data.size())


int dataLength = 0
dataLength = json.data.size()
try {
	JSONObject jsonObject = new JSONObject(response)
	
	dataLength = jsonObject.getJSONArray("data").length()
}
catch (JSONException err){
	println("Error! "+ err.toString())
//	assert WebUI.waitForElementVisible(err, 5, FailureHandling.STOP_ON_FAILURE)
}
println ("Jumlah Data = " + dataLength)



'untuk mengambil object dari elementnya'
TestObject to = findTestObject('Object Repository/Page-Payment/span_Click for detail')

'fungsi random nya'
int randomInt
if (dataLength > 0){
	 randomInt = new Random().nextInt(dataLength - 1 + 1) + 1
} else {
	KeywordUtil.markPassed().equals(null)
	WebUI.closeBrowser()
	return
//	throw new StepErrorException("FORCEDSTOP")
}



'Change value of CSS selector'
to.setSelectorValue(SelectorMethod.CSS, 'body > div > app-root > app-admin-payment > div.container > div:nth-child(2) > div:nth-child('+randomInt+') > div > div > p:nth-child(3) > small > span')

WebUI.click(to)



WebUI.takeScreenshot()

WebUI.delay(5)



////Fungsi random manual dengan melakukan edit pada "key" nya
//new_btn = WebUI.modifyObjectProperty(findTestObject('Object Repository/Page-Payment/span_Click for detail'), 'num', 'equals', "1", true)
//
//WebUI.click(new_btn)
//
WebUI.click(findTestObject('Object Repository/Page-Payment/button_'))

WebUI.click(findTestObject('Object Repository/Login-Logout/a_Superdmin'))

WebUI.click(findTestObject('Object Repository/Login-Logout/a_Sign Out'))

WebUI.closeBrowser()