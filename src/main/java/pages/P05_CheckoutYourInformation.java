package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P05_CheckoutYourInformation {
    WebDriver driver;

    //ToDo: define driver
    public P05_CheckoutYourInformation(WebDriver driver) {
        this.driver = driver;
    }

    //ToDo: define locators
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueButton = By.xpath("//input[@class='btn_primary cart_button']");
    private final By pageTitle = By.xpath("//div[@class='subheader']");

    //ToDo: add action methods
    public P05_CheckoutYourInformation addFirstName(String firstName) {
        driver.findElement(this.firstName).sendKeys(firstName);
        return this;
    }

    public P05_CheckoutYourInformation addLastName(String lastName) {
        driver.findElement(this.lastName).sendKeys(lastName);
        return this;
    }

    public P05_CheckoutYourInformation addPostalCode(String code) {
        driver.findElement(this.postalCode).sendKeys(code);
        return this;
    }

    public P05_CheckoutYourInformation ClickOnContinueButton() {
        driver.findElement(this.continueButton).click();
        return this;
    }

    public boolean PageTitle() {
        return driver.findElement(this.pageTitle).getText().equals("Checkout: Your Information");
    }
}