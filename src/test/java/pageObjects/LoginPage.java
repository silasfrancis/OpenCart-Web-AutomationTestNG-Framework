package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseObject{


    public LoginPage(WebDriver driver)
    {
       super(driver);
    }

    @FindBy(xpath = "//a[@title='My Account']")
    WebElement acc_dropdown;

    @FindBy(xpath = "//a[normalize-space()='Login']")
    WebElement btn_login_drp;

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txt_email;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txt_password;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement btn_login;

    @FindBy(xpath = "//div[@class='list-group']//a[13]")
    WebElement logout;

    @FindBy(xpath = "//h1[normalize-space()='Account Logout']")
    WebElement logout_confirmation;

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement cont_logout;


    public void clickAccDrp()
    {
        acc_dropdown.click();
    }

    public void clickLogin()
    {
        btn_login_drp.click();
    }

    public void inputEmail(String email)
    {
        txt_email.sendKeys(email);
    }

    public void inputPassword(String password)
    {
        txt_password.sendKeys(password);
    }

    public void proceedLogin()
    {
        btn_login.click();
    }

    public WebElement loginConfirm()
    {
        return (WebElement) driver.findElement(By.xpath("//h2[normalize-space()='My Account']"));
    }

    public void logOut()
    {
       logout.click();
    }


    public WebElement logoutConfirm()
    {
         return logout_confirmation;
    }

    public void continuetoHompage()
    {
        cont_logout.click();
    }


}
