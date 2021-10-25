package scenarios;

import io.appium.java_client.MobileElement;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import setup.BaseTest;

public class webMobileTests extends BaseTest {

   /* @Test(groups = {"web"}, description = "Make sure that we've opened IANA homepage")
    public void simpleWebTest() throws InterruptedException {
        getDriver().get("http://iana.org"); // open IANA homepage

        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 10).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );

        // Check IANA homepage title
        assert ((WebDriver) getDriver()).getTitle().equals("Internet Assigned Numbers Authority") : "This is not IANA homepage";

        // Log that test finished
        System.out.println("Site opening done");
    }*/

    @Test(groups = {"web"}, description = "Open google search and search by the word «EPAM»")
    public void searchByWordEPAMTest() {

        //go to a Google search page
        getPo().getWebPO().openGoogleSearchPage(getDriver());




        /*List<MobileElement> mobileElements =
            (List<MobileElement>) getDriver().findElementsByClassName("android.widget.EditText");

        MobileElement mobileElement = mobileElements.get(2);*/


        //getDriver().findElement(By.cssSelector("#tsf")).click();

        /*getDriver().findElement(By.xpath
                                      ("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[3]/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.widget.EditText"))
            ;*/

        /*List<WebElement> mobileElements =
            (List<WebElement>) getDriver().findElements(By.cssSelector("[class='android.widget.EditText']"));

        mobileElements.get(0).sendKeys("dqwdcq");*/
        //int y = 0;
        //getDriver().findElement(By.cssSelector("#tsf")).sendKeys("wefwe");


        getPo().getWebPO().makeSearchUsingKeyword(getDriver(), property.getProperty("searchKeyword"));
    }
}
