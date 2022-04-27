package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:data.properties"
})

public interface AuthConfig extends Config {

    @Key("user")
    String user();

    @Key("key")
    String key();

}