package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.logevents.SelenideLogger.step;


public class AutomationPracticeFormTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();


    @Test
    @DisplayName("Регистрация клиента")
    void fillFormTest() {
        step("Открыть форму https://demoqa.com/automation-practice-form", () -> {
            registrationPage
                    .openPage()
                    .deleteBanner();
        });

        step("Заполнить поля на форме", () -> {
            registrationPage
                    .setFirstNameInput(testData.firstName)
                    .setLastNameInput(testData.lastName)
                    .setUserEmailInput(testData.userEmail)
                    .setGenderWrapperInput(testData.gender)
                    .setUserNumberInput(testData.userNumber)
                    .setDateOfBirt(testData.day, testData.month, testData.year)
                    .setSubjectsInput(testData.subject)
                    .setHobbies(testData.hobbies)
                    .setUploadPicture(testData.picture)
                    .setCurrentAddress(testData.address)
                    .setState(testData.state)
                    .setCity(testData.city);
        });

        step("Нажать кнопку Submit ", () -> {
            registrationPage
                    .clickSubmit()
                    .checkModalForm()
                    .checkModalFormTitle(testData.textForCheck);


        });

        step("Проверить результат заполнения формы ", () -> {
            registrationPage
                    .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                    .checkResult("Student Email", testData.userEmail)
                    .checkResult("Gender", testData.gender)
                    .checkResult("Mobile", testData.userNumber)
                    .checkResult("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
                    .checkResult("Subjects", testData.subject)
                    .checkResult("Hobbies", testData.hobbies)
                    .checkResult("Picture", testData.picture)
                    .checkResult("Address", testData.address)
                    .checkResult("State and City", testData.state + " " + testData.city);

        });


    }


    @Tag("registratin")
    @Story("Регистрация клиента")
    @Owner("Meschikowa")
    @Test
    @DisplayName("Регистрация клиента. Заполнены только обязательные поля")
    void fillFormTestMandatoryTest() {

        step("Открыть форму https://demoqa.com/automation-practice-form", () -> {
            registrationPage
                    .openPage()
                    .deleteBanner();
        });

        step("Заполнить обязельные поля на форме", () -> {
            registrationPage
                    .setFirstNameInput(testData.firstName)
                    .setLastNameInput(testData.lastName)
                    .setGenderWrapperInput(testData.gender)
                    .setUserNumberInput(testData.userNumber)
                    .setDateOfBirt(testData.day, testData.month, testData.year);
        });

        step("Нажать кнопку Submit ", () -> {
            registrationPage
                    .clickSubmit()
                    .checkModalForm()
                    .checkModalFormTitle(testData.textForCheck);

        });

        step("Проверить результат заполнения формы ", () -> {
            registrationPage
                    .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                    .checkResult("Gender", testData.gender)
                    .checkResult("Mobile", testData.userNumber)
                    .checkResult("Date of Birth", testData.day + " " + testData.month + "," + testData.year);


        });


    }

    @Test
    @DisplayName("Регистрация клиента. Не заполнено обязательное поле")
    void fillFormTestFailedTest() {
        step("Открыть форму https://demoqa.com/automation-practice-form", () -> {
            registrationPage
                    .openPage()
                    .deleteBanner();
        });

        step("Заполнить не все обязельные поля на форме", () -> {
            registrationPage
                    .setLastNameInput(testData.lastName)
                    .setGenderWrapperInput(testData.gender)
                    .setUserNumberInput(testData.userNumber);
        });

        step("Нажать кнопку Submit ", () -> {
            registrationPage
                    .clickSubmit()
                    .checkModalFormFail();

            Assertions.assertTrue(true);

        });


    }
}





