package testCases;

import org.testng.annotations.Test;
import pageObjects.AddToCart;
import pageObjects.CheckOutPage;
import pageObjects.LoginPage;
import pageObjects.SearchProduct;

public class TC_CheckOut_004 extends BaseClass{


    @Test
    public void checkOut() throws InterruptedException {

        LoginPage lp= new LoginPage(driver);
        SearchProduct search = new SearchProduct(driver);
        AddToCart add= new AddToCart(driver);
        CheckOutPage check = new CheckOutPage(driver);

        lp.clickAccDrp();
        lp.clickLogin();
        logger.info("Login in Progress");
        lp.inputEmail(username);
        lp.inputPassword(password);
        lp.proceedLogin();
        logger.info("Login successful");

        logger.info("Adding Items to Shopping Cart");

        logger.info("Searching for iPhone");
        search.searchProduct("iPhone");
        search.clickSearchbtn();
        logger.info("Adding iPhone to Shopping Cart");
        add.clickAdd();

        logger.info("Searching for iMac");
        search.searchProduct("iMac");
        search.clickSearchbtn();
        logger.info("Adding iMac to Shopping Cart");
        add.clickAdd();

        logger.info("Proceeding to Shopping Cart");
        add.clickShoppingcart();
        driver.navigate().refresh();


        logger.info("Proceeding to CheckOut");
        check.clickCheckOut();
        check.existingAdd();
        Thread.sleep(2000);
        check.enterFirstname(randomString(5));
        check.enterLastname(randomString(5));
        check.enterCompanyName(randomString(8));
        check.enterAdd1(randomNumber(2) + " " + randomString(8));
        check.enterAdd2(randomNumber(2) + " " + randomString(8));
        check.enterCity(randomString(5));
        check.enterPostalCode(randomNumber(6));
        check.selectCountry("Nigeria");
        check.selectRegion("Akwa Ibom");
        check.continueToDelivDetails();
        check.continueToDelivMethod();
        check.inputComment(randomString(10));
        check.contToPaymentMethod();
        check.clickAgree();
        check.continueToConfirmOrder();

        double iphone_price = 123.20;
        double imac_price = 122.00;

        boolean iPhone_Price = check.confirmPrice(1,"$"+String.valueOf(iphone_price));
        boolean iMac_Price= check.confirmPrice(2,"$"+String.valueOf(imac_price));

        if(iPhone_Price && iMac_Price)
        {
            assert true;
            logger.info("Prices confirmed");
        }

        double totalprice = iphone_price+imac_price;
        boolean Total = check.totalPrice("$"+String.valueOf(totalprice));

        if(Total)
        {
            assert true;
            logger.info("Total Price confirmed");
        }

        check.confirmOrder();
        logger.info("TC_CheckOut_004 successful");



        
    }
}
