package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P05_Confirm_Order {
    static WebDriver driver;

    //ToDo: define driver
    public P05_Confirm_Order(WebDriver driver) {
        this.driver = driver;
    }

    //ToDo: define locators

    private final By subTotal = By.xpath("//div[@class='summary_subtotal_label']");
    private final By tax = By.xpath("//div[@class='summary_tax_label']");
    private final By total = By.xpath("//div[@class='summary_total_label']");
    private final By finishButton = By.xpath("//a[@class='btn_action cart_button']");
    private final By confirmationMessage = By.xpath("//h2[@class='complete-header']");

    //ToDo: add action methods
    public P05_Confirm_Order clickOnFinishButton() {
        driver.findElement(this.finishButton).click();
        return this;
    }

    public boolean subTotal() {
        return driver.findElement(this.subTotal).getText().equals("Item total: 129.94");
    }

    public boolean tax() {
        return driver.findElement(this.tax).getText().equals("Tax: 10.40");
    }

    public boolean total() {
        return driver.findElement(this.total).getText().equals("Total: 140.34");
    }

    public boolean confirmationMessage() {
        return driver.findElement(this.confirmationMessage).getText().equals("THANK YOU FOR YOUR ORDER");
    }

    public static double expctedTotal = Double.parseDouble(String.valueOf(new P05_Confirm_Order(driver).subTotal));
}