package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends BaseObject{

    public CheckOutPage(WebDriver driver)
    {
        super(driver);
    }

    //Existing address
    @FindBy(xpath= "//input[@value='existing']")
    WebElement existingAddress;

    @FindBy(xpath = "//input[@value='new']")
    WebElement addNew_Add;

    @FindBy(xpath = "//input[@id='button-payment-address']")
    WebElement continueToNewAdd;

    //Billing Details

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement btn_checkout;

    @FindBy(xpath = "//input[@id='input-payment-firstname']")
    WebElement txt_firstname;

    @FindBy(xpath = "//input[@id='input-payment-lastname']")
    WebElement txt_lastname;

    @FindBy(xpath = "//input[@id='input-payment-company']")
    WebElement txt_companyName;

    @FindBy(xpath = "//input[@id='input-payment-address-1']")
    WebElement txt_address1;

    @FindBy(xpath = "//input[@id='input-payment-address-2']")
    WebElement txt_address2;

    @FindBy(xpath = "//input[@id='input-payment-city']")
    WebElement txt_cityname;

    @FindBy(xpath = "//input[@id='input-payment-postcode']")
    WebElement txt_postalCode;

    @FindBy(xpath = "//select[@id='input-payment-country']")
    WebElement drp_country;

    @FindBy(xpath = "//select[@id='input-payment-zone']")
    WebElement drp_region;

    @FindBy(xpath = "//input[@id='button-payment-address']")
    WebElement btn_continue_payAdd;

    //Delivery Details

    @FindBy(xpath = "//input[@id='button-shipping-address']")
    WebElement btn_contToDeliveryMethod;

    //DeliveryMethod

    @FindBy(xpath = "//textarea[@name='comment']")
    WebElement txt_comments;

    @FindBy(xpath = "//input[@id='button-shipping-method']")
    WebElement btn_continuetoPayment;

    //Payment Method

    @FindBy(xpath = "//input[@name='agree']")
    WebElement checkbox_agree;

    @FindBy(xpath = "//input[@id='button-payment-method']")
    WebElement btn_continueToConfirmOder;

    //Confirm Order

    @FindBy(xpath = "//tbody//tr[1]//td[4]")
    WebElement table_confirm_price;

    @FindBy(xpath = "//tfoot//tr[5]//td[2]")
    WebElement table_confirm_total;

    @FindBy(xpath = "//input[@id='button-confirm']")
    WebElement confirmOrder;

    public void existingAdd()
    {
        if(existingAddress.isDisplayed())
        {
            addNew_Add.click();
            continueToNewAdd.click();
        }
    }

    public void clickCheckOut()
    {
        btn_checkout.click();
    }

    public void enterFirstname(String fname)
    {
        txt_firstname.sendKeys(fname);
    }

    public void enterLastname(String lname)
    {
        txt_lastname.sendKeys(lname);
    }

    public void enterCompanyName(String company_name)
    {
        txt_companyName.sendKeys(company_name);
    }

    public void enterAdd1(String Add1)
    {
        txt_address1.sendKeys(Add1);
    }

    public void enterAdd2(String Add2)
    {
        txt_address2.sendKeys(Add2);
    }

    public void enterCity(String CityName)
    {
        txt_cityname.sendKeys(CityName);
    }

    public void enterPostalCode(String postCode)
    {
        txt_postalCode.sendKeys(postCode);
    }

    public void selectCountry(String country)
    {
        Select drp= new Select(drp_country);
        drp.selectByVisibleText(country);
    }

    public void selectRegion(String region)
    {
        Select drp= new Select(drp_region);
        drp.selectByVisibleText(region);
    }

    public void continueToDelivDetails() throws InterruptedException {
        btn_continue_payAdd.click();
    }

    public void continueToDelivMethod() throws InterruptedException
    {

        Thread.sleep(2000);
        btn_contToDeliveryMethod.click();
    }

    public void inputComment(String comment)
    {
        txt_comments.sendKeys(comment);
    }

    public void contToPaymentMethod()
    {
        btn_continuetoPayment.click();
    }

    public void clickAgree()
    {
        checkbox_agree.click();
    }

    public void continueToConfirmOrder()
    {
        btn_continueToConfirmOder.click();
    }

    public boolean confirmPrice(int row, String price)
    {
        WebElement Price = driver.findElement(By.xpath("//tbody//tr["+row+"]//td[4]"));
        return Price.getText().equals(price);
    }

    public boolean totalPrice(String price)
    {
        WebElement TotalPrice = driver.findElement(By.xpath("//tfoot//tr[5]//td[2]"));
        return TotalPrice.getText().equals(price);
    }

    public void confirmOrder()
    {
        confirmOrder.click();
    }







    
}
