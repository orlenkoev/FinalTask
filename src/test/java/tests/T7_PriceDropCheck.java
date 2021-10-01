package tests;

import blocks.Product;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.List;

public class T7_PriceDropCheck extends BaseTest {
    @Test
    public void checkPriceDropCheck() {
        MainPage mainPage = new MainPage();
        SoftAssertions sa = new SoftAssertions();
        List<Product> nameOfProducts = mainPage
                .getFooter()
                .clickOnPricesDropButton()
                .getProductsOnPage();
        for (Product product : nameOfProducts) {
            sa.assertThat(product.getPrice().isDisplayed());
            sa.assertThat(product.getOldPrice().isDisplayed());
//            sa.assertThat(product.getPrice()).isEqualTo(product.countExpectedPrice());
            sa.assertAll();
        }
        }
    }

