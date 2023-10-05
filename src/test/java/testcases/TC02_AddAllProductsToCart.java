package testcases;

import org.testng.annotations.Test;
import pages.P01_LoginPage;
import pages.P02_AddAllProductsToCart;
import utility.Utilities;

public class TC02_AddAllProductsToCart extends TestBase {
    private String Username = "standard_user";
    private String Password = "secret_sauce";

    //positive test case
    //ToDo: create test case to Add Products To Shopping Cart
    @Test(priority = 1, description = "Add Products To Shopping Cart")
    public void Add_Products_To_Shopping_Cart() throws InterruptedException {

        //ToDo: Login with valid mail and valid password
        new P01_LoginPage(driver).enterEmail(Username).enterPassword(Password).clickLoginButton();

        //ToDo: Adding the Products To Shopping Cart
        new P02_AddAllProductsToCart(driver).addProductToCart().Navigatetothecart();

        //ToDo: Take a screenshot
        Utilities.Capturescreenshots(driver, "AddProductsToShoppingCart");

    }
    @Test(priority = 2, description = "Add Random Products To Shopping Cart")
    public void Add_Random_Products_To_Shopping_Cart() throws InterruptedException {

        //ToDo: Login with valid mail and valid password
        new P01_LoginPage(driver).enterEmail(Username).enterPassword(Password).clickLoginButton();

        //ToDo: Adding random Products To Shopping Cart
        new P02_AddAllProductsToCart(driver).addproducttocart(5).Navigatetothecart();
    }
}