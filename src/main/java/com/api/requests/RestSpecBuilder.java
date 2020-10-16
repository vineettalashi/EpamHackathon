package com.api.requests;

import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.specification.RequestSpecification;
import javax.ws.rs.core.MediaType;
import java.util.Map;

public class RestSpecBuilder {

    RequestSpecification requestSpecification;

    public RestSpecBuilder() {

        requestSpecification = RestAssured.given().log().all();
    }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }

    public RestSpecBuilder setPort(int value) {
        requestSpecification.port(value);
        return this;
    }
    public RestSpecBuilder setBaseUrl(String url) {
        requestSpecification.baseUri(url);
        return this;
    }


    public RestSpecBuilder setContentTypeJson() {
        requestSpecification.contentType(MediaType.APPLICATION_JSON);
        return this;
    }

    public RestSpecBuilder setAcceptasJson() {
        requestSpecification.accept(MediaType.APPLICATION_JSON);
        return this;
    }

    public RestSpecBuilder setParam(String key, String value) {
        requestSpecification.param(key, value);
        return this;
    }

    public RestSpecBuilder setHeaders(Map<String, String> headerMap) {
        requestSpecification.headers(headerMap);
        return this;
    }

    public RestSpecBuilder setCookies(Cookie cookies){
        requestSpecification.cookie(cookies);
        return this;
    }
}
