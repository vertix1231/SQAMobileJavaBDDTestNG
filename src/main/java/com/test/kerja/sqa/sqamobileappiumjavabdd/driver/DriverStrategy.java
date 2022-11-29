package com.test.kerja.sqa.sqamobileappiumjavabdd.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public interface DriverStrategy {
	
	public AppiumDriver<MobileElement> setStrategy() throws Exception;

}
