package Exercise.pages;

import LocalUtils.Annotations.WebElementLocator;
import LocalUtils.Annotations.WebElementLocatorFactory;
import InternetArchive.SiteTools.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class IframeFromGlobalsqa extends BaseClass {
    @WebElementLocator(webDesktop = "//input[@id='s']")
    private static WebElement inputFieldInIFrame() {
        return getDriver().findElement(By.xpath(new WebElementLocatorFactory().getLocator(IframeFromGlobalsqa.class, "inputFieldInIFrame")));
    }
    @WebElementLocator(webDesktop = "//iframe[@class=' lazyloaded']")
    private static WebElement iframe() {
        return getDriver().findElement(By.xpath(new WebElementLocatorFactory().getLocator(IframeFromGlobalsqa.class, "iframe")));
    }
public boolean typeDataInInputFieldFromIframe() throws InterruptedException {
    switchToIFrame(iframe());
   WebElement input=  getDriver().findElement(By.xpath("//input[@id='s']"));
   type(input, "Petar Vulovic");
   Thread.sleep(300);
    String text = input.getText();
    System.out.println("Text " + text);
    return text.equals("Petar Vulovic");
    }
    public boolean verifyThatYouEnterDataInInputField() throws InterruptedException {
        getDriver().switchTo().frame(iframe());
        String text = inputFieldInIFrame().getText();
        System.out.println("Text " + text);
        return text.equals("Petar Vulovic");
    }
}
