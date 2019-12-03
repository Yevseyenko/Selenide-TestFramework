package com.epam.core2;

import ch.qos.logback.classic.Logger;
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

public class RestAssuredClient implements Client {
    Logger logger =
            (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(this.getClass());

    private RequestSpecBuilder specification = new RequestSpecBuilder();

    private void setDomain() {
        logger.info("Request executed to: " + EndPoints.domain);
        this.specification.setBaseUri(EndPoints.domain);
    }

    private void setHeaders(String token) {
        this.specification.setAccept(ContentType.JSON)
                .setContentType("application/json")
                .addHeader("Authorization", "Bearer " + token);
    }

    public Response getRequest() {
        return given(specification.build()).get(EndPoints.users);
    }

    public Response postRequest() {
        return given(specification.build()).post(EndPoints.users);
    }

    public Response deleteRequest(String user) {
        return given(specification.build()).delete(String.format(EndPoints.usersByName, user));
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

    public Response getUsers() {
        setDomain();
        setHeaders(Propertiator.getTokenDomain());
        return getRequest();
    }

    public Response createUser(String firstName){
        return null;
    }
    public Response createUser(String firstName, String lastName, String gender, String email) {
        setDomain();
        setHeaders(Propertiator.getTokenDomain());
        initBody(firstName, lastName, gender, email);
        return postRequest();
    }

    public Response deleteUser(String user) {
        setDomain();
        setHeaders(Propertiator.getTokenDomain());
        return deleteRequest(user);
    }
}
