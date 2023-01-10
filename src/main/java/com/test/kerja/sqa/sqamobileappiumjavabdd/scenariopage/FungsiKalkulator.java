package com.test.kerja.sqa.sqamobileappiumjavabdd.scenariopage;

import org.openqa.selenium.support.PageFactory;

import com.test.kerja.sqa.sqamobileappiumjavabdd.driver.DriverSingleton;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FungsiKalkulator {

	private AppiumDriver<MobileElement> driver;

	public FungsiKalkulator() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

    @AndroidFindBy(id = "com.android.calculator2:id/digit_1")
    private MobileElement btnSatu;
    @AndroidFindBy(id = "com.android.calculator2:id/digit_2")
    private MobileElement btnDua;
    @AndroidFindBy(id = "com.android.calculator2:id/op_add")
    private MobileElement btnTambah;
    @AndroidFindBy(id = "com.android.calculator2:id/eq")
    private MobileElement btnSamaDengan;
    @AndroidFindBy(id = "com.android.calculator2:id/result")
    private MobileElement hasil;
    @AndroidFindBy(id = "com.android.calculator2:id/digit_3")
    private MobileElement btnTiga;
    @AndroidFindBy(id = "com.android.calculator2:id/digit_4")
    private MobileElement btnEmpat;
    @AndroidFindBy(id = "com.android.calculator2:id/op_mul")
    private MobileElement btnKali;

    
	public void pertambahan() {
		btnSatu.click();
		btnTambah.click();
		btnDua.click();
		btnSamaDengan.click();
	}

	public void perkalian() {

		btnTiga.click();
		btnKali.click();
		btnEmpat.click();
		btnSamaDengan.click();
	}

}
