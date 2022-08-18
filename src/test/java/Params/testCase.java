package Params;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class testCase {
    // @Disabled "codetools-0494848"//выключить тест до последующего фикса бага
    @Test
    @DisplayName(" открытие формы регистрации")
    void firstTest() {
        Assertions.assertTrue(3 > 2, "Text"); // месседж для вставки в отчеты, для полноты картины
        Assertions.assertFalse(3 < 2);
        Assertions.assertEquals("bar", "bar");
        Assertions.assertAll(
                () -> Assertions.assertTrue(3 > 2),
                () -> Assertions.assertTrue(3 < 2)
                // лямбда выражение,замыкание
        );
    }
    @Disabled
    @Test
    @DisplayName(" проверка поиска в Яндексе по словоу Selenide")
    void searchTest() {
        // предусловие
        Selenide.open("https://yandex.ru/");
        // шаги
        $("#text").setValue("Selenide");
        $(".search2__button").click();
        // ожидаемый результат
        $(".serp-item").shouldHave(text("Selenide"));
        // Если меняются входные данные, а шаги остаются те же, то используется параметризованные тесты
    }

    @ParameterizedTest
    @DisplayName(" проверка поиска в Яндексе по словоу Selenide")
    void ParamTest(String testData) {

        Selenide.open("https://yandex.ru/");

        $("#text").setValue(testData);
        $(".search2__button").click();
        // ожидаемый результат
        $(".serp-item").shouldHave(text(testData)).shouldBe(visible);
    }
}
