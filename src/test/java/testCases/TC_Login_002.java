package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

import java.io.IOException;
import java.util.logging.Logger;

public class TC_Login_002 extends BaseClass{

    @Test
    public void loginTest() throws IOException
    {
        LoginPage lp= new LoginPage(driver);
        lp.clickAccDrp();
        lp.clickLogin();

        logger.info("Login in Progress");
        lp.inputEmail(username);
        lp.inputPassword(password);
        lp.proceedLogin();

        if(lp.loginConfirm().getText().equals("My Account"))
        {
            logger.info("Login Successful");
            Assert.assertTrue(true);

        }
        else {
            takeScreenshot(driver,"loginTest");
            logger.info("Login Failed");
            Assert.fail();
        }

        logger.info("Proceeding to Logout");
        lp.logOut();

        if(lp.logoutConfirm().isDisplayed())
        {
            logger.info("Logout Successful");
            logger.info("Continuing to Homepage");
            lp.continuetoHompage();
            Assert.assertTrue(true);
            logger.info("TC_Login_002 Successful");
        }
        else {
            takeScreenshot(driver, "loginTest_Logout");
            logger.info("Logout Failed");
            Assert.fail();
        }

    }
}
