package InternetArchive.Pages;

import LocalUtils.Annotations.WebElementLocator;
import LocalUtils.Annotations.WebElementLocatorFactory;
import InternetArchive.SiteTools.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

import java.util.Random;

import static InternetArchive.SiteTools.Constant.*;

public class RegistrationPage extends BaseClass {
    /**
     * locator for email input field
     *
     * @return Web element usernameField
     */
    @WebElementLocator(webDesktop = "//input[@type='email']", webPhone = "//input[@type='email']")
    private static WebElement emailField() {
        return getDriver().findElement(By.xpath(new WebElementLocatorFactory().getLocator(RegistrationPage.class, "emailField")));
    }

    /**
     * locator for password input field
     *
     * @return Web element passwordField
     */
    @WebElementLocator(webDesktop = "//input[@type='password']", webPhone = "//input[@type='password']")
    private static WebElement passwordField() {
        return getDriver().findElement(By.xpath(new WebElementLocatorFactory().getLocator(RegistrationPage.class, "passwordField")));
    }

    /**
     * locator for screen name input field
     *
     * @return Web element screenNameField
     */
    @WebElementLocator(webDesktop = "//input[@name='screenname']", webPhone = "//input[@name='screenname']")
    private static WebElement screenNameField() {

        return getDriver().findElement(By.xpath(new WebElementLocatorFactory().getLocator(RegistrationPage.class, "screenNameField")));

    }

    /**
     * locator for button sign up
     *
     * @return Web element buttonSignUp
     */
    @WebElementLocator(webDesktop = "//button[text()='Sign up']", webPhone = "//button[text()='Sign up']")
    private static WebElement buttonSignUp() {
        return getDriver().findElement(By.xpath(new WebElementLocatorFactory().getLocator(RegistrationPage.class, "buttonSignUp")));
    }
    /**
     * locator for error screen name
     *@return Web element screenName
     */
    @WebElementLocator(webDesktop = "//span[@name='screenname_error']",webPhone = "//span[@name='screenname_error']")
private static WebElement alertScreenName(){
        return getDriver().findElement(By.xpath(new WebElementLocatorFactory().getLocator(RegistrationPage.class,"alertScreenName")));
    }
    @WebElementLocator(webDesktop = "//span[@name='username_error']",webPhone = "//span[@name='username_error']")
    private static WebElement alertEmailField(){
        return getDriver().findElement(By.xpath(new WebElementLocatorFactory().getLocator(RegistrationPage.class,"alertEmailField")));
    }
    @WebElementLocator(webDesktop = "//span[@name='password_error']",webPhone = "//span[@name='password_error']")
    private static WebElement alertPasswordField(){
        return getDriver().findElement(By.xpath(new WebElementLocatorFactory().getLocator(RegistrationPage.class,"alertPasswordField")));
    }
    /**
     * Method for entering validate data which you call in main class
     */
    public void enterValidData() throws InterruptedException {
        type(emailField(),createEmail());
        type(screenNameField(), GET_NAME);
        type(passwordField(), CORRECT_PASSWORD);

        click(buttonSignUp());

    }
public  boolean  verifyThatAlertIsDisplayed() {
        if (alertScreenName().isDisplayed() ||alertEmailField().isDisplayed() || alertPasswordField().isDisplayed()) {
        return true;}
else {
    return false;
        }
}
    /**
     * method for getting random screen name
     **/
    public static String randomWords(int n) {
        // lower limit for LowerCase Letters
        int lowerLimit = 97;
        // lower limit for LowerCase Letters
        int upperLimit = 122;
        Random random = new Random();
        // Create a StringBuffer to store the result
        StringBuffer r = new StringBuffer(n);
        for (int i = 0; i < n; i++) {
            int nextRandomChar = lowerLimit
                    + (int) (random.nextFloat()
                    * (upperLimit - lowerLimit + 1));
            r.append((char) nextRandomChar);
        }
        return r.toString();

    }
    public void enterBadValues(String email,String screen,String pass){
        waitUntilElementIsAbleToTypeBool(emailField(),email);
        waitUntilElementIsAbleToTypeBool(screenNameField(),screen);
        waitUntilElementIsAbleToTypeBool(passwordField(),pass);
        buttonSignUp();
    }

    @DataProvider(name = "badValue")
    public Object[][] getData() {
        return new Object[][]{
                {createEmail(),randomWords(2), "1234"},
                {createEmail(),randomWords(1), "1234"},
                {INCORRECT_EMAIL1,randomWords(5),"1234"},
                {INCORRECT_EMAIL2,randomWords(5),"1234"},
                {INCORRECT_EMAIL3,randomWords(5),"1234"},
                {INCORRECT_EMAIL4,randomWords(5),"1234"}

        };
    }

}


