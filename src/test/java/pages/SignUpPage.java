package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SignUpPage extends PageBase{


   @FindBy (xpath = "//a[@class='login']")
   public WebElement link;

   @FindBy (id = "email_create")
   public WebElement email;

  @FindBy (id="SubmitCreate")
  public WebElement creatAccount;


   @FindBy ("id_gender1")
   public WebElement genderMale;

    @FindBy ("id_gender")
    public WebElement genderFemale;


   @FindBy (id = "customer_firstname")
   public WebElement firstName;

   @FindBy (id = "customer_lastname")
   public WebElement lastName;

   @FindBy (xpath ="//input[@id='email']")
   public WebElement emailCopy

   @FindBy (id = "passwd")
   public WebElement password;


   @FindBy (id = "days")
   public WebElement dayBirth;

   @FindBy (id = "years")
 public WebElement yearBirth;
    @FindBy (id = "months")
    public WebElement monthBirth;

    @FindBy (id = "company")
    public WebElement companyName;

    @FindBy (id = "address1")
    public WebElement streetName;

    @FindBy (id = "city")
    public WebElement cityName;

    @FindBy (id = "id_state")
    public WebElement stateName;

    @FindBy (id = "postcode")
    public WebElement postcode;

    @FindBy (id = "id_country")
    public WebElement country;

    @FindBy (id = "other")
    public WebElement additionalInformation;

    @FindBy (id = "phone")
    public WebElement phone;

    @FindBy (id = "phone_mobile")
    public WebElement phoneMobile;

    @FindBy (id = "alias")
    public WebElement home;

   @FindBy (ide = "submitAccount")
   public WebElement registerButton;

   @FindBy (xpath= "//div[@class='alert alert-danger']")
   public WebElement message1;


}
