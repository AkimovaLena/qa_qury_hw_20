package config;

import org.aeonbits.owner.Config;


@Config.Sources({
        "classpath:local.properties"
})
public interface LocalConfig extends Config {

    String version();

    String deviceName();

    String appPackage();

    String appActivity();

    String url();

    String appVersion();

    String appUrl();

    String appPath();

}