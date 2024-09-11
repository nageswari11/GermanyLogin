import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

@Listeners(GermanyLoginReport.class)
public class LoginTest {
    public WebDriver driver;
    public WebDriverWait wait;

    //we can set the BeforeMethod annotation for repeated script every time it execute before the each and every test case is run
    @BeforeMethod
    public void setUp() {

        // we can give the path to the chromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nages\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();// We are creating an instance of the ChromeDriver
        driver.get("https://app.germanyiscalling.com/common/login/");// we can give the url link which we want test it
    }

    @Test(priority = 1)// Here we can give the test annotation and priority it will executes the test in given order
    public void LoginWithValidCredentials() {// here give the valid username and password for successful login

        //here we can find the WebElements by using the locators like id className
        WebElement userEl = driver.findElement(By.id("username"));
        WebElement passwordEl = driver.findElement(By.id("password"));
        WebElement loginButtonEl = driver.findElement(By.className("btn-danger"));

        // here we can perform the actions like enter the valid username and valid password and submit the login button by useing sendKeys() and submit() methods
        userEl.sendKeys("vallepunageswari9242@gmail.com");
        passwordEl.sendKeys("venky@123");
        loginButtonEl.submit();

        //we can assign the expected url to the  String variable
        String expectedUrl = "https://app.germanyiscalling.com/cv/upload/";
        String currentUrl = driver.getCurrentUrl();// get the current url by using the getCurrentUrl() method

        //while login to the website some times the webElements are loaded slowly then occur the time dealy
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));//s, wait for 10 seconds to load that elements
        wait.until(ExpectedConditions.urlToBe(expectedUrl));// then we can compare the current url and expected url


        //Assertions verify if a condition is true or false here those are not true it will executes the false message
        Assert.assertEquals(currentUrl, expectedUrl, "URLS did not match");

    }

    @Test(priority = 2)
    public void LoginWithInValidUsernameAndValidPassword() {
        //here we can find the WebElements by using the locators like id className
        WebElement userEl = driver.findElement(By.id("username"));
        WebElement passwordEl = driver.findElement(By.id("password"));
        WebElement loginButtonEl = driver.findElement(By.className("btn-danger"));

        // here we can perform the actions like enter the invalid username and valid password and submit the login button by useing sendKeys() and submit() methods
        userEl.sendKeys("vallepunageswari@gmail.com");
        passwordEl.sendKeys("venky@123");
        loginButtonEl.submit();

        //here we can  Wait for the Error message to be loaded
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/form/div[3]/ul/li")));

        //here we can find the errorMessage webElement by using the relative xpath
        WebElement errorMessageEl = driver.findElement(By.xpath("//div/form/div[3]/ul/li"));
        String errorMessage = errorMessageEl.getText(); // get the current Text by using the getText() method
        Assert.assertEquals(errorMessage, "Please enter a correct username and password. Note that both fields may be case-sensitive.", "Error message is not displayed");
    }

    @Test(priority = 3)
    public void LoginWithValidUsernameAndInValidPassword() {
        //here we can find the WebElements by using the locators like id className
        WebElement userEl = driver.findElement(By.id("username"));
        WebElement passwordEl = driver.findElement(By.id("password"));
        WebElement loginButtonEl = driver.findElement(By.className("btn-danger"));

        // here we can perform the actions like enter the valid username and invalid password and submit the login button by useing sendKeys() and submit() methods
        userEl.sendKeys("vallepunageswari9242@gmail.com");
        passwordEl.sendKeys("venky@1");
        loginButtonEl.submit();

        //here we can  Wait for the Error message to be loaded
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/form/div[3]/ul/li")));

        //here we can find the errorMessage webElement by using the relative xpath
        WebElement errorMessageEl = driver.findElement(By.xpath("//div/form/div[3]/ul/li"));
        String errorMessage = errorMessageEl.getText(); // get the current Text by using the getText() method
        Assert.assertEquals(errorMessage, "Please enter a correct username and password. Note that both fields may be case-sensitive.", "Error message is not displayed");
    }


    @Test(priority = 4)
    public void LoginWithInValidUsernameAndInValidPassword() {
        //here we can find the WebElements by using the locators like id className
        WebElement userEl = driver.findElement(By.id("username"));
        WebElement passwordEl = driver.findElement(By.id("password"));
        WebElement loginButtonEl = driver.findElement(By.className("btn-danger"));

        // here we can perform the actions like enter the valid username and invalid password and submit the login button by useing sendKeys() and submit() methods
        userEl.sendKeys("vallepunageswari@gmail.com");
        passwordEl.sendKeys("venky@1");
        loginButtonEl.submit();

        //here we can  Wait for the Error message to be loaded
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/form/div[3]/ul/li")));

        //here we can find the errorMessage webElement by using the relative xpath
        WebElement errorMessageEl = driver.findElement(By.xpath("//div/form/div[3]/ul/li"));
        String errorMessage = errorMessageEl.getText(); // get the current Text by using the getText() method
        Assert.assertEquals(errorMessage, "Please enter a correct username and password. Note that both fields may be case-sensitive.", "Error message is not displayed");
    }

    @Test(priority = 5)
    public void LoginWithEmptyFieldUsernameAndValidPassword() {
        WebElement passwordEl = driver.findElement(By.id("password"));
        WebElement loginButtonEl = driver.findElement(By.className("btn-danger"));

        // here we can perform the actions like Empty username and valid password and submit the login button by useing sendKeys() and submit() methods

        passwordEl.sendKeys("venky@123");
        loginButtonEl.submit();

        //here we can  Wait for the Error message to be loaded
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/form/div[3]/ul/li")));

        //here we can find the errorMessage webElement by using the relative xpath
        WebElement errorMessageEl = driver.findElement(By.xpath("//div/form/div[3]/ul/li"));
        String errorMessage = errorMessageEl.getText(); // get the current Text by using the getText() method
        Assert.assertEquals(errorMessage, "Email: This field is required.", "Error message is not displayed");

    }

    @Test(priority = 6)
    public void LoginWithValidUsernameAndEmptyFieldPassword() {
        WebElement userEl = driver.findElement(By.id("username"));
        WebElement loginButtonEl = driver.findElement(By.className("btn-danger"));

        // here we can perform the actions like valid  username and empty password and submit the login button by useing sendKeys() and submit() methods

        userEl.sendKeys("vallepunageswari9242@gmail.com");
        loginButtonEl.submit();

        //here we can  Wait for the Error message to be loaded
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/form/div[3]/ul/li")));

        //here we can find the errorMessage webElement by using the relative xpath
        WebElement errorMessageEl = driver.findElement(By.xpath("//div/form/div[3]/ul/li"));
        String errorMessage = errorMessageEl.getText(); // get the current Text by using the getText() method
        Assert.assertEquals(errorMessage, "Password: This field is required.", "Error message is not displayed");

    }

    @Test(priority = 7)
    public void LoginWithEmptyUsernameAndPasswordFields() {
        WebElement loginButtonEl = driver.findElement(By.className("btn-danger"));
        loginButtonEl.submit();

        List<WebElement> errorMessagesEl = driver.findElements(By.tagName("li"));

        // Expected error messages is assign to the array
        String[] expectedMessages = {
                "Email: This field is required.",
                "Password: This field is required."
        };

        // we can Verify the number of error messages count
        Assert.assertEquals(errorMessagesEl.size(), expectedMessages.length, "count of length error messages are incorrect");

        // we can Use a for loop to verify each error message individually
        for (int i = 0; i < errorMessagesEl.size(); i++) {
            String actualMessages = errorMessagesEl.get(i).getText();
            Assert.assertEquals(actualMessages, expectedMessages[i], "Error message " + i + "is not displayed");
        }

    }


    @Test(priority = 8)
    public void LoginWithSpecialCharacters() {
        //here we can find the WebElements by using the locators like id className
        WebElement userEl = driver.findElement(By.id("username"));
        WebElement passwordEl = driver.findElement(By.id("password"));
        WebElement loginButtonEl = driver.findElement(By.className("btn-danger"));

        // here we can perform the actions like enter the  specialCharacters username and  password and submit the login button by useing sendKeys() and submit() methods
        userEl.sendKeys("#$&*@");
        passwordEl.sendKeys("#$&*@");
        loginButtonEl.submit();

        //here we can  Wait for the Error message to be loaded
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/form/div[3]/ul/li")));

        //here we can find the errorMessage webElement by using the relative xpath
        WebElement errorMessageEl = driver.findElement(By.xpath("//div/form/div[3]/ul/li"));
        String errorMessage = errorMessageEl.getText(); // get the current Text by using the getText() method
        Assert.assertEquals(errorMessage, "Please enter a correct username and password. Note that both fields may be case-sensitive.", "Error message is not displayed");
    }

    @AfterMethod//this annotation is executes the each and every time each test case is run
    public void tearDown(){
        driver.quit();// quit() method is closes the all browser windows
    }
}
