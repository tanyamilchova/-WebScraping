package org.example.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CaseSummaryPage extends AbstractPage {
    private final Logger logger = LoggerFactory.getLogger(CaseSummaryPage.class);

    private List<String> theadersText = null;

    private static final String ROWS = "//tbody[@id='caseSummary:tbl_data']/tr[@role='row']";

    private static final String HEAD1 = "#caseSummary\\:tbl_head .ui-state-default.ui-sortable-column";
    private static final String TABLE_DATA = "caseSummary:tbl_data";
    private static final String FIRST_RECORD_LINK = "//tbody[@id='caseSummary:tbl_data']/tr[@role='row'][1]//a";

    private static final String TBODIES_XPATH = "//tr[contains(@class, 'ui-expanded-row-content') and contains(@class, 'ui-widget-content')]";
    private static final String NAME_TYPE_HEADERS_ONE = "caseSummaryDiv";
    private static final String NAME_TYPE_HEADERS_TWO = "(//div[@class='ui-grid-row']/*[2])";


    @FindBy(xpath = ROWS)
    private List<WebElement> rows;

    @FindBy(how = How.ID, using = TABLE_DATA)
    public WebElement table_data;
    @FindBy(how = How.XPATH, using = FIRST_RECORD_LINK)
    public WebElement firstRecordLink;

    @FindBy(xpath = NAME_TYPE_HEADERS_TWO)
    private List<WebElement> nameTypeHeadersTwo;
    @FindBy(how = How.XPATH, using = TBODIES_XPATH)
    private List<WebElement> tbodies;
    @FindBy(how = How.ID, using = NAME_TYPE_HEADERS_ONE)
    private List<WebElement> nameTypeHeaders;

    public CaseSummaryPage(WebDriver driver) {
        super(driver);
    }


    public void extractTableData() {
        waitForElementToBeVisible(table_data);
        List<List<Map<String, List<String>>>> tableData = new ArrayList<>();

        for (int rowNum = 0; rowNum < rows.size(); rowNum++) {
            WebElement row = rows.get(rowNum);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", row);

            List<Map<String, List<String>>> record = new ArrayList<>();

            Map<String, List<String>> firstMap = extractCaseSummarySectionOne( row);
            Map<String, List<String>> secondMap = extractCaseSummarySectionTwo(rowNum);
            Map<String, List<String>> thirdMap = extractCaseSummarySectionTree(rowNum);
            Map<String, List<String>> fourthMap = extractCaseSummarySectionFour(rowNum);

            record.add(firstMap);
            record.add(secondMap);
            record.add(thirdMap);
            record.add(fourthMap);

            tableData.add(record);
        }
        convertRecordsToJson(tableData, "summary.json");

        waitForElementToBeClickable(firstRecordLink);
        firstRecordLink.click();
    }



    private Map<String, List<String>> extractCaseSummarySectionFour(int rowNum) {
        logger.debug("Extracting section four for row: {}", rowNum);
        try{
        List<String> headerName2 = getHeaderValuesFromTBody(nameTypeHeadersTwo.get(rowNum), "thead", "th" );
        List<String> headerNameValue2 = getHeaderValuesFromTBody(nameTypeHeadersTwo.get(rowNum), "tbody", "td" );

        logger.debug("Header and values for section four extracted.");
        return createMap(headerName2, headerNameValue2);
        } catch (Exception e) {
            logger.error("Error extracting section four for row: {}: {}", rowNum, e.getMessage(), e);
            throw new RuntimeException("Error extracting section four", e);
        }
    }

    private Map<String, List<String>> extractCaseSummarySectionTree(int rowNum) {
        logger.debug("Extracting section three for row: {}", rowNum);
        try {
        List<String> headerName = getHeaderValuesFromTBody(nameTypeHeaders.get(rowNum), "thead", "th" );
        List<String> headerNameValue = getHeaderValuesFromTBody(nameTypeHeaders.get(rowNum), "tbody", "td" );
        logger.debug("Header and values for section three extracted.");
        return createMap(headerName, headerNameValue);
        } catch (Exception e) {
            logger.error("Error extracting section three for row: {}: {}", rowNum, e.getMessage(), e);
            throw new RuntimeException("Error extracting section three", e);
        }
    }

    private Map<String, List<String>> extractCaseSummarySectionTwo(int rowNum) {
        logger.debug("Extracting section two for row: {}", rowNum);
        try {
        if(rowNum == 0) {
            theadersText = getHeaderValuesFromTBody(tbodies.get(rowNum), "thead", "th");
        }
        List<String> tbodiesText = getHeaderValuesFromTBody(tbodies.get(rowNum), "tbody", "td");

        logger.debug("Tbody text for row {}: {}", rowNum, tbodiesText);
        return createMap(theadersText, tbodiesText);
        } catch (Exception e) {
            logger.error("Error extracting section two for row: {}: {}", rowNum, e.getMessage(), e);
            throw new RuntimeException("Error extracting section two", e);
        }
    }


    private  Map<String, List<String>> extractCaseSummarySectionOne(WebElement row) {
        logger.debug("Extracting section one.");
        try{
            List<String> headerList = getHeaderList(HEAD1);
            List<String> valueList = getHeaderValues(row);
            return  createMap(headerList, valueList);
        } catch (Exception e) {
            logger.error("Error extracting section one",e);
            throw new RuntimeException("Error extracting section one", e);
        }
    }

    public List<String> getHeaderList(String selector){
        List<WebElement> headerColNames = waitFluent.waitForElements(By.cssSelector(selector));
        List< String> headerList = new ArrayList<>();
        if (headerColNames == null || headerColNames.isEmpty()) {
            logger.warn("No header elements found for selector: {}", selector);
            throw new IllegalArgumentException("No header elements found");
        }
        for (int i = 0; i < headerColNames.size(); i++) {
            try {
                WebElement row = headerColNames.get(i);
                WebElement spanElement = row.findElement(By.cssSelector("span.ui-column-title"));
                String columnName = spanElement.getText().trim();

                headerList.add(columnName);
            } catch (NoSuchElementException e) {
                logger.error("No span element found ", e);
            } catch (Exception e) {
                logger.error("Unexpected error while extracting column name: {}", e.getMessage(), e);
            }
        }
        return headerList;
    }


    public List<String> getHeaderValues(WebElement row) {
        List<String> rowData = new ArrayList<>();
        List<WebElement> cells = waitFluent.waitForElements(By.tagName("td"));
        for (WebElement cell : cells) {
            String cellText = cell.getText().trim();
            rowData.add(cellText);
        }
        return rowData;
    }

    public List<String> getHeaderValuesFromTBody(WebElement row, String element, String tag) {
        List<String> rowData = new ArrayList<>();
        waitForElementToBeVisible(row);
        WebElement tbody = row.findElement(By.tagName(element));
        List<WebElement> cells = tbody.findElements(By.tagName(tag));

        for (WebElement cell : cells) {
            String cellText = cell.getText().trim();
            rowData.add(cellText);
        }
        return rowData;
    }
}

