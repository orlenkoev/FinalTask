package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

public class T3_RegistrationWithValidData extends BaseTest {
    @Test
    public void checkThatYourCorrectNameAppearsAfterAccountCreating() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEMail = faker.internet().emailAddress();
        String password = faker.internet().password();
        String birthdayDate = "05/31/1970";

        MainPage mainPage = new MainPage();
        String expectedAccountName = firstName + " " + lastName;
        String actualAccountName = mainPage
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
                .clickSaveButton()
                .getTextFromUserLoginField();
        Assert.assertEquals(actualAccountName, expectedAccountName);
    }
}
