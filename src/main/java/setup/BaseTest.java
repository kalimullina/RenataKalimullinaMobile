package setup;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.WatchEvent;
import java.util.Properties;
import javax.imageio.ImageIO;
import org.opencv.core.Core;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import pageObjects.NativePageObject;
import pageObjects.PageObject;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import pageObjects.WebPageObject;


public class BaseTest implements IDriver {

    private static AppiumDriver appiumDriver; // singleton
    IPageObject po;
    FileInputStream file;
    protected Properties property;

    @Override
    public AppiumDriver getDriver() { return appiumDriver; }

    public IPageObject getPo() {
        return po;
    }

    @Parameters({"platformName","appType","deviceName","browserName","app"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(String platformName, String appType, String deviceName, @Optional("") String browserName, @Optional("") String app) throws Exception {
        System.out.println("Before: app type - "+appType);
        setAppiumDriver(platformName, deviceName, browserName, app);
        setPageObject(appType, appiumDriver);

        property = new Properties();
        file = new FileInputStream("src/test/resources/test.properties");
        property.load(file);


    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        System.out.println("After");
        appiumDriver.closeApp();
        file.close();
    }

    private void setAppiumDriver(String platformName, String deviceName, String browserName, String app){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory Android capabilities
        capabilities.setCapability("platformName",platformName);
        capabilities.setCapability("deviceName",deviceName);

        if(app.endsWith(".apk")) capabilities.setCapability("app", (new File(app)).getAbsolutePath());

        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("chromedriverDisableBuildCheck","true");

        //capabilities.setCapability("chromeOptions", ImmutableMap.of("w3c", false));

        try {
            appiumDriver = new AppiumDriver(new URL(System.getProperty("ts.appium")), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // Timeouts tuning
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    private void setPageObject(String appType, AppiumDriver appiumDriver) throws Exception {
        po = new PageObject(appType, appiumDriver);
    }



   /* public static byte[] getBase64ByteFormatOfImage(String imgName)
                                throws URISyntaxException, IOException {
        URL refImgUrl =
            ImageUtils.class.getClassLoader().getResource(imgName);
        File refImgFile = Paths.get(refImgUrl.toURI()).toFile();
        return Files.readAllBytes(refImgFile.toPath());
    }*/


    public byte[] partialImage() throws IOException {
        File file = new File("src/main/resources/partialImage.JPG");
        BufferedImage originalImage = ImageIO.read(file);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(originalImage, "jpg", baos);
        return baos.toByteArray();
    }
}
