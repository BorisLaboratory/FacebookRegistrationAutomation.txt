package  facebookregistration

 // Automate Facebook Registration page using Direct locators

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

 
public class FacebookRegistration{


	public static void main(String[] args) throws InterruptedException 
	{

		System.setProperty( "webdriver.gecko.driver","C:\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait( driver , 15 );		
		driver.get("https://www.facebook.com");
		String p = driver.getWindowHandle();		
		System .out.println( "This is parent window :"+ driver.switchTo().window(p).getTitle());	 
		WebElement create = wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath("//a[contains(text(),'Create new account')]"))) ;
		create.click();	 
		wait .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@name='firstname']")));
		 WebElement f =  driver.findElement(By.xpath("//input[@name='firstname']"));
		 f.sendKeys("Simmy");		  
		 WebElement l = wait.until( ExpectedConditions.visibilityOf( driver.findElement( By.xpath( "//input[@name='lastname']"))));
		 l.sendKeys( "Smith" ); 		   
		  WebElement email = wait.until( ExpectedConditions.visibilityOf(driver.findElement( By.xpath( "//input[contains(@aria-label,'Mobile number or email' )]"))));
	     email.sendKeys("Simmy505@gmail.com");
		  wait.until(ExpectedConditions.visibilityOfElementLocated(  By.xpath( "//input[contains(@aria-label,'Re-enter email' )]")));
		  WebElement confirmEmail =  driver.findElement( By.xpath( "//input[contains(@aria-label,'Re-enter email' )]"));
		  confirmEmail.sendKeys("Simmy505@gmail.com");		   
		  WebElement p = wait.until( ExpectedConditions.visibilityOf( driver.findElement( By.xpath( "//input[@id='password_step_input']" ))));
		   p.sendKeys( "Jiliimmy11" );
		 
		  int m_index = 0 ;	
		  Select m_d = new Select( driver.findElement( By.id("month")));
		  m_d.selectByIndex(  m_index ); 
		  String day = "27"; 
		  Select d_d = new Select ( driver.findElement( By.id("day")) ); 
		  d_d.selectByValue( day );											
		  String year = "2000"; 
		  Select y_d = new Select( driver.findElement( By.xpath( "//select[@id='year']" )) );
		  y_d.selectByValue( year );
	  
		  WebElement genderButton = driver.findElement(By.xpath("//label[contains(text(),genderValue)]"));
		  genderButton.click();
		  
		  WebElement submitButton = driver.findElement( By.xpath( "//button[@name='websubmit']"));
		  submitButton.click();
	}


}
