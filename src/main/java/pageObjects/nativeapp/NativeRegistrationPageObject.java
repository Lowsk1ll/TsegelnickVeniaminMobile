package pageObjects.nativeapp;

import data.User;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class NativeRegistrationPageObject {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    WebElement emailTextField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    WebElement usernameTextField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    WebElement passwordTextField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    WebElement confirmPasswordTextField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    WebElement registerNewAccountButton;


    public NativeRegistrationPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
    }

    public void registerNewAccount(User user){
        emailTextField.sendKeys(user.getEmail());
        usernameTextField.sendKeys(user.getUserName());
        passwordTextField.sendKeys(user.getPassword());
        confirmPasswordTextField.sendKeys(user.getPassword());
        registerNewAccountButton.click();
    }

}
