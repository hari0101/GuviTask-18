package guvitask18;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DragandDrop {
		
	static String expectedtext = "Dropped!"; 
	
	public static void main(String[] args) {

		//Creating thr firefox browser instance.
		WebDriver fox = new FirefoxDriver();
		//Maximize the browser window
		fox.manage().window().maximize();
		//Implicit wait initialize to webdriver(fox)
		fox.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Navigating to the website
		fox.get("https://jqueryui.com/droppable/");
		
		//Drag and Drop element are inside the iframe element.
		//Find the iframe element
		WebElement iframe = fox.findElement(By.cssSelector(".demo-frame"));
		//Switching to the control to iframe.
		fox.switchTo().frame(iframe);
		
		//locators of the drag and drop objects inside the frame.
		WebElement dragobject= fox.findElement(By.id("draggable"));
		WebElement dropobject = fox.findElement(By.id("droppable"));
		
		//To make Drag and Drop action we must use the Action class from selenium.	
		Actions act = new Actions(fox);
		
		//Getting the CSS color property of drop element before the drop takes place.
		String beforecolor = dropobject.getCssValue("color");
		System.out.println("CSS color element before drop :" + beforecolor + "\n");
		
		//Text of the drop element before DragandDrop
		System.out.println("Text of the element before DragandDrop done : " + dropobject.getText() + "\n");
		
		//Invoking the webelement variable to perform the draganddrop action.
		act.dragAndDrop(dragobject, dropobject).build().perform();
		
		//Getting the CSS color property of dropped element after the drop takes place.
		String aftercolor = dropobject.getCssValue("color");
		System.out.println("CSS color element after dropped :" + aftercolor + "\n");
		//Getting the text element of the dropped. 
		String actualtext = dropobject.getText();
		System.out.println("Text of the element after DragandDrop : " + actualtext + "\n");
		
		//Try-catch to handle the assertion exception if the result and exception is not matched.
		try {
		Assert.assertEquals(actualtext, expectedtext, "The text must match with the expected result --");
			}
		catch(AssertionError e) //Java Exception
		{
			System.out.println("Assertion Failed : " + e.getMessage()); //Prints if the result is not matched.
		}
		
		
	}

}
