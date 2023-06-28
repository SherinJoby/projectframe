package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigProperty {
	String path = System.getProperty("user.dir");
	public String url;
	public String browser;
	
	public ReadConfigProperty() {
		Properties prop = new Properties();
	    InputStream input = null;

	    try {

	        input = new FileInputStream(path +"//src//main//resources//properties//config.properties");

	        // load a properties file
	        prop.load(input);

	        // get the property value and print it out
	        url= prop.getProperty("url");
	        browser =prop.getProperty("browser");
	       

	    } catch (IOException ex) {
	        ex.printStackTrace();
	    } finally {
	        if (input != null) {
	            try {
	                input.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
		
	}
	
	public static void main(String args[])
	{
		ReadConfigProperty objprop = new ReadConfigProperty();
		System.out.println(objprop.url);
		System.out.println(objprop.browser);
	}

}
