package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:params/android_emulator.properties"
})
public interface LocalConfig extends Config {

    @Key("localURL")
    String getLocalUrl();

    @Key("deviceName")
    String getDeviceName();

    @Key("platformVersion")
    String getPlatformVersion();

    @Key("appPackage")
    String getAppPackage();

    @Key("appActivity")
    String getAppActivity();

}
