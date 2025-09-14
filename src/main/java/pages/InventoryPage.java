package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InventoryPage {
    private WebDriver driver;
    private By message = By.className("inventory_item_name");
    private By Dropdown = By.className("product_sort_container");
    private By addToCartButton = By.xpath("//a[@id='item_2_title_link']/ancestor::div[@class='inventory_item']//button");
    private By CartNumber = By.cssSelector(".fa-layers-counter.shopping_cart_badge");
    private By CartIcon = By.id("shopping_cart_container");

    public InventoryPage(WebDriver driver) {this.driver = driver;}



    public String getSuccessMessage(){
        return driver.findElement(message).getText();
    }

    public String assertCartQuantity(){
        return driver.findElement(CartNumber).getText();
    }


    public void selectFromDropdown(String optionText) {
        Select dropdown = new Select(driver.findElement(Dropdown));
        dropdown.selectByVisibleText(optionText);
    }

    public void clickAddToCartButton(String productName) {
        String xpath = String.format(
                "//div[@class='inventory_item'][.//div[@class='inventory_item_name' and text()='%s']]//button",
                productName
        );
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        addButton.click();
    }


    public CartPage clickCartButton(){
        driver.findElement(CartIcon).click();
        return new CartPage(driver);
    }




}
