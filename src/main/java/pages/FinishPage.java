package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FinishPage {

    private WebDriver driver;
    private By confirmMessage = By.className("complete-header");

    public FinishPage(WebDriver driver) {
        this.driver = driver;
    }

    public String confirmOrder(){
        return driver.findElement(confirmMessage).getText();
    }

}
