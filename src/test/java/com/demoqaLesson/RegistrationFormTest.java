package com.demoqaLesson;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class RegistrationFormTest {
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
        Faker faker = new Faker();
        String firstName = faker.name().firstName(),
                lastName = faker.name().firstName(),
                userEmail = faker.internet().emailAddress(),
                phone = "1234567891",
                gender = "Male",
                address = "Moscow street 15",
                picture = "OMG.png";


        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#userNumber").setValue(phone);
        $(byText(gender)).click();

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1990");
        $("[aria-label$='March 13th, 1990']").click();

        $("#subjectsInput").setValue("Physics").pressEnter();
        $(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath(picture);
        $("#currentAddress").setValue(address);
        $("#stateCity-wrapper").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Noida")).click();
        $("#submit").click();

        // Verification of actual results
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text(firstName),
                text(lastName),
                text(userEmail),
                text(phone),
                text(address));
    }

}