package automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    @FindBy(id = "cart_info")
    public WebElement cartInfo;

    @FindBy(xpath = "//a[text()='Proceed To Checkout']")
    WebElement checkoutButton;

    @FindBy(xpath = "(//a[@href='/login'])[2]")
    WebElement registerLoginButton;

    public void clickCheckOut() {
        checkoutButton.click();
    }

    public void clickRegisterLoginToCheckout() {
        waitFor(registerLoginButton);
        registerLoginButton.click();
    }

}
