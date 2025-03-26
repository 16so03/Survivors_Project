package com.survivors.step_defs;

import com.survivors.pages.MagentoPage;
import com.survivors.utilities.ConfigurationReader;
import com.survivors.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class Magento_StepDef {
    MagentoPage magento = new MagentoPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.get();
    String FirstItem_name = "";
    Actions actions = new Actions(Driver.get());

    @Given("User is on the {string}")
    public void userIsOnThe(String s) {
        Driver.get().get(ConfigurationReader.getProperty(s));
    }

    @When("User clicks on the first item in the catalog")
    public void user_clicks_on_the_first_item_in_the_catalog() {
        FirstItem_name = magento.FirstProductTogetName.getText();
        magento.FirstProductItem.click();

        System.out.println("First Item is: " + FirstItem_name);
    }

    @When("User selects size {string}")
    public void user_selects_size(String s) {

        Driver.get().findElement(By.xpath("//div[@option-tooltip-value='" + s + "']")).click();
    }

    @When("User selects color {string}")
    public void user_selects_color(String s) {
        Driver.get().findElement(By.xpath("//div[@option-label='" + s + "']")).click();
    }

    @When("User sets quantity to {string}")
    public void user_sets_quantity_to(String s) {
        WebElement quantity = Driver.get().findElement(By.xpath("//input[@name='qty']"));
        if (s.equals(1)) {
            System.out.println("Default");
        } else {
            quantity.clear();
            quantity.sendKeys(s);
        }
    }

    @And("User clicks on Add to Cart")
    public void userClicksOnAddToCart() {
        magento.AddToCartButton.click();
    }

    @Then("User opens the cart")
    public void user_opens_the_cart() {
        //  WebElement EmptyCart = Driver.get().findElement(By.xpath("//span[@class='counter qty empty']"));
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        magento.goToCartButton.click();
    }

    @Then("The cart should contain the item with size {string}, color {string}, and quantity {string}")
    public void the_cart_should_contain_the_item_with_size_color_and_quantity(String exp_size, String exp_color, String exp_quantity) {
        WebElement act_name = Driver.get().findElement(By.xpath("(//tbody[@class='cart item']//a)[2]"));
        Assert.assertEquals(FirstItem_name, act_name.getText());

        WebElement act_size = Driver.get().findElement(By.xpath("(//tbody[@class='cart item']//dd)[1]"));
        Assert.assertEquals(exp_size, act_size.getText());

        WebElement act_color = Driver.get().findElement(By.xpath("(//tbody[@class='cart item']//dd)[2]"));
        Assert.assertEquals(exp_color, act_color.getText());

        WebElement act_quantity = Driver.get().findElement(By.xpath("//input[@title='Qty']"));
        Assert.assertEquals(exp_quantity, act_quantity.getAttribute("value"));

        Driver.closeDriver();
    }

    //=-=-=-=-Test Case 2-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=--=
    @When("User scrolls down to the review section")
    public void user_scrolls_down_to_the_review_section() {
        js.executeScript("arguments[0].scrollIntoView(true);", magento.reviewsBox);
    }

    @When("User clicks on {string}")
    public void user_clicks_on(String string) {
        switch (string) {
            case "Add Your Review":
                magento.reviewsBox.click();
                js.executeScript("arguments[0].scrollIntoView(true);", magento.YourRating);
        }
    }

    @When("User fills out the review form with:")
    public void user_fills_out_the_review_form_with(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : data) {
            String key = row.get("Field");
            String value = row.get("Value");

            if (key.equals("Rating")) {
                magento.rating(row.get("Value"));
            }
            if (key.equals("nickname")) {
                magento.nicknameInput(row.get("Value"));
            }
            if (key.equals("Summary")) {
                magento.summaryInput(row.get("Value"));
            }
            if (key.equals("Review")) {
                magento.reviewInput(row.get("Value"));
            }
        }


    }

    @When("User submits the review")
    public void user_submits_the_review() {
        magento.SubmitReviewButton.click();
    }

    @Then("A confirmation message should be displayed")
    public void a_confirmation_message_should_be_displayed() {
        Assert.assertTrue(magento.ReviewSubmitMessage.isDisplayed());
    }

//=-=-=-=-=- TC 3 -=-=-=-=-=-=-=-=-=
    @When("User navigates to {string} -{string} -{string}")
    public void userNavigatesTo(String feature, String feature2, String feature3) {
       if (feature.equals("Women")) {
            actions.moveToElement(Driver.get().findElement(By.xpath("//a[.='" + feature + "']")))
                    .moveToElement(Driver.get().findElement(By.xpath("//ul//li[@role='presentation']//span[.='" + feature2 + "']")))
                    .moveToElement(Driver.get().findElement(By.xpath("(//ul//li//span[.='" + feature3 + "'])[1]"))).click().perform();
        } else if (feature.equals("Men")) {
           actions.moveToElement(Driver.get().findElement(By.xpath("//a[.='" + feature + "']")))
                   .moveToElement(Driver.get().findElement(By.xpath("(//ul//li[@role='presentation']//span[.='" + feature2 + "'])[2]")))
                   .moveToElement(Driver.get().findElement(By.xpath("(//ul//li//span[.='" + feature3 + "'])[2]"))).click().perform();


       }
    }

    @Then("User should see exactly {string} items displayed on the page")
    public void userShouldSeeExactlyItemsDisplayedOnThePage(String num) {
        List <WebElement> ItemsonPage=Driver.get().findElements(By.xpath("//li[@class='item product product-item']"));
        int count= 0;
        for (WebElement item : ItemsonPage) {
            count++;
        }
        Assert.assertEquals(num, Integer.toString(count));
    }

    @And("User scrolls to the bottom of the page")
    public void userScrollsToTheBottomOfThePage() {
        List <WebElement> ItemsonPage=Driver.get().findElements(By.xpath("//li[@class='item product product-item']"));
js.executeScript("arguments[0].scrollIntoView(true);", ItemsonPage.get(ItemsonPage.size()-1));
    }

    @Then("User captures the name of the last item displayed")
    public void userCapturesTheNameOfTheLastItemDisplayed() {
        List <WebElement> ItemsonPage=Driver.get().findElements(By.xpath("//li[@class='item product product-item']"));
        System.out.println(ItemsonPage.get(ItemsonPage.size()-1).getText());
    }
}
