 package testng;


import Utilities.ExcelReader;
import Utilities.ReadConfigProperty;
import Utilities.WebDriverManager;

import pageElements.UnitPageElements;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ProductUnit extends WebDriverManager{
	ReadConfigProperty objprop = new ReadConfigProperty();
	public static WebDriver driver;
	UnitPageElements unitelement;
	ExcelReader objExcel=new ExcelReader();
  @Test(priority=0,enabled=true,dataProvider="logins")
  
    public void loginSite(String id,String password) {
	  unitelement.login(id,password);
	  Assert.assertEquals(unitelement.welcome.getText(),"Welcome admin,");
		  
  }
  @Test(priority=1,enabled=true)
  public void productTab()
  {
	  unitelement.unit_add();
	  Assert.assertEquals(unitelement.unit_search(objExcel.excelread(4, 2)), "Item_001");
  }
  
  @Test(priority=2,enabled=true)
  public void productUnitEdit()
  {
	  
	 	  unitelement.unit_edit(objExcel.excelread(5, 2));
	  
	  Assert.assertEquals(objExcel.excelread(5, 2), "NewItem_001");
  }
  
  @Test(priority=3,enabled=true)
  
  public void productUnitDelete()
  {
	  unitelement.unit_delete();
	  unitelement.unit_search(objExcel.excelread(5, 2));
	  Assert.assertEquals( unitelement.no_Records(), "No matching records found");
  }
  
  @BeforeTest
  
  public void beforeTest()
  {
	  driver=launchBrowser(objprop.browser,objprop.url);
	  unitelement=new UnitPageElements(driver);
	
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
