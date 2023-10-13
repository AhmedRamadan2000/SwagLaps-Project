package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage {

    //ToDo: define locators
    private final By Email = By.xpath("//input[@data-test=\"username\"]");
    private final By Password = By.xpath("//input[@data-test=\"password\"]");
    private final By LoginButton = By.id("login-button");
    WebDriver driver;
    //ToDo: define driver
    public P01_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //ToDo: add action methods
    public P01_LoginPage enterEmail(String email) {
        driver.findElement(this.Email).sendKeys(email);
        return this;
    }

    public P01_LoginPage enterPassword(String Password) {
        driver.findElement(this.Password).sendKeys(Password);
        return this;
    }

    public P01_LoginPage clickLoginButton() {
        driver.findElement(this.LoginButton).click();
        return this;
    }
}