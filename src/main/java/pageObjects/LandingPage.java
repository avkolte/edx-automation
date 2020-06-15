
package pageObjects;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	 public WebDriver driver;

	String searchbox="//input[@id='home-search']";
	String searchbtn="//button[@id='edit-submit-home-search']";	

	public LandingPage(WebDriver driver) 
	{	
		this.driver=driver;	
	}

	
	public WebElement getSearchBox() throws IOException
	{
		
		return driver.findElement(By.xpath(searchbox));
	}
	
	public WebElement getSearchBtn() throws IOException
	{
		
		return driver.findElement(By.xpath(searchbtn));
	}
	
}
