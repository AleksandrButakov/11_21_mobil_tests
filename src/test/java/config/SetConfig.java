package config;

import org.aeonbits.owner.ConfigFactory;

public class SetConfig {

    public static BrowserStackConfig browserStackConfig = ConfigFactory
            .create(BrowserStackConfig.class, System.getProperties());

    public static AuthConfig authConfig = ConfigFactory
            .create(AuthConfig.class, System.getProperties());

}
