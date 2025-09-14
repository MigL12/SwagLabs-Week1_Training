package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private WebDriver driver;
    private By InfoMessage = By.className("subheader");
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By zipCodeField = By.id("postal-code");
    private By continueCheckout = By.className("cart_button");

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    public String getInfo(){
        return driver.findElement(InfoMessage).getText();
    }

    public void FirstName(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void LastName(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void ZipCode(int zipCode){
        driver.findElement(zipCodeField).sendKeys(String.valueOf(zipCode));
    }

    public OverviewPage clickContinueCheckout(){
        driver.findElement(continueCheckout).click();
        return new OverviewPage(driver);
    }
}
