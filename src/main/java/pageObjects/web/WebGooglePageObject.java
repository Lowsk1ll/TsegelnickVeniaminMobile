package pageObjects.web;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebGooglePageObject {

    @FindBy(xpath = "//input[@type='search']")
    WebElement searchField;



    public WebGooglePageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);

    }

    public WebElement getSearchField() {
        return searchField;
    }

    public void makeSearch(String word){
        searchField.sendKeys(word + Keys.ENTER);
    }
}
