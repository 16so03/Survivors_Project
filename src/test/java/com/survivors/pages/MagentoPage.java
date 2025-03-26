package com.survivors.pages;

import com.survivors.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MagentoPage {
    public MagentoPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    JavascriptExecutor js= (JavascriptExecutor) Driver.get();

    @FindBy(xpath = "//li[@class='product-item'][1]")
    public WebElement FirstProductItem;

    @FindBy(xpath = "//li[@class='product-item'][1]//a[@title]")
    public WebElement FirstProductTogetName;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    public WebElement AddToCartButton;

    @FindBy(xpath = "(//a[@href='https://magento.softwaretestingboard.com/checkout/cart/'])[3]")
    public WebElement goToCartButton;

    @FindBy(xpath = "//div[@aria-controls='reviews']")
    public WebElement reviewsBox;

    @FindBy(xpath = "(//div[@class='control review-control-vote']//input)[5]")
    public WebElement fiveStar;

    @FindBy(xpath = "(//div[@class='control review-control-vote']//input)[4]")
    public WebElement fourStar;

    @FindBy(xpath = "(//div[@class='control review-control-vote']//input)[3]")
    public WebElement threeStar;

    @FindBy(xpath = "(//div[@class='control review-control-vote']//input)[2]")
    public WebElement twoStar;

    @FindBy(xpath = "(//div[@class='control review-control-vote']//input)[1]")
    public WebElement oneStar;

    @FindBy(xpath = "//span[.='Your Rating']")
    public WebElement YourRating;

    @FindBy(xpath = "//input[@name='nickname']")
    public WebElement YourNickname;

    @FindBy(xpath = "//input[@id='summary_field']")
    public WebElement YourSummary;

    @FindBy(xpath = "//textarea[@id='review_field']")
    public WebElement YourReview;

    @FindBy(xpath = "//button[@class='action submit primary']")
    public WebElement SubmitReviewButton;

    @FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
    public WebElement ReviewSubmitMessage;





    public void rating(String value){
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        switch(value){
            case "1 ":js.executeScript("arguments[0].click();", oneStar);
                System.out.println(oneStar);
            case "2":js.executeScript("arguments[0].click();",twoStar);
                System.out.println(twoStar);
            case "3":js.executeScript("arguments[0].click();",threeStar);
                System.out.println(threeStar);
            case "4":js.executeScript("arguments[0].click();", fourStar);
                System.out.println(fourStar);
            case "5":js.executeScript("arguments[0].click();",fiveStar);
                System.out.println(fiveStar);
        }
        }

        public void nicknameInput(String value){
        YourNickname.sendKeys(value);
        }

        public void reviewInput(String value){
        YourReview.sendKeys(value);
        }

        public void summaryInput(String value){
        YourSummary.sendKeys(value);
        }
    }

