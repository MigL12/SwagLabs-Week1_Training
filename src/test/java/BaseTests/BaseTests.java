package BaseTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;

public class BaseTests {
    private WebDriver driver;
    protected LoginPage loginPage;
//    protected InventoryPage inventoryPage;
//    protected CartPage cartPage;

    @BeforeClass  // Runs once BEFORE all test methods in this class
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");

        // 🔹 Set Chrome preferences to disable password manager + leak detection
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        options.setExperimentalOption("prefs", prefs);

        // 🔹 Launch Chrome with these options
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/");

        loginPage = new LoginPage(driver);
    }

    @AfterClass  // Runs once AFTER all test methods in this class
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
