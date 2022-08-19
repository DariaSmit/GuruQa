package com.demoqaLessonTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

@DisplayName("Класс с тестом формы регистрации")
public class RegistrationFormPageObject {
    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            phone = faker.numerify("##########"),
            address = faker.address().fullAddress();

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();


    // строчка сверху должна находится в классе.
    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        Configuration.holdBrowserOpen = true;
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
    @Owner("DariaSmit")
    @Severity(SeverityLevel.MINOR)
    @Feature("Тестинг с PageObject и Faker")
    @Story("Тестинг формы регистрации PageObject")

    @Test
    @DisplayName("Testing the students registration form")
    void fillFormTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        // Testing the students registration form (Page Object)
        registrationFormPage.openPage()
                .setFirstName()
                .setLastName()
                .setUserEmail()
                .setPhone()
                .setGender()
                .setPsy()
                .setBirthDate("14", "January", "1984")
                .setSub()
                .setUpload()
                .setAddress()
                .setSityState()
                .setSity()
                .setCityClick()
                .setCityClick2()
                .setSubmit()
                .checkHeader("Student Name", firstName + " " + lastName)
                .checkHeader("Student Email", userEmail)
                .checkHeader("Gender", "Female")
                .checkHeader("Mobile", phone)
                .checkHeader("Date of Birth", "14 January,1984")
                .checkHeader("Subjects", "Arts")
                .checkHeader("Hobbies", "Music")
                .checkHeader("Picture", "khosiko5.jpg")
                .checkHeader("Address", address)
                .checkHeader("State and City", "NCR Delhi");


    }

}