import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class Multiply {

    @ParameterizedTest
    @CsvSource({"5,5,25", "5,0,0", "5,2.5,12.5", "-5,-4.5,22.5", "-1,0.5,0.5",})
    public void positiveResultForMultiply(Double one, Double two, Double result) {
        given()
                .log()
                .all()
                .params("one", one)
                .params("two", two)
                .when()
                .get("http://localhost:8080/division")
                .then()
                .body("result", is(result.toString()))
                .log()
                .all();
    }

    @Test
    public void MultiplyByLetter() {
        given()
                .log()
                .all()
                .params("one", 5)
                .params("two", "k")
                .when()
                .get("http://localhost:8080/multiply")
                .then()
                .body("message", containsString("NumberFormatException"))
                .log()
                .all();
    }

    @Test
    public void MultiplyBySpaceParam() {
        given()
                .log()
                .all()
                .params("one", "5")
                .params("two", " ")
                .when()
                .get("http://localhost:8080/multiply")
                .then()
                .body("error", containsString("Internal Server Error"))
                .log()
                .all();
    }
}

