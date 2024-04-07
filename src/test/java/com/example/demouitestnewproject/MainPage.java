package com.example.demouitestnewproject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

//page_url = https://business.gett.com/auth
//page_url = https://www.jetbrains.com/
public class MainPage {
//    public SelenideElement seeDeveloperToolsButton = $x("//*[@data-test-marker='Developer Tools']");
//    public SelenideElement findYourToolsButton = $x("//*[@data-test='suggestion-action']");
//    public SelenideElement toolsMenu = $x("//div[@data-test='main-menu-item' and @data-test-marker = 'Developer Tools']");
//    public SelenideElement searchButton = $("[data-test='site-header-search-action']");

    // Homework
    public SelenideElement loginField = $x("//*[@data-name='emailLoginForm']");

    public SelenideElement nextButton = $x("//*[@data-name='loginNextButton']");
    public SelenideElement passwordField = $x("//*[@data-name='passwordLoginForm']");
    public SelenideElement signInButton = $x("//*[@data-name='loginButton']");
    public SelenideElement passwordErrorMessage = $x("//*[@data-name='passwordValidationError']");
    public SelenideElement invalidPasswordErrorMessage = $x("//*[@data-name='errorMessage']");
    public SelenideElement forgotPasswordLink = $x("//*[@data-name='forgotPasswordLink']");
    public SelenideElement continueButton = $x("//*[@data-name='forgotPasswordBtn']");
    public SelenideElement instructionSent = $x("//*[@data-name='successNotificationMessage']");
    public SelenideElement backToLoginButton = $x("//*[@data-name='backToLoginBtn']");
    public SelenideElement loginForm = $x("//*[@data-component='LogInForm']");



}
