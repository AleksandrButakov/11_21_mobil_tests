package test;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import test.TestBase;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("selenide")
public class AndroidSelenideTests extends TestBase {
    /*
       Тест находящийся в классе AndroidSampleTests написанный на Selenium перепишем на Selenoid
     */
    @Test
    @DisplayName("My tests")
    void searchTest() {

        /*
        step("Type search", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("BrowserStack");
        });
        step("Verify content found", () -> {
            $$(byClassName("android.widget.TextView")).shouldHave(sizeGreaterThan(0));
        });
         */

        step("Checking the opening of the main page", () -> {
            $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
                    "android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/" +
                    "android.view.ViewGroup/android.widget.TextView")).shouldHave(text("Распиновка разъемов"));
        });

        step("Pressing the button without the selected parameters", () -> {
            $(MobileBy.id("com.anbn.pinout:id/button1")).click();
            $(MobileBy.id("com.anbn.pinout:id/textView1")).shouldHave(text("Выберите интересующий тип"));
        });




        step("Checking Main menu, Search", () -> {
            $(MobileBy.xpath("//android.widget.ImageView[@content-desc=\"Ещё\"]")).click();
            
            $$(MobileBy.id("com.anbn.pinout:id/title")).findBy(text("Строка")).click();
            $(MobileBy.id("com.anbn.pinout:id/textView1")).shouldHave(text("Для поиска необходимого оборудо"));
            $(MobileBy.id("android:id/search_button")).click();
        });

        step("Search 'SMK-30 MUX'", () -> {
            $(MobileBy.id("android:id/search_src_text")).setValue("СМК-30");
            $$(MobileBy.id("android:id/text1")).findBy(text("СМК-30 (MUX)")).click();
            $(MobileBy.id("com.anbn.pinout:id/textView")).shouldHave(text("СМК-30 (MUX)"));
            $(MobileBy.id("com.anbn.pinout:id/button1")).click();
        });

        step("Search 'CMA'", () -> {
            $(MobileBy.id("android:id/search_src_text")).setValue("СМА");
            $$(MobileBy.id("android:id/text1")).findBy(text("СМА-2-4")).click();
            $(MobileBy.id("com.anbn.pinout:id/textView")).shouldHave(text("СМА-2-4"));
            $(MobileBy.id("com.anbn.pinout:id/button1")).click();
        });

        step("Search 'MDK'", () -> {
            $(MobileBy.id("android:id/search_src_text")).setValue("МДК");
            $$(MobileBy.id("android:id/text1")).findBy(text("МДК-М1")).click();
            $(MobileBy.id("com.anbn.pinout:id/textView")).shouldHave(text("МДК-М1"));
            $(MobileBy.id("com.anbn.pinout:id/button1")).click();
        });

        step("Search 'ASR-920'", () -> {
            $(MobileBy.id("android:id/search_src_text")).setValue("ASR-920");
            $$(MobileBy.id("android:id/text1")).findBy(text("ASR-920")).click();
            $(MobileBy.id("com.anbn.pinout:id/textView")).shouldHave(text("ASR-920"));
            $(MobileBy.id("com.anbn.pinout:id/button1")).click();
            $(MobileBy.id("com.anbn.pinout:id/button")).click();
        });

        step("Checking Main menu, About", () -> {
            $(MobileBy.xpath("//android.widget.ImageView[@content-desc=\"Ещё\"]")).click();
            $$(MobileBy.id("com.anbn.pinout:id/title")).findBy(text("О программе")).click();
            $(MobileBy.id("com.anbn.pinout:id/textView3")).shouldHave(text("О ПРОГРАММЕ"));
            $(MobileBy.id("com.anbn.pinout:id/button1")).click();
            $(MobileBy.id("com.anbn.pinout:id/textView1")).shouldHave(text("Выберите интересующий тип"));
        });


        step("Manual selection of equipment Cisco", () -> {
            $(MobileBy.id("com.anbn.pinout:id/spinner1")).click();
            $$(MobileBy.id("android:id/text1")).findBy(text("Оборудование Cisco, ВСТСПД")).click();
            $(MobileBy.id("com.anbn.pinout:id/spinner2")).click();
            $$(MobileBy.id("android:id/text1")).findBy(text("RJ-45 connector Ethernet")).click();
            $(MobileBy.id("com.anbn.pinout:id/button1")).click();
            $(MobileBy.id("com.anbn.pinout:id/textView")).shouldHave(text("RJ-45 connector Ethernet"));
            $(MobileBy.id("com.anbn.pinout:id/button1")).click();
        });

        step("Manual selection of equipment VSTSPD", () -> {
            $(MobileBy.id("com.anbn.pinout:id/spinner1")).click();
            $$(MobileBy.id("android:id/text1")).findBy(text("Оборудование Cisco, ВСТСПД")).click();
            $(MobileBy.id("com.anbn.pinout:id/spinner2")).click();
            $$(MobileBy.id("android:id/text1")).findBy(text("Оборудование ВСТСПД")).click();
            $(MobileBy.id("com.anbn.pinout:id/button1")).click();
            $(MobileBy.id("com.anbn.pinout:id/textView")).shouldHave(text("Оборудование ВСТСПД"));
            $(MobileBy.id("com.anbn.pinout:id/button1")).click();
        });

    }

}
