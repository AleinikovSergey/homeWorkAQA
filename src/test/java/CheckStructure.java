import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class CheckStructure {

    @ParameterizedTest
    @CsvSource({"division,5,5,0", "multiply,-1,2,-3", "add,10,-1,11", "substract,10,-15.5,25.5"})
    public void positiveResultForSubstract(String funct, Double one, Double two, Double result) {
            given()
                .log()
                .all()
                .params("one", 5)
                .params("two", 2)
                .when()
                .get("http://localhost:8080/" +funct)
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("generated.json"))
                .log()
                .all();
    }
}
