package com.survivors.step_defs;

import com.survivors.pages.LumuHomePage;
import com.survivors.utilities.BrowserUtils;
import com.survivors.utilities.ConfigurationReader;
import com.survivors.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class HomePageStepDef {
    LumuHomePage homepage = new LumuHomePage();

    @Given("User is on the homepage")
    public void user_is_on_the_homepage() {
        Driver.get().get(ConfigurationReader.getProperty("url"));
    }

    @When("User clicks on the first item in the catalog")
    public void user_clicks_on_the_first_item_in_the_catalog() {
        BrowserUtils.scrollToElement(homepage.hotSellersTitle);
        WebElement firstItem = homepage.products.get(0);
        firstItem.click();
    }

    @When("User selects size {string}")
    public void user_selects_size(String size) {
        homepage.selectSize(size).click();
    }

    @When("User selects color {string}")
    public void user_selects_color(String color) {
        homepage.selectColor(color).click();
    }

    @When("User sets quantity to {string}")
    public void user_sets_quantity_to(String quantity) {
        homepage.setQuantity(quantity);
    }

    @When("User clicks on {string}")
    public void user_clicks_on(String buttonName) {
        homepage.addToCartButton.click();
    }

    @Then("User opens the cart")
    public void user_opens_the_cart() {
        BrowserUtils.waitForPageToLoad(3);
       homepage.cartLink.click();
    }

    @Then("The cart should contain the item with size {string}, color {string}, andquantity {string}")
    public void the_cart_should_contain_the_item_with_size_color_andquantity(String size, String color, String quantity) {
        Assert.assertEquals(homepage.productOptions().get("Size"), size);
        Assert.assertEquals(homepage.productOptions().get("Color"), color);
        Assert.assertEquals(homepage.productOptions().get("Quantity"), quantity);
    }

    @Then("User see the first item name in success message")
    public void userSeeTheFirstItemNameInSuccessMessage() {
        String productName = homepage.productName.getText();
        System.out.println(productName);
        String successMessage = homepage.successMessage.getText();
        System.out.println(successMessage);
        Assert.assertTrue(successMessage.contains(productName));
    }
}
