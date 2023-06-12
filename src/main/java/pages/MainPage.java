package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private final String url = "https://stellarburgers.nomoreparties.site/";
    private final By loginToAccount = By.xpath(".//*[contains(text(),'Войти')]");// Локатор кнопки Войти
    private final By personalAccount = By.xpath(".//p[contains(text(),'Личный Кабинет')]");
    private final By stellarBurger = By.xpath(".//*[@class='AppHeader_header__logo__2D0X2']");
    private final By enterText = By.xpath(".//h2[contains(text(),'Вход')]");
    private final By constructor = By.xpath(".//p[contains(text(),'Конструктор')]");
    private final By sauces = By.xpath(".//span[contains(text(),'Соусы')]");
    private final By saucesInDesigner = By.xpath(".//h2[contains(text(),'Соусы')]");
    private final By buns = By.xpath(".//span[contains(text(),'Булки')]");
    private final By bunsInDesigner = By.xpath(".//h2[contains(text(),'Булки')]");
    private final By fillings = By.xpath(".//span[contains(text(),'Начинки')]");
    private final By fillingsInDesigner = By.xpath(".//h2[contains(text(),'Начинки')]");
    private final By constructBurger = By.xpath("//*[contains(text(),'Соберите бургер')]");
    private final By constructorButton = By.xpath("//*[contains(text(),'Конструктор')]");

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }

    @Step("Клик по кнопке войти в аккаунт")
    public void clickLogin() {
        driver.findElement(loginToAccount).click();
    }

    @Step("Проверка клика по личному аккаунту")
    public void clickPersonalAccount() {
        driver.findElement(personalAccount).click();
    }

    @Step("Клик по лого")
    public void clickStellarBurger() {
        driver.findElement(stellarBurger).click();
    }

    @Step("Проверка сборки")
    public void checkStellarBurger() {
        String actualText = driver.findElement(constructBurger).getText();
        String expected = "Соберите бургер";
        Assert.assertEquals(expected, actualText);
    }

    @Step("Клик по кнопке конструтор")
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
        String actualText = driver.findElement(constructBurger).getText();
        String expected = "Соберите бургер";
        Assert.assertEquals(expected, actualText);
    }

    @Step("Проверка входа")
    public void checkEnterPageOpen() {
        String actualText = driver.findElement(enterText).getText();
        String expected = "Вход";
        Assert.assertEquals(expected, actualText);
    }

    @Step("Переход к соусам")
    public void checkSauces() {
        driver.findElement(constructor).click();
        driver.findElement(sauces).click();
        String actualText = driver.findElement(saucesInDesigner).getText();
        String expected = "Соусы";
        Assert.assertEquals(expected, actualText);
    }

    @Step("Переход к булкам")
    public void checkBuns() {
        driver.findElement(constructor).click();
        driver.findElement(buns);
        String actualText = driver.findElement(bunsInDesigner).getText();
        String expected = "Булки";
        Assert.assertEquals(expected, actualText);
    }

    @Step("Переход к начинкам")
    public void checkFillings() {
        driver.findElement(constructor).click();
        driver.findElement(fillings).click();
        String actualText = driver.findElement(fillingsInDesigner).getText();
        String expected = "Начинки";
        Assert.assertEquals(expected, actualText);
    }


}
