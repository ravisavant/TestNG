package testNGsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGFeatures{
	
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\JavaAutomation\\chromedriver-win64\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		driver.get("https://demoqa.com/automation-practice-form");
	}
	
	//---------------------------------------------------------------------------------------------------//
	
	@Test(priority=1,groups="Textfield")
	public void FirstName() {
		WebElement Textfields=driver.findElement(By.id("firstName"));
		Textfields.sendKeys("ravi");
		String enteredText = Textfields.getAttribute("value");
        Assert.assertEquals(enteredText, "raviii", "Text field is not accepting input");
	}
	@Test(priority=1,groups="Textfield")
	public void lasttName() {
		WebElement Textfields=driver.findElement(By.id("lastName"));
		Textfields.sendKeys("savant");
		String enteredText = Textfields.getAttribute("value");
        Assert.assertEquals(enteredText, "savant", "Text field is not accepting input");
	}
	@Test(priority=2,groups="Textfield")
	public void userEmail() {
		WebElement Textfields=driver.findElement(By.id("userEmail"));
		Textfields.sendKeys("ravi@gamil.com");
		String enteredText = Textfields.getAttribute("value");
        Assert.assertEquals(enteredText, "ravi@gamil.com", "Text field is not accepting input");
	}
	
   
	@Test(priority=3,groups="Textfield")  //priority  // groups  
	public void mobilenumber() {
		WebElement Textfields=driver.findElement(By.id("userNumber"));
		Textfields.sendKeys("7349396606");
		String enteredText = Textfields.getAttribute("value");
        Assert.assertEquals(enteredText, "7349396606", "Text field is not accepting input");
	}
	@Test(priority=4,groups="Textfield")
	public void Adress() {
		WebElement Textfields=driver.findElement(By.id("currentAddress"));
		Textfields.sendKeys("banglore");
		String enteredText = Textfields.getAttribute("value");
        Assert.assertEquals(enteredText, "banglore", "Text field is not accepting input");
	}
	@Test(dependsOnMethods="FirstName",priority=5,groups="radiobutton")   // dependsOnMethods     
	public void radiobutton() {
		System.out.println("radio button");	
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	
	@AfterMethod
	public void Closite() {
		driver.quit();
	}

}
