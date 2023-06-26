package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    @Before
    public void setUp() {
        openBrowser();
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {


        // Enter Admin username
        WebElement usernameField = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        usernameField.sendKeys("Admin");

        // Enter admin123 password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");

        //Click on Login Button
        driver.findElement(By.xpath("//button[text()=' Login ']")).click();

        //Verify the text ‘Dashboard’ is displayed
        String expectedText = "Dashboard";
        String actualText = driver.findElement(By.linkText("Dashboard")).getText();
        Assert.assertEquals("verify the dashboard text", expectedText, actualText);
    }
    @After
    public void closeDown(){
        closeBrowser();
    }

}