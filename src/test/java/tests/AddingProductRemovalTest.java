package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.qameta.allure.Allure.step;

@Owner("Sergey")
@Epic("Mobile test app Wildberries")
public class AddingProductRemovalTest extends PreparingTest {

    @Test
    @DisplayName("Добавление товара в корзину")
    void shouldIntoABasketItem() {

        step("Click search field", () -> {
            $x("//android.widget.EditText/android.view.View").click();
        });
        step("Entering the name of the product you are looking for", () -> {
            $(By.className("android.widget.EditText")).sendKeys("samsung");
        });
        step("Select the section you are interested in", () -> {
            $x("//android.widget.TextView[@text=\"samsung телефон\"]").click();
        });
        step("Click first element of result search", () -> {
            $$x("(//android.view.ViewGroup[@resource-id=\"com.wildberries.ru:id/itemLayout\"])")
                    .first().click();
        });
        step("Product photo", () -> {
            $x("//android.view.View[@content-desc=\"Фото товара\"]").shouldBe(visible);
        });
        step("Button 'buy now'", () -> {
            $x("//ru.wildberries.composeutils.FixedComposeView/android.view.View" +
                    "/android.view.View/android.view.View[2]/android.widget.Button").shouldBe(visible);
        });
        step("Button 'Into a basket'", () -> {
            $x("//ru.wildberries.composeutils.FixedComposeView/android.view.View" +
                    "/android.view.View/android.view.View[3]/android.widget.Button").shouldBe(visible).click();
        });

        step("Modal window 'item in cart'", () -> {
            $x("//ru.wildberries.composeutils.FixedComposeView/android.view.View" +
                    "/android.view.View/android.view.View[2]").shouldBe(visible);
        });
        step("Go to cart", () -> {
            $(accessibilityId("Корзина")).click();
        });
        step("Presence of 1 item in the cart", () -> {
            $x("//android.widget.FrameLayout[@resource-id=\"com.wildberries.ru:id/fragmentTabContainer\"]" +
                    "/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View" +
                    "/android.view.View[1]/android.view.View").shouldBe(visible);
            $x("(//android.widget.TextView[@text=\"1\"])[1]").shouldHave(text("1"), visible);
        });

    }

    @Test
    @DisplayName("Удаление товара из корзины")
    void removingAnItemFromTheCart() {

        step("Click search field", () -> {
            $x("//android.widget.EditText/android.view.View").click();
        });
        step("Entering the name of the product you are looking for", () -> {
            $(By.className("android.widget.EditText")).sendKeys("samsung");
        });
        step("Select the section you are interested in", () -> {
            $x("//android.widget.TextView[@text=\"samsung телефон\"]").click();
        });
        step("Click first element of result search", () -> {
            $$x("(//android.view.ViewGroup[@resource-id=\"com.wildberries.ru:id/itemLayout\"])")
                    .first().click();
        });
        step("Product photo", () -> {
            $x("//android.view.View[@content-desc=\"Фото товара\"]").shouldBe(visible);
        });
        step("Button 'buy now'", () -> {
            $x("//ru.wildberries.composeutils.FixedComposeView/android.view.View" +
                    "/android.view.View/android.view.View[2]/android.widget.Button").shouldBe(visible);
        });
        step("Button 'Into a basket'", () -> {
            $x("//ru.wildberries.composeutils.FixedComposeView/android.view.View" +
                    "/android.view.View/android.view.View[3]/android.widget.Button").shouldBe(visible).click();
        });

        step("Modal window 'item in cart'", () -> {
            $x("//ru.wildberries.composeutils.FixedComposeView/android.view.View" +
                    "/android.view.View/android.view.View[2]").shouldBe(visible);
        });
        step("Go to cart", () -> {
            $(accessibilityId("Корзина")).click();
        });
        step("Presence of 1 item in the cart", () -> {
            $x("//android.widget.FrameLayout[@resource-id=\"com.wildberries.ru:id/fragmentTabContainer\"]" +
                    "/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View" +
                    "/android.view.View[1]/android.view.View").shouldBe(visible);
            $x("(//android.widget.TextView[@text=\"1\"])[1]").shouldHave(text("1"), visible);
        });
        step("Click action menu", () -> {
            $x("//android.widget.FrameLayout[@resource-id=\"com.wildberries.ru:id/fragmentTabContainer\"]" +
                    "/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]" +
                    "/android.view.View/android.view.View[1]").click();
        });
        step("Click on the delete section in the menu that opens", () -> {
            $x("//android.widget.TextView[@text=\"Удалить\"]").click();
        });
        step("Message 'Cart is empty'", () -> {
            $x("//android.widget.TextView[@text=\"Корзина пуста\"]").shouldBe(visible);
        });
        step("Click button 'Go to directory'", () -> {
            $x("//android.widget.TextView[@text=\"Перейти в каталог\"]").shouldBe(visible).click();
        });
        step("Return product catalog", () -> {
            $x("//android.widget.FrameLayout[@resource-id=\"com.wildberries.ru:id/fragmentTabContainer\"]")
                    .shouldBe(visible);
        });

    }

}
