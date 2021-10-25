package pageObjects;

import entities.User;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class NativePageObject extends PageObject {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    WebElement signInBtn;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    WebElement registerBtn;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    WebElement registrationEmailTextField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    WebElement registrationUsernameTextField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    WebElement registrationPasswordTextField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    WebElement registrationConfirmPasswordTextField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    WebElement registerNewAccountBtn;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_email")
    WebElement loginEmailTextField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
    WebElement loginPasswordTextField;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.TextView")
    WebElement titleOfUserAccountText;


    public NativePageObject(AppiumDriver appiumDriver) throws Exception {
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
    }

    public void registerUser(User user, AppiumDriver appiumDriver) {
        registerBtn.click();
        registrationEmailTextField.sendKeys(user.getEmail());
        registrationUsernameTextField.sendKeys(user.getUsername());
        registrationPasswordTextField.sendKeys(user.getPassword());
        registrationConfirmPasswordTextField.sendKeys(user.getPassword());
        registerNewAccountBtn.click();
    }

    public void loginAsUser(User user) {
        loginEmailTextField.sendKeys(user.getEmail());
        loginPasswordTextField.sendKeys(user.getPassword());
        signInBtn.click();
    }

    public String getTittleNativeApp() {
        return titleOfUserAccountText.getText();
    }
}
