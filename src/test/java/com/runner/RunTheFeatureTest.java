package com.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "pretty", "html:target/cucumber" },
        glue = "com.steps",
        features = "classpath:features"
)
public class RunTheFeatureTest {
}
