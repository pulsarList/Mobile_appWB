package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.*;

@Owner("Sergey")
@Epic("Mobile test app Wildberries")
public class MainPageTest extends PreparingTest {

    @Test
    @DisplayName("Ввод валидного номера телефона при входе в личный кабинет")
    void switchingToAProfileInputCorrectPhone() {

        step("Click button 'Профиль'", () -> {
            $x("//android.view.View[@content-desc=\"Профиль\"]").click();
        });
        step("Privilege message", () -> {
            $x("//android.widget.TextView[@text=\"Войдите в свой профиль\"]")
                    .shouldHave(text("Войдите в свой профиль"), visible);
        });
        step("Click on the button 'Войти в профиль'", () -> {
            $(className("android.widget.Button")).click();
        });
        step("input PhoneNumber", () -> {
            $x("//android.widget.EditText[@resource-id=\"com.wildberries.ru:id/phoneInput\"]")
                    .sendKeys("79520000011");
        });
        step("click Request button", () -> {
            $x("//android.widget.Button[@resource-id=\"com.wildberries.ru:id/requestCodeButton\"]")
                    .click();
        });
        step("Message 'Введите код с картинки'", () -> {
            $x("//android.widget.TextView[@resource-id=\"com.wildberries.ru:id/title\"]")
                    .shouldHave(text("Введите код с картинки"), visible);
        });
        step("Click button 'cancel'", () -> {
            $(By.id("android:id/button2")).click();
        });
        step("Click button 'close'", () -> {
            $(By.id("com.wildberries.ru:id/closeButton")).click();
        });
        step("Privilege message", () -> {
            $x("//android.widget.TextView[@text=\"Войдите в свой профиль\"]")
                    .shouldHave(text("Войдите в свой профиль"), visible);
        });
    }

    @Test
    @DisplayName("Ввод невалидного номера телефона при входе в личный кабинет")
    void switchingToAProfileInputIncorrectPhone() {

        step("Click button 'Профиль'", () -> {
            $x("//android.view.View[@content-desc=\"Профиль\"]").click();
        });
        step("Privilege message", () -> {
            $x("//android.widget.TextView[@text=\"Войдите в свой профиль\"]")
                    .shouldHave(text("Войдите в свой профиль"), visible);
        });
        step("Click on the button 'Войти в профиль'", () -> {
            $(className("android.widget.Button")).click();
        });
        step("input PhoneNumber", () -> {
            $x("//android.widget.EditText[@resource-id=\"com.wildberries.ru:id/phoneInput\"]")
                    .sendKeys("555555555555");
        });
        step("click Request button", () -> {
            $x("//android.widget.Button[@resource-id=\"com.wildberries.ru:id/requestCodeButton\"]")
                    .click();
        });
        step("Modal window 'Invalid format phone number'", () -> {
            $x("//androidx.compose.ui.platform.ComposeView[@resource-id=\"com.wildberries.ru:id/snackbarCompose\"]" +
                    "/android.view.View/android.view.View/android.view.View").shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Ввод номера телефона из 10ти цифр при входе в личный кабинет")
    void switchingToAProfileInputIncorrectPhone9digits() {

        step("Click button 'Профиль'", () -> {
            $x("//android.view.View[@content-desc=\"Профиль\"]").click();
        });
        step("Privilege message", () -> {
            $x("//android.widget.TextView[@text=\"Войдите в свой профиль\"]")
                    .shouldHave(text("Войдите в свой профиль"), visible);
        });
        step("Click on the button 'Войти в профиль'", () -> {
            $(className("android.widget.Button")).click();
        });
        step("input PhoneNumber", () -> {
            $x("//android.widget.EditText[@resource-id=\"com.wildberries.ru:id/phoneInput\"]")
                    .sendKeys("7904904889");
        });
        step("click Request button", () -> {
            $x("//android.widget.Button[@resource-id=\"com.wildberries.ru:id/requestCodeButton\"]")
                    .click();
        });
        step("Modal window 'text input error phone number'", () -> {
            $x("//android.widget.TextView[@resource-id=\"com.wildberries.ru:id/textinput_error\"]")
                    .shouldHave(text("Неверный номер телефона"), visible);
        });
    }

    @Test
    @DisplayName("Переход в каталог товаров из корзины")
    void movingFromTheShoppingCartToTheProductCatalog() {

        step("Click button 'Корзина'", () -> {
            $x("//android.view.View[@content-desc=\"Корзина\"]").click();
        });
        step("Checking that the trash is empty", () -> {
            $x("//android.widget.TextView[@text=\"Корзина пуста\"]")
                    .shouldHave(text("Корзина пуста"), visible);
        });
        step("Click on the button 'Перейти в каталог'", () -> {
            $x("//android.widget.Button").click();
        });
        step("Go to the product catalog", () -> {
            $x("//android.widget.FrameLayout[@resource-id=\"com.wildberries.ru:id/fragmentTabContainer\"]")
                    .shouldBe(visible);
        });
    }

}
