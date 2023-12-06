package config;

import org.aeonbits.owner.Config;

@RemoteConfig.LoadPolicy(RemoteConfig.LoadType.MERGE)
@org.aeonbits.owner.Config.Sources(
        {"system:properties",
                "classpath:params/android_browserstack.properties",
                "classpath:params/android_browserstack_credentials.properties"})
public interface RemoteConfig extends Config {

    @Key("login")
    String login();

    @Key("password")
    String password();

    @Key("baseURL")
    String getBaseUrl();

    @Key("appURL")
    String getAppUrl();

    @Key("device")
    String getDevice();

    @Key("os_version")
    String getOSVersion();

    @Key("project")
    String getProjectName();

    @Key("build")
    String getBuildName();

    @Key("name")
    String getTestName();

}
