package helpers;

import static io.restassured.RestAssured.given;

public class BrowserStack {
    public static String videoUrl(String sessionId) {
        return given()
                .auth().basic("aleksandrbutakov_KwWe1P", "oNza8nFrrqhYaCuJTa16")
                .when()
                .get("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionId + ".json")
                .then()
                .statusCode(200)
                .extract()
                // automation_session и video_url это путь в json файле к ссылке видео
                .path("automation_session.video_url");
    }

}