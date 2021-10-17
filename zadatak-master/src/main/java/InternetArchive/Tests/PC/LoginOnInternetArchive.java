package InternetArchive.Tests.PC;

import InternetArchive.Pages.Homepage;
import InternetArchive.Pages.LoginPage;
import InternetArchive.SiteTools.BaseClass;
import InternetArchive.SiteTools.Constant;
import InternetArchive.SiteTools.Groups;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginOnInternetArchive extends BaseClass {
    Homepage homepage=new Homepage();
    LoginPage loginPage=new LoginPage();

    @Test(groups = {Groups.PC})
    public void loginWithValidUsernameAndPassword() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();
        Reporter.log("Navigate to pc home page", true);
        homepage.navigateToPageNoCookie(Constant.MAIN_NAVIGATION_URL);
        checkPageIsReady();
        Reporter.log("Click on login page from navigation",true);
        homepage.clickOnLogin();
        softAssert.assertTrue(getDriver().getCurrentUrl().contains("/login"));
        Reporter.log("Type valid email and valid password in input field",true);
        loginPage.enterDataForUsernameAndPassword(Constant.CORRECT_EMAIL,Constant.CORRECT_PASSWORD);
        checkPageIsReady();
        Reporter.log("Verify that you are logged in successfully",true);
        softAssert.assertTrue(homepage.verifyImageOnHomePage());
    softAssert.assertAll();
    }

}
