package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebPageObject extends PageObject {

    @FindBy(css = "[name='q']")
    WebElement searchTextField;

    @FindBy(css = "[class='q8U8x MBeuO ynAwRc PpBGzd YcUVQe']")
    List<WebElement> pageTitles;






    @FindBy(css = "[class='GPcFIc']")
    WebElement firstSearchAutoCompleteTextView;

    @FindBy(css = "[class='sbic sb43']")
    WebElement searchMark;

    public WebPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
    }

    public void openGoogleSearchPage(AppiumDriver appiumDriver) {
        appiumDriver.get("https://google.com");

        // Make sure that page has been loaded completely
        new WebDriverWait(appiumDriver, 10).until(
            wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );
    }

    public void makeSearchUsingKeyword(AppiumDriver appiumDriver, String keyword) throws InterruptedException {
        searchTextField.sendKeys(keyword);
        searchMark.click();
        new WebDriverWait(appiumDriver, 10).until(
            wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );

        //appiumDriver.getKeyboard().pressKey("\n");
        //boolean isKeyboardShown = appiumDriver.isKeyboardShown();
        //Thread.sleep(5000);
        //firstSearchAutoCompleteTextView.click();
        //appiumDriver.findElement(By.cssSelector("[class='s49v2']")).click();
        //appiumDriver.getKeyboard().sendKeys(Keys.ENTER);
        //searchTextField.sendKeys("\n");
        //searchButton.click();
        //Thread.sleep(5000);
        // Make sure that page has been loaded completely
        //pageTitles.get(0).click();
    }

    public int verifyRelevantResults(String keyword) {
        int countRelevantResults = 0;
        for (WebElement pageTitle : pageTitles)
            if (pageTitle.getText().contains(keyword))
                countRelevantResults++;
        return countRelevantResults;
    }
}
