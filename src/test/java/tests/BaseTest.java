package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    @BeforeMethod
    public synchronized void setUp() {
        String browser = System.getProperty("browser");
        WebDriver driver;

        if (browser == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            switch (browser) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                default:
                    throw new IllegalStateException("Wrong browser");
            }
        }
        driver.get("https://demo.prestashop.com/");
        driver.manage().window().maximize();
        BasePage.setThreadLocalDriver(driver);

        try {
            new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.id("loadingMessage")));
        } catch (Exception a) {
            a.printStackTrace();
        }
        driver.switchTo().frame("framelive");
    }

    @AfterMethod
    public void quit() {
        BasePage.getDriver().quit();
        BasePage.getThreadLocalDriver().remove();
        }
    }

