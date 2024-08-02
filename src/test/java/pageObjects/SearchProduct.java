package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProduct extends BaseObject {


    public SearchProduct(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement txt_search;

    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
    WebElement btn_search;

    public void searchProduct(String product_name)
    {
        txt_search.clear();
        txt_search.sendKeys(product_name);
    }

    public void clickSearchbtn()
    {
        btn_search.click();
    }
}
