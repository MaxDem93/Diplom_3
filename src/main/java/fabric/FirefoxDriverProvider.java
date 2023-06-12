package fabric;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverProvider implements WebDriverProvider {
    @Override
    public WebDriver createDriver() {
        return new FirefoxDriver();
    }
}