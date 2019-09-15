package com.epam.taf.util;

import org.apache.commons.lang.RandomStringUtils;

public class StringUtils {
    public static String generateRandomName()
    {
        return RandomStringUtils.randomAlphanumeric(5);
    }
}
