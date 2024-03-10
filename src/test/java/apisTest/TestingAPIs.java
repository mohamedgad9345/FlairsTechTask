package apisTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestingAPIs {

    String deleteBody ="{\"ids\":[48]}";
    String body = "{\n" +
            "    \"firstName\": \"mhmd\",\n" +
            "    \"middleName\": \"sayed\",\n" +
            "    \"lastName\": \"Gad\",\n" +
            "    \"email\": \"test@test.io\",\n" +
            "    \"contactNumber\": null,\n" +
            "    \"keywords\": null,\n" +
            "    \"comment\": null,\n" +
            "    \"dateOfApplication\": \"2024-03-10\",\n" +
            "    \"consentToKeepData\": false,\n" +
            "    \"vacancyId\": 9\n" +
            "}";


    @Test
    public void addNewRecord(){
        given().baseUri("https://opensource-demo.orangehrmlive.com/web/index.php")
                .contentType(ContentType.JSON)
                .body(body)
                .log().all()
                .when()
                .post("/api/v2/recruitment/candidates")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void deleteRecord(){
        given().baseUri("https://opensource-demo.orangehrmlive.com/web/index.php/api/v2/recruitment/candidates")
                .contentType(ContentType.JSON)
                .body(deleteBody)
                .log().all()
                .when()
                .delete()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);

    }
}
