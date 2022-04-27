package test;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("selenide")
public class AndroidSelenideTests extends TestBase {

    @Test
    @DisplayName("My tests")
    void searchTest() {
        step("Enter the first term", () -> {
            // ru.anbn.testapplication
            // android:id="@+id/editText1
            $(MobileBy.id("ru.anbn.testapplication:id/editText1")).setValue("15");
        });

        step("Enter the second term", () -> {
            // ru.anbn.testapplication
            // android:id="@+id/editText2
            $(MobileBy.id("ru.anbn.testapplication:id/editText2")).setValue("3");
        });

        step("Click on the button", () -> {
            // ru.anbn.testapplication
            // android:id="@+id/button1
            $(MobileBy.id("ru.anbn.testapplication:id/button1")).click();
        });

        step("Check the result", () -> {
            // ru.anbn.testapplication
            // android:id="@+id/textView2
            $(MobileBy.id("ru.anbn.testapplication:id/textView2")).shouldHave(text("18"));
        });

    }

}
