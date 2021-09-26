package pages;

import blocks.Footer;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class MainPage extends BasePage {
    private Footer footer;

    @FindBy(xpath = "(//span[@class='hidden-sm-down'])[1]")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@class ='user-info']//span")
    private WebElement userLoginField;

    @FindBy(xpath = "//i[contains(@class,'expand-more')]")
    private WebElement dropdownMenuWithLanguages;

    @FindBy(xpath = ".//ul[contains(@class,'dropdown')]/li")
    private List<WebElement> languagesContainers;

    public MainPage() {
        PageFactory.initElements(getWebDriver(), this);
        this.footer = new Footer(getWebDriver());
    }

    public MainPage clickOnDropdownMenuWithLanguages() {
        dropdownMenuWithLanguages.click();
        return this;
    }

    public SignInPage clickSignInButton() {
        signInButton.click();
        return new SignInPage();
    }

    public int getCountOfLanguage() {
        return languagesContainers.size();
    }

    public String getLanguageOutOfTheDropList(String language) {
        if (languagesContainers.contains(language)) ;
        return language;
    }

    public String getTextFromUserLoginField() {
        return userLoginField.getText();
    }
}

