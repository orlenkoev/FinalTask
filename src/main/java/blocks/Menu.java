package blocks;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static pages.BasePage.getDriver;

@Getter
public class Menu {

    @FindBy(id = "category-3")
    private WebElement clothes;

    @FindBy(id = "category-6")
    private WebElement accessories;

    @FindBy(id = "category-9")
    private WebElement art;

    @FindBy(xpath = "//div[contains(@class,'popover')]")
    private WebElement fieldUnderMenuElements;


    public Menu(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    Actions actions = new Actions(getDriver());

    public Menu hoverOverTopMenuLinks(String linkName) {
        String categoryId = null;
        switch (linkName) {
            case "CLOTHES":
                categoryId = "3";
                break;
            case "ACCESSORIES":
                categoryId = "6";
                break;
            case "ART":
                categoryId = "9";
                break;
        }
        String baseXpath = "//li[@id='category-" + categoryId + "']";
        actions.moveToElement(getDriver().findElement(By.xpath(baseXpath))).build().perform();
        getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        return this;
    }

    public boolean isCategoryDisplaying(String linkName) {
        String categoryId = null;
        switch (linkName) {
            case "MEN":
                categoryId = "4";
                break;
            case "WOMEN":
                categoryId = "5";
                break;
            case "STATIONERY":
                categoryId = "7";
                break;
            case "HOME_ACCESSORIES":
                categoryId = "8";
                break;
        }
        String baseXpath = "//li[@id='category-" + categoryId + "']";
        return getDriver().findElement(By.xpath(baseXpath)).isDisplayed();
    }

    public boolean isEmptyFieldUnderArtButton() {
        return fieldUnderMenuElements.getText().isEmpty();
    }
}



