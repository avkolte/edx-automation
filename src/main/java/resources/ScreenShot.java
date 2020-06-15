package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {

	public void screenShotCapture(WebDriver driver) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis =new FileInputStream("/home/avkolte/eclipse-workspace/edx-automation/src/main/java/resources/config.properties");
		prop.load(fis);
		TakesScreenshot ss = (TakesScreenshot)driver;
		File src = ss.getScreenshotAs(OutputType.FILE);
		//File dest = new File(prop.getProperty("ss")+System.currentTimeMillis()+".png");
		//FileUtils.copyDirectory(src, dest);
		FileUtils.copyFile(src, new File(prop.getProperty("ss")+System.currentTimeMillis()+"screenshot.png"));
	}
}
