package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class Random {
    public static String getRandomText() {
        return RandomStringUtils.random(
                Integer.parseInt(Parser.parse("countRandomText")),
                true,
                false
        );
    }
}