package com.almosafer.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ALMOSAFER_TASK {
    ExtentReports extent;
    ExtentSparkReporter sparkReporter;
    ExtentTest test;
    long maxAllowedResponseTime = 2000;

    private static final String BASE_URL = "https://global.almosafer.com/";

    @BeforeClass
    public void setUp() {
        extent = new ExtentReports();
        sparkReporter = new ExtentSparkReporter("target/extent-report.html");
        extent.attachReporter(sparkReporter);

        RestAssured.baseURI = BASE_URL;
    }

    @Test
    public void GET_FlightsMainPage() {

        test = extent.createTest("FlightsMainPage_GET_API");

        Response response = RestAssured
                .given()
                // Usually we write here the header and params
                .when().get("en/flights-home")
                .then().statusCode(200) // Validate the response code
                .extract().response();

        // Validate response
        Assert.assertNotNull(response.getBody());
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.getTime() < maxAllowedResponseTime,
                "Response time is too long: " + response.getTime() + " ms");

        // Log results to Extent Report
        test.info("Response Body: " + response.getBody().asString());
        test.info("Status Code: " + response.getStatusCode());
        test.pass("GET request to /flights-home was successful.");
        test.info("Response Time: " + response.getTime() + " ms");
    }

    // *******************************First The GET APIs*****************************************

    @Test
    public void GET_aboutUsPage() {

        test = extent.createTest("aboutUsPage_GET_API");

        Response response = RestAssured
                .given()
                .when().get("en/about-us")
                .then().statusCode(200)
                .extract().response();

        Assert.assertNotNull(response.getBody());

        // Another way of asserting the API Response
        if (response.getStatusCode() == 200) {
            test.pass("GET request to /about-us was successful." + response.getStatusCode());
        } else {
            test.fail("GET request to /about-us failed, Status Code: " + response.getStatusCode());
        }
        Assert.assertTrue(response.getTime() < maxAllowedResponseTime,
                "Response time is too long: " + response.getTime() + " ms");

        test.info("Response Body: " + response.getBody().asString());
        test.info("Status Code: " + response.getStatusCode());
        test.info("Response Time: " + response.getTime() + " ms");
    }
    // *******************************Now The POST API*****************************************

    @Test
    public void POST_CMSPage() {

        test = extent.createTest("CMSPage_POST_API");

        String requestBody = "{"
                + "\"origins\": [{"
                + "\"id_airport\": \"88740\","
                + "\"iata\": \"RUH\","
                + "\"name\": \"King Khaled International Airport\","
                + "\"main_city_name\": \"Riyadh\","
                + "\"country_code\": \"SA\","
                + "\"country_name\": \"Saudi Arabia\","
                + "\"type\": \"2\","
                + "\"destinations\": [{"
                + "\"id_airport\": \"428\","
                + "\"iata\": \"JED\","
                + "\"name\": \"King Abdulaziz International Airport\","
                + "\"main_city_name\": \"Jeddah\","
                + "\"country_code\": \"SA\","
                + "\"country_name\": \"Saudi Arabia\","
                + "\"type\": \"2\""
                + "}, {"
                + "\"id_airport\": \"515\","
                + "\"iata\": \"DXB\","
                + "\"name\": \"Dubai Airport\","
                + "\"main_city_name\": \"Dubai\","
                + "\"country_code\": \"AE\","
                + "\"country_name\": \"United Arab Emirates\","
                + "\"type\": \"1\""
                + "}]"
                + "}]"
                + "}";

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("api/cms/page")
                .then()
                .statusCode(200)
                .extract()
                .response();

        Assert.assertNotNull(response.getBody());
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.getTime() < maxAllowedResponseTime,
                "Response time is too long: " + response.getTime() + " ms");

        // Log results to Extent Report
        if (response.getStatusCode() == 200) {
            test.pass("POST request to api/cms/page was successful." + response.getStatusCode());
        } else {
            test.fail("POST request to api/cms/page failed, Status Code: " + response.getStatusCode());
        }

        test.info("Status Code: " + response.getStatusCode());
        test.info("Response Time: " + response.getTime() + " ms");


    }

    @AfterClass
    public void tearDown() {

        extent.flush();
    }
}
