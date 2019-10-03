import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class Substract {

    @ParameterizedTest
    @CsvSource({"5,5,0", "-1,2,-3", "10,-1,11", "10,-15.5,25.5"})
    public void positiveResultForSubstract(Double one, Double two, Double result) {
        given()
                .log()
                .all()
                .params("one", one)
                .params("two", two)
                .when()
                .get("http://localhost:8080/substract")
                .then()
                .body("result", is(result.toString()))
                .log()
                .all();
    }

    @Test
    public void SubstractLetter() {
        given()
                .log()
                .all()
                .params("one", 5)
                .params("two", "k")
                .when()
                .get("http://localhost:8080/substract")
                .then()
                .body("message", containsString("NumberFormatException"))
                .log()
                .all();
    }

    @Test
    public void SubstractSpaceParam() {
        given()
                .log()
                .all()
                .params("one", " ")
                .params("two", " ")
                .when()
                .get("http://localhost:8080/substract")
                .then()
                .body("error", containsString("Internal Server Error"))
                .log()
                .all();
    }
}
