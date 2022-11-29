package com.test.kerja.sqa.sqamobileappiumjavabdd.scenariopage;



import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.test.kerja.sqa.sqamobileappiumjavabdd.driver.DriverSingleton;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class FungsiKalkulator {
	
	AppiumDriver<MobileElement> driver;
	
	public FungsiKalkulator() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	public void pertambahan() {
		MobileElement satu = driver.findElement(By.id("com.android.calculator2:id/digit_1"));
		
		MobileElement dua = driver.findElement(By.id("com.android.calculator2:id/digit_2"));
		
		MobileElement tambah = driver.findElement(By.id("com.android.calculator2:id/op_add"));
		
		MobileElement samadengan = driver.findElement(By.id("com.android.calculator2:id/eq"));
		
		MobileElement hasil = driver.findElement(By.id("com.android.calculator2:id/result"));
		
		satu.click();
		
		tambah.click();
		
		dua.click();
		
		samadengan.click();
	}
	
	public void perkalian() {
		
		MobileElement tiga = driver.findElement(By.id("com.android.calculator2:id/digit_3"));
		
		MobileElement empat = driver.findElement(By.id("com.android.calculator2:id/digit_4"));
		
		MobileElement kali = driver.findElement(By.id("com.android.calculator2:id/op_mul"));
		
		MobileElement samadengan = driver.findElement(By.id("com.android.calculator2:id/eq"));
		
		MobileElement hasil = driver.findElement(By.id("com.android.calculator2:id/result"));
		
		tiga.click();
		
		kali.click();
		
		empat.click();
		
		samadengan.click();
	}

}
