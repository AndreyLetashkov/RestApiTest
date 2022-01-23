package utils;

import aquality.selenium.browser.AqualityServices;
import models.UserId;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {
    public static List<UserId> sort(List<UserId> actualResult) {
        List<UserId> expectedResult = new ArrayList<>(actualResult);
        Collections.copy(expectedResult, actualResult);
        AqualityServices.getLogger().info("Sort a copy of the User list.");
        expectedResult.sort(Comparator.comparing(UserId::getId));
        return expectedResult;
    }
}