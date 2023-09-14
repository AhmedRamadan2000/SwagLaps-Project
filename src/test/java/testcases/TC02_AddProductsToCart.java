package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import pages.P02_AddProductsToCart;
import utility.Utilities;

public class TC02_AddProductsToCart extends TestBase {
    private String Username = "standard_user";
    private String Password = "secret_sauce";

    //positive test case
    //ToDo: create test case to Add Products To Shopping Cart
    @Test(priority = 1, description = "Add Products To Shopping Cart")
    public void Add_Products_To_Shopping_Cart() {

        new P02_AddProductsToCart(driver).getPricesFromCart();

        //ToDo: Login with valid mail and valid password
        new P01_LoginPage(driver).enterEmail(Username).enterPassword(Password).clickLoginButton();

        //ToDo: Adding the Products To Shopping Cart
        new P02_AddProductsToCart(driver).addProductsToCart();

        //ToDo: Take a screenshot
        Utilities.Capturescreenshots(driver, "AddProductsToShoppingCart");

        //ToDo: Assert the validation message appears
        Assert.assertTrue(new P02_AddProductsToCart(driver).numberOnCartIcon());
    }
}