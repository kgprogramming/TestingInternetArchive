package InternetArchive.Pages;

import InternetArchive.SiteTools.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Homepage extends BaseClass {
    /**
    method for clicking on login page with using JsExecutor
     @return new page Login
     */
    public LoginPage clickOnLogin(){
        JavascriptExecutor js=(JavascriptExecutor) getDriver();
        WebElement logInButton= (WebElement) js.executeScript("return document.querySelector(\"body > app-root\").shadowRoot.querySelector(\"header > ia-topnav\").shadowRoot.querySelector(\"div.topnav > primary-nav\").shadowRoot.querySelector(\"nav > div.user-info > login-button\").shadowRoot.querySelector(\"div > span > a:nth-child(2)\")");
        logInButton.click();
        return new LoginPage();
    }
    /**
     method for clicking on sign up page with using JsExecutor
     @return new page Sign up
     */
    public RegistrationPage clickOnSignUp(){
        JavascriptExecutor js=(JavascriptExecutor) getDriver();

        WebElement signUpButton=(WebElement) js.executeScript("return document.querySelector(\"body > app-root\").shadowRoot.querySelector(\"header > ia-topnav\").shadowRoot.querySelector(\"div.topnav > primary-nav\").shadowRoot.querySelector(\"nav > div.user-info > login-button\").shadowRoot.querySelector(\"div > span > a:nth-child(1)\")");
        signUpButton.click();
        return new RegistrationPage();
    }
    public void navigateToPageNoCookie(String pageUrl) {
        if (pageUrl.contains("http")) {
            getDriver().get(pageUrl);
        } else {
            getDriver().get(getBaseURL() + pageUrl);
        }
        checkPageIsReady();
    }
    /**
     method for verify that user image are shown using JsExecutors
     */
    public boolean verifyImageOnHomePage() {
     JavascriptExecutor js=(JavascriptExecutor) getDriver();
     WebElement img=(WebElement) js.executeScript("return document.querySelector(\"#topnav > ia-topnav\").shadowRoot.querySelector(\"div.topnav > primary-nav\").shadowRoot.querySelector(\"nav > div.user-info > button\")");
    if (img.isDisplayed()){
        return true;
    }
    else {
        return false;
    }
    }
    /**
     method for clicking on sign up page with using JsExecutor
     @return new page Sign up
     */
    public void clickOnSignUpForMobile(){
        JavascriptExecutor js=(JavascriptExecutor) getDriver();
        WebElement signUp=(WebElement) js.executeScript("return document.querySelector(\"#topnav > ia-topnav\").shadowRoot.querySelector(\"signed-out-dropdown\").shadowRoot.querySelector(\"nav > ul > li:nth-child(1) > a\")");
        signUp.click();
    }/**
     method for clicking navigation on homepage using JsExecutor
     @return nav bar expanded
     */
    public void clickOnNavigation() throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor) getDriver();
        WebElement picture=(WebElement) js.executeScript("return document.querySelector(\"#topnav > ia-topnav\").shadowRoot.querySelector(\"div.topnav > primary-nav\").shadowRoot.querySelector(\"nav > div.user-info > login-button\").shadowRoot.querySelector(\"div\")");
        picture.click();
        Thread.sleep(300);
    }
    /**
     method for clicking on login page with using JsExecutor
     @return new page Login
     */
    public LoginPage clickOnLoginForMobile(){
        JavascriptExecutor js=(JavascriptExecutor) getDriver();
        WebElement login=(WebElement) js.executeScript("return document.querySelector(\"#topnav > ia-topnav\").shadowRoot.querySelector(\"signed-out-dropdown\").shadowRoot.querySelector(\"nav > ul > li:nth-child(2) > a\")");
        login.click();
        return new LoginPage();
    }

}
