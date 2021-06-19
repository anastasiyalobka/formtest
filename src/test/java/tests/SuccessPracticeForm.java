package tests;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SuccessPracticeForm {
    @Test
    void successfullPracticeForm(){
        open("https://demoqa.com/automation-practice-form");

        $("[id=firstName]").setValue("Иван");
        $("[id=lastName]").setValue("Иванов");
        $("[id=userEmail]").setValue("ivanov@mail.er");
        $(byText("Female")).click();
        $("[id=userNumber]").setValue("1234567890");
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOptionByValue("1990");
        $(".react-datepicker__month-select").selectOptionByValue("4");
        $("#subjectsInput").setValue("English").pressEnter();
        $(".react-datepicker__day", 4).click();
        $(byText("Sports")).click();
        $("input#uploadPicture").uploadFile(new File("/Users/anastasiya/Desktop/file.rtf"));
        $("#currentAddress").setValue("Минск, Независимости проспект");
        $("#react-select-3-input").setValue("Uttar Pradesh").pressEnter();
        $("#react-select-4-input").setValue("Agra").pressEnter();
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Иван Иванов"), text("ivanov@mail.er"),text("1234567890"),
                text("English"), text("Минск, Независимости проспект"),text("file.rtf"),
                text("Uttar Pradesh Agra"),text("03 May,1990"),text("Female"),text("Sports"));

    }
}

