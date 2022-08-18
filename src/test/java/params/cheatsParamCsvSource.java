package params;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
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
        Configuration.holdBrowserOpen = true;

        Selenide.open("https://gorzdrav.org/");
        $("#js-site-search-input").click();
        $("#js-site-search-input").setValue(testData).pressEnter();
        $(".b-bckgr--common").shouldHave(text(resultS));
    }
}