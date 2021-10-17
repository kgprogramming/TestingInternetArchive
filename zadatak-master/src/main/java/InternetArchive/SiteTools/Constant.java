package InternetArchive.SiteTools;


import InternetArchive.Pages.RegistrationPage;

public class Constant extends BaseClass {

    public static final String MAIN_NAVIGATION_URL = "https://archive.org/";
    /**
     * you need to add here your email and password
     */
    public static final String CORRECT_EMAIL="example@gmail.com";
    public static final String CORRECT_PASSWORD="somepass";

    public static final String INCORRECT_EMAIL1 ="petarStudentprotonmail.com";
    public static final String INCORRECT_EMAIL2 ="petarStudent+";
    public static final String INCORRECT_EMAIL3 ="petarStudentprotonmailcom";
    public static final String INCORRECT_EMAIL4 ="@protonmail.com";
    public static final String INCORRECT_PASSWORD="password";

    public static final String GET_NAME = RegistrationPage.randomWords(5);
    public static String EMAIL_PREFIX="prefix";
    public static Long index=null;


}













