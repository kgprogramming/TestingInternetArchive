package InternetArchive.Tests.PC;

import InternetArchive.Pages.Homepage;
import InternetArchive.Pages.LoginPage;

import InternetArchive.Pages.TestUtilsForGettingDataFromExcel;
import InternetArchive.SiteTools.BaseClass;
import InternetArchive.SiteTools.Constant;
import InternetArchive.SiteTools.Groups;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginWithInvalidInputs extends BaseClass {
    Homepage homepage = new Homepage();
    LoginPage loginPage = new LoginPage();
@BeforeMethod
public void setup(){
    getDriver().manage().window().maximize();
}
    @Test(groups = {Groups.PC}, dataProviderClass = LoginPage.class, dataProvider = "badValues")
    public void LoginWithBadInputs(String screen, String pass) throws InterruptedException {
        Reporter.log("Navigate to pc home page", true);
        homepage.navigateToPageNoCookie(Constant.MAIN_NAVIGATION_URL);
        Reporter.log("Click on sign up page", true);
        homepage.clickOnLogin();
        Reporter.log("Enter wrong email and wrong password", true);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginPage.enterDataForUsernameAndPassword(screen, pass),"Email address and/or Password incorrect."+"Current url is: /n"
                + getDriver().getCurrentUrl().contains("/login"));
        softAssert.assertAll();
    }

    @Test(groups = {Groups.PC},dataProviderClass = TestUtilsForGettingDataFromExcel.class,dataProvider = "getLoginData")
    public void loginWithDataFromExcelFile(String user,String pas) throws InterruptedException {

        Reporter.log("Navigate to pc home page", true);
        homepage.navigateToPageNoCookie(Constant.MAIN_NAVIGATION_URL);
        checkPageIsReady();

        Reporter.log("Click on sign up page", true);
        homepage.clickOnLogin();
        checkPageIsReady();

        Reporter.log("Verify that we are on sign up page", true);
        Assert.assertTrue(loginPage.getCurrentUrl());

        Reporter.log("Enter wrong email and wrong password", true);
        Assert.assertTrue(loginPage.enterDataForUsernameAndPassword(user, pas));

        Reporter.log("You enter invalid parameters ",true);
        Assert.assertTrue(loginPage.getCurrentUrl());

    }

}