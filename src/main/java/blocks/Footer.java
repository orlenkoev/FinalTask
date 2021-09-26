package blocks;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static pages.BasePage.getWebDriver;

@Getter
public class Footer {
    @FindBy(id = "block-newsletter-label")
    private WebElement nearTheEmailField;

    @FindBy(xpath = "//div[@class='col-xs-12']/p")
    private WebElement underTheEmailField;

    @FindBy(xpath = "//input[@class='btn btn-primary float-xs-right hidden-xs-down']")
    private WebElement subscribeButton;

    public Footer(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getTextNearTheEmailField() {
        return nearTheEmailField.getText();
    }

    public String getTextUnderTheEmailField() {
        return underTheEmailField.getText();
    }

    public String getTextFromSubscribeButton() {
        return subscribeButton.getText();
    }
}


