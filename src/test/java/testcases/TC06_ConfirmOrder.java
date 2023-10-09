package testcases;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utility.Utilities;
import static testcases.TC01_LoginPage.*;

public class TC06_ConfirmOrder extends TestBase {
    public static Faker faker = new Faker();
    public static String firstname = faker.name().firstName();
    public static String lastname = faker.name().lastName();
    public static String code = "12365";

    @Test()
    public void Confirm_Order() throws InterruptedException {

        //ToDo: Login to site
        new P01_LoginPage(driver).enterEmail(Username).enterPassword(Password).clickLoginButton();

        //ToDo: Adding the Products To Shopping Cart
        new P02_AddAllProductsToCart(driver).addProductToCart().Navigatetothecart();

        //ToDo: Take a screenshot
        Utilities.Capturescreenshots(driver, "AddProductsToShoppingCart");

        //ToDo: Click on the checkout button
        new P04_CheckoutOrder(driver).ClickOnCheckOutButton();

        //ToDo: Assert the user in the Checkout Information page
        new P05_CheckoutYourInformation(driver).PageTitle();

        //ToDo: Add Checkout Information
        new P05_CheckoutYourInformation(driver).addFirstName(firstname).addLastName(lastname).addPostalCode(code);

        //ToDo: Take a screenshot
        Utilities.Capturescreenshots(driver, "Checkout Information");

        //ToDo: click on the checkout button
        new P05_CheckoutYourInformation(driver).ClickOnContinueButton();

        //ToDo: Assert the sub total appears
        new P06_ConfirmOrder(driver).getSubTotalPrice();

        //ToDo: Assert the total appears
        new P06_ConfirmOrder(driver).getTotalPrice();

        //ToDo: Assert the total in cart is equal total price
//        Assert.assertEquals(new P02_AddAllProductsToCart(driver).getTotalPrice(), new P06_ConfirmOrder(driver).getSubTotalPrice(), "Total is not Matched");

        //ToDo: Assert the subtotal + tax is equal the total price
        Assert.assertEquals(new P06_ConfirmOrder(driver).calculateSubTotalPlusTax(), new P06_ConfirmOrder(driver).getTotalPrice(), "Total is != subtotal+tax");

        //ToDo: Click on the finish button
        new P06_ConfirmOrder(driver).clickOnFinishButton();

        //ToDo: Take a screenshot
        Utilities.Capturescreenshots(driver, "success Order");

        //ToDo: Assert the sub total appears
        new P06_ConfirmOrder(driver).confirmationMessage();
    }
}