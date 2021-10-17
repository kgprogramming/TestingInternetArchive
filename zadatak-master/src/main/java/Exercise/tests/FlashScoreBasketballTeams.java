package Exercise.tests;

import Exercise.pages.FlashScoreTable;
import InternetArchive.SiteTools.BaseClass;
import InternetArchive.SiteTools.Groups;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class FlashScoreBasketballTeams extends BaseClass {
    FlashScoreTable flash=new FlashScoreTable();
    @Test(groups = {Groups.PC})
    public void getAllWinners() throws InterruptedException {
        Reporter.log("Go to flash score",true);
        getDriver().navigate().to("https://www.flashscore.com/");

        Reporter.log("Go to basketball page and get all basketball teams who wins that day",true);
        flash.collectData();
    }

}
