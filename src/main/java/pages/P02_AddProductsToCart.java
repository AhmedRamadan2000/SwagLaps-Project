package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class P02_AddProductsToCart {
    static WebDriver driver;

    //ToDo: define driver
    public P02_AddProductsToCart(WebDriver driver) {
        this.driver = driver;
    }

    //ToDo: define locators
    private final By shoppingCartIcon = By.id("shopping_cart_container");
    private final By shoppingCartNumber = By.xpath("//span[contains(text(),'6')]");

    //ToDo: add action methods
//ToDo: check the number of products on Shopping Cart icon
    public P02_AddProductsToCart clickOnCartIcon() {
        driver.findElement(this.shoppingCartIcon).click();
        return this;
    }

    public void addProductsToCart() {
        //ToDo: Adding the Products To Shopping Cart
        int Expectedadd = 6;
        List<WebElement> productNames = driver.findElements(By.xpath("//button[@class=\"btn_primary btn_inventory\"]"));
        for (int i = 0; i < productNames.size(); i++) {
            productNames.get(i).click();
        }
    }

    //ToDo: confirm the 6 Products is adding To Shopping Cart
    public boolean numberOnCartIcon() {
        return driver.findElement(this.shoppingCartNumber).getText().equals("6");
    }

    //ToDo: get prices from cart
    public double getPricesFromCart() {
        List<WebElement> pricesElements = driver.findElements(By.className("inventory_item_price"));
        List<Double> prices = new ArrayList<>();

        for (WebElement priceElement : pricesElements) {
            String priceText = priceElement.getText().replaceAll("[^0-9.]", "");
            double price = Double.parseDouble(priceText);
            prices.add(price);
            System.out.println("Item Price: " + price);
        }

        double cartTotal = 0;
        for (double price : prices) {
            cartTotal += price;
        }

        System.out.println("Cart Total: " + cartTotal);
        String actualTotalString = Double.toString(cartTotal);
        return cartTotal;
    }
    public static String cartTota= String.valueOf(new P02_AddProductsToCart(driver).getPricesFromCart());

}