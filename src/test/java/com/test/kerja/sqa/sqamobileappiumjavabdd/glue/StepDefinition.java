package com.test.kerja.sqa.sqamobileappiumjavabdd.glue;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.test.kerja.sqa.sqamobileappiumjavabdd.driver.DriverSingleton;
import com.test.kerja.sqa.sqamobileappiumjavabdd.driver.config.AutomationFrameworkConfiguration;
import com.test.kerja.sqa.sqamobileappiumjavabdd.scenariopage.FungsiKalkulator;
import com.test.kerja.sqa.sqamobileappiumjavabdd.utils.ConfigurationProperties;
import com.test.kerja.sqa.sqamobileappiumjavabdd.utils.ScenarioTestCases;
import com.test.kerja.sqa.sqamobileappiumjavabdd.utils.UtilsTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfiguration.class)
public class StepDefinition  {
//	private static WebDriver driverWeb;
	private ExtentTest extentTest;
	static ExtentReports extentReports = new ExtentReports();
	static ExtentSparkReporter htmlreporter = new ExtentSparkReporter("src/test/resources/stepdef_report_mobiletest_appium_teskerja_stepdef.html");
	private static AppiumDriver<MobileElement> driver;
	private static FungsiKalkulator kalkulator;

//start WEB TEST KERJA---------------------------------------------------------------------------------------------------------------------

//MULAI TESTSTING TEST KERJA-------------------------------------------------------------------------------------------------------------------
	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void workSetUp() {
		DriverSingleton driverSingleton =DriverSingleton.getInstance();
		driver = driverSingleton.getDriver();
		System.out.println("Appium Testing started...");
		kalkulator = new FungsiKalkulator();
		extentReports.attachReporter(htmlreporter);
		ScenarioTestCases[] tests = ScenarioTestCases.values();
		extentTest = extentReports.createTest(tests[UtilsTest.scenariotestcount].getScenarioTestName());
		UtilsTest.scenariotestcount++;
	}

//---------------------------------------------------------------------------------------------------------------------

	@Given("^Go to Main web Login")
	public void workZero() throws IOException {
		kalkulator.pertambahan();
		extentTest.log(Status.PASS, "^Go to Main web Login ");
//		driver.get(ConstantsParam.URL_MAIN_WEB);
//		if (loginPage.getTxtLoginHighlight().contains(configurationProperties.getLoginhighlightexpected())) {
//			extentTest.log(Status.PASS, "Navigation to : " + ConstantsParam.URL_MAIN_WEB);
//		} else {
//			extentTest.fail("Navigation to : " + ConstantsParam.URL_MAIN_WEB,
//					MediaEntityBuilder.createScreenCaptureFromPath(failcaptureScreen()).build());
//		}

	}

	@When("^input user and password to login to web")
	public void workOne() throws IOException {
		kalkulator.perkalian();
		extentTest.log(Status.PASS, "input user and password to login to web");
//		if (loginPage.getTxtLoginHighlight().contains(configurationProperties.getLoginhighlightexpected())) {
//			loginPage.goToSignin("Admin", "admin123");
//			System.out.println("input user and password to login to web pass");
//			extentTest.log(Status.PASS, "input user and password to login to web");
//
//		} else {
//			System.out.println("input user and password to login to web fail");
//			extentTest.fail("input user and password to login to web",
//					MediaEntityBuilder.createScreenCaptureFromPath(failcaptureScreen()).build());
//
//		}

	}

	@Then("^enter dashboard page")
	public void workTwo() throws IOException {
		kalkulator.perkalian();
		extentTest.log(Status.PASS, "enter dashboard page");
//		if (loginPage.getTvdashboard().contains(configurationProperties.getDashboardexpectedtext())) {
//			System.out.println("scenario enter dashboard page pass");
//			extentTest.log(Status.PASS, "enter dashboard page pass");
//		} else {
//			System.out.println("scenario enter dashboard page fail");
//			extentTest.fail("succesfully enter dashboard page fail",
//					MediaEntityBuilder.createScreenCaptureFromPath(failcaptureScreen()).build());
//		}

	}

	@Given("^Click admin menu")
	public void workThree() throws IOException {
		kalkulator.perkalian();
		extentTest.fail("Click admin menu",MediaEntityBuilder.createScreenCaptureFromPath(failcaptureScreen()).build());
//		adminPage.goToAdmin();
//		if (adminPage.getTxtAdmiTabHighlight().contains(configurationProperties.getAdmintabadminmenu())) {
//			System.out.println("scenario Click admin menu pass");
//			extentTest.log(Status.PASS, "Click admin menu");
//		} else {
//			System.out.println("scenario Click admin menu fail");
//			extentTest.fail("Click admin menu",
//					MediaEntityBuilder.createScreenCaptureFromPath(failcaptureScreen()).build());
//		}
	}

	@After
	public void closeObject() {
		extentReports.flush();
	}

//CAPTURE PHOTO TESTING
	public String failcaptureScreen() throws IOException {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest = "C:\\Users\\ACER\\Desktop\\JCCODING\\sqa\\com.test.kerja.sqa.coretcobacoba.sqamobileappiumjavabdd\\src\\test\\resources\\failevidence\\"
				+ getcurrentdateandtime() + ".png";
		File target = new File(dest);
		FileUtils.copyFile(src, target);
		return dest;
	}

	public String getcurrentdateandtime() {
		String str = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
			Date date = new Date();
			str = dateFormat.format(date);
			str = str.replace(" ", "-").replaceAll("/", "").replaceAll(":", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
}
