package guvitask18;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FacebookSignup {
	// Initializing the string to verify the correct page.
	static String expectedtitle = "Facebook - Homepage";

	public static void main(String[] args) {

		// Chromedriver instance.
		WebDriver chrome = new ChromeDriver();
		// maximizing the webbrowser
		chrome.manage().window().maximize();
		// Pageload wait untill the entire webbrowser is loaded within specific time.
		chrome.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		// Global wait for all element.
		chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		// Navigating to website
		chrome.get("https://www.facebook.com/");

		// Selecting the create new account button.
		chrome.findElement(By.xpath("//a[normalize-space(text())= 'Create new account']")).click();

		// Title of the page before creating account.
		String actualtitle = chrome.getTitle(); 	System.out.println(actualtitle + "\n");
		
		//Verify the expected and actual title using assert.
		//try-catch to handle the exception.
		try {
			
			Assert.assertEquals(actualtitle, expectedtitle, "Page title doesn't match!");
		}
		catch(AssertionError e){
			
			//Throws the above string if the assert fails.
			System.out.println("Condition failed : " + e.getMessage());
		}
		
		//Passing all the values to the SIGN UP form
		
		//First name field.
		chrome.findElement(By.name("firstname")).sendKeys("Maria");
		//Surname or lastname field.
		chrome.findElement(By.name("lastname")).sendKeys("Jose");
		//Email field.
		chrome.findElement(By.name("reg_email__")).sendKeys("testusertestmail.com@gmail.com");
		//Password field.
		chrome.findElement(By.name("reg_passwd__")).sendKeys("Testaccount@001");
		
		//Selecting the drop down items
		//Birth_Date
		WebElement dropbirth = chrome.findElement(By.name("birthday_day"));
		//Create an instance to make dropdown action on date.
		Select date = new Select(dropbirth);
		//selecting the date by index.
		date.selectByIndex(10);	
		
		//Birth_Month
		WebElement dropmonth = chrome.findElement(By.name("birthday_month"));
		//Create an instance to make dropdown action on month.
		Select month = new Select(dropmonth);
		//Selecting the month by text.
		month.selectByVisibleText("May");
		
		//Birth_Year
		WebElement dropyear = chrome.findElement(By.name("birthday_year"));
		//Create an instance to make dropdown action on year.
		Select year = new Select(dropyear);	
		//Selecting the month by value.
		year.selectByValue("1985");
		
		//Clicking the male radiobutton
		chrome.findElement(By.xpath("//label[text() = 'Male']")).click();
		
		//Click the Sign Up button
		chrome.findElement(By.cssSelector("button[name ='websubmit']")).click();
		
	}

}
