package testcases;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utility.Utilities;

import java.util.List;

public class TC04_Checkout_Your_Information extends TestBase{

    private String Username = "standard_user";
    private String Password = "secret_sauce";
    public static Faker faker = new Faker();
    public static String firstname = faker.name().firstName();
    public static String lastname = faker.name().lastName();
    public static String code = "12365";

    @Test(enabled = true)
    public void CheckoutTheInformation() {

        //ToDo: Login to site
        new P01_LoginPage(driver).enterEmail(Username).enterPassword(Password).clickLoginButton();

        //ToDo: Adding the Products To Shopping Cart
//        new P02_AddProductsToCart(driver).addProductsToCart();

        //ToDo: Take a screenshot
        Utilities.Capturescreenshots(driver, "AddProductsToShoppingCart");

        //ToDo: Assert products are added to shopping cart
        Assert.assertTrue(new P03_CheckoutOrder(driver).checkCheckOutButtonAppear());

        //ToDo: Click on the checkout button
        new P03_CheckoutOrder(driver).ClickOnCheckOutButton();

        //ToDo: Assert the user in the Checkout Information page
        new P04_Checkout_Your_Information(driver).PageTitle();

        //ToDo: Add Checkout Information
        new P04_Checkout_Your_Information(driver).addFirstName(firstname).addLastName(lastname).addPostalCode(code);
        //ToDo: Take a screenshot
        Utilities.Capturescreenshots(driver, "Checkout Information2");

        new P04_Checkout_Your_Information(driver).ClickOnContinueButton();
    }
}