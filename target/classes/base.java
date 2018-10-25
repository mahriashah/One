	package resources;

import java.io.File;
import org.apache.commons.io.FileUtils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

	public class base {
		
		public static WebDriver driver;
		public Properties prop;
		
		public WebDriver initializeDriver() throws IOException
		{
		prop= new Properties();
		FileInputStream fis= new FileInputStream("/Users/mahriashah/E2EProject/src/main/java/resources/data.properties");
		prop.load(fis);
		
		String browsername = prop.getProperty("browser");
		
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "/Users/mahriashah/Documents/chromedriver");
			driver = new ChromeDriver();
			
		}
		
		else if(browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "/Users/mahriashah/Documents/geckodriver");
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
		}
		public void getScreenshot(String result) throws IOException
		{
			File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("/Users/mahriashah/Documents/PNT JAVA/JavaScreenshots/" +result+"Screenshot.png"));
		}

	}


