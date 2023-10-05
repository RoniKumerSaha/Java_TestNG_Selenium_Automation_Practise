package browser_tests;

import automation.pages.*;
import automation.utils.DataHelper;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PlaceOrderTests extends BaseTest {

    @Test(testName = "Verify that user can select a product and place order successfully")
    public void testOrderFeature() {
        HomePage homePage = new HomePage();
        CartPage cartPage = new CartPage();
        RegistrationPage registrationPage = new RegistrationPage();
        ProductPage productPage = new ProductPage();
        DataHelper dataHelper = new DataHelper();
        CheckoutPage checkoutPage = new CheckoutPage();
        PaymentPage paymentPage = new PaymentPage();

        // Checking the page title and application logo is present
        Assert.assertEquals(homePage.getPageTitle(), "Automation Exercise");
        Assert.assertTrue(homePage.applicationLogo.isDisplayed());

        // Adding product to cart
        homePage.goToProducts();
        productPage.addProductToCart("Summer White Top");

        // Checking cart info and register for checkout
        productPage.goToCart();
        Assert.assertTrue(cartPage.cartInfo.isDisplayed());

        cartPage.clickCheckOut();
        cartPage.clickRegisterLoginToCheckout();

        // Creating account for user
        String userName = "Tester";
        registrationPage.enterNameEmailToSignup(userName, dataHelper.getDynamicEmail());
        registrationPage.enterAccountInformation("Male", "10/5/1990", "12345678");
        registrationPage.enterAddressInformation(dataHelper.getAddressData());
        registrationPage.clickSubmitButton();

        registrationPage.checkAccountCreatedAndContinue();
        Assert.assertEquals(homePage.loggedInUserName.getText(), userName);

        // Going to cart to continue the checkout process
        registrationPage.goToCart();
        cartPage.clickCheckOut();

        String fullName = dataHelper.getAddressData().get("firstname") + " " + dataHelper.getAddressData().get("lastname");
        String address = dataHelper.getAddressData().get("city") + " " + dataHelper.getAddressData().get("state") + " " + dataHelper.getAddressData().get("zip");
        String country = dataHelper.getAddressData().get("country");
        String mobile = dataHelper.getAddressData().get("mobile");

        // Checking the address information is same as given while creating account
        Assert.assertTrue(checkoutPage.deliveryFullName.getText().contains(fullName));
        Assert.assertTrue(checkoutPage.deliveryAddress.getText().contains(address));
        Assert.assertTrue(checkoutPage.deliveryCountry.getText().contains(country));
        Assert.assertTrue(checkoutPage.deliveryMobile.getText().contains(mobile));

        // Providing the payment info and place order
        checkoutPage.writeCommentAndPlaceOrder();
        paymentPage.enterCardInfo(dataHelper.getCardInfo());
        paymentPage.payAndConfirmOrder();

        Assert.assertEquals(paymentPage.confirmMsg.getText(), "Congratulations! Your order has been confirmed!");


    }
}
