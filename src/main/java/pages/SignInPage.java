package pages;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
@Slf4j

public class SignInPage extends BasePage {

    @FindBy(xpath = "//div[@class='no-account']/a")
    private WebElement createNewAccountButton;

    public SignInPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public LoginPage clickCreateNewAccountButton() {
        log.info("Click on Create new account Button");
        createNewAccountButton.click();
        return new LoginPage();
    }
}
