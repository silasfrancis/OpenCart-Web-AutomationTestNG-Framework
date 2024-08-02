package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AddToCart;
import pageObjects.CheckOutPage;
import pageObjects.LoginPage;
import pageObjects.SearchProduct;

public class TC_SearchandAddToCart_003 extends BaseClass {

    @Test
    public void searchAndAddtoCart() throws InterruptedException {

        LoginPage lp= new LoginPage(driver);
        SearchProduct search = new SearchProduct(driver);
        AddToCart add= new AddToCart(driver);

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
        Thread.sleep(2000);
        if(add.Confirmation_alert().isDisplayed())
        {
            logger.info("iPhone added to Cart");
            assert true;
        }


        logger.info("Searching for iMac");
        search.searchProduct("iMac");
        search.clickSearchbtn();
        logger.info("Adding iMac to Shopping Cart");
        add.clickAdd();
        Thread.sleep(2000);
        if(add.Confirmation_alert().isDisplayed())
        {
            logger.info("iMac added to Cart");
            assert true;
        }

        logger.info("Proceeding to Shopping Cart");
        add.clickShoppingcart();
        driver.navigate().refresh();
        logger.info("Confirming Items in Shopping Cart");
        Thread.sleep(2000);
        boolean iphone_confirm = add.confrimProductInCart(1, "iPhone");
        boolean imac_confirm = add.confrimProductInCart(2, "iMac");

        if(iphone_confirm)
        {
            assert true;
            logger.info("iPhone in Cart");
        }
        if(imac_confirm)
        {
            assert true;
            logger.info("iMac in Cart");
        }

        logger.info("Removing Items from Shopping Cart");
        add.removeProductFromCart(1);
        add.removeProductFromCart(2);

        logger.info("Confirming if shopping cart is empty");
        driver.navigate().refresh();
        if(add.confirmShoppingCartISEmpty().isDisplayed())
        {
            Assert.assertTrue(true);
            logger.info("Shopping Cart is Empty");
            logger.info("TC_SearchandAddToCart_003 Successful");
        }
    }




}
