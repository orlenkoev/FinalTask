package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    //    @BeforeMethod
//    public void createDriver() {
//        DriverFactory.init();
//    }
//
//    @AfterMethod(alwaysRun = true)
//    public void quite() {
//        DriverFactory.getDriver().quit();
//    }
//}
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("chrome.switches", "--disable-extensions");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://demo.prestashop.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        BasePage.setWebDriver(driver);
        try {
            new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.id("loadingMessage")));
        } catch (Exception a) {
        }
    }

    @AfterMethod
    public void quit() {
        if (BasePage.getWebDriver() != null) {
            BasePage.getWebDriver().quit();
        }
    }
}
