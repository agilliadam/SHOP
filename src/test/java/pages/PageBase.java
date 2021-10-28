package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public abstract class PageBase {

    public PageBase(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

}
