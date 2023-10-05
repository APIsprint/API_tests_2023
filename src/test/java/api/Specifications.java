package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.lessThan;

public class Specifications {

        public static RequestSpecification requestSpecification(String url){
            return new RequestSpecBuilder()
                    .setBaseUri(url)
                    .setContentType(ContentType.JSON)
                    .build();
        }

        public static ResponseSpecification responseSpecificationOK200(){
            return new ResponseSpecBuilder()
                    .expectResponseTime(lessThan(1000L))
                    .expectStatusCode(200)
                    .build();
        }

    public static ResponseSpecification responseSpecificationNotOK400(){
        return new ResponseSpecBuilder()
                .expectResponseTime(lessThan(1000L))
                .expectStatusCode(400)
                .build();
    }

    public static ResponseSpecification responseSpecificationUnique(int enterExpectedStatusCode){
        return new ResponseSpecBuilder()
                .expectResponseTime(lessThan(1000L))
                .expectStatusCode(enterExpectedStatusCode)
                .build();
    }

        public static void installSpecification(RequestSpecification request, ResponseSpecification response){
            RestAssured.requestSpecification = request;
            RestAssured.responseSpecification = response;
        }
    }


