package pageElements;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.CommonAction;
import Utilities.ExcelReader;
import Utilities.JavascriptExecutors;
import Utilities.WaitConditions;

public class ProductBrandElements  extends CommonAction
{
	
		WebDriver driver;
		UnitPageElements objUnitPage;
		ExcelReader objExcel=new ExcelReader();
		WaitConditions wait=new WaitConditions();
		JavascriptExecutors script=new JavascriptExecutors();
		public  ProductBrandElements(WebDriver driver) {
			this.driver =driver;
			PageFactory.initElements(driver, this);
			objUnitPage= new UnitPageElements(driver);
		}
		
		@FindBy(xpath="//*[@id=\"tour_step5\"]/ul/li[10]/a")
		public WebElement brands;
		
		@FindBy(xpath="/html/body/div[2]/div[1]/section[2]/div[1]/div[1]/div/button")
		public WebElement add;
		
		@FindBy(id="name")
		public WebElement brandName;
		
		@FindBy(id="description")
		public WebElement brandDescription;
		
		@FindBy(xpath="//*[@id=\"brand_add_form\"]/div[3]/button[1]")
		public WebElement save;
		
		@FindBy(xpath="//*[@id=\"brands_table_filter\"]/label/input")
		public WebElement search;
		
		@FindBy(xpath="//*[@id=\"brands_table\"]/tbody/tr/td")
		public WebElement brandsTableRow;
		
		@FindBy(xpath="//*[@id=\"brands_table\"]/tbody/tr[1]/td[3]/button[1]")
		public WebElement edit;
		
		@FindBy(xpath="//*[@id=\"brand_edit_form\"]/div[3]/button[1]")
		public WebElement update;
		
		@FindBy(xpath="//*[@id=\"brands_table\"]/tbody/tr[1]/td[3]/button[2]")
		public WebElement delete;
		
		@FindBy(xpath="/html/body/div[4]/div/div[4]/div[2]/button")
		public WebElement ok;
		
		@FindBy(xpath="//*[@id=\"brands_table\"]/tbody/tr/td")
        public WebElement noRecords;
		
		
		public void brands_add()
		{
			click(objUnitPage.products);
			click(brands);
			click(add);
			sendKeys(brandName, objExcel.excelread(7, 0));
			sendKeys(brandDescription,objExcel.excelread(8, 0) );
			click(save);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		}
		
		public String brands_search(String name)
		{
			click(brands);
			sendKeys(search,name);
			return getText(brandsTableRow);
			
		}
		
		public void brand_edit(String brandEditName)
		{
			click(edit);
			brandName.clear();
			sendKeys(brandName,brandEditName);
			wait.explicitWait_elementvisibility(driver,update , 2);
			click(update);
			
		}
		
		public void brand_delete()
		{
			wait.explicitWait_elementvisibility(driver,delete, 5);
			click(delete);
			click(ok);
			
		}
		
		public String noRecords() 
		{
			String text=noRecords.getText();
			return text;
		}

	}


