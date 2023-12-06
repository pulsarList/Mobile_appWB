package helpers;

import config.RemoteConfig;
import org.aeonbits.owner.ConfigFactory;

import static helpers.CustomApiListener.withCustomTemplates;
import static io.restassured.RestAssured.given;


public class Browserstack {

    private static final String URL = "https://api.browserstack.com/app-automate/sessions/%s.json";

    public static String videoUrl(String sessionId) {
        RemoteConfig config = ConfigFactory.create(RemoteConfig.class);
        String urlVideo = String.format(URL, sessionId);
        return given()
                .filter(withCustomTemplates())
                .auth().basic(config.login(), config.password())
                .get(urlVideo)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
