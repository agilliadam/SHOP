package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage extends PageBase {


    @FindBy (xpath = "//a[contains(text(),'Sign in')]")
    public WebElement signInButton;

    @FindBy (xpath= "//input[@id='email']")
    public WebElement loginEmail;

    @FindBy (id ="passwd")
    public WebElement loginPassword;

    @FindBy (xpath = "//i[@class='icon-lock left']")
    public WebElement loginButton;

}
