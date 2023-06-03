package burgerTests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import pages.BrowserBase;
import pages.MainPage;
import pages.UserRegistrationPage;

public class RegistrationTest {
    @Rule
    public BrowserBase browserBase = new BrowserBase();

    @Test
    @DisplayName("Успешная регистрация")
    public void successfulReg() throws InterruptedException {
        UserRegistrationPage userRegistrationPage = new UserRegistrationPage(browserBase.getDriver());
        MainPage mainPage = new MainPage(browserBase.getDriver());
        userRegistrationPage.open();
        userRegistrationPage.clickLogin();
        userRegistrationPage.checkRegistration();
        mainPage.checkStellarBurger();
    }

    @Test
    @DisplayName("Ошибка для некорректного пароля")
    public void failWithWrongPassword() {
        UserRegistrationPage userRegistrationPage = new UserRegistrationPage(browserBase.getDriver());
        userRegistrationPage.open();
        userRegistrationPage.clickLogin();
        userRegistrationPage.checkWrongPasswordRegistration();
    }

    @Test
    @DisplayName("Переход через кнопку Войти в аккаунт")
    public void checkLoginToAccount() {
        MainPage mainPage = new MainPage(browserBase.getDriver());
        mainPage.open();
        mainPage.clickLogin();
        mainPage.checkEnterPageOpen();
    }

    @Test
    @DisplayName("Регистрация через личный кабинет")
    public void successfulLoginAccount() throws InterruptedException {
        UserRegistrationPage userRegistrationPage = new UserRegistrationPage(browserBase.getDriver());
        MainPage mainPage = new MainPage(browserBase.getDriver());
        userRegistrationPage.open();
        userRegistrationPage.clickPersonalAccount();
        userRegistrationPage.checkRegistration();
        mainPage.checkStellarBurger();
    }

    @Test
    @DisplayName("Восстановить пароль")
    public void passwordUpdatedSuccessfully() {
        UserRegistrationPage userRegistrationPage = new UserRegistrationPage(browserBase.getDriver());
        userRegistrationPage.open();
        userRegistrationPage.clickPersonalAccount();
        userRegistrationPage.clickUpdatePassword();
        userRegistrationPage.sendEmailUpdatePassword();
        userRegistrationPage.changeEmail();
    }

    @Test
    @DisplayName("Разлогинивание пользователя")
    public void successfulLogOut() {
        UserRegistrationPage userRegistrationPage = new UserRegistrationPage(browserBase.getDriver());
        userRegistrationPage.open();
        userRegistrationPage.clickLogin();
        userRegistrationPage.checkSuccessfulLogOut();
    }
}
