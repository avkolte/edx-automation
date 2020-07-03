
package pageObjects;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	 public WebDriver driver;

	String searchbox="//input[@id='main-search-bar']";
	String searchbtn="//button[@id='search-box-submit']";	
	String courses = "//button[contains(text(),'Courses')]";
	String level = "//div[4]//div[1]//div[1]//button[1]";
	String level_intro = "//div[@class='collapsible open']//li[1]";
	String lang = "//div[6]//div[1]//div[1]//button[1]";
	String lang_eng = "//div[@class='collapsible open']//li[1]";
	String firstcourse = "//div[@id='displayed-results']//div[1]//a[1]//div[1]//div[1]//img[1]";
	String firstcoursename = "//h1[@class='course-intro-heading mb-2']";
	String firstcoursetime = "//span[contains(text(),'3 Weeks')]";
	String secondcourse = "//div[@class='scrollable-mobile-discovery-card-list d-flex m-xl-0 flex-wrap disable-scrolling']//div[2]//a[1]//div[1]//div[1]//img[1]";
	String secondcoursename = "//h1[@class='course-intro-heading mb-2']";
	String secondcoursetime = "//span[contains(text(),'5 Weeks')]";
	String email = "//input[@id='login-email']";
	String password = "//input[@id='login-password']";
	String loginbutton = "//button[@class='action action-primary action-update js-login login-button']";

	public LandingPage(WebDriver driver) 
	{	
		this.driver=driver;	
	}

	public WebElement getEmail() throws IOException
	{
		
		return driver.findElement(By.xpath(email));
	}

	public WebElement getPassword() throws IOException
	{
		
		return driver.findElement(By.xpath(password));
	}
	
	public WebElement getLoginButton() throws IOException
	{
		
		return driver.findElement(By.xpath(loginbutton));
	}

	public WebElement getSearchBox() throws IOException
	{
		
		return driver.findElement(By.xpath(searchbox));
	}
	
	public WebElement getSearchBtn() throws IOException
	{
		
		return driver.findElement(By.xpath(searchbtn));
	}

	public WebElement getCourses() throws IOException
	{
		return driver.findElement(By.xpath(courses));
	}
	
	public WebElement getLevel() throws IOException
	{
		return driver.findElement(By.xpath(level));
	}
	
	public WebElement getLevelAsIntro() throws IOException
	{
		return driver.findElement(By.xpath(level_intro));
	}
	
	public WebElement getLang() throws IOException
	{
		return driver.findElement(By.xpath(lang));
	}
	
	public WebElement getLangAsEng() throws IOException
	{
		return driver.findElement(By.xpath(lang_eng));
	}

	public WebElement getFirstCourse() throws IOException{
		return driver.findElement(By.xpath(firstcourse));	
	}

	public WebElement getFirstCourseName() throws IOException{
		return driver.findElement(By.xpath(firstcoursename));
	}

	public WebElement getFirstCourseTime() throws IOException{
		return driver.findElement(By.xpath(firstcoursetime));
	}

	public WebElement getSecondCourse() throws IOException{
		return driver.findElement(By.xpath(secondcourse));	
	}

	public WebElement getSecondCourseName() throws IOException{
		return driver.findElement(By.xpath(secondcoursename));
	}

	public WebElement getSecondCourseTime() throws IOException{
		return driver.findElement(By.xpath(secondcoursetime));
	}


	
}
