package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseUrl ="https://courses.ultimateqa.com/ ";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){

        // click on the ‘Sign In’ link
         driver.findElement(By.partialLinkText("Sign ")).click();
        //Verify the text ‘Welcome Back!’
        driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();
    }

    @Test
    public void verifyTheErrorMessage(){

        //click on the ‘Sign In’ link
        driver.findElement(By.partialLinkText("Sign ")).click();
        //Enter invalid username
        driver.findElement(By.xpath("//input[@name='user[email]']")).sendKeys("tv@yahoo.com");
        //Enter invalid password
        driver.findElement(By.xpath("//input[@id='user[password]']")).sendKeys("tv123");
        //Click on Login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Verify the error message ‘Invalid email or password.’
        String expectedText="Invalid email or password.";
        String actualText=driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        Assert.assertEquals("Message not found",expectedText,actualText);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
