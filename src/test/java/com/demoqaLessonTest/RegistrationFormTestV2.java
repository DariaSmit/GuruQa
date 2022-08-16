package com.demoqaLessonTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;


public class RegistrationFormTestV2 {
    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";

    }

    @Test
    void fillFormTest() {
       // CalendarComponent calendar = new CalendarComponent();
        // Testing the students registration form
       new RegistrationFormPage().openPage();

        Faker faker = new Faker();

        new RegistrationFormPage().setFirstName();
        new RegistrationFormPage().setLastName();
        new RegistrationFormPage().setUserEmail();
        new RegistrationFormPage().setPhone();
        new RegistrationFormPage().setGender();

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1990");
        $("[aria-label$='March 13th, 1990']").click();

        new RegistrationFormPage().setSubject();
        new RegistrationFormPage().setSub();
        new RegistrationFormPage().setUpload();
        new RegistrationFormPage().setAddress();
        new RegistrationFormPage().setSityState();
        new RegistrationFormPage().setSity();
        new RegistrationFormPage().setCityClick();
        new RegistrationFormPage().setCityClick2();
        new RegistrationFormPage().setSubmit();


        // Verification of actual results
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

    }

}