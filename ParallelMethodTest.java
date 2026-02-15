// “First, I created TestNG test classes for different pages.
// Inside those classes, I wrote multiple test methods using the @Test annotation.

// Then I created a testng.xml file.
// In the XML, I enabled parallel execution at the method level by setting parallel="methods" and defining the thread-count.

// In the XML file, I specified the package name and class name so TestNG knows which classes to execute.
// When I run the XML, TestNG assigns separate threads to each test method and executes them at the same time, even if the methods belong to the same class.

// This allows multiple test methods to run concurrently, which reduces overall execution time.”
  //parallel execution using method

package testNGsessions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ParallelMethodTest {

    @Test(enabled = true,priority=0)                //enable=true,Disable=false
    public void testOne() {
        System.out.println("Methos one");
    }

    @Test()
    public void testTwo() {
        System.out.println("Method two");
        String name="ravi";
        //SoftAssert softAssert = new SoftAssert();  // soft Assert
		//softAssert.assertEquals(name, "ravis");    // soft Assert
		Assert.assertEquals(name, "ravi");         // Hard Assert
    }
		
		
   @Test(dependsOnMethods="testTwo")
   public void dependsonmethods() {
	   System.out.println("dependent");  
   }
   
   @Test(invocationCount=3)
   public void invocationCount() {
	   
	   System.out.println("invocationcount");
   }           
}
//.xml file 
<suite name="MethodParallelSuite"
       parallel="methods"
       thread-count="4">

    <test name="MethodTests">
        <classes>
            <class name="testNGsessions.ParallelMethodTest"/>
        </classes>
    </test>

</suite>
