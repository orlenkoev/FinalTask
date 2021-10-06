package tests;

import blocks.Product;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.ProductDescriptionPage;
import pages.ShoppingCartPage;

import java.util.List;

public class AddingToCartTests extends BaseTest {
    @Test
    public void checkThatSelectedProductsOptionsAreDisplayedCorrectlyWhenAddedToCart()
            throws InterruptedException {
        MainPage mainPage = new MainPage();
        List<Product> nameOfProducts = mainPage
                .enterSomeProductForSearch("Bear")
                .pressEnterForSearch()
                .getProductsOnPage();
        for (Product product : nameOfProducts) {
            if (product.getNameAsString().equals("Brown Bear Notebook")) {
                product.getName().click();
                break;
            }
        }
        ProductDescriptionPage productDescriptionPage = new ProductDescriptionPage();
        String quantityYouNeed = "5";
        String paperTypeYouNeed = "Doted";
        String expectedTitleOfShoppingCart = "Product successfully added to your shopping cart";

        ShoppingCartPage shoppingCartPage = productDescriptionPage
                .clickOnTheDropdownMenuWithPaperType()
                .changePaperType(paperTypeYouNeed)
                .enterTheNeededQuantity(quantityYouNeed)
                .clickOnAddToCartButton();

        String actualTitleOfShoppingCart = shoppingCartPage
                .getTextFromTitleOfShoppingCart();

        String actualQuantity = shoppingCartPage
                .getQuantityFromForm();

        String actualPaperType = shoppingCartPage
                .getPaperTypeFromForm();

        for (Product product : nameOfProducts) {
            double expectedPriceOfAllCheckedProducts = shoppingCartPage.countExpectedPriceOfAllCheckedProducts(product);
            double actualPriceOfAllCheckedProducts = shoppingCartPage.getTotalPriceAsDouble();

            SoftAssertions sa = new SoftAssertions();
            sa.assertThat(actualTitleOfShoppingCart)
                    .as("Title of Shopping Cart is not as expected")
                    .isEqualTo(expectedTitleOfShoppingCart);
            sa.assertThat(actualQuantity)
                    .as("Quantity is not as expected")
                    .isEqualTo(quantityYouNeed);
            sa.assertThat(actualPaperType)
                    .as("PaperType is not as expected")
                    .isEqualTo(paperTypeYouNeed);
            sa.assertThat(expectedPriceOfAllCheckedProducts)
                    .as("Total price calculated not correct")
                    .isEqualTo(actualPriceOfAllCheckedProducts);
            sa.assertAll();
        }
    }
}