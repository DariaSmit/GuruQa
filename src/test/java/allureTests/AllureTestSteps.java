package allureTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class AllureTestSteps {
    private static final String Repository = "AnastasiyaIlkevich/Bot";
    private static final int IssueNumber = 1;

    @Owner("DariaSmit")
    @Severity(SeverityLevel.MINOR)
    @Feature("Тестинг c опциями Allure")
    @Story("Тестинг c опциями Allure")

    @Test
    public void TestingAllureSteps(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.holdBrowserOpen = true;

        step("Открыть главную страницу", () -> {
            open("https://github.com");
        });
        step("Найти реопзиторий " + Repository, () -> {
            $(".js-site-search-form").click();
            $(".header-search-input").setValue(Repository).pressEnter();
        });
        step("Перейти в " + Repository, ()->{
            $("em:nth-child(1)").click();
            Thread.sleep(1000);
        });
        step("Перейти в вкладку Issue", ()->{
            $("#issues-tab").click();
        });
        step("Проверить что существует Issue с номером" + IssueNumber, ()->{
            $(withText("#1")).click();
        });

    }

}
