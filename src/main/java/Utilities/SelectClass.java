package Utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SelectClass {
	public void dropdown(WebElement element,int byIndex) throws InterruptedException
	{
		Select obj=new Select(element);
		boolean re = obj.isMultiple();
		Assert.assertEquals(false, re);
		Thread.sleep(3000);
		obj.selectByIndex(byIndex);
		
	}
	public void dropdown(WebElement element,String byValue) throws InterruptedException
	{
		Select obj=new Select(element);
		boolean re = obj.isMultiple();
		Assert.assertEquals(false, re);
		obj.selectByValue(byValue);
		
	}
	public void dropdownByVisibleText(WebElement element,String byVisibleText) throws InterruptedException
	{
		Select obj=new Select(element);
		boolean re = obj.isMultiple();
		Assert.assertEquals(false, re);
		Thread.sleep(3000);
		obj.selectByVisibleText(byVisibleText);
		
	}

}
