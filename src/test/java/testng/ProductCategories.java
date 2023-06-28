package testng;

import org.testng.annotations.Test;

import Utilities.ExcelReader;
import Utilities.ReadConfigProperty;
import Utilities.WebDriverManager;
import pageElements.ProductCategoryElements;
import pageElements.UnitPageElements;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;


public class ProductCategories extends WebDriverManager {
	ReadConfigProperty objprop = new ReadConfigProperty();
	public static WebDriver driver;
	UnitPageElements unitelement;
	ExcelReader objExcel=new ExcelReader();
	ProductCategoryElements  catelements;
	
  @Test(priority = 0,enabled =true,dataProvider ="logins")
  public void loginSite(String id,String password) throws InterruptedException {
	  unitelement.login(id,password);
	Assert.assertEquals(driver.getTitle(),"Home - QAlegend");
	  Assert.assertEquals(unitelement.welcome.getText(),"Welcome admin,");
  }
  
  @Test(priority = 1,enabled =true)
  public void productCategories() {
	  catelements.categories_add();
	 // Assert.assertEquals(catelements.categories_search("Maruthi"), "Maruthi");
	  Assert.assertEquals(catelements.categories_search(objExcel.excelread(4, 0)), "Maruthi");
  }
   @Test(priority=2,enabled=true)
   public void categoriesEdit()
   {
	  // catelements.categories_search("Maruthi");
	   catelements.categories_search(objExcel.excelread(4, 0));
	   
	   //catelements.categories_edit("Volvo");
	   catelements.categories_edit(objExcel.excelread(5, 0));
	   Assert.assertEquals(objExcel.excelread(5, 0), "Volvo");
	    
   }
  @Test(priority=3,enabled=true)
  public void categoriesDelete()
  
  {
	 // catelements.categories_search("Volvo");
	  catelements.categories_search(objExcel.excelread(5, 0));
	  catelements.categories_delete();
	  //catelements.categories_search("Volvo");
	  catelements.categories_search(objExcel.excelread(5, 0));
	  Assert.assertEquals(catelements.noRecords(), "No matching records found");
	  
  }
  @BeforeTest
  public void beforeTest() {
	  driver = launchBrowser(objprop.browser,objprop.url);
	  unitelement = new UnitPageElements(driver);
	  catelements= new ProductCategoryElements(driver);
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