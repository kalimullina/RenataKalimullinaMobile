package setup;

import org.openqa.selenium.WebElement;
import pageObjects.NativePageObject;
import pageObjects.WebPageObject;

public interface IPageObject {

    WebElement getWelement(String weName) throws NoSuchFieldException, IllegalAccessException, InstantiationException;

    NativePageObject getNativePO();
    WebPageObject getWebPO();
}
