package Config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties",
        "classpath:android.properties"
})
public interface BrowserstackConfig extends Config {

    String app();

    String device();

    String osVersion();

    String project();

    String build();

    String name();

    String url();
}
