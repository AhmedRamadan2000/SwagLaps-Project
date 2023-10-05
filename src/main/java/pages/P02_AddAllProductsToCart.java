package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.NumberGenerator;
import utility.Utilities;

import java.util.List;

public class P02_AddAllProductsToCart {
    static float totalprice = 0;
    //ToDo: define locators
    private final By shoppingCartIcon = By.id("shopping_cart_container");
    WebDriver driver;
    NumberGenerator generator;

    //ToDo: define driver
    public P02_AddAllProductsToCart(WebDriver driver) {
        this.driver = driver;
    }

    //ToDo: add action methods
    public P02_AddAllProductsToCart Navigatetothecart() {
        driver.findElement(this.shoppingCartIcon).click();
        return this;
    }

    public P02_AddAllProductsToCart addProductToCart(){
        for (int i = 3; i <= 8; i++) {
            driver.findElement(By.xpath("(//button)["+i+"]")).click();
            totalprice += Utilities.removeFirstLetterAndReturnFloat(driver.findElement(By.xpath("(//div[@class=\"inventory_item_price\"])["+(i-2)+"]")).getText());
        }
        System.out.println(totalprice);
        return this;
    }

    public P02_AddAllProductsToCart addproducttocart(int numberOfProductsToAdd) throws InterruptedException {
        generator = new NumberGenerator();
        for (int i = 1; i <= numberOfProductsToAdd; i++) {
            int uniqueNumber = generator.generateUniqueRandomNumber(6);
            driver.findElement(By.xpath("(//button[@class=\"btn_primary btn_inventory\"])[" + uniqueNumber + "]")).click();
            totalprice += Utilities.removeFirstLetterAndReturnFloat(driver.findElement(By.xpath("(//div[@class=\"inventory_item_price\"])[" + uniqueNumber + "]")).getText());
//            System.out.println("sub Total is " + totalprice);
        }
        System.out.println("sub Total is " + totalprice);
        return this;
    }

    public String getTotalPrice() {
        return String.valueOf(totalprice);
    }
}