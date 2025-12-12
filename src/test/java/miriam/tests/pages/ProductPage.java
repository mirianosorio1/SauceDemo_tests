package miriam.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {

    private WebDriver driver;

    private By title = By.cssSelector(".title");
    private By sortSelect = By.cssSelector(".product_sort_container");
    private By cartIcon = By.id("shopping_cart_container");

    // Botón "Add to cart" del primer producto de la lista
    private By firstAddToCartButton = By.xpath("(//button[contains(@class,'btn_inventory')])[1]");

    // Botón Add to cart según el nombre del producto
    private String addToCartButtonByProductName =
            "//div[contains(@class,'inventory_item_name') and normalize-space(text())='%s']" + "/ancestor::div[contains(@class,'inventory_item')]//button[contains(@class,'btn_inventory')]";

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLoaded() {
        return driver.findElement(title).isDisplayed();
    }

    public void sortBy(String visibleText) {
        Select select = new Select(driver.findElement(sortSelect));
        select.selectByVisibleText(visibleText);
    }

    public void addProductToCartByName(String productName) {
        By button = By.xpath(String.format(addToCartButtonByProductName, productName));
        driver.findElement(button).click();
    }

    public void addFirstProductToCart() {
        driver.findElement(firstAddToCartButton).click();
    }

    public void openCart() {
        driver.findElement(cartIcon).click();
    }
}
