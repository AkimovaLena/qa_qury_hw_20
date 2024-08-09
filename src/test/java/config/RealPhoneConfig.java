package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:real.properties"
})
public interface RealPhoneConfig extends Config {
    String deviceName();

    String appPackage();

    String appActivity();

    String url();

    String appVersion();

    String appUrl();

    String appPath();

    String appLanguage();

    String appLocale();

}
