package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class BoxText {
    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";

    }

    @Test
    void fillFormTest() {
        Selenide.open("/automation-practice-form");
    // Testing the students registration form
        String Firstname = "Semen";
        String Lastname = "Semenov";
        String UserEmail = "semen@ae.ru";
        String Phone = "1234567891";
        String Gender = "Male";
        String Address = "Moscow street 15";
        String Picture = "OMG.png";

        $("#firstName").setValue(Firstname);
        $("#lastName").setValue(Lastname);
        $("#userEmail").setValue(UserEmail);
        $("#userNumber").setValue(Phone);
        $(byText(Gender)).click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1990");
        $("[aria-label$='March 13th, 1990']").click();
        $("#subjectsInput").setValue("Physics").pressEnter();
        $(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath(Picture);
        $("#currentAddress").setValue(Address);
        $("#stateCity-wrapper").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Noida")).click();
        $("#submit").click();

        // Verification of actual results
        $("[class=table-responsive").shouldHave(
                Condition.text(Firstname),
                Condition.text(Lastname),
                Condition.text(UserEmail),
                Condition.text(Phone),
                Condition.text(Address));
    }

}