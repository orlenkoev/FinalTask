package tests;

import blocks.Product;
import org.assertj.core.api.SoftAssertions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.PricesDropPage;

import java.util.List;

public class T7_PriceDropCheck extends BaseTest {
    @Test
    public void checkPriceDropCheck() {
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
                    .as("New price of product is not displayed")
                    .isTrue();

            sa.assertThat(isOldPriceIsDisplayed)
                    .as("Old price of product is not displayed")
                    .isTrue();

            sa.assertThat(actualPriceWithDiscount)
                    .as("Promo price calculated not correct")
                    .isEqualTo(expectedPriceWithDiscount);
            sa.assertAll();
        }
    }
}

