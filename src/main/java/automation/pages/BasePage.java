package automation.pages;

import automation.utils.DriverSetUP;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;

public class BasePage extends DriverSetUP {

    @FindBy(xpath = "//*[@href='/products']")
    WebElement productsPageLink;

    @FindBy(xpath = "//a[@href='/view_cart']")
    WebElement cartPageLink;

    @FindBy(xpath = "//b")
    public WebElement loggedInUserName;

    public BasePage() {
        initElements(getWebDriver(), this);
    }

    public void goToProducts() {
        productsPageLink.click();
    }

    public void goToCart() {
        cartPageLink.click();
    }

    public String getPageTitle() {
        return getWebDriver().getTitle();
    }

    public void waitFor(WebElement element) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(getWebDriver())
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class, NullPointerException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToVanish(WebElement element) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(getWebDriver())
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class, NullPointerException.class);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void hoverOn(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public Select selectDropdown(WebElement element) {
        return new Select(element);
    }
}
