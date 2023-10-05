package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P07_ConfirmOrderWithRandomProducts {
     WebDriver driver;

    //ToDo: define driver
    public P07_ConfirmOrderWithRandomProducts(WebDriver driver) {
        this.driver = driver;
    }

    //ToDo: define locators

    private final By subTotal = By.xpath("//div[@class='summary_subtotal_label']");
    private final By tax = By.xpath("//div[@class='summary_tax_label']");
    private final By total = By.xpath("//div[@class='summary_total_label']");
    private final By finishButton = By.xpath("//a[@class='btn_action cart_button']");
    private final By confirmationMessage = By.xpath("//h2[@class='complete-header']");

    //ToDo: add action methods
    public P07_ConfirmOrderWithRandomProducts clickOnFinishButton() {
        driver.findElement(this.finishButton).click();
        return this;
    }

    public double getSubTotal() {
        return Double.parseDouble(driver.findElement(this.subTotal).getText().replace("Item total: $", ""));
    }

    public double getTax() {
        return Double.parseDouble(driver.findElement(this.tax).getText().replace("Tax: $", ""));
    }

    public float total() {
        return Float.parseFloat(driver.findElement(this.total).getText().replace("Total: $", ""));
    }

    public boolean confirmationMessage() {
        return driver.findElement(this.confirmationMessage).getText().equals("THANK YOU FOR YOUR ORDER");
    }

    public float calculateSubTotalPlusTax() {
        double subtotal = getSubTotal();
        System.out.println("subtotal value: " + subtotal);
        double taxValue = getTax();
        System.out.println("Tax value: " + taxValue);
        float totalPrice= (float) (subtotal + taxValue);
        System.out.println("Total value: " + totalPrice);
        return totalPrice;
    }
}