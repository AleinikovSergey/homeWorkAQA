import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class Division {
    @ParameterizedTest
    @CsvSource({"50,5,10", "-10,5,-2", "-10,-2,5", "10,3,3.3333333333333335", "-10,5,-2", "0,10,0",
                "-10,5,-2", "-5,2.3,-2.173913043478261"})
    public void positiveResultForDivision(Double one, Double two, Double result) {
        given()
                .log()
                .all()
                .params("one", one)
                .params("two", two)
                .when()
                .get("http://localhost:8080/division")
                .then()
                .body("result", is (result.toString()))
                .log ()
                .all();
    }


        @Test
        public void DivisionByZero() {
            given()
                    .log ()
                    .all()
                    .params("one",5 )
                    .params("two", 0)
                    .when()
                    .get("http://localhost:8080/division")
                    .then()
                    .body("result", containsString ("Infinity"))
                    .log ()
                    .all();
        }
    @Test
    public void DivisionByLetter() {
        given()
                .log ()
                .all()
                .params("one",5 )
                .params("two", "k")
                .when()
                .get("http://localhost:8080/division")
                .then()
                .body("message", containsString ("NumberFormatException"))
                .log ()
                .all();
    }
}



