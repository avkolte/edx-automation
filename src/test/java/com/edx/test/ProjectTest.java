package com.edx.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import pageObjects.LandingPage;
import resources.Driver;
import resources.ScreenShot;
import resources.readExcel;

import com.beust.jcommander.Parameter;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;
 
public class ProjectTest{
   

    boolean status = false;
    public WebDriver driver;

     //Opening browser with the given URL and navigate to Registration Page

    @BeforeTest
	public void createDriver() throws IOException
	{
		Driver obj = new Driver();
        driver=obj.initializeDriver();
    
	}
   
    // Registration without providing user email field
    @Test
    public void emptyEmailTest()
    {
         
        WebElement fullName = driver.findElement(By.name("name"));
        fullName.sendKeys("test");
         
        
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys(Keys.CONTROL+"a");
        email.sendKeys(Keys.DELETE);
        email.sendKeys("");
                 
        WebElement password = driver.findElement(By.name("password"));
       // password.sendKeys(Keys.CONTROL+"a");
        //password.sendKeys(Keys.DELETE);
        password.sendKeys("Test@123");
         
         
        WebElement signUp = driver.findElement(By.xpath("/html/body/div[3]/div/div/span/div[3]/div/div/div[3]/div/div/div/div[3]/div[1]/div[1]/form/div/button/span"));
        signUp.click();
       
        String expectedErrorMsg = "Please enter an email address";
       
        String actualErrorMsg = driver.findElement(By.name("email")).getAttribute("validationMessage");
       
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
    }
   
   
    // Registration without providing password field
    @Test
    public void emptyPasswordTest()
    {
   
         
       /* WebElement fullName = driver.findElement(By.name("name"));
        fullName.sendKeys("TestName");*/
         
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("test@test.com");
                 
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys(Keys.CONTROL+"a");
        password.sendKeys(Keys.DELETE);
        password.sendKeys("");
   
        WebElement signUp = driver.findElement(By.xpath("/html/body/div[3]/div/div/span/div[3]/div/div/div[3]/div/div/div/div[3]/div[1]/div[1]/form/div/button/span"));
        signUp.click();
       
        String expectedErrorMsg = "Please enter a password";
       
        String actualErrorMsg = driver.findElement(By.name("password")).getAttribute("validationMessage");

       
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
    }
   
      // Registration with all valid data
      @Test
      public void validRegistrationTest(){            
               
               
        driver.findElement(By.xpath("//a[@class='btn']")).click();;    
          WebElement email = driver.findElement(By.xpath("//input[@id='login-email']"));
          email.sendKeys("anupkolte92@gmail.com");
           
          WebElement password = driver.findElement(By.xpath("//input[@id='login-password']"));
          password.sendKeys("");
   
           WebElement signUp = driver.findElement(By.xpath("//button[contains(@class,'action action-primary action-update js-login login-button')]"));
          signUp.click();
      }

      //Test function for correct search
      @Test
      public void rightSearch() throws IOException, InterruptedException
      {
          LandingPage l = new LandingPage(driver);
          readExcel e = new readExcel();
          //String input=e.getexcel(0,0);
          l.getSearchBox().sendKeys("Web Development");
          l.getSearchBtn().click();
          Thread.sleep(10000);
          ScreenShot s = new ScreenShot();
          s.screenShotCapture(driver);
      
      }
      //Test function for wrong search by entering wrong keywords
      @Test
      public void wrongSearch() throws IOException, InterruptedException
      {
          LandingPage l = new LandingPage(driver);
          readExcel e = new readExcel();
          String input=e.getexcel(1,0);
          l.getSearchBox().sendKeys(Keys.CONTROL+"a");
          l.getSearchBox().sendKeys(Keys.DELETE);
          l.getSearchBox().sendKeys(input);
          l.getSearchBtn().click();
          Thread.sleep(10000);
          ScreenShot s = new ScreenShot();
          s.screenShotCapture(driver);
      
      }
      //Test function for empty search i.e. nothing is passs as keywords
      @Test
      public void emptySearch() throws IOException, InterruptedException
      {
          LandingPage l = new LandingPage(driver);
          l.getSearchBox().sendKeys(Keys.CONTROL+"a");
          l.getSearchBox().sendKeys(Keys.DELETE);
          l.getSearchBtn().click();
          Thread.sleep(10000);
          ScreenShot s = new ScreenShot();
          s.screenShotCapture(driver);
      
      }

      @Test
	public void filtertest() throws Exception {
				
		/*************** To wait for page load *********************/		
		
		/*************** To searching for web development *********************/
		Thread.sleep(10000);     
		LandingPage l = new LandingPage(driver);
		readExcel e = new readExcel();
		String input=e.getexcel(0,0);
		l.getSearchBox().sendKeys(input);
		l.getSearchBtn().click();
		Thread.sleep(10000);    
		
		
		/*************** For setting Language as English *********************/
	
		
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div/div/div[1]/div[2]/div[1]/div/div[2]/div/div/div[1]/div/div/div/div/div[1]")).click();
	    WebElement dropdownValue1 = driver.findElement(By.xpath("//*[@id=\"filter_all_languages_checked_button\"]/label/input"));
	    dropdownValue1.click();									 
		Thread.sleep(10000);
		
		
		/*************** For setting Level as Beginner *********************/
	
		
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div/div/div[1]/div[2]/div[1]/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")).click();
	    WebElement dropdownValue2 = driver.findElement(By.xpath("//*[@id=\"filter_skills_checked_button\"]"));
	    dropdownValue2.click();
		Thread.sleep(10000);
		
		
		/*************** For setting Learning product as Course *********************/
	
		
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div/div/div[1]/div[2]/div[1]/div/div[2]/div/div/div[5]/div/div/div/div/div[1]")).click();
	    WebElement dropdownValue3 = driver.findElement(By.xpath("//*[@id=\"filter_partners_checked_button\"]/label/input"));
	    dropdownValue3.click();
		
		Thread.sleep(10000);
		
    }
    
    @Test
   public void courseInfo()
   {
        
    
        
    

   }
    
        

        
}




