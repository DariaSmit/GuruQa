package lession9;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;

public class HomeWork {



    @Test
    void TestHomeWork () {

        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.holdBrowserOpen = true;

        Selenide.open("https://github.com/");
        $(".js-site-search-form").click();
        $(".header-search-input").setValue("Selenide").pressEnter();
        $(".repo-list", 0).find(By.linkText("selenide/selenide")).click();
        $("#wiki-tab").click();
        $(".markdown-body").shouldHave(text("Soft assertions"));
        $(byLinkText("Soft assertions")).click();
        $(".markdown-body").shouldHave(text("void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n"));
    }
}
