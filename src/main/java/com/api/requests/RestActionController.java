package com.api.requests;


import io.restassured.response.Response;

public class RestActionController {

    private RestSpecBuilder restSpecBuilder;

    public RestActionController(RestSpecBuilder restSpecBuilder) {
        this.restSpecBuilder = restSpecBuilder;
    }

    public Response hitGetRequest(String resourceUrl) {
        Response response = restSpecBuilder.getRequestSpecification().get(resourceUrl);
        return response;

    }

    public Response hitPostRequestWithBody(String resourceUrl, String requestBody) {
        System.out.println(resourceUrl);
        Response response = restSpecBuilder.getRequestSpecification().body(requestBody).post(resourceUrl);
        response.prettyPrint();
        return response;
    }

}
