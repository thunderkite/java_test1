package tests;

import pages.RegisterPage;
import pages.ZipPage;
import pages.LoginPage;
import pages.BookPage;
import pages.ShoppingCartPage;
import pages.CheckoutPage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RegisterTest {
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void registeredUserCanAddBookToCart() {
        ZipPage zipPage = new ZipPage(driver);
        zipPage.open();

        RegisterPage registerPage = zipPage.inputZip("12345");
        registerPage.signUp("Test", "Runner", "test.runner@example.com", "Test1234", "Test1234");

        String email = registerPage.generatedEmail();
        String password = registerPage.generatedPassword();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login(email, password);

        BookPage bookPage = new BookPage(driver, "2");
        bookPage.open();
        bookPage.addToCart();

        ShoppingCartPage cartPage = new ShoppingCartPage(driver);
        cartPage.open();
        assertEquals("1", cartPage.quantityFor("White Fang"));
        assertTrue(cartPage.totalFor("White Fang").contains("10.70"));
        cartPage.proceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        assertTrue(checkoutPage.isOpen());
        assertTrue(checkoutPage.containsText("10.70"));
    }
}
