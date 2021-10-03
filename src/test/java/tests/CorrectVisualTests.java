package tests;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class CorrectVisualTests extends BaseTest{
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
                .as("All characters on Subscribe button not in upper case as expected")
                .isEqualTo(expectedLettersWithUpperCase);
    }
    @Test
    public void checkСorrectDisplayingCategoriesInTheMenu() {
        MainPage mainPage = new MainPage();

        boolean isMenCategoriesDisplayedRight = mainPage
                .getMenu()
                .hoverOverTopMenuLinks("CLOTHES")
                .isCategoryDisplaying("MEN");
        boolean isWomenCategoriesDisplayedRight  = mainPage
                .getMenu()
                .isCategoryDisplaying("WOMEN");
        boolean isHomeAccessoriesDisplayedRight = mainPage
                .getMenu()
                .hoverOverTopMenuLinks("ACCESSORIES")
                .isCategoryDisplaying("STATIONERY");
        boolean isStationeryButtonDisplayedRight  = mainPage
                .getMenu()
                .isCategoryDisplaying("HOME_ACCESSORIES");
        boolean isEmptyArtButton = mainPage
                .getMenu()
                .hoverOverTopMenuLinks("ART")
                .isEmptyFieldUnderArtButton();

        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(isMenCategoriesDisplayedRight)
                .as(" Categories MEN of clothes button not displayed")
                .isTrue();
        sa.assertThat(isWomenCategoriesDisplayedRight)
                .as(" Categories Women of clothes button not displayed")
                .isTrue();
        sa.assertThat(isHomeAccessoriesDisplayedRight)
                .as(" Categories Home Accessories of Accessories button not displayed")
                .isTrue();
        sa.assertThat(isStationeryButtonDisplayedRight)
                .as(" Categories Stationery of Accessories button not displayed")
                .isTrue();
        sa.assertThat(isEmptyArtButton)
                .as("Categories under Art button not empty")
                .isTrue();
        sa.assertAll();
    }

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
                .isEqualTo(46);
        sa.assertThat(languageList)
                .as("List doesn`t contain language " + expectedLanguage)
                .contains(expectedLanguage);
        sa.assertAll();
    }
}

