package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Tools extends DriverManager {
    public static WebDriverWait wait = new WebDriverWait(DriverManager.setupProcess(), Duration.ofSeconds(30));
    WebDriver driver = DriverManager.setupProcess();

    public void clickFunction(WebElement element) {
        elementToBeClickable(element);
        element.click();
    }

    public void sendKeysFunction(WebElement element, String text) {
        elementToBeVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    public void clickAfterMouseOver(WebElement mouseOver, WebElement element) {
        elementToBeClickable(mouseOver);
        Actions actios = new Actions(driver);
        Action action = actios.moveToElement(mouseOver).build();
        action.perform();

        clickFunction(element);
    }

    public void clickElementInTheList(List<WebElement> list, int index) {
        waitForAllElements(list);
        clickFunction(list.get(index));
    }

    public void elementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void elementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForAllElements(List<WebElement> elementList) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
    }

}
