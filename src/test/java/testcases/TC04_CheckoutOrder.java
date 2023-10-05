package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import pages.P04_CheckoutOrder;
import utility.Utilities;

public class TC04_CheckoutOrder extends TestBase {
    private String Username = "standard_user";
    private String Password = "secret_sauce";

    @Test(enabled = true)
    public void CheckOutOrder() {

        //ToDo: Login to site
        new P01_LoginPage(driver).enterEmail(Username).enterPassword(Password).clickLoginButton();

//        //ToDo: Adding the Products To Shopping Cart
//        new P02_AddProductsToCart(driver).addProductsToCart();

        //ToDo: Take a screenshot
        Utilities.Capturescreenshots(driver, "AddProductsToShoppingCart");

        //ToDo: Click on the checkout button
        new P04_CheckoutOrder(driver).ClickOnCheckOutButton();

        //ToDo: Take a screenshot
        Utilities.Capturescreenshots(driver, "CheckOutOrderImage");

        //ToDo: Assert products are added to shopping cart
        Assert.assertTrue(new P04_CheckoutOrder(driver).checkCheckOutButtonAppear());
    }
}