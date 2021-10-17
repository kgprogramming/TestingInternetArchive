package InternetArchive.Tests.PC;

import InternetArchive.Pages.Homepage;
import InternetArchive.Pages.RegistrationPage;
import InternetArchive.SiteTools.BaseClass;
import InternetArchive.SiteTools.Constant;
import InternetArchive.SiteTools.Groups;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RegistrationOnInternetArchive extends BaseClass {
    Homepage homepage = new Homepage();
    RegistrationPage registrationPage = new RegistrationPage();


    @Test(groups = {Groups.PC})
    public void registrationWithValidUsernameAndPassword() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Reporter.log("Navigate to pc home page", true);
        homepage.navigateToPageNoCookie(Constant.MAIN_NAVIGATION_URL);
        Reporter.log("Click on sign up page", true);
        homepage.clickOnSignUp();
        softAssert.assertTrue(getDriver().getCurrentUrl().contains("/signup"));
        Reporter.log("Enter valid data in input fields", true);
        registrationPage.enterValidData();
    }

    }
