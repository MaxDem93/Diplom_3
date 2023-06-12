package burgerTests;

import fabric.BrowserType;
import fabric.WebDriverFactory;
import fabric.WebDriverProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class CrossBrowserTest {

    private WebDriverProvider provider;

    public CrossBrowserTest(BrowserType type) {
        provider = WebDriverFactory.getProvider(type);
    }

    @Before
    public void setUp() throws Exception {
        WebDriver driver = provider.createDriver();
        // выполните настройку драйвера
    }

    @Test
    public void testSomething() throws Exception {
        // выполните тест
    }

    @After
    public void tearDown() throws Exception {
        // выполните очистку
    }
}