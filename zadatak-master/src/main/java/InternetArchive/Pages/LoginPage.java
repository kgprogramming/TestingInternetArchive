package InternetArchive.Pages;

import LocalUtils.Annotations.WebElementLocator;
import LocalUtils.Annotations.WebElementLocatorFactory;
import InternetArchive.SiteTools.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

import static InternetArchive.SiteTools.Constant.*;

public class LoginPage extends BaseClass {
    /**
     * locator for email input field
     *  @return Web element emailField
     */
    @WebElementLocator(webDesktop = "//input[@type='email']",webPhone = "//input[@type='email']")
    private static WebElement emailField() {
        return getDriver().findElement(By.xpath(new WebElementLocatorFactory().getLocator(LoginPage.class, "emailField")));
    }
    /**
     * locator for password input field
     *  @return Web element passwordField
     */
    @WebElementLocator(webDesktop = "//input[@type='password']",webPhone = "//input[@type='password']")
    private static WebElement passwordField() {
        return getDriver().findElement(By.xpath(new WebElementLocatorFactory().getLocator(LoginPage.class, "passwordField")));
    }
    /**
     * locator for button submit
     *  @return Web element buttonSubmit
     */
    @WebElementLocator(webDesktop = "//input[@type='submit']",webPhone = "//input[@type='submit']")
    private static WebElement buttonSubmit() {
        return getDriver().findElement(By.xpath(new WebElementLocatorFactory().getLocator(LoginPage.class, "buttonSubmit")));
    }
    @WebElementLocator(webDesktop = "//span[@class='login-error password-error']",webPhone = "//span[@class='login-error password-error']")
    private static WebElement messageAlertForPasswordOrEmail() {
        return getDriver().findElement(By.xpath(new WebElementLocatorFactory().getLocator(LoginPage.class, "messageAlertForPasswordOrEmail")));
    }
   /* public boolean verifyThatAlertMessageForEmailAndPasswordAreShowing(){
     return    verifyThatElementIsVisible(emailField());
    */
   public  boolean  verifyThatAlertISDisplayedForLogin(){
       return  messageAlertForPasswordOrEmail().isDisplayed();
   }
    /**
     Method for entering valid data in input fields for login
     */
    public boolean enterDataForUsernameAndPassword(String email, String pass) throws InterruptedException {

        try {
            waitUntilElementIsAbleToTypeBool(emailField(), email);
            waitUntilElementIsAbleToTypeBool(passwordField(), pass);
            click(buttonSubmit());
            Thread.sleep(2000);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
        return false;
        }

    }
    /**
     *Data provider for login page
     */
    @DataProvider(name = "badValues")
    public Object[][] getData4() {
        return new Object[][]{
                {CORRECT_EMAIL, INCORRECT_PASSWORD},
               {INCORRECT_EMAIL1,CORRECT_PASSWORD},
               {INCORRECT_EMAIL2,CORRECT_PASSWORD},
                {INCORRECT_EMAIL3,CORRECT_PASSWORD},
                {INCORRECT_EMAIL4,CORRECT_PASSWORD}

        };
    }
    public boolean getCurrentUrl(){
        return waitUntilUrlContainCertainString("/login");
    }



}
