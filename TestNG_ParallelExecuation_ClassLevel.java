// “First, I created two separate test classes for two different pages using TestNG.
// Each class contains its own test method with the @Test annotation.// Then I created a testng.xml file.
// In the XML, I defined a suite and enabled parallel execution by setting parallel="classes" and specifying the thread-count.

// Inside the XML, I called both test classes using their fully qualified package and class names.
// When I run the XML file, TestNG creates separate threads for each class and executes both classes at the same time.

// Because each class runs in its own thread, the tests execute in parallel instead of sequentially.”


//class11111111111111
package testNGsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class parallelLoginTest {                                                                                  // class one

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver","C:\\JavaAutomation\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @SuppressWarnings("deprecation")
	@Test
    public void loginTest() {
        driver.get("https://github.com/topics/login");
        System.out.println("Login Test - Thread ID: "+ Thread.currentThread().getId());
  
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

// class2222222222222

package testNGsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class parallelHomeTest {                                                            //class two

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver","C:\\JavaAutomation\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @SuppressWarnings("deprecation")
	@Test
    public void homePageTest() {
        driver.get("https://www.ebay.com");
        System.out.println("Home Test - Thread ID: "+ Thread.currentThread().getId());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

//.xml filee

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">

<suite name="ParallelSuite" parallel="classes" thread-count="2">                         //.xml file

    <test name="ParallelTests">
        <classes>
            <class name="testNGsessions.parallelLoginTest"/>
            <class name="testNGsessions.parallelHomeTest"/>
        </classes>
    </test>

</suite>

