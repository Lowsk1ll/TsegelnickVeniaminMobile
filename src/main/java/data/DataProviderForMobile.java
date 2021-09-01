package data;

import org.testng.annotations.DataProvider;

public class DataProviderForMobile {

    @DataProvider
    public Object[][] registerAndSignInProvider() {
        return new Object[][] {{User.DEFAULT}};
    }

    @DataProvider
    public Object[][] searchWithGoogle() {
        return new Object[][] {{"https://www.google.com",SearchWord.DEFAULT_WORD}};
    }
}
