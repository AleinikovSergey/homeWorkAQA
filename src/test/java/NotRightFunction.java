import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NotRightFunction {

    @Test
    public void NotRightFunction() {
        functionResult expectedResult = new functionResult("fail operation");
        functionResult actualResult =
                given()
                        .log()
                        .all()
                        .get("http://localhost:8080/asdsad")
                        .then()
                        .log()
                        .all()
                        .extract()
                        .as(functionResult.class);
        assertEquals(expectedResult, actualResult);
    }
}
