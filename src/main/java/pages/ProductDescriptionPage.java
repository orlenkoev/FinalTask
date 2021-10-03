package pages;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

@Getter
@Slf4j

public class ProductDescriptionPage extends BasePage {
    @FindBy(xpath = "//select[@id='group_4']")
    private WebElement dropdownMenuWithPaperType;

    @FindBy(xpath = "//button[@class='btn btn-primary add-to-cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//input[@id='quantity_wanted']")
    private WebElement quantityField;

    public ProductDescriptionPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public ProductDescriptionPage clickOnTheDropdownMenuWithPaperType() {
        log.info("Click on the dropdown menu with paper type");
        dropdownMenuWithPaperType.click();
        return this;
    }

    public ProductDescriptionPage changePaperType(String paperTypeYouNeed) {
        WebElement selectElem = getDriver().findElement(By.id("group_4"));
        Select select = new Select(selectElem);
        select.selectByVisibleText(paperTypeYouNeed);
        return this;
    }

    public ProductDescriptionPage enterTheNeededQuantity(String quantity) throws InterruptedException {
        log.info("Clear quantity field and enter the needed number");
        Thread.sleep(2000);
        quantityField.clear();
        quantityField.sendKeys(quantity);
        return this;
    }

    public ShoppingCartPage clickOnAddToCartButton() {
        log.info("Click on Add to cart button");
        addToCartButton.click();
        return new ShoppingCartPage();
    }
}
