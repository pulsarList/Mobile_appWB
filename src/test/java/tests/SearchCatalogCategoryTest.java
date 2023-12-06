package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.id;

@Owner("Sergey")
@Epic("Mobile test app Wildberries")
public class SearchCatalogCategoryTest extends PreparingTest {

    @Test
    @DisplayName("Поиск товаров из каталога в разделе 'Женщинам'")
    void productSearchByCategory_Woman() {

        step("Click button 'Catalog'", () -> {
            $x("//android.view.View[@content-desc=\"Каталог\"]").click();
        });
        step("product catalog", () -> {
            $x("//android.widget.FrameLayout[@resource-id=\"com.wildberries.ru:id/fragmentTabContainer\"]")
                    .shouldBe(visible);
        });
        step("Click on the button 'Woman'", () -> {
            $(accessibilityId("Женщинам")).click();
        });
        step("Click category 'Blouses and shirts'", () -> {
            $x("//android.widget.TextView[@text=\"Блузки и рубашки\"]").click();
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
    @DisplayName("Поиск товаров из каталога в разделе 'Новый год'")
    void productSearchByCategory_NewYear() {

        step("Click button 'Catalog'", () -> {
            $x("//android.view.View[@content-desc=\"Каталог\"]").click();
        });
        step("product catalog", () -> {
            $x("//android.widget.FrameLayout[@resource-id=\"com.wildberries.ru:id/fragmentTabContainer\"]")
                    .shouldBe(visible);
        });
        step("Click on the button 'New Year'", () -> {
            $(accessibilityId("Новый год")).click();
        });
        step("Click category 'Christmas trees'", () -> {
            $x("//android.widget.TextView[@text=\"Елки\"]").click();
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
    @DisplayName("Возврат из раздела 'Товары для взрослых' для лиц младше 18ти лет")
    void productSearchByCategory_18ForAdults_buttonNO_backCatalogItems() {

        step("Click button 'Catalog'", () -> {
            $x("//android.view.View[@content-desc=\"Каталог\"]").click();
        });
        step("product catalog", () -> {
            $x("//android.widget.FrameLayout[@resource-id=\"com.wildberries.ru:id/fragmentTabContainer\"]")
                    .shouldBe(visible);
        });
        step("Click on the button 'Products for adults'", () -> {
            $(accessibilityId("Товары для взрослых")).click();
        });
        step("Modal verify window 'Are you over 18 years old?'", () -> {
            $(id("com.wildberries.ru:id/textAgeConfirmTitle"))
                    .shouldHave(text("Вам есть 18 лет?"), visible);
        });
        step("Modal verify window: button 'No' click", () -> {
            $(id("com.wildberries.ru:id/buttonAgeRefuse"))
                    .shouldHave(text("НЕТ"), visible).click();
        });
        step("product catalog", () -> {
            $x("//android.widget.FrameLayout[@resource-id=\"com.wildberries.ru:id/fragmentTabContainer\"]")
                    .shouldBe(visible);
        });

    }


    @Test
    @DisplayName("Поиск товаров из каталога в разделе 'Товары для взрослых'")
    void productSearchByCategory_18ForAdults_buttonYES() {

        step("Click button 'Catalog'", () -> {
            $x("//android.view.View[@content-desc=\"Каталог\"]").click();
        });
        step("product catalog", () -> {
            $x("//android.widget.FrameLayout[@resource-id=\"com.wildberries.ru:id/fragmentTabContainer\"]")
                    .shouldBe(visible);
        });
        step("Click on the button 'Products for adults'", () -> {
            $(accessibilityId("Товары для взрослых")).click();
        });
        step("Modal verify window 'Are you over 18 years old?'", () -> {
            $(id("com.wildberries.ru:id/textAgeConfirmTitle"))
                    .shouldHave(text("Вам есть 18 лет?"), visible);
        });
        step("Modal verify window: button 'YES, I AM 18 YEARS OLD' click", () -> {
            $(id("com.wildberries.ru:id/buttonAgeConfirm"))
                    .shouldHave(text("ДА, МНЕ ЕСТЬ 18 ЛЕТ"), visible).click();
        });
        step("Click category 'Lingerie and accessories'", () -> {
            $x("//android.widget.TextView[@text=\"Белье и аксессуары\"]").click();
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
