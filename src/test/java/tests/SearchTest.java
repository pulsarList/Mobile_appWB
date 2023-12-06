package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

import org.openqa.selenium.By;

@Owner("Sergey")
@Epic("Mobile test app Wildberries")
public class SearchTest extends PreparingTest {

    @Test
    @DisplayName("Поиск товаров через поле для поиска при вводе букв")
    void searchWhenEnteringLetters() {

        step("Click search field", () -> {
            $x("//android.widget.EditText/android.view.View").click();
        });
        step("Entering the name of the product you are looking for", () -> {
            $(By.className("android.widget.EditText")).sendKeys("lego technic");
        });
        step("Select the section you are interested in", () -> {
            $x("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout").click();
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
                    "/android.view.View/android.view.View[3]/android.widget.Button").shouldBe(visible);
        });

    }


    @Test
    @DisplayName("Поиск товаров через поле для поиска при вводе цифр")
    void searchWhenEnteringNumbers() {

        step("Click search field", () -> {
            $x("//android.widget.EditText/android.view.View").click();
        });
        step("Entering the name of the product you are looking for", () -> {
            $(By.className("android.widget.EditText")).sendKeys("15");
        });
        step("Select the section you are interested in", () -> {
            $x("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout").click();
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
                    "/android.view.View/android.view.View[3]/android.widget.Button").shouldBe(visible);
        });

    }

}
