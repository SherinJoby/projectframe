package testng;

import org.testng.annotations.Test;

import Utilities.ExcelReader;
import Utilities.ReadConfigProperty;
import Utilities.Retry;
import Utilities.WebDriverManager;
import pageElements.UnitPageElements;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
@Listeners(Utilities.TestListener.class)
public class LoginPage extends WebDriverManager{
	ReadConfigProperty objprop = new ReadConfigProperty();
	public static WebDriver driver;
	UnitPageElements unitelement;
	ExcelReader objexcel=new ExcelReader();
  
 
  @Test(priority = 1,enabled =true,dataProvider ="logins")
  public void loginSite(String id,String password) {
	  unitelement.login(id,password);
	  Assert.assertEquals(unitelement.welcome.getText(),"Welcome admin,");
	 
	  }
  @BeforeTest

  public void beforeTest()
  {
	  driver=launchBrowser(objprop.browser,objprop.url);
	  unitelement = new UnitPageElements(driver);
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }
  @DataProvider(name="logins")
  public Object[][] getDataFromDataprovider(){
	  return new Object[][] 
	  	{
	          { "admin", "123123" }
	      
	      };
	      
	 

	}

}
