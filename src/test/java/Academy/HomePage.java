package Academy;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver =initializeDriver();
	
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String Username, String Password, String Text) throws IOException
	{
		
		driver.get(prop.getProperty("url"));
		LandingPage l= new LandingPage(driver);
		l.getLogin().click();
		
		LoginPage lp= new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		log.info(Text);
//		System.out.println(Text);
		lp.getLogin().click();
		
		
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][3];
		
		data[0][0]="nonrestricteduser@qw.com";
		data[0][1]="123456";
		data[0][2]="Non Restricted User";
		
		data[1][0]="restricteduser@qw.com";
		data[1][1]="123456";
		data[1][2]="Restricted User";
	
		
		return data;
		
		
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}

}
