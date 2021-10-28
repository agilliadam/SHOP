package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignUpPage;
import utilities.ConfigReader;
import utilities.Driver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class SignUpTests extends TestBase{

    @Test
    public void positiveSignUp(){

        Faker faker = new Faker();
        SignUpPage signUpPage = new SignUpPage();
        driver.get(ConfigReader.getProperty("url"));
        signUpPage.link.click();
        Assert.assertTrue(driver.getCurrentUrl().equals(" http://automationpractice.com/index.php?controller=authentication&back=my-account");

        signUpPage.email.sendKeys(faker.internet().emailAddress())
        signUpPage.creatAccount.click();
        Assert.assertTrue(driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");

        signUpPage.genderMale.click();
        signUpPage.firstName.sendKeys(faker.name().firstName());
        signUpPage.lastName.sendKeys(faker.name().lastName());


        //Verify Email text box has email address defined as used in step
        String attr = signUpPage.emailCopy.getText();
        signUpPage.verifyEquals(attr, email);

        signUpPage.password.sendKeys("dt123");

        signUpPage.dayBirth.selectByVisibleText("15");
        signUpPage.yeatBirth.selectByVisibleText("1984");
        signUpPage.monthBirth.selectByValue("9");

        signUpPage.firstName.sendKeys(faker.name().firstName());
        signUpPage.lastName.sendKeys(faker.name().lastName());
        signUpPage.companyName.sendKeys(faker.company.companyName);
        sighUpPage.cityName.sendKeys(faker.address.city());
        sighUpPage.streetName.sendKeys(faker.address.street());
        signUpPage.stateName.selectByVisibleText("New York");
        signUpPage.postcode.sendKeys(faker.address.zipcode);
        signUpPage.country.selectByVisibleText("United States");
        signUpPage.phone.sendKeys(faker.phone.phoneNumber);
        signUpPage.phoneMobile.sendKeys(faker.phone.phoneNumber);
        signUpPage.home.sendKeys("home");


        signUpPage.registerButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("http://automationpractice.com/index.php?controller=my-account"));

        Assert.assertTrue(driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=my-account"));
    }


        @Test negativeSignUp()
            Faker faker = new Faker();
            SignUpPage signUpPage = new SignUpPage();
            driver.get(ConfigReader.getProperty("url"));
            signUpPage.link.click();
            Assert.assertTrue(driver.getCurrentUrl().equals(" http://automationpractice.com/index.php?controller=authentication&back=my-account");

            signUpPage.email.sendKeys(faker.internet().emailAddress())
            signUpPage.creatAccount.click();
            Assert.assertTrue(driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");

            signUpPage.registerButton.click();


            msg = signUpPage.message1.getText();
            System.out.println(msg);
            signUpPage.message1.verifyEquals(msg.contains("You must register at least one phone number."), true);
            signUpPage.message1.verifyEquals(msg.contains("lastname is required."), true);
            signUpPage.message1.verifyEquals(msg.contains("firstname is required."), true);
            signUpPage.message1.verifyEquals(msg.contains("passwd is required."), true);
            signUpPage.message1.verifyEqualss(msg.contains("address1 is required."), true);
            signUpPage.message1.verifyEquals(msg.contains("city is required."), true);
            signUpPage.message1.verifyEquals(msg.contains("The Zip/Postal code you've entered is invalid. It must follow this format: 00000"), true);
            signUpPage.message1.verifyEquals (msg.contains("This country requires you to choose a State."), true);



    @Test
    public void negativeSignUp() throws InterruptedException {
        Faker faker = new Faker();
        SignUpPage signUpPage = new SignUpPage();
        driver.get(ConfigReader.getProperty("url"));
        signUpPage.link.click();
        Assert.assertTrue(driver.getCurrentUrl().equals(" http://automationpractice.com/index.php?controller=authentication&back=my-account");

        signUpPage.email.sendKeys("abcdef")
        signUpPage.creatAccount.click();
        String msg2=driver.findElement.ByXpath("//li[contains(text(),'Invalid email address.')]");
        msg2.verifyEquals("Invalid email address.");


    }
