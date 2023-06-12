package pages;

import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static data.ExpectedData.getLoginButtonText;

public class UserRegistrationPage {
    private final String url = "https://stellarburgers.nomoreparties.site/";
    private final By LOGIN_ACCOUNT = By.xpath(".//*[contains(text(),'Войти')]");
    private final By PERSONAL_ACCOUNT = By.xpath(".//p[contains(text(),'Личный Кабинет')]");
    private final By REGISTRATION = By.xpath(".//a[contains(text(),'Зарегистрироваться')]");
    private final By USER_NAME = By.xpath("//label[contains(text(),'Имя')]/../input");
    private final By EMAIL = By.xpath("//label[contains(text(),'Email')]/../input");
    private final By password = By.xpath("//label[contains(text(),'Пароль')]/../input");
    private final By registerButton = By.xpath("//button[contains(text(),'Зарегистрироваться')]");
    private final By errorText = By.xpath(".//p[@class='input__error text_type_main-default']");
    private final By loginEmail = By.xpath(".//input[@name='name']");
    private final By loginPassword = By.xpath(".//input[@name='Пароль']");
    private final By enter = By.xpath(".//button[contains(text(),'Войти')]");
    private final By updatePassword = By.xpath(".//a[contains(text(),'Восстановить пароль')]");
    private final By emailUpdate = By.xpath("//*[contains(text(),'Email')]/../input");
    private final By recover = By.xpath(".//button[contains(text(),'Восстановить')]");
    private final By changeEmail = By.xpath("//input[@name='Введите новый пароль']");
    private final By code = By.xpath("//input[@name='name']");
    private final By save = By.xpath(".//button[contains(text(),'Сохранить')]");
    private final By logOutButton = By.xpath("//button[contains(text(),'Выход')]");
    private final By centralLoginButton = By.xpath("//h2[contains(text(),'Вход')]");
    private final String randomName = RandomStringUtils.randomAlphanumeric(8);
    private final String randomEmail = RandomStringUtils.randomAlphanumeric(10) + "@yandex.ru";
    private final String randomPassword = RandomStringUtils.randomAlphanumeric(10);

    private final WebDriver driver;

    public UserRegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }

    @Step("Клик войти")
    public void clickLogin() {
        driver.findElement(LOGIN_ACCOUNT).click();
    }

    @Step("Личный аккаунт")
    public void clickPersonalAccount() {
        driver.findElement(PERSONAL_ACCOUNT).click();
    }

    @Step("Проверка регистрации")
    public void checkRegistration() throws InterruptedException {
        driver.findElement(REGISTRATION).click();
        driver.findElement(USER_NAME).sendKeys(randomName);
        driver.findElement(EMAIL).sendKeys(randomEmail);
        driver.findElement(password).sendKeys(randomPassword);
        driver.findElement(registerButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(loginEmail));
        driver.findElement(loginEmail).sendKeys(randomEmail);
        driver.findElement(loginPassword).sendKeys(randomPassword);
        driver.findElement(enter).click();
    }

    @Step("Проверка некорректного пароля")
    public void checkWrongPasswordRegistration() {
        driver.findElement(REGISTRATION).click();
        driver.findElement(USER_NAME).sendKeys(randomName);
        driver.findElement(EMAIL).sendKeys(randomEmail);
        driver.findElement(password).sendKeys(RandomStringUtils.randomAlphanumeric(3));
        driver.findElement(registerButton).click();
        String text = driver.findElement(errorText).getText();
        String expected = "Некорректный пароль";
        Assert.assertEquals(expected, text);
    }

    @Step("Клик по кнопке восстановления пароля")
    public void clickUpdatePassword() {
        driver.findElement(updatePassword).click();
    }

    @Step("Восстановление пароля")
    public void sendEmailUpdatePassword() {
        driver.findElement(emailUpdate).sendKeys(randomEmail);
        driver.findElement(recover).click();
        String text = driver.findElement(By.xpath(".//h2[contains(text(),'Восстановление пароля')]")).getText(); //появилась страница восстановление пароля
        String expected = "Восстановление пароля";
        Assert.assertEquals(expected, text);
    }

    @Step("Смена почты")
    public void changeEmail() {
        driver.findElement(changeEmail).sendKeys(randomPassword);
        driver.findElement(code).sendKeys("testcase");
        driver.findElement(save).click();
    }

    @Step("Клик по кнопке разлогиниться")
    public void clickLogOut() {
        driver.findElement(logOutButton).click();
    }

    @Step("Проверка успешности разлогиниться")
    public void checkSuccessfulLogOut() {
        String centralLoginBtn = driver.findElement(centralLoginButton).getText();
        String expectedText = getLoginButtonText();
        Assert.assertEquals(expectedText, centralLoginBtn);
    }


}
