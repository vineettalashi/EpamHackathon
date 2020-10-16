package com.steps;


import com.api.requests.RestSpecBuilder;

import cucumber.api.java.en.Given;
import io.restassured.response.Response;


public class FeatureSteps {


    RestSpecBuilder restSpecBuilder;
    Response response;
    String jsonToPost;

    @Given("^I have the valid data to post$")
    public void iHaveTheDataToPost() throws Throwable {

    }
}
