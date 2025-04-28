package org.example.page;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.driver.FluentWaitImpementation;
import org.example.service.TestDataReader;
import org.example.util.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AbstractPage {

    protected WebDriver driver;
    protected FluentWaitImpementation waitFluent;

    private Logger logger = LoggerFactory.getLogger(AbstractPage.class);

    private String waitFluentTime = TestDataReader.getTestData("wait.fluent.time");

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        int waitTime = Util.getTime(waitFluentTime);
        waitFluent = new FluentWaitImpementation(driver, Duration.ofSeconds(waitTime));
        PageFactory.initElements(driver, this);
    }

    protected void waitForElementToBeVisible(WebElement element) {
        waitFluent.waitForElement(element);
    }

    protected void waitForElementToBeClickable(WebElement element) {
        waitFluent.waitForElement(element);
    }

    protected void convertRecordsToJson(List<List<Map<String, List<String>>>> tableData, String fileName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(tableData);

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(json);
            System.out.println("Data saved to tableData.json");
        } catch (Exception exception) {
            exception.printStackTrace();

        }
    }

    protected Map<String, List<String>> createMap(List<String> headers, List<String> values) {
        Map<String, List<String>> recordSectionOneMap = new LinkedHashMap<>();
        for (int i = 0; i < headers.size(); i++) {
            List<String> valueList = new ArrayList<>();
            if (i < values.size()) {
                valueList.add(values.get(i));
            } else {
                valueList.add("");
            }
            recordSectionOneMap.put(headers.get(i), valueList);
        }
        return recordSectionOneMap;
    }

    protected Map<String, List<String>> createMapHeadersListValues(List<String> headers, List<List<String>> values) {
        Map<String, List<String>> recordMap = new LinkedHashMap<>();
        if (values.isEmpty()) {
            return recordMap;
        }

        int columnCount = headers.size();
        int rowCount = values.size();

        for (int j = 0; j < columnCount; j++) {
            List<String> valueList = new ArrayList<>();
            for (int i = 0; i < rowCount; i++) {
                List<String> row = values.get(i);
                if (j < row.size()) {
                    valueList.add(row.get(j));
                } else {
                    valueList.add("");
                }
            }
            recordMap.put(headers.get(j), valueList);
        }
        return recordMap;
    }
}