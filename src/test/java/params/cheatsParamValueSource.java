package params;

import com.codeborne.selenide.Selenide;
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

        Selenide.open("https://animestars.org/");
        $("#story").setValue(name).pressEnter();
        $(".has-overlay__icon").click();


    }
}
