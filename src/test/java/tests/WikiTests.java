package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

public class WikiTests extends TestBase {

    @Test
    @Tag("allDevice")
    @DisplayName("Checking the search")
    void successfulSearchTest() {
        back();
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Verify content found", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @Tag("allDevice")
    @DisplayName("Checking Voice Search")
    void checkRecording() {
        back();
        step("Сlick on microphone", () -> {
            $(id("org.wikipedia.alpha:id/voice_search_button")).click();
        });
        step("Checking that the recording modal window is displayed", () -> {
            $(className("android.widget.FrameLayout")).shouldBe(visible);
        });
    }

    @Test
    @Tag("allDevice")
    @DisplayName("Checking Onboarding View")
    void chekOnboardingViewTest() {
        step("Check that the first onboarding page contains a title \"The Free Encyclopedia\"", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldBe(visible);
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("The Free Encyclopedia\n…in over 300 languages"));
        });
        step("Move to the next onboarding page", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Check that the second onboarding page contains a title \"New ways to explore\"", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("New ways to explore"));
        });
        step("Move to the next onboarding page", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Check that the third onboarding page contains a title \"Reading lists with sync\"", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Reading lists with sync"));
        });
        step("Move to the next onboarding page", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Check that the fourth onboarding page contains a title \"Data & Privacy\"", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Data & Privacy"));
        });
        step("Checking for the presence of a button \"Get started\"", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).
                    shouldHave(text("Get started"));
        });
        step("Transition to the beginning of the page", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).click();
        });
        step("Checking that the main page of the wiki has opened", () -> {
            $(id("org.wikipedia.alpha:id/main_toolbar_wordmark")).shouldBe(visible);
        });

    }


}