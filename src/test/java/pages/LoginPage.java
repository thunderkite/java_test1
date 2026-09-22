package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private static final String URL = "https://www.sharelane.com/cgi-bin/main.py";
    private static final By EMAIL = By.name("email");
    private static final By PASSWORD = By.name("password");
    private static final By LOGIN = By.cssSelector("input[value='Login']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(URL);
    }

    public void login(String email, String password) {
        find(EMAIL).sendKeys(email);
        find(PASSWORD).sendKeys(password);
        click(LOGIN);
    }
}