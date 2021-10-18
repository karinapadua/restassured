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
import io.restassured.http.ContentType;

public class GetStatusCodeTest {
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://theaxolotlapi.netlify.app/";
    }

    @Test
    public void getStatusCodeOK() {
        String conteudo = (String) given().get("/axolotlbasics.html").then().assertThat().statusCode(200).extract()
                .path("//b[contains(text(),'Axolotl basics')]");
        assertEquals("Axolotl basics", conteudo);
    }

    // @Test
    // public void getStatusCodeNOK() {
    // ValidatableResponse code =
    // given().get("/axolotlbasic.html").then().assertThat().statusCode(404);
    // assertEquals(404, code);
    // }
}
