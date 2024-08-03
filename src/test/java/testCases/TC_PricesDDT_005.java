package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.SearchProduct;
import utilities.DataProviders;

public class TC_PricesDDT_005 extends BaseClass{

    @Test(dataProvider = "prices", dataProviderClass = DataProviders.class)
    public void pricesDDT(String product, String prices)
    {
        SearchProduct search = new SearchProduct(driver);
        WebElement searchbox = driver.findElement(By.xpath("//input[@placeholder='Search']"));

        if(searchbox.isDisplayed())
        {
            search.searchProduct(product);
            search.clickSearchbtn();

            WebElement act_productname = expicitWait(By.xpath("//div[@class='product-thumb']//div[2]//div//h4"));
            WebElement act_price = expicitWait(By.xpath("//div[@class='product-thumb']//div[2]//div//p[2]"));


            if(act_productname.getText().equals(product) && act_price.getText().equals(prices))
            {
                Assert.assertTrue(true);
                logger.info("{} price accurate", product);
            }
            else {
                logger.info("{} price inaccurate", product);
                Assert.fail();
            }
        }

    }

}
