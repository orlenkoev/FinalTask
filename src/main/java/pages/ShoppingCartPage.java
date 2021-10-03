package pages;

import blocks.Product;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


@Getter
@Slf4j

public class ShoppingCartPage extends BasePage {
    @FindBy(id = "myModalLabel")
    private WebElement titleOfShoppingCart;

    @FindBy(xpath = "//span[@class='product-quantity']/strong")
    private WebElement quantity;

    @FindBy(xpath = "//span[@class='paper type']/strong")
    private WebElement paperType;

    @FindBy(xpath = "//p[@class='product-price']")
    private WebElement priceOfOneItem;

    @FindBy(xpath = "//span[@class='value']")
    private WebElement totalPrice;

    public ShoppingCartPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public String getTextFromTitleOfShoppingCart() {
        log.info("Get text from title of shopping cart");
        return titleOfShoppingCart.getText().replace("\uE876", "");
    }

    public String getQuantityFromForm() {
        log.info("Get quantity from shopping cart");
        return quantity.getText();
    }

    public double getQuantityFromFormAsDouble() {
        log.info("Get quantity from shopping cart as double");
        return Double.parseDouble(String.valueOf(getQuantityFromForm()));
    }

    public String getPaperTypeFromForm() {
        log.info("Get paper type from shopping cart");
        return paperType.getText();
    }

    public String getPriceOfOneItem() {
        log.info("Get price of one item");
        return priceOfOneItem.getText();
    }

    public double getPriceOfOneItemAsDouble() {
        log.info("Get price of one item as double");
        return Double.parseDouble(getPriceOfOneItem().replace("€", ""));
    }

    public String getTotalPrice() {
        log.info("Get price of  all checked products");
        return totalPrice.getText();
    }

    public double getTotalPriceAsDouble() {
        log.info("Get price of all checked products as double");
        return Double.parseDouble(String.valueOf(getTotalPrice().replace("€", "")));
    }

    public double countExpectedPriceOfAllCheckedProducts(Product product) {
        log.info("Count expected price of all checked products");
        double priceOfOneItem = getPriceOfOneItemAsDouble();
        double quantityOfItems = getQuantityFromFormAsDouble();
        return priceOfOneItem * quantityOfItems;
    }
}
