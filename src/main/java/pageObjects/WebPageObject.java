package pageObjects;

import io.appium.java_client.AppiumDriver;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebPageObject extends PageObject {

    @FindBy(css = "[name='q']")
    WebElement searchTextField;

    @FindBy(css = "[role='heading'] > div")
    List<WebElement> pageTitles;


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
        searchTextField.submit();
        new WebDriverWait(appiumDriver, 10).until(
            wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );
    }

    public int verifyRelevantResults(String keyword) {
        int countRelevantResults = 0;
        for (WebElement pageTitle : pageTitles)
            if (pageTitle.getText().contains(keyword))
                countRelevantResults++;
        return countRelevantResults;
    }

    public int getRelevantResultAmount(){
        return pageTitles.size();
    }
}
