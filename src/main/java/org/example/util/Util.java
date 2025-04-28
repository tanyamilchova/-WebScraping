package org.example.util;

import org.example.exception.PropertyException;
import org.example.service.TestDataReader;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Util {

    private static final Logger logger = LoggerFactory.getLogger(Util.class);

    public static List<String> getTextNoBlank(List<WebElement> elements){
        List<String>cellTexts = new ArrayList<>();
        for (WebElement cell : elements){
            String cellName = cell.getText().trim();
                cellTexts.add(cellName);
        }
        return cellTexts;
    }

    public static int parseIntSafe(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            logger.error("Invalid number format for value '{}'.", value, e);
            throw new PropertyException("Invalid number format for value: " + value);
        }
    }
    public static int getTime(String time) {
        try {
            return Util.parseIntSafe(time);
        } catch (PropertyException exception) {
            logger.warn("Error parsing time. Using default time: " + TestDataReader.getTestData("wait.default.time"));
            return parseIntSafe(TestDataReader.getTestData("wait.default.time"));
        }
    }
}
