package pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class LoginPage extends BasePage {
    @FindBy(xpath = "(//input[@name='id_gender'])[2]")
    private WebElement socialTitleButton;

    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement lastNameField;

    @FindBy(xpath = "//div[@class='col-md-6']/input[@name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@name='birthday']")
    private WebElement birthdayDateField;

    @FindBy(xpath = "//input[@name ='customer_privacy']")
    private WebElement customerPrivacyButton;

    @FindBy(xpath = "//input[@name='psgdpr']")
    private WebElement agreeButton;

    @FindBy(xpath = "//button[contains(@class,'form-control')]")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(@class,'form-group')]//li[@class='alert alert-danger']")
    private WebElement fieldWithInvalidFormText;

    public LoginPage() {
        PageFactory.initElements(getWebDriver(), this);
    }

    public LoginPage chooseSocialTitle() {
        socialTitleButton.click();
        return this;
    }

    public LoginPage enterFirstName(String name) {
        firstNameField.sendKeys(name);
        return this;
    }

    public LoginPage enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
        return this;
    }

    public LoginPage enterUserEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage enterBirthdayDate(String birthday) {
        birthdayDateField.sendKeys(birthday);
        return this;
    }

    public LoginPage clickCustomerPrivacyButton() {
        customerPrivacyButton.click();
        return this;
    }

    public LoginPage checkAgreeToThePrivacyPolicyAndTerms() {
        agreeButton.click();
        return this;
    }

    public MainPage clickSaveButton() {
        saveButton.click();
        return new MainPage();
    }

    public LoginPage clickSaveButtonWithIncorrectData() {
        saveButton.click();
        return this;
    }

    public String getColorOfFirstNameField() {
        String style = firstNameField.getCssValue("outline");
        String[] a = style.split("solid");
        return a[0].trim();
    }

    public String getTextFromInvalidForm() {
        return fieldWithInvalidFormText.getText();
    }
}