package testCases;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import pageObjects.*;
import utilities.ReadConfig;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseClass {

    public static WebDriver driver;

    ReadConfig readConfig = new ReadConfig();
    public String baseURL = readConfig.getAppURl();
    public String username = readConfig.getUsername();
    public String password = readConfig.getPassword();

    public Logger logger;


    @Parameters("browser")
    @BeforeClass
    public void setup(String br)
    {
        switch(br.toLowerCase())
        {
            case "chrome":  driver = new ChromeDriver(); break;
            case "edge": driver = new EdgeDriver(); break;
            case "firefox": driver = new FirefoxDriver(); break;
            default: System.out.println("Invalid browser");
        }
        driver.get(baseURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logger = LogManager.getLogger(this.getClass());
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

    public void takeScreenshot(WebDriver driver, String methodname) throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir")+"\\Screenshots\\"+methodname+ ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot Taken");
    }

    public String randomString(int count)
    {
        return RandomStringUtils.randomAlphabetic(count);
    }

    public String randomNumber(int count)
    {
        return RandomStringUtils.randomNumeric(count);
    }

    public String randomAlphaNumeric(int count)
    {
        return RandomStringUtils.randomAlphanumeric(count);
    }

    public WebElement expicitWait (By locator)
    {
        WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return mywait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
