package tests;

import com.github.javafaker.Faker;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class T4_RegistrationWithInvalidData extends BaseTest {

    @Test
    public void checkThatFieldHighlightedAndDanderTextAppearsAfterEnteredInvalidData() {
        Faker faker = new Faker();
        String firstName = "James8";
        String lastName = faker.name().lastName();
        String userEMail = faker.internet().emailAddress();
        String password = faker.internet().password();
        String birthdayDate = faker.date().birthday().toString();

        MainPage mainPage = new MainPage();

        String expectedDangerTextMessage = "Invalid format.";
        String actualDangerTextMessage = mainPage
                .clickSignInButton()
                .clickCreateNewAccountButton()
                .chooseSocialTitle()
                .enterFirstName(firstName)
                .enterLastName(lastName)
                .enterUserEmail(userEMail)
                .enterPassword(password)
                .enterBirthdayDate(birthdayDate)
                .clickCustomerPrivacyButton()
                .checkAgreeToThePrivacyPolicyAndTerms()
                .clickSaveButtonWithIncorrectData()
                .getTextFromInvalidForm();

        String expectedColorOfField = "rgb(255, 76, 76)";
        String actualColorOfField = mainPage
                .clickSignInButton()
                .clickCreateNewAccountButton()
                .chooseSocialTitle()
                .enterFirstName(firstName)
                .enterLastName(lastName)
                .enterUserEmail(userEMail)
                .enterPassword(password)
                .enterBirthdayDate(birthdayDate)
                .clickCustomerPrivacyButton()
                .checkAgreeToThePrivacyPolicyAndTerms()
                .clickSaveButtonWithIncorrectData()
                .getColorOfFirstNameField();

        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(actualDangerTextMessage)
                .as("Danger Text when you input invalid data ia not as espected")
                .isEqualTo(expectedDangerTextMessage);

        sa.assertThat(actualColorOfField)
                .as("Color of Field when you input invalid data is not as espected")
                .isEqualTo(expectedColorOfField);
        sa.assertAll();
    }
}
