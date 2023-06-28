package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class JavascriptExecutors {
	
	public void scrollToElement(WebElement element,WebDriver driver)
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element);
	}
	public void scrollByPixel(WebDriver driver)
	{
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500)");
	}
	public void ClickjsElement(WebElement element,WebDriver driver)
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",element);
	}
	
}
