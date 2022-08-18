package params;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.$;

public class cheatsParamValueSource {
    @ValueSource (strings ={
            "Дорохедоро",
            "Ангел кровопролития"
    })
    @ParameterizedTest(name = "проверка поиска animestars по слову {0}")
    void ValueTest(String name) {
        SelenideLogger.addListener("allure", new AllureSelenide());

        Selenide.open("https://animestars.org/");
        $("#story").setValue(name).pressEnter();
        $(".has-overlay__icon").click();


    }
}
