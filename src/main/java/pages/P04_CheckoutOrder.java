package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_CheckoutOrder {
    WebDriver driver;

    //ToDo: define driver

    public P04_CheckoutOrder(WebDriver driver) {
        this.driver = driver;
    }

    //ToDo: define locators
    private final By CheckOutButton = By.xpath("//a[contains(text(),'CHECKOUT')]");

    //ToDo: add action methods
    public P04_CheckoutOrder ClickOnCheckOutButton() {
        driver.findElement(this.CheckOutButton).click();
        return this;
    }

    public boolean checkCheckOutButtonAppear() {
        return driver.findElement(this.CheckOutButton).isDisplayed();
    }
}