package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BrowsePage extends PageBase{


    @FindBy (id ="block_top_menu")
    public List<WebElement> allOptions;


}
