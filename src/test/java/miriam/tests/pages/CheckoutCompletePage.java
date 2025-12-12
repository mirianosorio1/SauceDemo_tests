package miriam.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {

    private WebDriver driver;

    private By confirmationHeader = By.cssSelector("h2.complete-header");

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOrderConfirmed() {
        return driver.findElement(confirmationHeader).isDisplayed();
    }

    public String getConfirmationText() {
        return driver.findElement(confirmationHeader).getText();
    }
}
