package testcases;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import utility.Utilities;

import java.io.IOException;

@Epic("Login Feature")
@Story("Login")
public class TC01_LoginPage extends TestBase {
    //define test data
    static String Username = Utilities.getExcelData(1, 0, "Sheet1");
    static String Password = Utilities.getExcelData(1, 1, "Sheet1");

    public TC01_LoginPage() throws IOException, ParseException {
    }

    //positive test case

    //ToDo: create test case to check login with valid emila nad password
    @Test(priority = 1, description = "Check login with valid username and password")
    @Description
    public void loginWithValidEmailAndValidPassword_P() {

        //ToDo: Login with valid mail and valid password
        new P01_LoginPage(driver).enterEmail(Username).enterPassword(Password).clickLoginButton();
        //ToDo: Take a screenshot
        Utilities.Capturescreenshots(driver, "ValidLoginImage");
    }

    //Negative test cases
    @Test(priority = 2, description = "Check login with valid username and Invalid password")
    public void loginWithValidEmailAndInvalidPassword_N() {
        Password = "dsfsd";
        //ToDo: Login with invalid mail and invalid password
        new P01_LoginPage(driver).enterEmail(Username).enterPassword(Password).clickLoginButton();
        //ToDo: Take a screenshot
        Utilities.Capturescreenshots(driver, "InvalidPasswordImage");
    }

    @Test(priority = 3, description = "Check login with invalid username and valid password")
    public void loginWithInvalidEmailAndValidPassword_N() {

        Username = "djdd";
        //ToDo: Login with invalid mail and invalid password
        new P01_LoginPage(driver).enterEmail(Username).enterPassword(Password).clickLoginButton();
        //ToDo: Take a screenshot
        Utilities.Capturescreenshots(driver, "InvalidUsernameImage");
    }

    @Test(priority = 4, description = "Check login with invalid username and invalid password")
    public void loginWithInvalidEmailAndInvalidPassword_N() {
        Username = "djdd";
        Password = "dsfsd";
        //ToDo: Login with invalid mail and invalid password

        new P01_LoginPage(driver).enterEmail(Username).enterPassword(Password).clickLoginButton();
        //ToDo: Take a screenshot
        Utilities.Capturescreenshots(driver, "invalidUsernameAndPasswordImage");
    }
}