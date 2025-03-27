package com.survivors.pages;

import com.github.javafaker.Faker;
import com.survivors.utilities.ConfigurationReader;
import com.survivors.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.module.Configuration;
import java.util.HashMap;
import java.util.Map;

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
    @FindBy(xpath = "//div[@class='messages' and @role='alert']/div/div")
    public WebElement errorMessage;

    public void register(String FirstName,String LastName,String Email,String Password){
        firstName.sendKeys(FirstName);
        lastName.sendKeys(LastName);
        email.sendKeys(Email);
        password.sendKeys(Password);
        confirmPassword.sendKeys(Password);
        // Click on Register button
    }
    public static Map<String,String> generateRandomUser(){
        Map<String,String> registerData=new HashMap<>();
        Faker faker = new Faker();
        registerData.put("FirstName",faker.name().firstName());
        registerData.put("LastName",faker.name().lastName());
        registerData.put("Email",faker.internet().emailAddress());
        registerData.put("Password",faker.internet().password(10,12,true,true,true));
        return registerData;
    }
}
