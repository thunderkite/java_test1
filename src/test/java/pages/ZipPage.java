package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ZipPage extends BasePage {
    private static final String URL = "https://www.sharelane.com/cgi-bin/register.py";
    private static final By ZIP_CODE = By.name("zip_code");
    private static final By SUBMIT = By.cssSelector("input[value='Continue']");

    public ZipPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(URL);
    }

    public RegisterPage inputZip(String zipCode) {
        find(ZIP_CODE).sendKeys(zipCode);
        click(SUBMIT);
        return new RegisterPage(driver);
    }
}
