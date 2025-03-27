package com.survivors.pages;

import com.survivors.utilities.BrowserUtils;
import com.survivors.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LumuHomePage {
    public LumuHomePage(){
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy(xpath = "//h2[.='Hot Sellers']")
    public WebElement hotSellersTitle;
@FindBy(css = ".block.widget.block-products-list.grid>div>div>ol>li")
    public List<WebElement> products;
@FindBy(id = "qty")
    public WebElement quantityInput;
@FindBy(xpath = "//button[@title='Add to Cart']")
    public WebElement addToCartButton;
@FindBy(xpath = "//span[@itemprop='name']")
    public WebElement productName;
@FindBy(xpath = "//div[@role='alert']/div/div")
    public WebElement successMessage;
@FindBy(css = "a.action.showcart")
    public WebElement cartLink;
@FindBy(css = ".product-item-details>.product.options")
    public WebElement productDetails;
@FindBy(css = "a#tab-label-reviews-title")
    public WebElement reviewsTab;
@FindBy(css="form#review-form")
    public WebElement reviewForm;
@FindBy(css = "input#nickname_field")
    public WebElement nicknameField;
@FindBy(css = "input#summary_field")
    public WebElement summaryField;
@FindBy(css="#review_field")
    public WebElement reviewField;
@FindBy(css = "button.action.submit.primary")
    public WebElement submitReviewButton;
    public void selectStarRating(String starNumber) {
        String locater="#Rating_"+starNumber;
        WebElement star = Driver.get().findElement(By.cssSelector(locater));
        BrowserUtils.clickWithJS(star);
    }
public WebElement selectSize(String size){
    size=size.toUpperCase();
    String locater="//div[@role='listbox']//div[@option-label='"+size+"']";
    return Driver.get().findElement(By.xpath(locater));
}
    public WebElement selectColor(String color){
        color=color.substring(0,1).toUpperCase()+color.substring(1).toLowerCase();
        String locater="//div[@role='listbox']//div[@option-label='"+color+"']";
        return Driver.get().findElement(By.xpath(locater));
    }
    public void setQuantity(String quantity) {
        quantityInput.clear();
        quantityInput.sendKeys(quantity);
    }
    public Map<String,String> productOptions(){
        BrowserUtils.waitForVisibility(productDetails,5);
        productDetails.click();
        Map<String, String> productDetails = new HashMap<>();

        List<WebElement> labels = Driver.get().findElements(By.cssSelector(".product.options.list dt.label"));
        List<WebElement> values = Driver.get().findElements(By.cssSelector(".product.options.list dd.values span"));
        for (int i = 0; i < labels.size(); i++) {
            String key = labels.get(i).getText().trim();
            String value = values.get(i).getText().trim();
            productDetails.put(key, value);
        }
       WebElement edit=Driver.get().findElement(By.cssSelector(".action.edit"));
        BrowserUtils.scrollToElement(edit);
        WebElement quentity=Driver.get().findElement(By.cssSelector(".details-qty.qty input"));
        productDetails.put("Quantity",quentity.getAttribute("value"));
        System.out.println(productDetails);
        return productDetails;

    }
    public void selectItemByName(String name){
    String locator="img.product-image-photo[alt='"+name+"']";
    WebElement item=Driver.get().findElement(By.cssSelector(locator));
    item.click();
    }

}
