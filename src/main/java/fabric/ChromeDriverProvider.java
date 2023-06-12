package fabric;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverProvider implements WebDriverProvider {
    @Override
    public WebDriver createDriver() {
        return new ChromeDriver();
    }
}