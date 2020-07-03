package org.edx.test;

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
import resources.WriteExcel;
import resources.ReadExcel;

import com.beust.jcommander.Parameter;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.net.ssl.SSLEngineResult.Status;

public class ProjectTest {

    public WebDriver driver;
    ReadExcel input = new ReadExcel();

    // Opening browser with the given URL and navigate to Registration Page

    @BeforeTest
    public void createDriver() throws IOException {
        Driver obj = new Driver();
        driver = obj.initializeDriver();
        driver.manage().window().maximize();

    }

 

    // Registration without providing user email field
    @Test
    public void invalidLogin() throws IOException {
         
        driver.findElement(By.xpath("//a[@class='btn']//span[contains(text(),'Sign In')]")).click();
        LandingPage l = new LandingPage(driver);
        

        String passwordData=input.getexcel(1,1);
        l.getPassword().sendKeys(passwordData);  
      
        l.getLoginButton().click();
        
        String expectedErrorMsg1 = "Please enter your Email.";
        
        WebElement actualErrorMsg1 = driver.findElement(By.xpath("//ul[@class='message-copy']//li[contains(text(),'Please enter your Email.')]"));
        String actual1=actualErrorMsg1.getText();
          
        Assert.assertEquals(actual1, expectedErrorMsg1);
        String emailData=input.getexcel(1,0);
        l.getEmail().sendKeys(emailData);
                 
        l.getPassword().sendKeys(Keys.CONTROL+"a");
        l.getPassword().sendKeys(Keys.DELETE);
       
        l.getLoginButton().click();

        String expectedErrorMsg2 = "Please enter your Password.";
     
        WebElement actualErrorMsg2 = driver.findElement(By.xpath("//ul[@class='message-copy']//li[contains(text(),'Please enter your Password.')]"));
        String actual2=actualErrorMsg2.getText();
     
        Assert.assertEquals(actual2, expectedErrorMsg2);
    }
   

    @Test
    public void validLogin() throws IOException
    {
        LandingPage l = new LandingPage(driver);


        l.getEmail().sendKeys(Keys.CONTROL+"a");
        l.getEmail().sendKeys(Keys.DELETE);

        l.getPassword().sendKeys(Keys.CONTROL+"a");
        l.getPassword().sendKeys(Keys.DELETE);
   
        String emailData=input.getexcel(1,0);
        l.getEmail().sendKeys(emailData);                  
       
        String passwordData=input.getexcel(1,1);
        l.getPassword().sendKeys(passwordData);  
        
        
         l.getLoginButton().click();
         driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
         driver.findElement(By.xpath("//a[@class='btn-neutral']")).click();

    }

 
    // Test function for correct search
    @Test
    public void rightSearch() throws IOException, InterruptedException {
       
        LandingPage l = new LandingPage(driver);
        l.getSearchBox().sendKeys(Keys.CONTROL + "a");
        l.getSearchBox().sendKeys(Keys.DELETE);
        l.getSearchBox().sendKeys("Web Development");
        l.getSearchBtn().click();
        Thread.sleep(10000);
        ScreenShot s = new ScreenShot();
        s.screenShotCapture(driver);

    }

    // Test function for wrong search by entering wrong keywords
    @Test
    public void wrongSearch() throws IOException, InterruptedException {
        LandingPage l = new LandingPage(driver);
        l.getSearchBox().sendKeys(Keys.CONTROL + "a");
        l.getSearchBox().sendKeys(Keys.DELETE);
        l.getSearchBox().sendKeys("10 tola sona");
        l.getSearchBtn().click();
        Thread.sleep(10000);
        ScreenShot s = new ScreenShot();
        s.screenShotCapture(driver);

    }

    // Test function for empty search i.e. nothing is passs as keywords
    @Test
    public void emptySearch() throws IOException, InterruptedException {
        LandingPage l = new LandingPage(driver);
        l.getSearchBtn().click();
        Thread.sleep(10000);
        ScreenShot s = new ScreenShot();
        s.screenShotCapture(driver);

    }

    @Test
    public void filterTest() throws Exception {

        /***************
         * To create and initialize LandingPage's object
         *********************/

        LandingPage l = new LandingPage(driver);

        /*************** For setting Learning product as Course *********************/

        l.getCourses().click();

        Thread.sleep(10000);
        /*************** For setting Level as Beginner *********************/

        l.getLevel().click();
        l.getLevelAsIntro().click();

        Thread.sleep(10000);

        /*************** For setting Language as English *********************/

        l.getLang().click();
        l.getLangAsEng().click();

        Thread.sleep(10000);

    }

    @Test
    public void courseInfo() throws Exception {

        LandingPage l = new LandingPage(driver);

        String[] courses = new String[2];
        String[] time = new String[2];

        // get first coursename

        l.getFirstCourse().click();
        Thread.sleep(10000);

        WebElement exp1 = l.getFirstCourseName();
        String course1 = exp1.getText();
        Thread.sleep(10000);
        courses[0] = course1;

        WebElement exp2 = l.getFirstCourseTime();
        String time1 = exp2.getText();
        Thread.sleep(10000);
        time[0] = time1;

        driver.navigate().back();

        // get second course name
        Thread.sleep(10000);

        l.getSecondCourse().click();
        Thread.sleep(10000);

        WebElement exp3 = l.getSecondCourseName();
        String course2 = exp3.getText();
        Thread.sleep(10000);
        courses[1] = course2;

        WebElement exp4 = l.getSecondCourseTime();
        String time2 = exp4.getText();
        Thread.sleep(10000);
        time[1] = time2;

        // Creating object for writeResultToExcel class and writing result in excel.

        WriteExcel wr = new WriteExcel();
        wr.writeExcel(courses, time);
        //Logger.log(Status.INFO, "Data written in excel sheet- " + name);
           
       
   
      }

      @AfterClass
      public void closeBrowser()
      {
        driver.close();
        driver=null;
      }
       
    
        

        
}




