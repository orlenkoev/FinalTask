package blocks;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class Menu {
    @FindBy(id = "block-newsletter-label")
    private WebElement clothes;

    @FindBy(xpath = "//div[@class='col-xs-12']/p")
    private WebElement accessories;

    @FindBy(xpath = "//input[@class='btn btn-primary float-xs-right hidden-xs-down']")
    private WebElement art;

    @FindBy(xpath = "//a[contains(@href, 'prices-drop')]")
    private WebElement menClothes;

    @FindBy(xpath = "//a[contains(@href, 'prices-drop')]")
    private WebElement womenClothes;

    @FindBy(xpath = "//a[contains(@href, 'prices-drop')]")
    private WebElement stationery;

    @FindBy(xpath = "//a[contains(@href, 'prices-drop')]")
    private WebElement homeAccessories;


    public Menu(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
