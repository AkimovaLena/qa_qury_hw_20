package drivers;

import config.AuthConfigBS;
import config.BrowserstackConfig;
import com.codeborne.selenide.WebDriverProvider;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    AuthConfigBS authData = ConfigFactory.create(AuthConfigBS.class, System.getProperties());
    BrowserstackConfig bsConfig = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();
        AuthConfigBS authData = ConfigFactory.create(AuthConfigBS.class, System.getProperties());
        BrowserstackConfig bsConfig = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

        // Set your access credentials
        caps.setCapability("browserstack.user", authData.user());
        caps.setCapability("browserstack.key", authData.key());

        // Set URL of the application under test
        caps.setCapability("app", bsConfig.app());

        // Specify device and os_version for testing
        caps.setCapability("device", bsConfig.device());
        caps.setCapability("os_version", bsConfig.osVersion());

        // Set other BrowserStack capabilities
        caps.setCapability("project", bsConfig.project());
        caps.setCapability("build", bsConfig.build());
        caps.setCapability("name", bsConfig.name());

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL(bsConfig.url()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}