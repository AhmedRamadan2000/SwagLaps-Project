package testcases;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utility.Utilities;

public class TC07_ConfirmOrderWithRandomProducts extends TestBase {
    public static Faker faker = new Faker();
    public static String firstname = faker.name().firstName();
    public static String lastname = faker.name().lastName();
    public static String code = "12365";
    private final String Username = "standard_user";
    private final String Password = "secret_sauce";
    public double totalofproductsprices = new P03_AddRandomProductsToCart(driver).getTotalPrice();

    @Test()
    public void Confirm_Order() {

        //ToDo: Login to site
        new P01_LoginPage(driver).enterEmail(Username).enterPassword(Password).clickLoginButton();

        //ToDo: Adding the Products To Shopping Cart
        new P03_AddRandomProductsToCart(driver).addRandomProductToCartAndGetPrices();

        //ToDo: Take a screenshot
        Utilities.Capturescreenshots(driver, "AddProductsToShoppingCart");

        //ToDo: Click on the checkout button
        new P04_CheckoutOrder(driver).ClickOnCheckOutButton();

        //ToDo: Assert the user in the Checkout Information page
        new P05_CheckoutYourInformation(driver).PageTitle();

        //ToDo: Add Checkout Information
        new P05_CheckoutYourInformation(driver).addFirstName(firstname).addLastName(lastname).addPostalCode(code).ClickOnContinueButton();

        //ToDo: Take a screenshot
        Utilities.Capturescreenshots(driver, "Checkout Information2");

        //ToDo: Assert the sub total appears
        new P07_ConfirmOrderWithRandomProducts(driver).getSubTotal();

        //ToDo: Assert the tax appears
        new P07_ConfirmOrderWithRandomProducts(driver).getTax();

        //ToDo: Assert the total appears
        new P07_ConfirmOrderWithRandomProducts(driver).total();

        //ToDo: Assert the total in cart is equal total price
        Assert.assertEquals(totalofproductsprices, new P07_ConfirmOrderWithRandomProducts(driver).getSubTotal(), "The total item prices in cart is equal total price");

        //ToDo: Assert the subtotal + tax is equal the total price
        Assert.assertEquals(new P07_ConfirmOrderWithRandomProducts(driver).calculateSubTotalPlusTax(), new P07_ConfirmOrderWithRandomProducts(driver).total(), "Total is = subtotal+tax");

        //ToDo: Click on the finish button
        new P07_ConfirmOrderWithRandomProducts(driver).clickOnFinishButton();

        //ToDo: Take a screenshot
        Utilities.Capturescreenshots(driver, "success Order");

        //ToDo: Assert the sub total appears
        new P07_ConfirmOrderWithRandomProducts(driver).confirmationMessage();
    }
}