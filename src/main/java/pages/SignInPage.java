package pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class SignInPage extends BasePage {

    @FindBy(xpath = "//div[@class='no-account']/a")
    private WebElement createNewAccountButton;

    public SignInPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public LoginPage clickCreateNewAccountButton() {
        createNewAccountButton.click();
        return new LoginPage();
    }
}
