package com.example.demouitestnewproject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {
    MainPage mainPage = new MainPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setup(){
        //Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://business.gett.com/auth");
    }
    @Test
    public void loginWithEmptyEmailField() {

        mainPage.loginField.sendKeys("");

        //mainPage.nextButton.click();

        mainPage.nextButton.shouldBe(Condition.disabled);
    }
    @Test
    public void loginWithInvalidEmail() {

        mainPage.loginField.sendKeys("aaa@mail.com");
        mainPage.nextButton.click();

        //$("passwordField").shouldBe(visible);
        mainPage.passwordField.shouldBe(Condition.visible);
    }

    @Test
    public void loginWithEmptyPasswordValueCheckErrorMessage() {

        mainPage.loginField.sendKeys("aaa@mail.com");
        mainPage.nextButton.click();
        mainPage.passwordField.sendKeys("");
        mainPage.signInButton.click();
        mainPage.passwordErrorMessage.shouldBe(Condition.visible);
        mainPage.passwordErrorMessage.shouldBe(Condition.matchText("Please enter your password"));
    }

    @Test
    public void loginWithInvalidPasswordValueCheckErrorMessage() {

        mainPage.loginField.sendKeys("aaa@mail.com");
        mainPage.nextButton.click();
        mainPage.passwordField.sendKeys("11");
        mainPage.signInButton.click();
        mainPage.invalidPasswordErrorMessage.shouldBe(Condition.visible);
        mainPage.invalidPasswordErrorMessage.shouldBe(Condition.matchText("We didn't recognise your email or password"));
    }

    @Test
    public void resetPassword() {

        mainPage.loginField.sendKeys("aaa@mail.com");
        mainPage.nextButton.click();
        mainPage.forgotPasswordLink.click();
        mainPage.continueButton.click();
        mainPage.instructionSent.shouldBe(Condition.visible);
        mainPage.instructionSent.shouldBe(Condition.matchText("We sent an email with further instructions to aaa@mail.com if it exists in our database"));

    }

    @Test
    public void backToLoginPageAfterResetPassword() {

        mainPage.loginField.sendKeys("aaa@mail.com");
        mainPage.nextButton.click();
        mainPage.forgotPasswordLink.click();
        mainPage.continueButton.click();
        mainPage.backToLoginButton.click();
        mainPage.loginForm.shouldBe(Condition.visible);

    }


// LEFT AS EXAMPLE

//    @BeforeAll
//    public static void setUpAll() {
//        Configuration.browserSize = "1280x800";
//        SelenideLogger.addListener("allure", new AllureSelenide());
//    }
//
//    @BeforeEach
//    public void setUp() {
//        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
//        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
//        open("https://www.jetbrains.com/");
//    }
//
//    @Test
//    public void search() {
//        mainPage.searchButton.click();
//
//        $("[data-test='search-input']").sendKeys("Selenium");
//        $("button[data-test='full-search-button']").click();
//
//        $("input[data-test='search-input']").shouldHave(attribute("value", "Selenium"));
//    }
//
//    @Test
//    public void toolsMenu() {
//        mainPage.toolsMenu.click();
//
//        $("div[data-test='main-submenu']").shouldBe(visible);
//    }
//
//    @Test
//    public void navigationToAllTools() {
//        mainPage.seeDeveloperToolsButton.click();
//        mainPage.findYourToolsButton.click();
//
//        $("#products-page").shouldBe(visible);
//
//        assertEquals("All Developer Tools and Products by JetBrains", Selenide.title());
//    }
}
