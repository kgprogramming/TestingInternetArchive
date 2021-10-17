package Exercise.tests;

import Exercise.pages.SeleniumEasyTable;
import InternetArchive.SiteTools.BaseClass;
import InternetArchive.SiteTools.Groups;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class GetDataFromTable extends BaseClass {
    SeleniumEasyTable sel=new SeleniumEasyTable();
    @Test(groups = {Groups.PC})
    public void getDataFromTable() throws InterruptedException {
        Reporter.log("Go to url",true);
        getDriver().navigate().to("https://www.seleniumeasy.com/test/table-data-download-demo.html");
        checkPageIsReady();

        Reporter.log("Get data from table",true);
        Assert.assertTrue(sel.getDataFromTable());
    }
}

