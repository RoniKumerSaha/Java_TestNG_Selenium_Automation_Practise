package automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//*[@alt='Website for automation practice']")
    public WebElement applicationLogo;
}
