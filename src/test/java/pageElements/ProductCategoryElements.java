package pageElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.CommonAction;
import Utilities.ExcelReader;
import Utilities.JavascriptExecutors;
import Utilities.WaitConditions;

public class ProductCategoryElements extends CommonAction
{
	WebDriver driver;
	UnitPageElements objUnitPage;
	
	ExcelReader objExcel=new ExcelReader();
	WaitConditions wait=new WaitConditions();
	JavascriptExecutors script=new JavascriptExecutors();
	public ProductCategoryElements(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
		objUnitPage= new UnitPageElements(driver);
	}
	
	@FindBy(xpath="//*[@id=\"tour_step5\"]/ul/li[9]/a")
	public WebElement categories;
	
	@FindBy(xpath="/html/body/div[2]/div[1]/section[2]/div[1]/div[1]/div/button")
	public WebElement add;
	
	@FindBy(xpath="//*[@id=\"category_table_filter\"]/label/input")
	public WebElement search;
	
	@FindBy(id="name")
	public WebElement categoryName;
	
	@FindBy(id="short_code")
	public WebElement categoryCode;
	
	@FindBy(xpath="//*[@id=\"category_add_form\"]/div[3]/button[1]")
	public WebElement save;
	
	@FindBy(xpath="//*[@id=\"category_table\"]/tbody/tr[1]/td[1]")
	public WebElement categoryTableRow;
	
	@FindBy(xpath="//*[@id=\"category_table\"]/tbody/tr[1]/td[3]/button[1]")
	public WebElement edit;
	
	@FindBy(xpath="//*[@id=\"category_edit_form\"]/div[3]/button[1]")
	
	public WebElement update;
	
	@FindBy(xpath="//*[@id=\"category_table\"]/tbody/tr[1]/td[3]/button[2]")
	public WebElement delete;
	
	@FindBy(xpath="/html/body/div[4]/div/div[4]/div[2]/button")
	public WebElement ok;
	
	@FindBy(xpath="//*[@id=\"category_table\"]/tbody/tr/td")
	public WebElement noRecords;
	
	By delete1=By.xpath("//*[@id=\\\"category_table\\\"]/tbody/tr[1]/td[3]/button[2]");
	By update1=By.xpath("//*[@id=\\\"category_edit_form\\\"]/div[3]/button[1]");
	public void categories_add()
	{
		click(objUnitPage.products);
		click(categories);
		click(add);
		sendKeys(categoryCode, objExcel.excelread(4, 1));
		sendKeys(categoryName, objExcel.excelread(4, 0));
		click(save);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}
	
	public String categories_search(String name)
	{
		click(categories);
		sendKeys(search,name);
		return getText(categoryTableRow);
		
	}
	
	public void categories_edit(String cateEditName)
	{
		click(edit);
		categoryName.clear();
		sendKeys(categoryName,cateEditName);
		wait.explicitWait_elementvisibility(driver,update , 2);
		click(update);
		
	}
	
	public void categories_delete()
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

