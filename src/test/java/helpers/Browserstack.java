package helpers;

import config.AuthConfigBS;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;


public class Browserstack {

    // curl -u "qaguru_ti9G5S:5yrxu4nFTKkRExUAhqxh" -X GET "https://api.browserstack.com/app-automate/sessions/0359d759d2aaa4f46401dac46bd281b6d9b24943.json"
    // automation_session.video_url

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);
        AuthConfigBS authData = ConfigFactory.create(AuthConfigBS.class, System.getProperties());

        return given()
                .auth().basic(authData.user(), authData.key())
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}