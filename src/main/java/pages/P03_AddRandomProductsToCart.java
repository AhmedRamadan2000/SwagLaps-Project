package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class P03_AddRandomProductsToCart {
    WebDriver driver;
    public double TotalPrice;

    //ToDo: define driver
    public P03_AddRandomProductsToCart(WebDriver driver) {
        this.driver = driver;
    }

    //ToDo: define locators
    private final By shoppingCartIcon = By.id("shopping_cart_container");

    //ToDo: add action methods

    //ToDo: Adding the Products To Shopping Cart
    public P03_AddRandomProductsToCart addRandomProductToCartAndGetPrices() {
        //ToDo: Get the list of all products and add to cart.
        List<WebElement> products = driver.findElements(By.className("inventory_list"));
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int randomProductIndex = random.nextInt(products.size());
            WebElement product = products.get(randomProductIndex);
            product.findElement(By.xpath("//button[@class=\"btn_primary btn_inventory\"]")).click();
        }

        //ToDo:Navigate to the cart
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(this.shoppingCartIcon).click();

        //ToDo: Get the prices of all products in the cart.
        List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));
        List<Double> productPrices = new ArrayList<>();
        for (WebElement priceElement : prices) {
            productPrices.add(Double.parseDouble(priceElement.getText()));
        }
        this.TotalPrice = 0;
        for (double productPrice : productPrices) {
            this.TotalPrice += productPrice;
        }

        //ToDo: Print the prices and total price.
        System.out.println("Product prices:");
        for (double productPrice : productPrices) {
            System.out.println(productPrice);
        }
        System.out.println("Total price: " + TotalPrice);
       return this;
    }

    public double getTotalPrice() {
        return this.TotalPrice;
    }
}