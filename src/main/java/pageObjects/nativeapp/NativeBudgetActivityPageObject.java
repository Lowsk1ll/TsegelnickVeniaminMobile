package pageObjects.nativeapp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class NativeBudgetActivityPageObject {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/action_bar_container")
    WebElement actionBarContainer;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.TextView")
    WebElement budgetActivityText;

    public NativeBudgetActivityPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
    }

    public WebElement getActionBarContainerText(){
        return actionBarContainer.findElement(By.className("android.widget.TextView"));
    }

    public WebElement getBudgetActivityText(){
        return budgetActivityText;
    }
}
