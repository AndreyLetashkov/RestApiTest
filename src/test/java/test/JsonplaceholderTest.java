package test;

import adapters.Api;
import aquality.selenium.browser.AqualityServices;
import models.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Parser;
import utils.*;
import java.net.HttpURLConnection;
import java.util.List;
import org.testng.asserts.SoftAssert;

public class JsonplaceholderTest {

    @Test()
    void test() {
        SoftAssert softAssert =new SoftAssert();

        AqualityServices.getLogger().info("Get an object by making a request 'Get'.");
        List<UserId> actualId = new Api().getUserIdList();
        AqualityServices.getLogger().info("Make a copy of the User list and sort.");
        List<UserId> expectedID = Sort.sort(actualId);
        AqualityServices.getLogger().info("Compare sorted list with users and unsorted list with users.");
        softAssert.assertEquals(
                actualId,
                expectedID,
                "The list is not sorted in ascending order (by id)."
        );
        AqualityServices.getLogger().info("Compare status code.");
        softAssert.assertEquals(
                ScenarioContext.getInstance().get("statusCode"),
                HttpURLConnection.HTTP_OK,
                "status codes are different."
        );

        AqualityServices.getLogger().info("Get object from json file.");
        User expectedUser99 = Parser.parseUser("99.json");
        AqualityServices.getLogger().info("Get an object by making a request 'Get'.");
        User actualUser99 = new Api().getUser(99);
        AqualityServices.getLogger().info("Compare objects.");
        softAssert.assertEquals(actualUser99,
                expectedUser99,
                "Body is different."
        );
        AqualityServices.getLogger().info("Compare status code.");
        softAssert.assertEquals(
                ScenarioContext.getInstance().get("statusCode"),
                HttpURLConnection.HTTP_OK,
                "status codes are different."
        );

        AqualityServices.getLogger().info("Get String from json file.");
        String emptyJson = Parser.parse("emptyJson");
        AqualityServices.getLogger().info("Get an object by making a request 'Get'.");
        User actualUser150 = new Api().getUser(150);
        AqualityServices.getLogger().info("Compare Body.");
        softAssert.assertEquals(
                actualUser150.toString(),
                emptyJson,
                "Body is different."
        );
        AqualityServices.getLogger().info("Compare status code.");
        softAssert.assertEquals(
                ScenarioContext.getInstance().get("statusCode"),
                HttpURLConnection.HTTP_NOT_FOUND,
                "status codes are different."
        );

        AqualityServices.getLogger().info("Get expectedPerson.");
        Person expectedPerson = new Person(Random.getRandomText(), Random.getRandomText(), 1);
        AqualityServices.getLogger().info("Get actualPerson.");
        Person actualPerson = new Api().postPerson(expectedPerson, Parser.parse("headerKey"), Parser.parse("headerValue"));
        AqualityServices.getLogger().info("Compare Persons body.");
        softAssert.assertTrue(
                actualPerson.getBody().equals(expectedPerson.getBody()),
                "Body is different."
        );
        AqualityServices.getLogger().info("Compare status code.");
        softAssert.assertEquals(
                ScenarioContext.getInstance().get("statusCode"),
                HttpURLConnection.HTTP_CREATED,
                "status codes are different."
        );

        AqualityServices.getLogger().info("Get object from json file.");
        DifficultUser usersInList = Parser.parseDifficultUser("5.json");
        AqualityServices.getLogger().info("Get an object by making a request 'Get'.");
        List<DifficultUser> userInList = new Api().getDifficultUserList();
        AqualityServices.getLogger().info("Is there user with id 5 on the list?");
        Assert.assertTrue(
                userInList.contains(usersInList),
                "There isn't"
        );
        AqualityServices.getLogger().info("Compare status code.");
        softAssert.assertEquals(
                ScenarioContext.getInstance().get("statusCode"),
                HttpURLConnection.HTTP_OK,
                "status codes are different.");

        AqualityServices.getLogger().info("Get object from json file.");
        DifficultUser expectedResult = Parser.parseDifficultUser("5.json");
        AqualityServices.getLogger().info("Get an object by making a request 'Get'.");
        DifficultUser actualResult = new Api().getDifficultUser(5);
        AqualityServices.getLogger().info("Compare objects.");
        Assert.assertEquals(
                actualResult,
                expectedResult,
                "Body is different."
        );
        AqualityServices.getLogger().info("Compare status code.");
        softAssert.assertEquals(
                ScenarioContext.getInstance().get("statusCode"),
                HttpURLConnection.HTTP_OK,
                "status codes are different.");
        softAssert.assertAll();
    }
}