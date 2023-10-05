package automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.HashMap;

public class RegistrationPage extends BasePage {

    @FindBy(xpath = "//input[@name='name']")
    WebElement userName;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement userEmail;

    @FindBy(xpath = "//button[text()='Signup']")
    WebElement signUpButton;

    @FindBy(id = "id_gender1")
    WebElement genderOptionMale;

    @FindBy(id = "id_gender2")
    WebElement genderOptionFemale;

    @FindBy(id = "first_name")
    WebElement firstNameInput;

    @FindBy(id = "last_name")
    WebElement lastNameInput;

    @FindBy(id = "days")
    WebElement dayOption;

    @FindBy(id = "months")
    WebElement monthOption;

    @FindBy(id = "years")
    WebElement yearOption;

    @FindBy(id = "address1")
    WebElement address1;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "city")
    WebElement cityInput;

    @FindBy(id = "state")
    WebElement stateInput;

    @FindBy(id = "zipcode")
    WebElement zipInput;

    @FindBy(id = "mobile_number")
    WebElement mobileInput;

    @FindBy(xpath = "//*[text()='Account Created!']")
    WebElement successMessage;

    @FindBy(xpath = "//*[text()='Continue']")
    WebElement continueButton;


    @FindBy(xpath = "//button[@data-qa='create-account']")
    WebElement createAccount;

    public void enterNameEmailToSignup(String name, String email) {
        userName.sendKeys(name);
        userEmail.sendKeys(email);
        signUpButton.click();
    }

    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("Male")) {
            genderOptionMale.click();
        } else {
            genderOptionFemale.click();
        }
    }

    public void enterFullName(String firstname, String lastname) {
        firstNameInput.sendKeys(firstname);
        lastNameInput.sendKeys(lastname);
    }

    public void selectDateOfBirth(String date) {
        selectDropdown(dayOption).selectByValue(String.valueOf(Integer.parseInt(date.split("/")[0])));
        selectDropdown(monthOption).selectByValue(String.valueOf(Integer.parseInt(date.split("/")[1])));
        selectDropdown(yearOption).selectByValue(String.valueOf(Integer.parseInt(date.split("/")[2])));
    }

    public void enterAccountInformation(String gender, String dob, String password) {
        selectGender(gender);
        selectDateOfBirth(dob);
        passwordInput.sendKeys(password);
    }

    public void enterAddressInformation(HashMap<String, String> data) {
        enterFullName(data.get("firstname"), data.get("lastname"));
        address1.sendKeys(data.get("address"));
        cityInput.sendKeys(data.get("city"));
        stateInput.sendKeys(data.get("state"));
        zipInput.sendKeys(data.get("zip"));
        mobileInput.sendKeys(data.get("mobile"));
    }

    public void clickSubmitButton() {
        createAccount.click();
    }

    public void checkAccountCreatedAndContinue() {
        waitFor(successMessage);
        Assert.assertTrue(successMessage.isDisplayed());
        continueButton.click();
    }


}
