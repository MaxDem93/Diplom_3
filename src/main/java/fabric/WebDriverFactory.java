package fabric;

public class WebDriverFactory {
    public static WebDriverProvider getProvider(BrowserType type) {
        switch (type) {
            case CHROME:
                return new ChromeDriverProvider();
            case FIREFOX:
                return new FirefoxDriverProvider();
                        default:
                throw new IllegalArgumentException("Unsupported browser type: " + type);
        }
    }
}