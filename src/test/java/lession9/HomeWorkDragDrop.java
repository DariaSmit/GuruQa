package lession9;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class HomeWorkDragDrop {

    @Test
    public void hu() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        WebDriverRunner.getWebDriver().manage().window().setSize(new Dimension(1027, 513));
        $("#column-b").dragAndDropTo("#column-a");
    }
}