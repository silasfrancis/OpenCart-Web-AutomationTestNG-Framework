package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class RegisterPage extends BaseObject{


    public RegisterPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//a[@title='My Account']")
    WebElement acc_dropdown;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement btn_reg;

    @FindBy(name = "firstname")
    WebElement txt_fname;

    @FindBy(name = "lastname")
    WebElement txt_lname;

    @FindBy(name = "email")
    WebElement txt_email;

    @FindBy(name = "telephone")
    WebElement txt_telephone;

    @FindBy(name = "password")
    WebElement txt_pwd;

    @FindBy(name= "confirm")
    WebElement txt_confirmPwd;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement btn_agree;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement btn_continue;

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement btn_reg_successful;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement acc_confirm;

    public void clickAccDrp()
    {
        acc_dropdown.click();
    }

    public void clickRegister()
    {
        btn_reg.click();
    }

    public void inputFirstname(String fname)
    {
        txt_fname.sendKeys(fname);
    }

    public void inputLastname(String lname)
    {
        txt_lname.sendKeys(lname);
    }

    public void inputEmail(String email)
    {
        txt_email.sendKeys(email);
    }

    public void inputTelephone(String phone)
    {
        txt_telephone.sendKeys(phone);
    }
    public void setPassword(String password)
    {
        txt_pwd.sendKeys(password);
    }

    public void confirmPassword(String password)
    {
        txt_confirmPwd.sendKeys(password);
    }

    public void clickAgree()
    {
        btn_agree.click();
    }

    public void clickContinue()
    {
        btn_continue.click();
    }

    public void clickRegConfirm_Btn()
    {
        btn_reg_successful.click();
    }

    public WebElement account_Confirmation()
    {
        return acc_confirm;
    }



}
