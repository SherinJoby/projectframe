package testng;


import org.testng.annotations.Test;

import Utilities.ExcelReader;
import Utilities.ReadConfigProperty;
import Utilities.WebDriverManager;
import pageElements.ProductBrandElements;
import pageElements.UnitPageElements;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ProductBrands  extends WebDriverManager{
	ReadConfigProperty objprop=new ReadConfigProperty();
	public static WebDriver driver;
	UnitPageElements unitelement;
	ProductBrandElements brandelements;
	ExcelReader objExcel=new ExcelReader();
	
	  @Test(priority = 0,enabled =true,dataProvider ="logins",groups= {"functional"})
	  public void loginSite(String id,String password) throws InterruptedException {
		  unitelement.login(id,password);
		  Assert.assertEquals(unitelement.welcome.getText(),"Welcome admin,");
	  }
	  @Test(priority=1,enabled=true) 
	  public void prductBrands() {
		  brandelements.brands_add();
		 
	  Assert.assertEquals(brandelements.brands_search(objExcel.excelread(7, 0)),"Skechers");
	  }
	  
	  @Test(priority=2,enabled=true,groups= {"functional"})
	  public void brandEdit()
	  {
		
		  brandelements.brands_search(objExcel.excelread(7, 0));
		  brandelements.brand_edit(objExcel.excelread(7,1));
		  Assert.assertEquals(brandelements.brands_search(objExcel.excelread(7, 1)), "Under Armour");
		  
	  }
	  
	  @Test(priority=3,enabled=true ,groups= {"regression"})
	  public void brandDelete()
	  
	  {
		  brandelements.brands_search(objExcel.excelread(7, 1));
		  
		  brandelements.brand_delete();
		  brandelements.brands_search(objExcel.excelread(7, 1));
		  Assert.assertEquals(brandelements.noRecords(), "No matching records found");
	  }
	  
	  @BeforeTest
	  public void beforeTest() {
		  driver = launchBrowser(objprop.browser,objprop.url);
		  unitelement = new UnitPageElements(driver);
		  brandelements  = new ProductBrandElements(driver);
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