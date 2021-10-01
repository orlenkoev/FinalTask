package pages;

import blocks.Product;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static blocks.Product.getAllProductsOnPage;

@Getter
public class PricesDropPage extends BasePage{

    @FindBy(xpath = "//div[@itemprop='itemListElement']")
    private List<WebElement> productContainer;

    public PricesDropPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public List<Product> getProductsOnPage() {
        List<Product> allProducts = getAllProductsOnPage(productContainer);
        return allProducts;
    }
    public double countExpectedPriceWithDiscount(Product product) {
        double oldPrice = product.getOldPriceAsDouble();
        double discount = product.getDiscountAsDouble();
        double newPrice = oldPrice - (oldPrice * discount / 100);
        return Double.parseDouble(String.valueOf(newPrice).substring(0, 5));

    }

}
