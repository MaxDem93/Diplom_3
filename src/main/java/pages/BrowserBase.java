package pages;


import fabric.BrowserType;
import fabric.WebDriverFactory;
import fabric.WebDriverProvider;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;


public class BrowserBase extends ExternalResource {
    WebDriver driver;
    private WebDriverProvider provider;

    public BrowserBase(BrowserType type) {
        provider = WebDriverFactory.getProvider(type);
    }

    public WebDriver getDriver() {
        return driver;
    }

    @Override
    protected void before() throws Throwable {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
    }
    @Override
    protected void after() {
        driver.quit();
    }
}