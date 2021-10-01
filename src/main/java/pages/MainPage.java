package pages;

import blocks.Footer;
import blocks.Product;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static blocks.Product.getAllProductsOnPage;


@Getter
public class MainPage extends BasePage {
    private Footer footer;


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

    @FindBy(id = "category-3")
    private WebElement clothes;

    @FindBy(id = "category-6")
    private WebElement accessories;

    @FindBy(id = "category-9")
    private WebElement art;

    public List<Boolean> checkChildElements(WebElement parentElement, List<String> textOfChildElements) {
        List<Boolean> results = new ArrayList<>();
        Actions action = new Actions(getDriver());
        action.moveToElement(parentElement).build().perform();
        List<WebElement> childElem = parentElement.findElements(By.xpath(".//li/a"));
        if(childElem.size() > 0) {
            List<String> childText = parentElement.findElements(By.xpath(".//li/a"))
                    .stream().map(e -> e.getText()).collect(Collectors.toList());
            results.add(childText.equals(textOfChildElements));
        }
        results.add(childElem.size() == textOfChildElements.size());
        return results;
    }


    public MainPage() {
        PageFactory.initElements(getDriver(), this);
        this.footer = new Footer(getDriver());
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

