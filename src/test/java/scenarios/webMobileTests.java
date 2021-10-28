package scenarios;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import setup.BaseTest;

public class webMobileTests extends BaseTest {

    /*@Test(groups = {"web"}, description = "Make sure that we've opened IANA homepage")
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
    public void searchByWordEPAMTest() throws InterruptedException {

        //Go to a Google search page
        getPo().getWebPO().openGoogleSearchPage(getDriver());

        //Make a search using keyword ‘EPAM’
        getPo().getWebPO().makeSearchUsingKeyword(getDriver(), property.getProperty("searchKeyword"));

        //Make sure that there are some relevant results
       assertThat(getPo().getWebPO().verifyRelevantResults(property.getProperty("searchKeyword")))
            .as("The relevant results for a keyword were wrong. No relevant results")
            .isNotZero();
    }
}
