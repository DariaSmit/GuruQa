package lession9;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomeWorkDragDrop {

    @Test
    public void DD() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        WebDriverRunner.getWebDriver().manage().window().setSize(new Dimension(1027, 513));
        $("#column-b").dragAndDropTo("#column-a");
    }
}