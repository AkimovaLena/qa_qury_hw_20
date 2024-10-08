package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

public class WikiTests extends TestBase {

    @Test
    @Tag("android")
    @DisplayName("Checking the search")
    void successfulSearchTest() {
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Verify content found", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @Tag("android")
    @DisplayName("Checking Voice Search")
    void checkRecording() {

        step("Сlick on microphone", () -> {
            $(id("org.wikipedia.alpha:id/voice_search_button")).click();
        });
        step("Checking that the recording modal window is displayed", () -> {
           $(className("android.widget.FrameLayout")).shouldBe(visible);
        });
    }

    @Test
    @Tag("android")
    @DisplayName("Open found article")
    void successfulOpenArticleTest() {
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("search_src_text")).sendKeys("java");
        });
        step("Open found article", () -> $(id("page_list_item_title")).click());
        step("Verify article", () -> {
            $(className("android.widget.TextView")).shouldHave(text("Error"));
        });
    }


}