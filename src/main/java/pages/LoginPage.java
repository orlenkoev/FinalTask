package pages;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
@Slf4j

public class LoginPage extends BasePage {
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

    @FindBy(xpath = "(//input[@name='id_gender'])[1]")
    private WebElement socialTitleButton;

    @FindBy(xpath = "//input[@name ='customer_privacy']")
    private WebElement customerPrivacyButton;

    @FindBy(xpath = "//input[@name='psgdpr']")
    private WebElement agreeButton;

    @FindBy(xpath = "//button[contains(@class,'form-control')]")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(@class,'form-group')]//li[@class='alert alert-danger']")
    private WebElement fieldWithInvalidFormText;

    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }


    public LoginPage enterFirstName(String name) {
        log.info("Enter first name");
        firstNameField.sendKeys(name);
        return this;
    }

    public LoginPage enterLastName(String lastName) {
        log.info("Enter last name");
        lastNameField.sendKeys(lastName);
        return this;
    }

    public LoginPage enterUserEmail(String email) {
        log.info("Enter e-mail");
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        log.info("Enter password");
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage enterBirthdayDate(String birthday) {
        log.info("Enter birthday date");
        birthdayDateField.sendKeys(birthday);
        return this;
    }

    public LoginPage chooseSocialTitle() {
        log.info("Choose social title");
        socialTitleButton.click();
        return this;
    }

    public LoginPage clickCustomerPrivacyButton() {
        log.info("Click customer privacy button");
        customerPrivacyButton.click();
        return this;
    }

    public LoginPage checkAgreeToThePrivacyPolicyAndTerms() {
        log.info("Check agree to the privacy policy and terms");
        agreeButton.click();
        return this;
    }

    public MainPage clickSaveButton() {
        log.info("Click Save button");
        saveButton.click();
        return new MainPage();
    }

    public LoginPage clickSaveButtonWithIncorrectData() {
        log.info("Click Save button when data isn't correct");
        saveButton.click();
        return this;
    }

    public String getColorOfFirstNameFieldBorder() {
        log.info("Get color of first name fields border");
        String style = firstNameField.getCssValue("outline");
        String[] a = style.split("solid");
        return a[0].trim();
    }

    public String getTextFromInvalidForm() {
        log.info("Get text from invalid form if entered data isn't correct");
        return fieldWithInvalidFormText.getText();
    }
}