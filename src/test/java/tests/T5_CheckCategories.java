package tests;

import com.github.javafaker.Faker;
import org.assertj.core.api.SoftAssertions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T5_CheckCategories extends BaseTest {
    @Test
    public void checkCategories() {
        MainPage mainPage = new MainPage();

        boolean resultMenCategories = mainPage
                .getMenu()
                .hoverOverTopMenuLinks("CLOTHES")
                .isCategoryDisplaying("MEN");
        boolean resultWomenCategories = mainPage
                .getMenu()
                .isCategoryDisplaying("WOMEN");
        boolean resultHomeAccessoriesButton = mainPage
                .getMenu()
                .hoverOverTopMenuLinks("ACCESSORIES")
                .isCategoryDisplaying("STATIONERY");
        boolean resultStationeryButton = mainPage
                .getMenu()
                .isCategoryDisplaying("HOME_ACCESSORIES");
        boolean resultArtButton = mainPage
                .getMenu()
                .hoverOverTopMenuLinks("ART")
                .isEmptyFieldUnderArtButton();

        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(resultMenCategories)
                .as(" Categories MEN of clothes button not displayed")
                .isTrue();
        sa.assertThat(resultWomenCategories)
                .as(" Categories Women of clothes button not displayed")
                .isTrue();
        sa.assertThat(resultHomeAccessoriesButton)
                .as(" Categories Home Accessories of Accessories button not displayed")
                .isTrue();
        sa.assertThat(resultStationeryButton)
                .as(" Categories Stationery of Accessories button not displayed")
                .isTrue();
        sa.assertThat(resultArtButton)
                .as("Categories under Art button not empty")
                .isTrue();
        sa.assertAll();
    }
}

