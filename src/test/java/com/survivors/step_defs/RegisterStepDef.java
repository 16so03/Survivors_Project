package com.survivors.step_defs;

import com.survivors.pages.RegisterPage;
import com.survivors.utilities.ConfigurationReader;
import com.survivors.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class RegisterStepDef {
    RegisterPage page=new RegisterPage();
    @Given("the user is on the registration page")
    public void the_user_is_on_the_registration_page() {
        Driver.get().get(ConfigurationReader.getProperty("registerURL"));
    }
    @When("the user enters valid details")
    public void the_user_enters_valid_details(Map<String,String> dataTable) {
        System.out.println(dataTable);
       page.register(dataTable.get("FirstName"), dataTable.get("LastName"),dataTable.get("Email"), dataTable.get("Password"));
    }
    @When("clicks the {string} button")
    public void clicks_the_button(String string) {
       page.registerButton.click();
    }

    @Then("the user should see a success message {string}")
    public void theUserShouldSeeASuccessMessage(String successMessage) {
        String expected=page.successMessage.getText();
        Assert.assertEquals(expected,successMessage);
    }
}
