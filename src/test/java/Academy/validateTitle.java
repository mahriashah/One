package Academy;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class validateTitle extends base {
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver =initializeDriver();
		log.info("Driver is Initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to HomePage");
	}
	@Test
	public void validateAppTitle()throws IOException
	{
		
		LandingPage l= new LandingPage(driver);
		AssertJUnit.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		log.info("Successfully validated Text message");
		AssertJUnit.assertTrue(true);
//		System.out.println(l.getTitle().getText());
		
		
		
		
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver = null;
	}

}
