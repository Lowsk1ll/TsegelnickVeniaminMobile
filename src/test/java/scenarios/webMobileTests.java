package scenarios;

import data.DataProviderForMobile;
import data.SearchWord;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.web.WebGooglePageObject;
import setup.BaseTest;

public class webMobileTests extends BaseTest {

    //    @Test(groups = {"web"}, description = "Make sure that we've opened IANA homepage")
    //    public void simpleWebTest() throws InterruptedException {
    //        getDriver().get("http://iana.org"); // open IANA homepage
    //
    //        // Make sure that page has been loaded completely
    //        new WebDriverWait(getDriver(), 10).until(
    //            wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
    //        );
    //
    //        // Check IANA homepage title
    //        assert ((WebDriver) getDriver()).getTitle().equals("Internet Assigned Numbers Authority") :
    //            "This is not IANA homepage";
    //
    //        // Log that test finished
    //        System.out.println("Site opening done");
    //    }

    @Test(groups = {"web"},
          description = "Search EPAM at Google",
          dataProvider = "searchWithGoogle",
          dataProviderClass = DataProviderForMobile.class)
    public void googleSearchTest(String site, SearchWord searchWord) throws InterruptedException {

        //open google homepage
        getDriver().get(site);

        //type searchWord at search field
        WebGooglePageObject googlePage = new WebGooglePageObject(getDriver());
        googlePage.makeSearch(searchWord.getWord());

        //make sure that result page contains fields with epam site
        new WebDriverWait(getDriver(), 10)
            .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'www.epam.com')]")));

        //Check google search result title
        Assert.assertEquals(getDriver().getTitle(), "EPAM - Google Search");
    }
}
