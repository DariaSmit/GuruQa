package params;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

@DisplayName(" проверка поиска в gorzdrav")
public class cheatsParamCsvSource {

    @CsvSource({
            "Флуоксетин, КАНОНФАРМА ПРОДАКШН",
            "Кармабазепин, Велфарм"

    })
    @ParameterizedTest(name = "проверка слов {0} в поиске gorzdrav {1} ")
    void ParamYouTube(String testData, String resultS) {
        SelenideLogger.addListener("allure", new AllureSelenide());

        Selenide.open("https://gorzdrav.org/");
        $("#js-site-search-input").click();
        $("#js-site-search-input").setValue(testData).pressEnter();
        $(".b-bckgr--common").shouldHave(text(resultS));
    }
}