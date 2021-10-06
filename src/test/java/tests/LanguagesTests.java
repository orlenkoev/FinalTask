package tests;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.List;
import java.util.stream.Collectors;

public class LanguagesTests extends BaseTest {
    @Test
    public void checkCountOfLanguagesAndPresenceOfSomeLanguage() {

        MainPage mainPage = new MainPage();
        List<WebElement> language = mainPage
                .clickOnDropdownMenuWithLanguages()
                .getLanguagesContainers();
        List<String> languageList = language.stream().map(WebElement::getText).collect(Collectors.toList());
        String expectedLanguage = "Українська";
        int countOfLanguage = mainPage
                .clickOnDropdownMenuWithLanguages()
                .getCountOfLanguage();

        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(countOfLanguage)
                .as("The count of language is not as expected")
                .isEqualTo(44);
        sa.assertThat(languageList)
                .as("List does not contain language " + expectedLanguage)
                .contains(expectedLanguage);
        sa.assertAll();
    }
}
