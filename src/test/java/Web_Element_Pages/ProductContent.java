package Web_Element_Pages;

import Utilities.DriverManager;
import Utilities.Tools;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductContent extends Tools {
    public ProductContent() {
        PageFactory.initElements(DriverManager.setupProcess(), this);
    }
    @FindBy(css = ".productListContent-zAP0Y5msy8OHn5z7T_K_")
    private List<WebElement> searchProducts;

    @FindBy(xpath = "(//*[@class='add-to-basket button small'])[1]")
    public List<WebElement> differentSeller;

    @FindBy(css = "button[id='addToCart']")
    private WebElement addToCard;

    @FindBy(xpath = "(//*[@class='product_delete_1zR-0'])[1]")
    private WebElement deleteProductOne;

    @FindBy(css = ".product_name_3Lh3t")
    public List<WebElement> productsInShoppingCard;


    // The methods after this line have been created to be used by converting the values from the test codes
    // as Strings to Web elements and sending them to the methods in the Tools class that need to do the action.
    // Thus, a framework that is useful and easy to use just by finding the Locator is created.
    // and at the same time, someone who studies the test classes can examine what the steps are without the clutter of code.
    WebElement myElement;
    public void findAndClick(String strElement) {

        switch (strElement) {
            case "searchProducts":myElement=searchProducts.get(0);break;
            case "addToCard":myElement=addToCard;break;
            case "differentSeller":myElement=differentSeller.get(0);break;
            case "deleteProductOne":myElement=deleteProductOne;break;
        }
        clickFunction(myElement);
    }

    List<WebElement> myElementList;
    public void clickInTheListByIndex(String strElement, int index) {
        switch (strElement) {
            case "myList":myElementList=searchProducts;break;
        }
        clickElementInTheList(myElementList,index);
    }



}
