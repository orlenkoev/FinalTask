package pages;

import blocks.Product;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static blocks.Product.getAllProductsOnPage;

@Getter
@Slf4j
public class ResultOfSearchPage extends BasePage {
    @FindBy(xpath = "//div[@itemprop='itemListElement']")
    private List<WebElement> productContainer;

    public ResultOfSearchPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public List<Product> getProductsOnPage() {
        log.info("Get all products from page");
        List<Product> allProducts = getAllProductsOnPage(productContainer);
        return allProducts;
    }
}
