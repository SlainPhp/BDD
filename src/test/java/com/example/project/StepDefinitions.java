package com.example.project;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class StepDefinitions {

    private String currentLogin;
    private String currentPassword;
    private String displayedName;
    private String errorMessage;
    private boolean isLoggedIn = false;

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        System.out.println("-> Opening login page...");
        isLoggedIn = false;
        errorMessage = null;
    }

    @Given("the Login field is cleared")
    public void theLoginFieldIsCleared() {
        currentLogin = null;
        System.out.println("-> Login field cleared");
    }

    @Given("the Password field is cleared")
    public void thePasswordFieldIsCleared() {
        currentPassword = null;
        System.out.println("-> Password field cleared");
    }

    @Given("the user enters login {string}")
    public void theUserEntersLogin(String login) {
        currentLogin = login;
        System.out.println("-> Entered login: " + login);
    }

    @Given("the user enters password {string}")
    public void theUserEntersPassword(String password) {
        currentPassword = password;
        System.out.println("-> Entered password: " + password);
    }

    @When("the user clicks the {string} button")
    public void theUserClicksTheButton(String buttonText) {
        System.out.println("-> Clicking button: " + buttonText);

        // TODO: здесь позже можно вставить реальную логику через Selenium/WebDriver
        if ("user1".equals(currentLogin) && "pass1".equals(currentPassword)) {
            isLoggedIn = true;
            displayedName = "User One";
            errorMessage = null;
        } else if ("user2".equals(currentLogin) && "pass2".equals(currentPassword)) {
            isLoggedIn = true;
            displayedName = "User Two";
            errorMessage = null;
        } else {
            isLoggedIn = false;
            errorMessage = "Неверный логин или пароль";
        }
    }


    @Then("the system should redirect to the main page")
    public void theSystemShouldRedirectToTheMainPage() {
        System.out.println("-> Redirected to main page (success)");
        Assertions.assertEquals(true, isLoggedIn, "Expected successful login and redirect, but login failed");
    }

    @Then("the profile header should display name {string}")
    public void theProfileHeaderShouldDisplayName(String expectedName) {
        System.out.println("-> Profile name matches: " + displayedName);
        Assertions.assertEquals(expectedName, displayedName,
                "Expected name: " + expectedName + ", but displayed: " + displayedName);
    }

    @Then("an error message {string} should appear")
    public void anErrorMessageShouldAppear(String expectedError) {
        System.out.println("-> Error message matches: " + errorMessage);
        Assertions.assertEquals(expectedError, errorMessage,
                "Expected error: " + expectedError + ", but got: " + errorMessage);
    }
}
