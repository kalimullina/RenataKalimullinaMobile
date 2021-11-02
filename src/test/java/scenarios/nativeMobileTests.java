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
            .contains(property.getProperty("titleOfNativeApp"));
    }

}
