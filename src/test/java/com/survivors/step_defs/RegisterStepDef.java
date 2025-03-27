package com.survivors.step_defs;

import com.survivors.pages.RegisterPage;
import com.survivors.utilities.BrowserUtils;
import com.survivors.utilities.ConfigurationReader;
import com.survivors.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class RegisterStepDef {
    RegisterPage page = new RegisterPage();
    static Map<String, String> registerData;
    static String reusedEmail;


    @Given("the user is on the registration page")
    public void the_user_is_on_the_registration_page() {
        Driver.get().get(ConfigurationReader.getProperty("registerURL"));
    }

    @When("the user enters valid details")
    public void the_user_enters_valid_details() {
        registerData = RegisterPage.generateRandomUser();
        reusedEmail = registerData.get("Email");
        System.out.println(registerData);
        page.register(registerData.get("FirstName"), registerData.get("LastName"), registerData.get("Email"), registerData.get("Password"));
    }

    @Then("the user should see a success message {string}")
    public void theUserShouldSeeASuccessMessage(String successMessage) {
        String expected = page.successMessage.getText();
        Assert.assertEquals(expected, successMessage);
    }

    @When("the user enters an email that is already in use")
    public void theUserEntersAnEmailThatIsAlreadyInUse() {
        BrowserUtils.waitFor(3);
        page.register("John", "Smith",reusedEmail,"9b!c8A354e");
    }

    @Then("the user should see an error message {string}")
    public void theUserShouldSeeAnErrorMessage(String errorMessage) {
        String expected = page.errorMessage.getText();
        System.out.println(expected);
        Assert.assertTrue(expected.contains(errorMessage));
    }

    @And("clicks the Register button")
    public void clicksTheRegisterButton() {
        page.registerButton.click();
    }


}
