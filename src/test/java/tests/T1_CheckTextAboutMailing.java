package tests;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

import static org.assertj.core.api.Assertions.assertThat;

public class T1_CheckTextAboutMailing extends BaseTest {


    @Test
    public void checkThatTextNearMailFieldAsExpected() {
        MainPage mainPage = new MainPage();

        String expectedTextNearTheField = "Get our latest news and special sales";
        String actualTextNearTheField = mainPage
                .getFooter()
                .getTextNearTheEmailField();

        String expectedTextUnderTheField = "You may unsubscribe at any moment. For that purpose, please find my contact info in the legal notice";
        String actualTextUnderTheField = mainPage
                .getFooter()
                .getTextUnderTheEmailField();

        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(actualTextNearTheField)
                .as("Text about mailing near the mailing field is not as expected")
                .isEqualTo(expectedTextNearTheField);
        sa.assertThat(actualTextUnderTheField)
                .as("Text about mailing under the mailing field is not as expected")
                .isEqualTo(expectedTextUnderTheField);
        sa.assertAll();
    }


    @Test
    public boolean isTextUpperCase() {
        MainPage mainPage = new MainPage();
        String text = mainPage.getFooter().getTextFromSubscribeButton();
        char[] charArray = text.toCharArray();
        for (char c : charArray) {
            if (!Character.isUpperCase(c))
                return false;
        }
        return true;
    }
}

