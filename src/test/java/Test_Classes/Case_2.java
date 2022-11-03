package Test_Classes;

import Web_Element_Pages.MainContent;
import Web_Element_Pages.ProductContent;
import Utilities.DriverManager;
import Utilities.Log;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.Set;

public class Case_2 extends DriverManager {
    MainContent mc = new MainContent();
    ProductContent pc = new ProductContent();

    @Parameters("product")
    @Test
    public void case2(String product) {
        Log.info("Navigate to hepsiburada main page");

        mc.findAndClick("accept");
        Log.info("Cookies accepted...");

        mc.findAndSend("searchBox", product);
        Log.info("Product name entered..");

        mc.findAndClick("searchButton");
        Log.info("Clicked on the search button...");

        pc.clickInTheListByIndex("myList",0);
        Log.info("1. product selected from the searching result...");

        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            driver.switchTo().window(window);
        }
        Log.info("Navigated to new window... ");

        pc.findAndClick("addToCard");
        Log.info("Product added to card...");

        pc.findAndClick("differentSeller");
        Log.info("Product added to card from different seller...");

        WebElement productName = driver.findElement(By.cssSelector("#product-name"));
        String selectedProductName = productName.getText();
        Log.info("Product title saved so that it will be used for assertion...");

        mc.findAndClick("shoppingCard");
        Log.info("Navigated to shopping card page...");

        for (WebElement c : pc.productsInShoppingCard) {
            Assert.assertTrue(selectedProductName.equalsIgnoreCase(c.getText()));
        }
        Log.info("Checked that the products are the same... ");

        pc.findAndClick("deleteProductOne");
        driver.navigate().refresh();
        pc.findAndClick("deleteProductOne");
        Log.info("The products in the basket were deleted after the test...");

    }
}
