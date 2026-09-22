package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookPage extends BasePage {
    private static final String URL = "https://www.sharelane.com/cgi-bin/show_book.py?book_id=";
    private static final By ADD_TO_CART = By.cssSelector("a[href*='add_to_cart.py']");

    private final String bookId;

    public BookPage(WebDriver driver, String bookId) {
        super(driver);
        this.bookId = bookId;
    }

    @Override
    public void open() {
        driver.get(URL + bookId);
    }

    public void addToCart() {
        click(ADD_TO_CART);
    }
}