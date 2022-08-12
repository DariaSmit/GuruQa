package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
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
//
        String Firstname = "Semen";
        String Lastname = "Semenov";
        String UserEmail = "semen@ae.ru";
        String Phone = "1234567891";
        String Gender = "Male";

        $("[id=firstName]") .setValue(Firstname);
        $("[id=lastName]") .setValue(Lastname);
        $("[id=userEmail]") .setValue(UserEmail);
        $("[id=userNumber]") .setValue(Phone);
        $(byText(Gender)).click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1990");
        $("[aria-label$='March 13th, 1990']").click();
        $("[id=subjectsInput]") .setValue("Physics") .pressEnter();
        $(byText("Sports")).click();
        $("[id=uploadPicture") .uploadFromClasspath("OMG.png");
        $("[id=currentAddress]") .setValue("Moscow street 15");
        $("[id=stateCity-wrapper]") .click();
        $(byText("NCR")) .click();
        $("[id=city]") .click();
        $(byText("Noida")) .click();
        $("[id=submit]") .click();

        //Проверка фактических результатов
       $("[class=table-responsive").shouldHave(
                Condition.text(Firstname),
                Condition.text(Lastname),
                Condition.text(UserEmail),
                Condition.text(Phone));
    }



    @Test
    void assertTest1() {
    }
}


