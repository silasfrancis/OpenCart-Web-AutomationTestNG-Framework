package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.RegisterPage;

public class TC_Register_001 extends BaseClass{


    @Test(groups={"sanity"})
    public void register() throws InterruptedException {

        RegisterPage reg = new RegisterPage(driver);

        reg.clickAccDrp();
        reg.clickRegister();
        reg.inputFirstname("Francis");
        reg.inputLastname("Silas");
        reg.inputEmail("francis123@gmail.com");
        reg.inputTelephone("123456789");
        reg.setPassword("francis123");
        reg.confirmPassword("francis123");
        reg.clickAgree();
        reg.clickContinue();

        if(reg.account_Confirmation().isDisplayed())
        {
            Assert.assertTrue(true);
            reg.clickRegConfirm_Btn();
            System.out.println("Account Registered");
        }
        else
        {
            System.out.println("Account Registration Failed");
            Assert.fail();

        }

    }

}
