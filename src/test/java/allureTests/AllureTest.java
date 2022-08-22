package allureTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.selector.ByText;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;

public class AllureTest {
    @Owner("DariaSmit")
    @Severity(SeverityLevel.MINOR)
    @Feature("Тестинг с опциями Allure")
    @Story("Тестинг c опциями Allure")

    @Test
    @DisplayName("тест с селенид GitHub")
    public void testGitHub() throws InterruptedException {
        Configuration.holdBrowserOpen = true;
        SelenideLogger.addListener("allure", new AllureSelenide());

        Selenide.open("https://github.com/");

        $(".js-site-search-form").click();
        $(".header-search-input").setValue("DariaSmit/GuruQa").pressEnter();
        $("em:nth-child(1)").click();
        Thread.sleep(1000);
        $(linkText("Issues")).click();
        $("h3:nth-child(2)").shouldHave(Condition.text("There aren’t any open issues."));


    }


}
