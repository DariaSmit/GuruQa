package com.demoqaLessonTest;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
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

        Configuration.holdBrowserOpen = true;
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    @DisplayName("Testing the students registration form")
    void fillFormTest() {
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