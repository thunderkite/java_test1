package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage {
    private static final String URL = "https://www.sharelane.com/cgi-bin/shopping_cart.py";

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(URL);
    }

    public String quantityFor(String title) {
        return find(By.xpath("//td[normalize-space()='" + title
                + "']/following-sibling::td[1]//input")).getAttribute("value");
    }

    public String totalFor(String title) {
        return find(By.xpath("//td[normalize-space()='" + title
                + "']/following-sibling::td[5]")).getText();
    }

    public void proceedToCheckout() {
        click(By.cssSelector("input[value='Proceed to Checkout']"));
    }
}