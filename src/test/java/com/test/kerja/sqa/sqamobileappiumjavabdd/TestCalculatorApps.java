package com.test.kerja.sqa.sqamobileappiumjavabdd;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.test.kerja.sqa.sqamobileappiumjavabdd.driver.DriverSingleton;
import com.test.kerja.sqa.sqamobileappiumjavabdd.scenariopage.FungsiKalkulator;
import com.test.kerja.sqa.sqamobileappiumjavabdd.utilstest.Reporting;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class TestCalculatorApps extends Reporting {
	
	AppiumDriver<MobileElement> driver;
	
	FungsiKalkulator kalkulator;
	
		
	@BeforeTest
	public void openCalculator() {
		
		DriverSingleton driverSingleton = DriverSingleton.getInstance();
		driver = driverSingleton.getDriver();
		kalkulator = new FungsiKalkulator();
		
		System.out.println("Appium Testing started...");
	}
	
	@Test(priority = 1)
	public void fungsi1Tambah() {
		
		ExtentTest test1 = extentReports.createTest("Step 1","fungsi tambah");
		test1.log(Status.INFO, "Step 1");
//		test1.log(Status.INFO, "Step 1");
		
		kalkulator.pertambahan();
		
		test1.log(Status.PASS, "Fungsi 1 Tambah berhasil");
		
		
	}
	
	@Test(priority = 2)
	public void fungsi2Kali() {
		ExtentTest test2 = extentReports.createTest("Step 2","Fungsi Perkalian");
		test2.log(Status.INFO, "Step 2");	
		
		kalkulator.perkalian();
		
		test2.log(Status.PASS, "Fungsi 2 Perkalian berhasil");
	}
	
	@Test(priority = 3)
	public void fungsi22Kali() {
		ExtentTest test2 = extentReports.createTest("Step 3","Fungsi Perkalian SKIP");
		test2.log(Status.INFO, "Step 3");	
		
		kalkulator.perkalian();
		
		test2.log(Status.PASS, "Fungsi 3 Perkalian berhasil SKIP");
		test2.log(Status.PASS, "Fungsi 4 Perkalian berhasil Warning");
	}
	
	@Test(priority = 4)
	public void fungsi222Kali() throws IOException {
		ExtentTest test2 = extentReports.createTest("Step 4","Fungsi Perkalian Warning");
		test2.log(Status.INFO, "Step 4");	
		
		kalkulator.perkalian();
		
		test2.log(Status.PASS, "Fungsi 4 Perkalian berhasil Warning");
		test2.fail("Click admin menu",
				MediaEntityBuilder.createScreenCaptureFromPath(failcaptureScreen()).build());
	}
	
	
	
	
	
	//CAPTURE PHOTO TESTING
		public String failcaptureScreen() throws IOException {
			TakesScreenshot screen = (TakesScreenshot) driver;
			File src = screen.getScreenshotAs(OutputType.FILE);
			String dest = "C:\\Users\\ACER\\Desktop\\JCCODING\\sqa\\com.test.kerja.sqa.sqamobileappiumjavabdd\\src\\test\\resources\\failevidence\\"
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
