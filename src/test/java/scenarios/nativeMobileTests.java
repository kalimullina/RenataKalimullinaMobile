package scenarios;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import entities.User;
import java.io.IOException;
import org.testng.annotations.Test;
import setup.BaseTest;


public class nativeMobileTests extends BaseTest {

    @Test(groups = {"native"}, description = "This simple test just click on the Sign In button")
    public void simpleNativeTest()
        throws IllegalAccessException, NoSuchFieldException, InstantiationException, IOException {
        getPo().getWelement("signInBtn").click();


        /*byte[] screenshot = Base64.encodeBase64(getDriver().getScreenshotAs(OutputType.BYTES));
        byte[] partialImage = Base64.encodeBase64(partialImage());
        OccurrenceMatchingResult result = getDriver()
                .findImageOccurrence(screenshot, partialImage, new OccurrenceMatchingOptions()
                .withThreshold(0.1)
                .withEnabledVisualization());

        System.out.println(result.getRect().getDimension());
        System.out.println("X:"+result.getRect().getX());
        System.out.println("Y:"+result.getRect().getY());
        System.out.println("Height:"+result.getRect().getHeight());
        System.out.println("Width:"+result.getRect().getWidth());
        System.out.println(result.getVisualization().length);

        Assert.assertTrue(result.getVisualization().length >
            0 , "Partial image is not present!");
        //assertThat(result.getVisualization().length, is(greaterThan(0)));
        //assertNotNull(result.getRect());*/

        System.out.println("Simplest Android native test done");
    }

    @Test(groups = {"native"}, description = "This test register a new account and then sign in")
    public void nativeTestWithNewAccount() {

        //Register a new account
        getPo().getNativePO().registerUser(User.ROMAN);

        //Login as the new user
        getPo().getNativePO().loginAsUser(User.ROMAN);

        assertThat(getPo().getNativePO().getTittleNativeApp())
            .as("The title of user account was wrong")
            .isEqualTo(property.getProperty("titleOfNativeApp"));
    }

}
