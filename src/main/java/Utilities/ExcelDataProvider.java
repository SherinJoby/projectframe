package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
	  @DataProvider(name = "excelData")
	    public Object[][] excelDataProvider() throws IOException {

	        // We are creating an object from the excel sheet data by calling a method that
	        // reads data from the excel stored locally in our system
	        Object[][] arrObj = 
	        		getExcelData("C:\\Users\\user\\git\\SeleniumQalagendTesting\\SeleniumQalagendTesting\\src\\test\\resources\\logins.xlsx","Sheet1");
	        return arrObj;
	}

	    // This method handles the excel - opens it and reads the data from the
	    // respective cells using a for-loop & returns it in the form of a string array
	    public String[][] getExcelData(String fileName, String sheetName) throws IOException {
	        String[][] data = null;
	        String value=null;
	        int num;
	        try {

	            FileInputStream fis = new FileInputStream(fileName);
	            XSSFWorkbook workbook = new XSSFWorkbook(fis);
	            XSSFSheet sheet = workbook.getSheetAt(0);
	            XSSFRow row = sheet.getRow(0);
	            int noOfRows = sheet.getPhysicalNumberOfRows();
	            int noOfCols = row.getLastCellNum();
	            System.out.println(noOfCols+" "+noOfRows);
	            Cell cell;
	            data = new String[noOfRows][noOfCols];

	            for (int i = 1; i < noOfRows; i++) {
	                for (int j = 0; j < noOfCols; j++) {
	                    row = sheet.getRow(i);
	                    cell = row.getCell(j);
	                    switch (cell.getCellType()) {
	        			case STRING:
	        				value = cell.getStringCellValue();
	        				break;
	        			case NUMERIC:
	        				num=(int) (cell.getNumericCellValue());
	        				value=String.valueOf(num);
	        				break;
	        			default:
	        				break;
	        			}
	                    System.out.println(value);
	                    
	                    
	                    
	                    
	                    data[i][j] = value;
	                }
	            }
	        } catch (Exception e) {
	            System.out.println("The exception is: " + e.getMessage());
	        }
	        return data;
	    }

}
