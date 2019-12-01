package core2;

import ch.qos.logback.classic.Logger;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.slf4j.LoggerFactory;

public class RestClient {
    Logger logger =
            (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(this.getClass());
    private RequestSpecBuilder specification = new RequestSpecBuilder();

    private void setHeadlineDomain() {
        //move to constants
        String domain = "https://gorest.co.in" + Endpoints.users;
        logger.info("Request executed to: " + domain);
        this.specification.setBaseUri(domain);
    }

    public void setHeaders() {
        this.specification.setAccept(ContentType.JSON).setContentType("application/json");

    }

    public Response getUsersRequest() {
        return this.specification.addHeader(
                "Authorization", "Bearer UmRV1gczwTB7swW31-SgZ9vke5Vg6O8mAJ6N").build()
                .get();
    }

    public static void main(String[] args) {
        RestClient restClient = new RestClient();
        restClient.setHeadlineDomain();
        restClient.setHeaders();
        Response er = restClient.getUsersRequest();
        System.out.println(er.asString());
    }
}
