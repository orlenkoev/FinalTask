package tests;

import com.github.javafaker.Faker;
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
        List<Boolean> clothesResult = mainPage.checkChildElements(mainPage.getClothes(), Arrays.asList("MEN", "WOMEN"));
        clothesResult.stream().forEach(s -> Assert.assertTrue(s));

        List<Boolean> accessoriesResult = mainPage.checkChildElements(mainPage.getAccessories(), Arrays.asList("STATIONERY", "HOME ACCESSORIES"));
        accessoriesResult.stream().forEach(s -> Assert.assertTrue(s));

        List<Boolean> artResult = mainPage.checkChildElements(mainPage.getArt(), new ArrayList<>());
        artResult.stream().forEach(s -> Assert.assertTrue(s));
    }
}