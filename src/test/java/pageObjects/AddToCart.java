package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCart extends BaseObject{


    public AddToCart(WebDriver driver)
    {
       super(driver);
    }

    @FindBy(xpath = "//div[@class='button-group']//i[@class='fa fa-shopping-cart']")
    WebElement btn_add_to_cart;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement confirmation_alert;

    @FindBy(xpath = "//a[@title='Shopping Cart']//i[@class='fa fa-shopping-cart']")
    WebElement btn_shoppingCart;

    String product1 = "//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]";


    String xpath_removeProduct= "//tbody//tr[1]//td[4]//div//span//button[@class='btn btn-danger']";

    @FindBy(xpath = "//div[@id='content']//p[contains(text(),'Your shopping cart is empty!')]")
    WebElement msg_shoppingCartEmpty;


    public void clickAdd()
    {
        btn_add_to_cart.click();
    }

    public void clickShoppingcart()
    {
        btn_shoppingCart.click();
    }

    public WebElement Confirmation_alert()
        {
            return confirmation_alert;
        }

    public boolean confrimProductInCart(int rowno,String productname) throws InterruptedException {
        btn_shoppingCart.click();
        driver.navigate().refresh();
        Thread.sleep(5000);
        WebElement itemName= driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr["+rowno+"]/td[2]"));
        itemName.getText();
        if(itemName.getText().equals(productname))
        {
            return true;
        }
        else{
            return false;
        }
    }

    public void removeProductFromCart(int rowno)
    {
        WebElement removefromCart = driver.findElement(By.xpath("//tbody//tr["+rowno+"]//td[4]//div//span//button[@class='btn btn-danger']"));
        removefromCart.click();
    }

    public WebElement confirmShoppingCartISEmpty()
    {
        return msg_shoppingCartEmpty;
    }


}
