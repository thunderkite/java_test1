package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {
    private static final String URL = "https://www.sharelane.com/cgi-bin/register.py";
    private static final By FIRST_NAME = By.name("first_name");
    private static final By LAST_NAME = By.name("last_name");
    private static final By EMAIL = By.name("email");
    private static final By PASSWORD_1 = By.name("password1");
    private static final By PASSWORD_2 = By.name("password2");
    private static final By SUBMIT = By.cssSelector("input[value='Register']");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(URL);
    }

    public void signUp(String firstName, String lastName, String email,
                       String password1, String password2) {
        find(FIRST_NAME).sendKeys(firstName);
        find(LAST_NAME).sendKeys(lastName);
        find(EMAIL).sendKeys(email);
        find(PASSWORD_1).sendKeys(password1);
        find(PASSWORD_2).sendKeys(password2);
        click(SUBMIT);
    }

    public String generatedEmail() {
        return find(By.xpath("//td[normalize-space()='Email']/following-sibling::td[1]"))
                .getText();
    }

    public String generatedPassword() {
        return find(By.xpath("//td[normalize-space()='Password']/following-sibling::td[1]"))
                .getText();
    }
}
