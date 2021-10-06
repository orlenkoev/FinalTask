package pages;

import blocks.Footer;
import blocks.Menu;
import blocks.Product;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static blocks.Product.getAllProductsOnPage;


@Getter
@Slf4j

public class MainPage extends BasePage {
    private final Footer footer;
    private final Menu menu;

    @FindBy(xpath = "(//span[@class='hidden-sm-down'])[1]")
    private WebElement signInButton;

    @FindBy(xpath = "//i[contains(@class,'expand-more')]")
    private WebElement dropdownMenuWithLanguages;

    @FindBy(xpath = ".//ul[contains(@class,'dropdown')]/li")
    private List<WebElement> languagesContainers;

    @FindBy(xpath = "//div[@itemprop='itemListElement']")
    private List<WebElement> productContainer;

    @FindBy(xpath = "//div[@class ='user-info']//span")
    private WebElement registeredUserNameField;

    @FindBy(xpath = "//a[contains(@class,'all-product')]")
    private WebElement allProductsButton;

    @FindBy(xpath = "//input[@class='ui-autocomplete-input']")
    private WebElement searchField;

    @FindBy(xpath = "//i[@class='material-icons search']")
    private WebElement enterSearchButton;

    public MainPage() {
        PageFactory.initElements(getDriver(), this);
        this.footer = new Footer(getDriver());
        this.menu = new Menu(getDriver());
    }
    public MainPage enterSomeProductForSearch(String product) {
        log.info("Enter some name of product for search");
        waitUntilVisible(By.xpath("//input[@class='ui-autocomplete-input']"), 5);
        searchField.sendKeys(product);
        return this;
    }

    public ResultOfSearchPage pressEnterForSearch() {
        waitUntilClickable(By.xpath("//i[@class='material-icons search']"), 2);
        enterSearchButton.click();
        getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return new ResultOfSearchPage();
    }

    public MainPage clickOnDropdownMenuWithLanguages() {
        log.info("Click on dropdown menu with languages");
        waitUntilVisible(By.xpath("//i[contains(@class,'expand-more')]"), 3);
        dropdownMenuWithLanguages.click();
        return this;
    }

    public SignInPage clickSignInButton() {
        signInButton.click();
        return new SignInPage();
    }

    public int getCountOfLanguage() {
        log.info("Get count of all languages");
        return languagesContainers.size();
    }

    public String getNameFromUserLoginField() {
        return registeredUserNameField.getText();
    }

    public List<Product> getProductsOnPage() {
        log.info("Get all products from page");
        List<Product> allProducts = getAllProductsOnPage(productContainer);
        return allProducts;
    }
}
