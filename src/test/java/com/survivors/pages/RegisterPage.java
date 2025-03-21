package com.survivors.pages;

import com.survivors.utilities.ConfigurationReader;
import com.survivors.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.module.Configuration;

public class RegisterPage {
    public RegisterPage(){
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy(id="firstname")
    public WebElement firstName;
    @FindBy(id="lastname")
    public WebElement lastName;
    @FindBy(id="email_address")
    public WebElement email;
    @FindBy(id="password")
    public WebElement password;
    @FindBy(id="password-confirmation")
    public WebElement confirmPassword;
    @FindBy(xpath = "//button[.='Create an Account']")
    public WebElement registerButton;
    @FindBy(css = ".message-success>div")
    public WebElement successMessage;

    public void register(String FirstName,String LastName,String Email,String Password){
        firstName.sendKeys(FirstName);
        lastName.sendKeys(LastName);
        email.sendKeys(Email);
        password.sendKeys(Password);
        confirmPassword.sendKeys(Password);
        // Click on Register button
    }
}
