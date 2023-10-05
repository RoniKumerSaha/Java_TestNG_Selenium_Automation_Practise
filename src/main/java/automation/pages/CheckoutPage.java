package automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {
    @FindBy(xpath = "//ul[@id='address_delivery']/li[@class='address_firstname address_lastname']")
    public WebElement deliveryFullName;

    @FindBy(xpath = "//ul[@id='address_delivery']/li[@class='address_city address_state_name address_postcode']")
    public WebElement deliveryAddress;

    @FindBy(xpath = "//ul[@id='address_delivery']/li[@class='address_country_name']")
    public WebElement deliveryCountry;

    @FindBy(xpath = "//ul[@id='address_delivery']/li[@class='address_phone']")
    public WebElement deliveryMobile;

    @FindBy(xpath = "//textarea[@name='message']")
    WebElement commentText;

    @FindBy(xpath = "//a[text()='Place Order']")
    WebElement placeOrderButton;

    public void writeCommentAndPlaceOrder() {
        commentText.sendKeys("Test order");
        placeOrderButton.click();
    }

}
