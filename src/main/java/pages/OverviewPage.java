package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage {

    private WebDriver driver;
    private By checkoutItem = By.className("inventory_item_name");
    private By finishButton = By.className("cart_button");

    public OverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCheckoutItem(){
        return driver.findElement(checkoutItem).getText();
    }

    public FinishPage clickFinishCheckout(){
        driver.findElement(finishButton).click();
        return new FinishPage(driver);
    }
}
