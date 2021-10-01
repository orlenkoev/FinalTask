package tests;

import com.github.javafaker.Faker;
import org.assertj.core.api.SoftAssertions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T4_RegistrationWithInvalidData extends BaseTest {

    @Test
    public void checkThatFieldHighlightedAndDanderTextAppearsAfterEnteredInvalidData() {
        Faker faker = new Faker();
        String firstName = "James8";
        String lastName = faker.name().lastName();
        String userEMail = faker.internet().emailAddress();
        String password = faker.internet().password();
        String birthdayDate = "05/31/1970";

        MainPage mainPage = new MainPage();

        LoginPage loginPage = mainPage
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
                .clickSaveButtonWithIncorrectData();

        String expectedColorOfField = "rgb(255, 76, 76)";
        String actualColorOfField = loginPage.getColorOfFirstNameField();

        String expectedDangerTextMessage = "Invalid format.";
        String actualDangerTextMessage = loginPage.getTextFromInvalidForm();

        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(actualDangerTextMessage)
                .as("Danger Text when you input invalid data is not as expected")
                .isEqualTo(expectedDangerTextMessage);

        sa.assertThat(actualColorOfField)
                .as("Color of Field when you input invalid data is not as expected")
                .isEqualTo(expectedColorOfField);
        sa.assertAll();
    }
}
