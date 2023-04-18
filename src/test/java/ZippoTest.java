import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


// pm                                               // Rest Assured
// pm.response.json().'post code'                   // body("'post code'", ...)
// pm.response.json().places[0].'place name'        // body("places[0].'place name'", ...)

public class ZippoTest {
    @Test
    public void test() {

        given()  // preparation (token, request body, parameters, cookies...)

                .when() // for url and request method (get, post, put, delete)

                .then(); // response body, assertions, extract data from the response

    }

    @Test
    public void statusCodeTest() {

        given()

                .when()
                .get("http://api.zippopotam.us/us/90210")
                .then()
                .log().body() // prints the response body
                .log().status() // prints the status
                .statusCode(200); // checks if the status code is 200
    }

    @Test
    public void contentTypeTest() {

        given()

                .when()
                .get("http://api.zippopotam.us/us/90210")

                .then()
                .log().body()
                .statusCode(200)
                .contentType(ContentType.JSON); // checks if the response is in JSON format
    }

    @Test
    public void checkCountryFromResponseBody() {
        given()
                .when()
                .get("http://api.zippopotam.us/us/90210")
                .then()
                .log().body()
                .body("country", equalTo("United States"));

    }
    @Test
    public void checkStateFromResponse(){
        given()

                .when()
                .get("http://api.zippopotam.us/tr/")
    }

}