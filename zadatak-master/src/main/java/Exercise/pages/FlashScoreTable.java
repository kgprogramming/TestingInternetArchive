package Exercise.pages;

import LocalUtils.Annotations.WebElementLocator;
import LocalUtils.Annotations.WebElementLocatorFactory;
import InternetArchive.SiteTools.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlashScoreTable extends BaseClass {
    /**
     * locator for bold text
     * @return all basketball teams who are winners
     */
    @WebElementLocator(webDesktop = ".fontBold")
    private static List<WebElement> boldTextForWinner(){
        return getDriver().findElements(By.cssSelector(new WebElementLocatorFactory().getLocator(FlashScoreTable.class,"boldTextForWinner")));
    }
    /**
     * locator for basketball page
     * @return new page
     */
    @WebElementLocator(webDesktop = "//div[@class='sportIcon sportIcon--basketball']")
    private static WebElement basketballPage(){
        return getDriver().findElement(By.xpath(new WebElementLocatorFactory().getLocator(FlashScoreTable.class,"basketballPage")));
    }

    public void collectData() throws InterruptedException {
        basketballPage().click();
        Thread.sleep(1000);
        try {
            List<String> PMPageCMList = boldTextForWinner()
                    .stream()
                    .map(user -> user.getAttribute("innerText"))
                    .collect(Collectors.toList());
            List<String>text=new ArrayList<>();
            text.addAll(PMPageCMList);
            System.out.println(text);
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }

}
