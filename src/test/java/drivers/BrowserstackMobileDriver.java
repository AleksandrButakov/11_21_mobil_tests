package drivers;

import com.codeborne.selenide.WebDriverProvider;
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

        // Set your access credentials
        caps.setCapability("browserstack.user", "aleksandrbutakov_KwWe1P");
        caps.setCapability("browserstack.key", "oNza8nFrrqhYaCuJTa16");

        // Set URL of the application under test
        caps.setCapability("app", "bs://7ee3319df6dad76013f5461ee617064212874b8a");

        // Specify device and os_version for testing
        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "Pinout Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "Pinout_test");

        return new AndroidDriver(getBrowserstackUrl(), caps);
    }
}
