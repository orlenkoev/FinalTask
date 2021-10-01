package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class T3_RegistrationWithValidData extends BaseTest {
    @Test
    public void checkThatYourCorrectNameAppearsAfterAccountCreating() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEMail = faker.internet().emailAddress();
        String password = faker.internet().password();

        LocalDate start = LocalDate.of(1920, Month.JANUARY, 1);
        long days = ChronoUnit.DAYS.between(start, LocalDate.now());
        LocalDate randomDay = start.plusDays(new Random().nextInt((int) days + 1));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String birthdayDate = randomDay.format(formatter);

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
        Assert.assertEquals(actualAccountName, expectedAccountName, "Actual name is not as expected");
    }
}
