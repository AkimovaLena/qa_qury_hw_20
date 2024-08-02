package Config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:personal.properties"
})
public interface PersonalPhoneConfig extends  Config{
    String version();
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
