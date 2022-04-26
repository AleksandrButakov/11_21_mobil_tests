package test;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import test.TestBase;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
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

        step("Type search", () -> {
            /*  на Selenium:
                AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                        ExpectedConditions.elementToBeClickable(
                                MobileBy.AccessibilityId("Search Wikipedia")));
                searchElement.click();
             */
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();

            /*  на Selenium:
                AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                        ExpectedConditions.elementToBeClickable(
                                MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
                insertTextElement.sendKeys("BrowserStack");
             */
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("BrowserStack");
        });

        step("Verify content found", () -> {

            /*  на Selenium:
            Thread.sleep(5000);
            List<AndroidElement> allProductsName = driver.findElementsByClassName(
                    "android.widget.TextView");
            assert (allProductsName.size() > 0);
             */
            $$(byClassName("android.widget.TextView")).shouldHave(sizeGreaterThan(0));
        });

    }

}
