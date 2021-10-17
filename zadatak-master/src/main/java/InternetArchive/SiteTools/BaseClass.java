package InternetArchive.SiteTools;

import LocalUtils.SeleneseException;
import LocalUtils.UtilsBaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;

import static InternetArchive.SiteTools.Constant.*;

public class BaseClass extends UtilsBaseClass {
    public static Long index=null;
    public static   String email;
    public static String trenutno;
    public static final String FILE_PATH="/home/pepe/Documents/internetArchiveFinalni/zadatak-master/folder/indexOfEmail.txt";

    public WebDriverWait waiter() {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), 70,500);
        return wait;
    }

    public void switchToIFrame(WebElement element) {
       getDriver().switchTo().frame(element);
    }
    public JavascriptExecutor getExecutor() {
        JavascriptExecutor executor = (JavascriptExecutor) getWebDriver();
        return executor;
    }

    public  boolean waitUntilElementIsVisibleBool(By locator) {
        try {
            waiter().until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
    public boolean waitUntilElementIsClickableBool(WebElement locator) {
        try {
            waiter().until(ExpectedConditions.elementToBeClickable(locator)).click();

            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
    public boolean waitUntilElementIsAbleToTypeBool(WebElement locator,String text) {
        try {
            waiter().until(ExpectedConditions.visibilityOf(locator)).sendKeys(text);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
    public boolean elementAreClickableJS(WebElement locator){
        JavascriptExecutor js=(JavascriptExecutor) getDriver();
    try {
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].click()",locator);
    return true;
    }
    catch (Exception e){
        e.printStackTrace();
        return false;
    }
    }


    protected void elementToHasAttribute(WebElement element, String attribute, String value) {
        waiter().until(ExpectedConditions.attributeContains(element, attribute, value));
    }

    public void click(WebElement locator) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 5);
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        } catch (Exception e){
            throw new SeleneseException("SHUTDOWN");
        }

    }

    /**
     *
     * @param text waiters
     * @return
     */
    public boolean waitUntilUrlContainCertainString(String text){
        return waiter().until(ExpectedConditions.urlContains(text));
    }
    public void waitUntilElementDisappear(WebElement locator){
        waiter().until(ExpectedConditions.invisibilityOf(locator));
    }
    public boolean waitUntilElementContainText(WebElement locator, String text){
        return waiter().until(ExpectedConditions.textToBePresentInElement(locator,text));
    }



    public void scrollToElement(WebElement element) {
        getExecutor().executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void verifyThatElementIsVisible(final WebElement locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(locator));
    }
    public void type(WebElement locator, String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(locator)).sendKeys(text);
    }

    public  String incrementNumberInFile() {

        File file = new File(FILE_PATH);

        if (!file.exists()) {
            index = 1L;
        } else {
            try (BufferedReader bf = Files.newBufferedReader(file.toPath())) {
                index = Long.parseLong(bf.readLine());
            } catch (Exception e) {
                throw new SeleneseException(("Error while reading an index from the file"));
            }
        }
        try (FileWriter fileWriter = new FileWriter(file)) {
            index++;
            fileWriter.write(index.toString());
        } catch (Exception e) {
            throw new SeleneseException(("Error while writing a new index in the file"));
        }
        return index.toString();
    }
    public String createEmail() {
        incrementNumberInFile();
        EMAIL_PREFIX += index;
        email = INCORRECT_EMAIL2  +EMAIL_PREFIX+ INCORRECT_EMAIL4;
        trenutno=email;
        return email;
    }
}
