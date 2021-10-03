package blocks;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

@Getter
@Slf4j
public class Product {
    private WebElement name;
    private String nameAsString;
    private WebElement image;
    private WebElement price;
    private String priceAsString;
    private double priceAsDouble;
    private WebElement oldPrice;
    private String oldPriceAsString;
    private double oldPriceAsDouble;
    private String discount;
    private double discountAsDouble;


    public Product(WebElement container) {
        this.name = container.findElement(By.xpath(".//a[@itemprop='url']"));
        this.nameAsString = name.getText();
        this.image = container.findElement(By.xpath(".//a[@class='thumbnail product-thumbnail']/img"));
        priceInit(container);
    }

    private void priceInit(WebElement container) {
        if (container.findElements(By.xpath(".//span[@class='price']")).size() == 1) {
            this.price = container.findElement(By.xpath(".//span[@class='price']"));
            this.priceAsString = container.findElement(By.xpath(".//span[@class='price']")).getText();
            this.priceAsDouble = Double.parseDouble(priceAsString.replace("€", ""));
            if (container.findElements(By.xpath(".//span[@class='regular-price']")).size() == 1) {
                this.oldPrice = container.findElement(By.xpath(".//span[@class='regular-price']"));
                this.oldPriceAsString = container.findElement(By.xpath(".//span[@class='regular-price']")).getText();
                this.oldPriceAsDouble = Double.parseDouble(oldPriceAsString.replace("€", ""));
                if (container.findElements(By.xpath(".//li[@class='product-flag discount']")).size() == 1) {
                    this.discount = container.findElement(By.xpath(".//li[@class='product-flag discount']")).getText();
                    this.discountAsDouble = Double.parseDouble(container.findElement(By.xpath(".//li[@class='product-flag discount']")).getText().replace("-", "").substring(0, 2));
                }
            }
        } else {
            this.priceAsString = container.findElement(By.xpath(".//span[@class='price']")).getText().split("\n")[0];
            this.priceAsDouble = Double.parseDouble(priceAsString.replace("€", ""));
        }
    }

    public static List<Product> getAllProductsOnPage(List<WebElement> containers) {
        List<Product> allProducts = new ArrayList<>();
        for (WebElement container : containers) {
            allProducts.add(new Product(container));
        }
        return allProducts;
    }
}
