package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CheckResultComponent;
import tests.TestBase;

import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage extends TestBase {

    CheckResultComponent checkResultComponent = new CheckResultComponent();


    //SelenideElement

    SelenideElement
            fullNameInput = $("#userName"),
            emailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            buttonSubmit = $("#submit");


    //Actions


    public TextBoxPage openPage() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPage setFullNameInput(String value) {
        fullNameInput.setValue(value);
        return this;
    }

    public TextBoxPage setEmailInput(String value) {
        emailInput.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddressInput(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddressInput(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage clickButtonSubmit() {
        buttonSubmit.click();
        return this;
    }

    public TextBoxPage checkResult(String key, String value) {
        checkResultComponent.checkOutput(key, value);
        return this;
    }


}
