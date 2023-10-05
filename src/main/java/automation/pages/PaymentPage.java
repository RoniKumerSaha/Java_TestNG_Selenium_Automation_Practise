package automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;

public class PaymentPage extends BasePage {
    @FindBy(xpath = "//input[@name='name_on_card']")
    WebElement nameOnCardInput;

    @FindBy(xpath = "//input[@name='card_number']")
    WebElement cardNumberInput;

    @FindBy(xpath = "//input[@name='cvc']")
    WebElement cvcNumber;

    @FindBy(xpath = "//input[@data-qa='expiry-month']")
    WebElement mmNumber;

    @FindBy(xpath = "//input[@data-qa='expiry-year']")
    WebElement yearInput;

    @FindBy(id = "submit")
    WebElement submitButton;

    @FindBy(xpath = "//div[@class='col-sm-9 col-sm-offset-1']/p")
    public WebElement confirmMsg;


    public void enterCardInfo(HashMap<String, String> data) {
        nameOnCardInput.sendKeys(data.get("name"));
        cardNumberInput.sendKeys(data.get("cardNumber"));
        cvcNumber.sendKeys(data.get("cvc"));
        mmNumber.sendKeys(data.get("mm"));
        yearInput.sendKeys(data.get("year"));
    }

    public void payAndConfirmOrder() {
        submitButton.click();
    }
}
