package testcases;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utility.Utilities;

import static org.testng.Assert.assertEquals;

public class TC05_Confirm_Order extends TestBase {
    private final String Username = "standard_user";
    private final String Password = "secret_sauce";
    public static Faker faker = new Faker();
    public static String firstname = faker.name().firstName();
    public static String lastname = faker.name().lastName();
    public static String code = "12365";
    public String total = "129.94";

    @Test(enabled = true)
    public void Confirm_Order() {

        //ToDo: Login to site
        new P01_LoginPage(driver).enterEmail(Username).enterPassword(Password).clickLoginButton();

        //ToDo: Adding the Products To Shopping Cart
        new P02_AddProductsToCart(driver).addProductsToCart();

        //ToDo: Navigate To Shopping Cart
        new P02_AddProductsToCart(driver).clickOnCartIcon();

        //ToDo: Get total price
        new P02_AddProductsToCart(driver).getPricesFromCart();

        //ToDo: Take a screenshot
        Utilities.Capturescreenshots(driver, "AddProductsToShoppingCart");

        //ToDo: Assert the validation message appears
        Assert.assertTrue(new P02_AddProductsToCart(driver).numberOnCartIcon());

        //ToDo: Click on the checkout button
        new P03_CheckoutOrder(driver).ClickOnCheckOutButton();

        //ToDo: Assert the user in the Checkout Information page
        new P04_Checkout_Your_Information(driver).PageTitle();

        //ToDo: Add Checkout Information
        new P04_Checkout_Your_Information(driver).addFirstName(firstname).addLastName(lastname).addPostalCode(code);

        //ToDo: Take a screenshot
        Utilities.Capturescreenshots(driver, "Checkout Information2");

        //ToDo: Click on the continue button
        new P04_Checkout_Your_Information(driver).ClickOnContinueButton();

        //ToDo: Take a screenshot
        Utilities.Capturescreenshots(driver, "Finish Order");

        //ToDo: Assert the sub total appears
        new P05_Confirm_Order(driver).subTotal();

        //ToDo: Assert the tax appears
        new P05_Confirm_Order(driver).tax();

        //ToDo: Assert the total appears
        new P05_Confirm_Order(driver).total();

        //ToDo: Assert the total in cart is equal total price
assertEquals(P02_AddProductsToCart.cartTota, total,"is match");

        //ToDo: Click on the finish button
        new P05_Confirm_Order(driver).clickOnFinishButton();

        //ToDo: Take a screenshot
        Utilities.Capturescreenshots(driver, "success Order");

        //ToDo: Assert the sub total appears
        new P05_Confirm_Order(driver).confirmationMessage();
    }

}