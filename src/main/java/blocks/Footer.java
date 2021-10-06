package blocks;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.PricesDropPage;

import java.util.concurrent.TimeUnit;

import static pages.BasePage.getDriver;


@Getter
@Slf4j
public class Footer {
    @FindBy(id = "block-newsletter-label")
    private WebElement nearTheEmailField;

    @FindBy(xpath = "//div[@class='col-xs-12']/p")
    private WebElement underTheEmailField;

    @FindBy(xpath = "//input[@class='btn btn-primary float-xs-right hidden-xs-down']")
    private WebElement subscribeButton;

    @FindBy(xpath = "//a[contains(@href, 'prices-drop')]")
    private WebElement pricesDropButton;

    public Footer(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getTextNearTheEmailField() {
        getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return nearTheEmailField.getText();
    }

    public String getTextUnderTheEmailField() {
        return underTheEmailField.getText();
    }

    public String getTextFromSubscribeButton() {
        return subscribeButton.getText();
    }

    public PricesDropPage clickOnPricesDropButton() {
        log.info("Click on prices drop button");
        getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        pricesDropButton.click();
        return new PricesDropPage();
    }
}


