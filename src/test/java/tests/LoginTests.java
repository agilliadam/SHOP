package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigReader;

public class LoginTests extends TestBase{



    @Test
    public void positiveLoginPageObjectModelStyle(){
        Faker faker = new Faker();
        LoginPage loginPage = new loginPage();
        driver.get(ConfigReader.getProperty("url"));
        loginPage.signInButton.click;

        loginPage.LoginEmail.sendKeys(ConfigReader.getProperty("username"))
        loginPage.Loginpassword.sendKeys(ConfigReader.getProperty("password"));

        loginPage.loginButton.click();

        Assert.assertTrue(driver.getTitle().contains("YourLogo"));


    }

    @Test
    public void negativeLogin(){



    }


    @Test
    public void negativeLogin2(){



    }

}
