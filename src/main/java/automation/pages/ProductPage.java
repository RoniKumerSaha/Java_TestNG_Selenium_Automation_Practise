package automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//p[text()='Your product has been added to cart.']")
    public WebElement successfulMsg;

    @FindBy(xpath = "//button[text()='Continue Shopping']")
    public WebElement continueShoppingButton;

    public void addProductToCart(String productName) {
        WebElement product = getWebDriver().findElement(By.xpath("//div[@class='productinfo text-center']/p[text()='" + productName + "']"));
        hoverOn(getWebDriver(), product);
        WebElement addToCart = getWebDriver().findElement(By.xpath("//div[@class='overlay-content']/p[text()='" + productName + "']/following-sibling::a"));
        addToCart.click();
        waitFor(successfulMsg);
        Assert.assertTrue(successfulMsg.isDisplayed());
        continueShoppingButton.click();
    }
}
