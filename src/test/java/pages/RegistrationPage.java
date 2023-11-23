package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.CheckResultComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {


    CalendarComponent calendar = new CalendarComponent();

    CheckResultComponent checkResultComponent = new CheckResultComponent();

    //SelenideElement
    SelenideElement

            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapperInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbies = $("#hobbiesWrapper"),
            uploadPicture = $("input[type=file]"),
            currentAddress = $("#currentAddress"),
            state = $("#state"),
            stateCity = $("#stateCity-wrapper"),
            city = $("#city"),
            submit = $("#submit"),
            modalForm = $(".modal-dialog"),
            modalFormTitle = $("#example-modal-sizes-title-lg");


    //Actions



    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }


    public RegistrationPage deleteBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }


    public RegistrationPage setFirstNameInput(String value) {
        firstNameInput.setValue(value);

        return this;
    }


    public RegistrationPage setLastNameInput(String value) {
        lastNameInput.setValue(value);
        return this;

    }


    public RegistrationPage setUserEmailInput(String value) {
        userEmailInput.setValue(value);
        return this;

    }


    public RegistrationPage setGenderWrapperInput(String value) {
        genderWrapperInput.$(byText(value)).click();
        return this;

    }


    public RegistrationPage setUserNumberInput(String value) {
        userNumberInput.setValue(value);
        return this;

    }


    public RegistrationPage setDateOfBirt(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);
        return this;

    }


    public RegistrationPage setSubjectsInput(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }


    public RegistrationPage setHobbies(String value) {
        hobbies.$(byText(value)).click();
        return this;
    }


    public RegistrationPage setUploadPicture(String value) {
        if (!browser.equals("firefox")) {
            uploadPicture.uploadFromClasspath(value);
        }
        return this;
    }


    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }


    public RegistrationPage setState(String value) {
        state.click();
        stateCity.$(byText(value)).click();
        return this;
    }


    public RegistrationPage setCity(String value) {
        city.click();
        stateCity.$(byText(value)).click();
        return this;
    }


    public RegistrationPage clickSubmit() {
        submit.click();
        return this;
    }


    public RegistrationPage checkModalForm() {
        modalForm.should(appear);
        return this;
    }


    public RegistrationPage checkModalFormFail() {
        modalForm.shouldNot(appear);
        return this;
    }

    @Step("Открыть страницу")
    public RegistrationPage checkModalFormTitle(String value) {

        modalFormTitle.shouldHave(text(value));
        return this;
    }



    public RegistrationPage checkResult(String key, String value) {
        if (!(browser.equals("firefox") && key.equals("Picture"))) {
            checkResultComponent.checkResult(key, value);
        }
        return this;
    }


}
