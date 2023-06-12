package fabric;

import org.openqa.selenium.WebDriver;

public interface WebDriverProvider {
    WebDriver createDriver();
}