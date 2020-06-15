package resources;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Driver {

	public static WebDriver driver;
	public Properties prop;

public WebDriver initializeDriver() throws IOException
{
	
 prop= new Properties();
FileInputStream fis=new FileInputStream("/home/avkolte/eclipse-workspace/edx-automation/src/main/java/resources/config.properties");

prop.load(fis);
String browserName=prop.getProperty("browser");
System.out.println(browserName);

if(browserName.equals("chrome"))
{
	 System.setProperty("webdriver.chrome.driver", "/home/avkolte/eclipse-workspace/edx-automation/drivers/chromedriver");
	driver= new ChromeDriver();
		
	System.out.println("Driver Initialized...");
	driver.get(prop.getProperty("url"));
	
}
else if (browserName.equals("firefox"))
{
	
	 System.setProperty("webdriver.gecko.driver", "/home/avkolte/eclipse-workspace/edx-automation/drivers/geckodriver");
;
	 driver= new FirefoxDriver();
	 System.out.println("Driver Initalized...");
	 driver.get(prop.getProperty("url"));
	
}

else if(browserName.equals("opera"))
{
	 System.setProperty("webdriver.chrome.driver", "/home/avkolte/eclipse-workspace/edx-automation/drivers/operadriver");
	driver= new OperaDriver();
		
	System.out.println("Driver Initalized...");
	driver.get(prop.getProperty("url"));
	
}


driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
return driver;


}



}