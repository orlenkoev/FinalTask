package pages;

import blocks.Footer;
import blocks.Menu;
import blocks.Product;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static blocks.Product.getAllProductsOnPage;


@Getter
public class MainPage extends BasePage {
    private Footer footer;
    private Menu menu;


    @FindBy(xpath = "(//span[@class='hidden-sm-down'])[1]")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@class ='user-info']//span")
    private WebElement userLoginField;

    @FindBy(xpath = "//i[contains(@class,'expand-more')]")
    private WebElement dropdownMenuWithLanguages;

    @FindBy(xpath = ".//ul[contains(@class,'dropdown')]/li")
    private List<WebElement> languagesContainers;

    @FindBy(xpath = "//div[@itemprop='itemListElement']")
    private List<WebElement> productContainer;

    public MainPage() {
        PageFactory.initElements(getDriver(), this);
        this.footer = new Footer(getDriver());
        this.menu = new Menu(getDriver());
    }

    public MainPage clickOnDropdownMenuWithLanguages() {
        dropdownMenuWithLanguages.click();
        return this;
    }

    public SignInPage clickSignInButton() {
        signInButton.click();
        return new SignInPage();
    }

    public int getCountOfLanguage() {
        return languagesContainers.size();
    }

    public String getLanguageOutOfTheDropList(String language) {
        if (languagesContainers.contains(language)) ;
        return language;
    }

    public String getTextFromUserLoginField() {
        return userLoginField.getText();
    }

    public List<Product> getProductsOnPage() {
        List<Product> allProducts = getAllProductsOnPage(productContainer);
        return allProducts;
    }

}
