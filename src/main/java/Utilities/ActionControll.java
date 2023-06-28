package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionControll {
	WebDriver driver;
	WebElement element;
	Actions action=new Actions(driver);
	public void moveToElement(WebElement element)
	{
		action.moveToElement(element).click().build().perform();
	}
	public void dragAnddrop(WebElement source,WebElement target)
	{
		action.dragAndDrop(source,target).build().perform();
	}
	public void doubleClick(WebElement element)
	{
		action.doubleClick(element).build().perform();
	}

}
