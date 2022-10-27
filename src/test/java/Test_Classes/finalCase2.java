package Test_Classes;

import Web_Element_Pages.MainContent;
import Web_Element_Pages.ProductContent;
import Utilities.Driver;
import Utilities.Log;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class finalCase2 extends Driver {
    MainContent mc = new MainContent();
    ProductContent pc = new ProductContent();

    @Test
    public void case2() {
        Log.info("Siteye giriş yapıldı.");
        mc.findAndClick("kabulEt");
        Log.info("Siteye ait cookies kabul edildi.");
        mc.findAndSend("searchBox", "bardak");
        Log.info("Arama kutusuna ürün ismi yazıldı.");
        mc.findAndClick("searchButton");
        Log.info("Arama butonuna basıldu.");
        pc.clickInTheListByIndex("mylist",0);
        Log.info("Arama sonuçlarında çıkan ürünlerden 1.si seçildi.");

        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            driver.switchTo().window(window);
        }

        pc.findAndClick("addToCard");
        pc.findAndClick("differentSeller");

        WebElement productName = driver.findElement(By.cssSelector("#product-name"));
        String selectedProductName = productName.getText();

        mc.findAndClick("shoppingCard");

        for (WebElement c : pc.productsInShoppingCard) {
            Assert.assertTrue(selectedProductName.equalsIgnoreCase(c.getText()));
        }

    }

}
