package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckResultComponent {

    SelenideElement output = $("#output");
    SelenideElement formResult = $(".table-responsive");

    public void checkResult(String key, String value) {
        formResult.$(byText(key)).parent().shouldHave(text(value));
    }

    public void checkOutput(String key, String value) {
        output.$(byText(key)).parent().shouldHave(text(value));
    }


}
