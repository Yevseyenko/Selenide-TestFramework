package com.epam.core2.client;

import ch.qos.logback.classic.Logger;
import com.epam.core2.constants.EndPoints;
import com.epam.core2.models.User;
import com.epam.core2.utils.JsonUtils;
import com.epam.core2.utils.Propertiator;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static io.restassured.RestAssured.given;

public class RestAssuredClient implements InterfaceClient {

    private Logger logger =
            (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(this.getClass());

    private RequestSpecBuilder specification = new RequestSpecBuilder();


    private void setBasePath() {
        logger.info("Request executed to: " + EndPoints.domain);
        RestAssured.basePath = EndPoints.domain;
    }

    private void setEndPoint() {
        this.specification.setBaseUri(EndPoints.users);
    }

    private void setUserEndPoint(String user) {
        this.specification.setBaseUri(EndPoints.usersByName + user);
    }

    private void setHeaders(String token) {
        this.specification.setAccept(ContentType.JSON)
                .setContentType("application/json")
                .addHeader("Authorization", "Bearer " + token);
    }

    private Response getRequest(String name) {
        return given(specification.build()).get(EndPoints.usersByName + name);
    }

    private Response postRequest() {
        return given(specification.build()).post(EndPoints.users);
    }

    private Response deleteRequest(String user) {
        return given(specification.build()).delete(String.format(EndPoints.usersByName, user));
    }

    public RequestSpecBuilder getSpecification() {
        return specification;
    }

    private void initBody(String firstName, String lastName, String gender, String email) {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(System.getProperty("user.dir") + "/src/main/resources/newUser.json"), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String body = contentBuilder.toString();
        logger.info("Request body set to: " + String.format(body, firstName, lastName, gender, email));
        this.specification.setBody(String.format(body, firstName, lastName, gender, email));
    }

    private void initBody(User user) {
        this.specification.setBody(JsonUtils.getJsonStringFromObject(user));
    }

    public Response getUsers() {
        setEndPoint();
        setHeaders(Propertiator.getTokenDomain());
       return given(specification.build()).get();
    }

    public Response createUser(User user) {
        setBasePath();
        setHeaders(Propertiator.getTokenDomain());
        initBody(user);
        return postRequest();
    }

    public Response getUserByName(String name) {
        setUserEndPoint(name);
        setHeaders(Propertiator.getTokenDomain());
        return getRequest(name);
    }

    public Response createUser(String firstName, String lastName, String gender, String email) {
        setHeaders(Propertiator.getTokenDomain());
        initBody(firstName, lastName, gender, email);
        return postRequest();
    }

    private Response deleteUser(String user) {
        setBasePath();
        setHeaders(Propertiator.getTokenDomain());
        return deleteRequest(user);
    }

    public String getUsersResponse(){
        return getUsers().then().extract().body().asString();
    }

    @Override
    public int getUsersStatusCode() {
        return getUsers().then().extract().statusCode();
    }

    @Override
    public int getCreateUserStatusCode(User user) {
        return createUser(user)
                .then()
                .extract()
                .statusCode();
    }

    @Override
    public String getUserByFirstNameResponse(String userName) {
        return getUserByName(userName).then().extract().body().jsonPath().get("result").toString();
    }

    @Override
    public int getDeleteUserStatusCode(String userName) {
        return deleteUser(userName).then().extract().statusCode();
    }
}
