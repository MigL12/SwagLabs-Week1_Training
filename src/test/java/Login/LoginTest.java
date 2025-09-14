package Login;

import BaseTests.BaseTests;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTests {

    @Test
    public void testLogin(){
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        InventoryPage inventory = loginPage.clickLoginButton();
        assertTrue(inventory.getSuccessMessage().contains("Sauce Labs Backpack"),"Not Logged in");
        String option = "Price (low to high)";
        inventory.selectFromDropdown(option);
        inventory.clickAddToCartButton("Sauce Labs Onesie");
        assertTrue(inventory.assertCartQuantity().contains("1"),"None Added to Cart");
        CartPage cartPage = inventory.clickCartButton();
        assertTrue(cartPage.getCartItem().contains("Sauce Labs Onesie"), "Item not added to Cart");
        CheckoutPage checkoutPage = cartPage.clickCheckout();
        assertTrue(checkoutPage.getInfo().contains("Checkout: Your Information"),"Checkout failed");
        checkoutPage.FirstName("John Doe");
        checkoutPage.LastName("Smith");
        checkoutPage.ZipCode(1634);
        OverviewPage overviewPage = checkoutPage.clickContinueCheckout();
        assertTrue(overviewPage.getCheckoutItem().contains("Sauce Labs Onesie"), "Item not added to Cart");
        FinishPage finishPage = overviewPage.clickFinishCheckout();
        assertTrue(finishPage.confirmOrder().contains("THANK YOU FOR YOUR ORDER"),"Order not Placed.");
    }


}
