package test.java.com.restassuredatividade;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static io.restassured.RestAssured.get;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;
import main.java.com.restassuredatividade.GetStatusCode;
import io.restassured.http.ContentType;

public class GetStatusCodeTest {
    // @BeforeAll
    // public static void setup() {
    // RestAssured.baseURI = "https://axoltlapi.herokuapp.com/";
    // }

    @Test
    public void getStatusCodeOK() {
        RestAssured.baseURI = "https://axoltlapi.herokuapp.com/";
        String conteudo = given().get().then().assertThat().statusCode(200).extract().path("api_repo");
        assertEquals("https://github.com/AxolotlAPI/axolotl.py-api", conteudo);
    }

    @Test
    public void getStatusCodeNOK() {
        RestAssured.baseURI = "https://axoltlapi.herokuapp.com/";
        Response conteudo = given().get("/axolotlbasic.html").then().assertThat().statusCode(404).extract()
                .path("api_");
        assertEquals(null, conteudo);
    }
}
