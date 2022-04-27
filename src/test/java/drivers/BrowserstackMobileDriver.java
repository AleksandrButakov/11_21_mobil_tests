package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.SetConfig;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    public static URL getBrowserstackUrl() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(@Nonnull DesiredCapabilities caps) {
        /*
            You have successfully uploaded your app. Note the "app_url" value below. It uniquely identifies your
            uploaded app on BrowserStack.
            {"app_url":"bs://40baf56a2bdeb769f52078d697e7fda39a94412d"}
            In your test script, use this "app_url" value to specify the application under test using the "app"
            capability. During test execution, your app will automatically be installed and launched on the device
            being tested.
            caps.setCapability("app", "bs://40baf56a2bdeb769f52078d697e7fda39a94412d")
         */

        // Set your access credentials
        // caps.setCapability("browserstack.user", "aleksandrbutakov_KwWe1P");
        // caps.setCapability("browserstack.key", "oNza8nFrrqhYaCuJTa16");
        caps.setCapability("browserstack.user", SetConfig.authConfig.user());
        caps.setCapability("browserstack.key", SetConfig.authConfig.key());

        // Set URL of the application under test
        // caps.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");
        caps.setCapability("app", SetConfig.browserStackConfig.app());

        // Specify device and os_version for testing
        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");

        return new AndroidDriver(getBrowserstackUrl(), caps);
    }
}
