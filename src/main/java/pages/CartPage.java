package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;
    private By continueButton = By.className("btn_secondary");
    private By itemCart = By.className("inventory_item_name");
    private By checkoutButton = By.className("checkout_button");


    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickContinue(){
        driver.findElement(continueButton).click();
    }

    public CheckoutPage clickCheckout(){
        driver.findElement(checkoutButton).click();
        return new CheckoutPage(driver);
    }



    public String getCartItem(){
        return driver.findElement(itemCart).getText();
    }




}
