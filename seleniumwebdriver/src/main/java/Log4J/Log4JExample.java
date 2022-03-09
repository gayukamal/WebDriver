package Log4J;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Log4JExample {

	public static void main(String[] args)
	{
		//Here we need to create logger instance so we need to pass class name 
		
		Logger logger = Logger.getLogger("Log4JExample"); //here Logger is the class name ,where we need to provide the javafile which needs to be logged in
		DOMConfigurator.configure("log4j.xml");
		
		System.setProperty("webdriver.chrome.driver", "C://Program Files//eclipse//chromedriver_win32/chromedriver.exe");
		
	    WebDriver driver = new ChromeDriver();
		   
		logger.info("Browser opened");
		
		 driver.get("https://demo.nopcommerce.com/");
		 driver.manage().window().maximize();
		 
		 logger.info("Clicked on Register");
		 driver.findElement(By.linkText("Register")).click();
		 
		 logger.info("Entering Contact Information");
		 
		 driver.findElement(By.id("gender-female")).click();
		 driver.findElement(By.name("FirstName")).sendKeys("Gayu");
		 driver.findElement(By.name("LastName")).sendKeys("Kamal");
		 
		 logger.info("Entering user Information");
		 
		 driver.findElement(By.name("Email")).sendKeys("hdhfg@gmail.com");
		 driver.findElement(By.name("Company")).sendKeys("nkg");
		 driver.findElement(By.name("Password")).sendKeys("helloworld");
		 driver.findElement(By.name("ConfirmPassword")).sendKeys("helloworld");
		 
		 logger.info("Clicking on register link");
		 
		 driver.findElement(By.name("register-button")).click();
		 
		 logger.info("Validation Started");
		 
		 if(driver.getPageSource().contains("Your registration completed"))
		   {
			   System.out.println("Registration is success");
			   logger.info("Validation done");
		   }  
		   else
		   {
			   System.out.println("Registration is failed");
			   logger.info("Validation done");
		   }	   
		   
		  logger.info("Test Exit");
		  // driver.close();
	}
}
