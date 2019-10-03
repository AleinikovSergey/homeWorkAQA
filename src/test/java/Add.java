import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class Add {

    @ParameterizedTest
    @CsvSource({"5,5,10", "-1,2,1", "-1,-1,-2", "-1,1.5,0.5"})
    public void positiveResultForAdd(Double one, Double two, Double result) {
        given()
                .log()
                .all()
                .params("one", one)
                .params("two", two)
                .when()
                .get("http://localhost:8080/add")
                .then()
                .body("result", is(result.toString()))
                .log()
                .all();
    }

    @Test
    public void AddLetter() {
        given()
                .log()
                .all()
                .params("one", 5)
                .params("two", "k")
                .when()
                .get("http://localhost:8080/add")
                .then()
                .body("message", containsString("NumberFormatException"))
                .log()
                .all();
    }

    @Test
    public void AddSpaceParam() {
        given()
                .log()
                .all()
                .params("one", " ")
                .params("two", " ")
                .when()
                .get("http://localhost:8080/add")
                .then()
                .body("error", containsString("Internal Server Error"))
                .log()
                .all();
    }
}
