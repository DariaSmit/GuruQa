package params;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@DisplayName("описание класса тестов")
public class cheatsParam {
    //@ValueSource(strings = {
    //  "Selenide",
    // "JUnit"
    // })

    @Disabled
    @ParameterizedTest(name = "проверка поиска в Яндексе по слову{0}")
    void ParamTest(String testData) {

        Selenide.open("https://yandex.ru/");

        $("#text").setValue(testData);
        $(".search2__button").click();
        // ожидаемый результат
        $(".serp-item").shouldHave(text(testData)).shouldBe(visible);
    }

    @Disabled
    @CsvSource({
            "Selenide, это фреймворк для",
            "JUnit, Support JUnit"
    })
    @ParameterizedTest(name = "1проверка поиска в Яндексе по слову{0}, ожидаем результат: {1} ")
    void ParamYaTest(String testData, String expectedResult) {

        Selenide.open("https://yandex.ru/");

        $("#text").setValue(testData);
        $(".search2__button").click();
        // ожидаемый результат
        $(".serp-item").shouldHave(text(expectedResult)).shouldBe(visible);
    }

    static Stream<Arguments> methodSourceTest() {
        return Stream.of(
                Arguments.of("first string", List.of(42.13)),
                Arguments.of("second string", List.of(44.01))
        );
    }

    @Owner("DariaSmit")
    @Severity(SeverityLevel.MINOR)
    @Feature("Тестинг параметризированный")
    @Story("Тестинг Params")

    @MethodSource("methodSourceTest")
    @ParameterizedTest
    void methodSourceTest(String first, List<Integer> second) {
        System.out.println(first + " and List:" + second);
    }
}
