package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebPageObject extends PageObject {

    @FindBy(css = "#tsf")
    WebElement searchTextButton;

    @FindBy(css = "[class='android.widget.EditText']")
    List<WebElement> qqq;






    public WebPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
    }

    public void openGoogleSearchPage(AppiumDriver appiumDriver) {
        appiumDriver.get("https://google.com");
    }

    public void makeSearchUsingKeyword(AppiumDriver appiumDriver, String keyword) {
        /*List<WebElement> mobileElements = (WebElement)
            appiumDriver.findElementsByClassName("android.widget.ImageButton");
        MobileElement mobileElement = mobileElement.get(1);*/

        searchTextButton.click();



        qqq.get(0).click();
        int y = 0;

    }
}
