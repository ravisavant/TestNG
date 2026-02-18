// test data class
package Testdata; 

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {

        return new Object[][] {
            {"admin", "admin123"},
            {"user1", "pass123"},
            {"testuser", "test123"}
        };
    }
}

// testNG class

package testNGsessions;

import org.testng.annotations.Test;

import Testdata.TestData;

public class DataDrivenLoginTest {

    @Test(dataProvider = "loginData", dataProviderClass = TestData.class)
    public void loginTest(String username, String password) {

        System.out.println("Username: " + username+ " | Password: " + password);
    }
}


// data driven using same classs

package testNGsessions;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest {

    @DataProvider(name = "userData")
    public Object[][] getData() {
        return new Object[][] {
            {"Ravi", "123"},
            {"Ankit", "456"}
        };
    }

    @Test(dataProvider = "userData")
    public void testUser(String name, String id) {
        System.out.println(name + " - " + id);
    }
}
