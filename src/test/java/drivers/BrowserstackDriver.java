package drivers;

import Config.AuthConfig;
import Config.BrowserstackConfig;
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

    AuthConfig authData = ConfigFactory.create(AuthConfig.class, System.getProperties());
    BrowserstackConfig bsConfig = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();
        AuthConfig authData = ConfigFactory.create(AuthConfig.class, System.getProperties());
        BrowserstackConfig bsConfig = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
        caps.setCapability("browserstack.user", authData.user());
        caps.setCapability("browserstack.key", authData.key());
        caps.setCapability("app", bsConfig.app());
        caps.setCapability("device", bsConfig.device());
        caps.setCapability("os_version", bsConfig.osVersion());
        caps.setCapability("project", bsConfig.project());
        caps.setCapability("build", bsConfig.build());
        caps.setCapability("name", bsConfig.name());
        try {
            return new RemoteWebDriver(
                    new URL(bsConfig.url()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}