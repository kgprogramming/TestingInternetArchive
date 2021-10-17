package Exercise.tests;

import Exercise.pages.IframeFromGlobalsqa;
import InternetArchive.SiteTools.BaseClass;
import InternetArchive.SiteTools.Groups;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SwitchToIFrameAndTypeFirstNameAndLastName extends BaseClass {
    IframeFromGlobalsqa iframe=new IframeFromGlobalsqa();
    @Test(groups = {Groups.PC})
    public void typeTextInIFrame() throws InterruptedException {
        Reporter.log("Go to url",true);
        getDriver().navigate().to("https://www.globalsqa.com/demo-site/frames-and-windows/#iFrame");
        checkPageIsReady();

        Reporter.log("Enter data in input field",true);
        Assert.assertTrue(iframe.typeDataInInputFieldFromIframe());

        /*Reporter.log("Verify that you enter data in input field",true);
        Assert.assertTrue(iframe.verifyThatYouEnterDataInInputField());
         */
    }
}
