package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationFormPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    private final SelenideElement
    headerCheck = $("#example-modal-sizes-title-lg");

    private static final String TEG_CHECK = "Thanks for submitting the form";

    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            phone =  faker.numerify("##########"),
            gender = "Male",
            address = faker.address().fullAddress(),
            picture = "OMG.png";


    public RegistrationFormPage openPage() {
        Selenide.open("/automation-practice-form");
        return this;
    }

    public RegistrationFormPage setFirstName() {
        $("#firstName").setValue(firstName);
        return this;

    }

    public RegistrationFormPage setLastName() {
        $("#lastName").setValue(lastName);
        return this;
    }

    public RegistrationFormPage setUserEmail() {
        $("#userEmail").setValue(userEmail);
        return this;
    }

    public RegistrationFormPage setPhone() {
        $("#userNumber").setValue(phone);
        return this;
    }

    public RegistrationFormPage setGender() {
        $(byText(gender)).click();
        return this;
    }

    public RegistrationFormPage setPsy() {
        $("#subjectsInput").setValue("Physics").pressEnter();
        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }


    public RegistrationFormPage setSub() {
        $(byText("Sports")).click();
        return this;
    }

    public RegistrationFormPage setUpload() {
        $("#uploadPicture").uploadFromClasspath(picture);
        return this;
    }

    public RegistrationFormPage setAddress() {
        $("#currentAddress").setValue(address);
        return this;
    }

    public RegistrationFormPage setSityState() {
        $("#stateCity-wrapper").click();
        return this;
    }

    public RegistrationFormPage setSity() {
        $(byText("NCR")).click();
        return this;
    }

    public RegistrationFormPage setCityClick() {
        $("#city").click();
        return this;
    }

    public RegistrationFormPage setCityClick2() {
        $(byText("Noida")).click();
        return this;
    }

    public RegistrationFormPage setSubmit() {
        $("#submit").click();
        return this;
    }

    public RegistrationFormPage checkHeader(String result, String s) {
        $("#example-modal-sizes-title-lg").shouldHave(text(TEG_CHECK));
        return this;
    }

    }


