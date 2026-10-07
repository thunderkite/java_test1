package pages;

import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    private static final String URL = "https://www.sharelane.com/cgi-bin/checkout.py";

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(URL);
    }

    public boolean isOpen() {
        return driver.getCurrentUrl().contains("checkout.py");
    }

    public boolean containsText(String text) {
        return driver.getPageSource().contains(text);
    }
}