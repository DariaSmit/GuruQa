package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class BoxText {
    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize ="1920x1080";

    }


    @Test
    void fillFormTest() {
        Selenide.open("/automation-practice-form");
// Пол мужской
        $("[id=firstName]") .setValue("Semen");
        $("[id=lastName]") .setValue("Semenov");
        $("[id=userEmail]") .setValue("semen@ae.ru");
        $("[id=userNumber]") .setValue("1234567891");
        $(byText("Male")).click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1990");
        $("[aria-label$='March 13th, 1990']").click();
        $("[id=subjectsInput]") .setValue("Physics") .pressEnter();
        $(byText("Sports")).click();
        $("[id=uploadPicture") .uploadFromClasspath("src/test/resources/2,13.png");
        $("[id=currentAddress]") .setValue("Moscow street 15");
        $("[id=stateCity-wrapper]") .click();
        $(byText("NCR")) .click();
        $("[id=city]") .click();
        $(byText("Noida")) .click();
        $("[id=submit]") .click();




    }

    @Test
    void assertTest1() {
    }
}


