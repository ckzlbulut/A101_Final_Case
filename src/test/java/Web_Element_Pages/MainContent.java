package Web_Element_Pages;

import Utilities.DriverManager;
import Utilities.Tools;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainContent extends Tools {

    public MainContent() {
        PageFactory.initElements(DriverManager.setupProcess(), this);
    }
    @FindBy(css = "[title='Hesabım']")
    public WebElement loginAssertPoint;
    @FindBy(xpath = "//*[text()='Kabul Et']")
    private WebElement accept;
    @FindBy(css = "[class='desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b']")
    private WebElement searchBox;
    @FindBy(xpath = "//*[text()='ARA']")
    private WebElement searchButton;
    @FindBy(css = "#shoppingCart")
    private WebElement shoppingCard;
    @FindBy(css = "[id='login']")
    private WebElement loginPage;
    @FindBy(css = "[title='Giriş Yap']")
    private WebElement login;
    @FindBy(css = "#txtUserName")
    private WebElement loginMail;
    @FindBy(css = "#btnLogin")
    private WebElement continueLogin;
    @FindBy(css = "#txtPassword")
    private WebElement loginPassword;
    @FindBy(css = "#btnEmailSelect")
    private WebElement loginButton;
    private WebElement myElement;

    public void findAndSend(String strElement, String value) {
        switch (strElement) {
            case "searchBox":myElement=searchBox;break;
            case "email":myElement= loginMail;break;
            case "loginPassword":myElement=loginPassword;break;
        }
        sendKeysFunction(myElement, value);
    }

    public void findAndClick(String strElement) {

        switch (strElement) {
            case "accept":myElement = accept;break;
            case "searchButton":myElement = searchButton;break;
            case "shoppingCard":myElement=shoppingCard;break;
            case "loginPage":myElement=loginPage;break;
            case "continueLogin":myElement=continueLogin;break;
            case "loginButton":myElement=loginButton;break;

        }
        clickFunction(myElement);
    }

    private WebElement myElementTwo;
    public void mouseOverAndClick(String mouseOverPoint, String clickPoint)
    {
        switch (mouseOverPoint){
            case "login":{
                myElement=login;
                myElementTwo=loginPage;break;
            }
        }
        clickAfterMouseOver(myElement,myElementTwo);
    }


}
