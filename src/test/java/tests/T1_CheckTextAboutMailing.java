package tests;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.Locale;

public class T1_CheckTextAboutMailing extends BaseTest {


    @Test
    public void checkTextNearMailFieldAndUpperCaseLetterInSubscribeButton() {
        MainPage mainPage = new MainPage();

        String expectedTextNearTheField = "Get our latest news and special sales";
        String actualTextNearTheField = mainPage
                .getFooter()
                .getTextNearTheEmailField();

        String expectedTextUnderTheField = "You may unsubscribe at any moment. For that purpose, please find our contact info in the legal notice.";
        String actualTextUnderTheField = mainPage
                .getFooter()
                .getTextUnderTheEmailField();

        String lettersFromSubscribeButton = mainPage.getFooter().getTextFromSubscribeButton();
        String expectedLettersWithUpperCase = lettersFromSubscribeButton.toUpperCase(Locale.ROOT);

        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(actualTextNearTheField)
                .as("Text about mailing near the mailing field is not as expected")
                .isEqualTo(expectedTextNearTheField);
        sa.assertThat(actualTextUnderTheField)
                .as("Text about mailing under the mailing field is not as expected")
                .isEqualTo(expectedTextUnderTheField);
        sa.assertThat(lettersFromSubscribeButton)
                .as("All characters on Subscribe button not in upper case")
                .isEqualTo(expectedLettersWithUpperCase);
    }

}


