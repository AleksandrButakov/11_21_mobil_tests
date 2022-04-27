package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:data.properties"
})

public interface BrowserStackConfig extends Config {

    @Key("url")
    String url();

    @Key("app")
    String app();

}