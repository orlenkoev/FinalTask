package tests;

import blocks.Product;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.PricesDropPage;

import java.util.List;

public class ProductsAndPricesTests extends BaseTest {

    @Test
    public void checkPriceDropDisplayingAndPromoPriceCalculatedCorrect() {
        PricesDropPage pricesDropPage = new PricesDropPage();
        MainPage mainPage = new MainPage();
        List<Product> nameOfProducts = mainPage
                .getFooter()
                .clickOnPricesDropButton()
                .getProductsOnPage();
        for (Product product : nameOfProducts) {

            double expectedPriceWithDiscount = pricesDropPage.countExpectedPriceWithDiscount(product);
            double actualPriceWithDiscount = product.getPriceAsDouble();
            boolean isNewPriceIsDisplayed = product.getPrice().isDisplayed();
            boolean isOldPriceIsDisplayed = product.getOldPrice().isDisplayed();

            SoftAssertions sa = new SoftAssertions();
            sa.assertThat(isNewPriceIsDisplayed)
                    .as("The new price of product is not displayed")
                    .isTrue();

            sa.assertThat(isOldPriceIsDisplayed)
                    .as("The old price of product is not displayed")
                    .isTrue();

            sa.assertThat(actualPriceWithDiscount)
                    .as("The promo price of product is calculated wrong")
                    .isEqualTo(expectedPriceWithDiscount);
            sa.assertAll();
        }
    }

    @Test
    public void checkPopularProductsDisplayedCorrect() {
        MainPage mainPage = new MainPage();
        List<Product> nameOfProducts = mainPage
                .getProductsOnPage();
        for (Product product : nameOfProducts) {

            double actualPrice = product.getPriceAsDouble();
            boolean isNameDisplayed = product.getName().isDisplayed();
            boolean isPriceDisplayed = product.getPrice().isDisplayed();

            SoftAssertions sa = new SoftAssertions();
            sa.assertThat(isNameDisplayed)
                    .as("Products names are not displayed")
                    .isTrue();
            sa.assertThat(isPriceDisplayed)
                    .as("Products prices are not displayed")
                    .isTrue();
            sa.assertThat(actualPrice)
                    .as("All prices are not more than 0.00 as expected")
                    .isGreaterThan(0);
            sa.assertAll();
        }
    }
}
