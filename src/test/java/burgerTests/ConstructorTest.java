package burgerTests;


import org.junit.Rule;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import pages.BrowserBase;
import pages.MainPage;

public class ConstructorTest {
    @Rule
    public BrowserBase browserBase = new BrowserBase();

    @Test
    @DisplayName("Переход Булки")
    public void checkBuns() {
        MainPage mainPage = new MainPage(browserBase.getDriver());
        mainPage.open();
        mainPage.checkBuns();
    }

    @Test
    @DisplayName("Переход Соусы")
    public void checkSauces() {
        MainPage mainPage = new MainPage(browserBase.getDriver());
        mainPage.open();
        mainPage.checkSauces();
    }



    @Test
    @DisplayName("Переход Начинки")
    public void checkFillings() {
        MainPage mainPage = new MainPage(browserBase.getDriver());
        mainPage.open();
        mainPage.checkFillings();
    }
    @Test
    @DisplayName("Переход по клику на кнопку StellarBurgers")
    public void checkStellarBurger() {
        MainPage mainPage = new MainPage(browserBase.getDriver());
        mainPage.open();
        mainPage.clickLogin();
        mainPage.clickStellarBurger();
        mainPage.checkStellarBurger();
    }
    @Test
    @DisplayName("Переход по кнопке Конструктор из личного кабинета")
    public void checkDesignerButton() {
        MainPage mainPage = new MainPage(browserBase.getDriver());
        mainPage.open();
        mainPage.clickLogin();
        mainPage.clickConstructorButton();
    }

    @Test
    @DisplayName("Перехода через кнопку Личный кабинет")
    public void checkPersonalAccount() {
        MainPage mainPage = new MainPage(browserBase.getDriver());
        mainPage.open();
        mainPage.clickPersonalAccount();
        mainPage.checkEnterPageOpen();
    }
}
