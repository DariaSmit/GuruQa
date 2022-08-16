package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationFormPage {
  //  private final CalendarComponent calendar = new CalendarComponent();
    //SelenideElement setDate = $("#dateOfBirthInput");
    private SelenideElement
          subjectInput = $("#subjectsInput");

    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            phone = "1234567891",
            gender = "Male",
            address = "Moscow street 15",
            subject = "Art",
            picture = "OMG.png";

    public RegistrationFormPage openPage() {
        Selenide.open("/automation-practice-form");
        return this;
    }

    public void setFirstName() {
        $("#firstName").setValue(firstName);

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

    public RegistrationFormPage setSubjects(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }
    public RegistrationFormPage setSub(){
        $(byText("Sports")).click();
        return this;
    }
    public RegistrationFormPage setUpload(){
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
    public RegistrationFormPage setSubmit()
    { $("#submit").click();
    return this;
    }

    public void setSubject() {
        this.subject = subject;
    }
}
