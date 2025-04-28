package org.example.page;

import org.example.exception.NotFoundException;
import org.example.util.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class DetailsPage extends AbstractPage{

    private final Logger logger = LoggerFactory.getLogger(DetailsPage.class);
    public DetailsPage(WebDriver driver) {
        super(driver);
    }
    private static final String FORM_HEADERS = "(//div[@class='ui-datatable-tablewrapper'])[1]//thead/tr";
    private static final String FORM_VALUES = "(//div[@class='ui-datatable-tablewrapper'])[1]//tbody";


    private static final String CHARGE_DETAILS_HEADERS = "//form[@id='form']//div[4]//thead//tr";
    private static final String CHARGE_DETAILS_VALUES = "//form[@id='form']//div[4]//tbody//tr";

    private static final String PARTY_DETAILS_TABLE_HEADERS = "//form[@id='form']//div[5]//div//table//thead/tr";
    private static final String PARTY_DETAILS_TABLE_VALUES = "//form[@id='form']//div[5]//div//table//tbody";

    private static final String DOCKET_PANEL_HEADERS= "//div[@id='form:docketpanel_content']//div[1]//table//thead//tr";
    private static final String DOCKET_PANEL_VALUES= "//div[@id='form:docketpanel_content']//div[1]//table//tbody";

    private static final String ASSIGNMENT_HISTORY_TOGGLE_PANEL= "//div[@id='form:judgeAssignmentHistorypanel']";
    private static final String ASSIGNMENT_HISTORY_HEADERS_PANEL= "//div[@id='form:judgeAssignmentHistorypanel']//div[2]//div//table//thead/tr";
    private static final String ASSIGNMENT_HISTORY_VALUES_PANEL= "//div[@id='form:judgeAssignmentHistorypanel']//div[2]//div//table//tbody";

    private static final String EVENT_PANEL_HEADERS = "//div[@id='form:courtEventpanel']//div[2]//div//div//table//thead//tr";
    private static final String EVENT_PANEL_VALUES = "//div[@id='form:courtEventpanel']//div[2]//div//div//table//tbody";
    private static final String EVENT_PANEL_TOGGLE = "//div[@id='form:courtEventpanel_header']";

    private static final String SENTENCES_PANEL_TOGGLE = "//div[@id='form:sentencepanel_header']";
    private static final String SENTENCES_PANEL_VALUES =  "//div[@id='form:sentencepanel']//div[2]//div//div//table/tbody";
    private static final String SENTENCES_PANEL =  "//span[contains(text(), 'Sentences')]";


    private static final String FINANCIAL_SUMAMRY_PANEL_TOGGLE = "//div[@id='form:financialSummaryPanel_header']";
    private static final String FINANCIAL_SUMAMRY_PANEL_TABLE_HEADERS = "//table[@id='form:financialSummaryTable']//thead//tr";
    private static final String FINANCIAL_SUMAMRY_PANEL_TABLE_VALUES = "//table[@id='form:financialSummaryTable']//tbody";

    private static final String FINANCIAL_SUMAMRY_PANEL_INFO_TABLE_HEADERS = "//div[@id='form:financialInfoTable']//div//table//thead//tr";
    private static final String FINANCIAL_SUMAMRY_PANEL_INFO_TABLE_VALUES = "//div[@id='form:financialInfoTable']//div//table//tbody";

    private static final String REOPEN_HISTORY_PANEL_TOGGLE = "//div[@id='form:reOpenHistorypanel_header']";
    private static final String REOPEN_HISTORY_PANEL_HEADERS = "//div[@id='form:reOpenHistorypanel_content']//div//div//table//thead//tr";
    private static final String REOPEN_HISTORY_PANEL_VALUES ="//div[@id='form:reOpenHistorypanel_content']//div//div//table//tbody";


    @FindBy(how = How.XPATH, using = FORM_HEADERS)
    public WebElement formHeaders;
    @FindBy(how = How.XPATH, using = FORM_VALUES)
    public WebElement formValues;

    @FindBy(how = How.XPATH, using = CHARGE_DETAILS_HEADERS)
    public WebElement chargeDetailsHeaders;
    @FindBy(how = How.XPATH, using = CHARGE_DETAILS_VALUES)
    public WebElement chargeDetailsValues;

    @FindBy(how = How.XPATH, using = PARTY_DETAILS_TABLE_HEADERS)
    public WebElement partyDetailsHeaders;
    @FindBy(how = How.XPATH, using = PARTY_DETAILS_TABLE_VALUES)
    public WebElement partyDetailsValues;

    @FindBy(how = How.XPATH, using = DOCKET_PANEL_HEADERS)
    public WebElement dockletPanelHeaders;
    @FindBy(how = How.XPATH, using = DOCKET_PANEL_VALUES)
    public WebElement dockletPanelValues;

    @FindBy(how = How.XPATH, using = ASSIGNMENT_HISTORY_TOGGLE_PANEL)
    public WebElement toggleAssignmentHistoryPanel;
    @FindBy(how = How.XPATH, using = ASSIGNMENT_HISTORY_HEADERS_PANEL)
    public WebElement assignmentHistoryHeaders;
    @FindBy(how = How.XPATH, using = ASSIGNMENT_HISTORY_VALUES_PANEL)
    public WebElement assignmentHistoryValues;

    @FindBy(how = How.XPATH, using = EVENT_PANEL_HEADERS)
    public WebElement eventPanelHeaders;
    @FindBy(how = How.XPATH, using = EVENT_PANEL_VALUES)
    public WebElement eventPanelValues;
    @FindBy(how = How.XPATH, using = EVENT_PANEL_TOGGLE)
    public WebElement toggleEventPanel;

    @FindBy(how = How.XPATH, using = SENTENCES_PANEL_TOGGLE)
    public WebElement toggleSentencesPanel;
    @FindBy(how = How.XPATH, using = SENTENCES_PANEL_VALUES)
    public WebElement sentencesPanelValues;
    @FindBy(how = How.XPATH, using = SENTENCES_PANEL)
    public WebElement sentencesPanel;

    @FindBy(how = How.XPATH, using = FINANCIAL_SUMAMRY_PANEL_TOGGLE)
    public WebElement toggleFinancialSummaryPanel;
    @FindBy(how = How.XPATH, using = FINANCIAL_SUMAMRY_PANEL_TABLE_HEADERS)
    public WebElement financialSummaryPanelHeaders;
    @FindBy(how = How.XPATH, using = FINANCIAL_SUMAMRY_PANEL_TABLE_VALUES)
    public WebElement financialSummaryPanelValues;

    @FindBy(how = How.XPATH, using = FINANCIAL_SUMAMRY_PANEL_INFO_TABLE_HEADERS)
    public WebElement financialSummaryPanelInfoHeaders;
    @FindBy(how = How.XPATH, using = FINANCIAL_SUMAMRY_PANEL_INFO_TABLE_VALUES)
    public WebElement financialSummaryPanelInfoValues;

    @FindBy(how = How.XPATH, using = REOPEN_HISTORY_PANEL_TOGGLE)
    public WebElement toggleReopenPanel;
    @FindBy(how = How.XPATH, using = REOPEN_HISTORY_PANEL_HEADERS)
    public WebElement reopenHistoryPanelHeaders;
    @FindBy(how = How.XPATH, using = REOPEN_HISTORY_PANEL_VALUES)
    public WebElement reopenHistoryPanelValues;


    String valueUCN = "";
    private List<List<Map<String, List<String>>>> recordDetails = new ArrayList<>();

    public void extractDetails(){
        List<Map<String, List<String>>> formDetails = extractFormDetails();
        List<Map<String, List<String>>> chargeDetails = extractChargeDetails();
        List<Map<String, List<String>>> partyDetails = extractPartyDetails();
        List<Map<String, List<String>>> docketDetails = extractDocketPanelDetails();
        List<Map<String, List<String>>> assignmentHistoryDetails = extractAssignmentHistoryPanelDetails();
        List<Map<String, List<String>>> eventDetails = extractEventPanelDetails();
        List<Map<String, List<String>>> sentencesDetails = extractSentencesPanelDetails();
        List<Map<String, List<String>>> financialSummaryDetails = extractFinancialSummaryPanelDetails();
        List<Map<String, List<String>>> reopenHystoryDetails = extractReopenHistoryPanelDetails();

        recordDetails.add(formDetails);
        recordDetails.add(chargeDetails);
        recordDetails.add(partyDetails);
        recordDetails.add(docketDetails);
        recordDetails.add(assignmentHistoryDetails);
        recordDetails.add(eventDetails);
        recordDetails.add(sentencesDetails);

        recordDetails.add(financialSummaryDetails);
        recordDetails.add(reopenHystoryDetails);

        String fileName = "detail-" + valueUCN + ".json";
        convertRecordsToJson(recordDetails, fileName);
    }


    public List<Map<String, List<String>>> extractFormDetails(){
        logger.debug("Starting extractFormDetails method.");

        List<Map<String, List<String>>> recordList = new ArrayList<>();
        try {
        List<String> headerList = extractTagElementsTexts(formHeaders, "th");
        List<List<String>> valuesList = extractTagElementsTextsWithTrows(formValues, "td");

        if (headerList.isEmpty() || valuesList.isEmpty()) {
            logger.warn("Headers or values list is empty.");
            throw new NotFoundException("Headers or values list is empty.");
        }

        Map<String, List<String>> recordMap= createMapHeadersListValues(headerList, valuesList);
        recordList.add(recordMap);

        List <String> valueUCNList = valuesList.get(0);
        if (!valueUCNList.isEmpty()) {
            String rawValueUCNText = getUCN(valueUCNList.get(0));
            valueUCN = extractTextUCN(rawValueUCNText);
        } else {
            logger.warn("UCN values list is empty.");
            throw new NotFoundException("UCN values list is empty.");
        }
        } catch (Exception exception) {
            exception.printStackTrace();
            logger.error("Unexpected error in extractFormDetails: {}", exception.getMessage(), exception);
            throw new NotFoundException("An unexpected error occurred.");
        }
        return recordList;
    }


    public List<Map<String, List<String>>> extractChargeDetails(){
        logger.debug("Starting extractChargeDetails method.");
        List<Map<String, List<String>>> recordList = new ArrayList<>();
        try {
        waitForElementToBeVisible(chargeDetailsHeaders);
        List<WebElement> cells = chargeDetailsHeaders.findElements(By.tagName("th"));
        List<String>headerList = Util.getTextNoBlank(cells);


        waitForElementToBeVisible(chargeDetailsValues);
        List<WebElement> values = chargeDetailsValues.findElements(By.tagName("td"));
        List<String>valuesTexts = Util.getTextNoBlank(values);
            if (headerList.isEmpty() || valuesTexts.isEmpty()) {
                logger.warn("Headers or values list is empty.");
                throw new NotFoundException("Headers or values list is empty.");
            }

        List<List<String>> valuesList = new ArrayList<>();
        valuesList.add(valuesTexts);

        Map<String, List<String>> recordMap= createMapHeadersListValues(headerList, valuesList);
        recordList.add(recordMap);
        } catch (NotFoundException exception) {
            exception.printStackTrace();
            logger.error("NotFoundException in extractChargeDetails: {}", exception.getMessage());
            throw exception;
        } catch (Exception exception) {
            exception.printStackTrace();
            logger.error("Unexpected error in extractChargeDetails: {}", exception.getMessage(), exception);
            throw new NotFoundException("An unexpected error occurred.");
        }

        logger.debug("extractFormDetails method completed.");
        return recordList;
    }


    public List<Map<String, List<String>>> extractPartyDetails(){
        logger.debug("Starting extractPartyDetails method.");
        List<Map<String, List<String>>> recordList = new ArrayList<>();
        try {
        List<String> headerList = extractTagElementsTexts(partyDetailsHeaders, "th");
        List<List<String>> valuesList = extractTagElementsTextsWithTrows(partyDetailsValues, "td");
            if (headerList.isEmpty() || valuesList.isEmpty()) {
                logger.warn("Headers or values list is empty.");
                throw new NotFoundException("Headers or values list is empty.");
            }

        Map<String, List<String>> recordMap= createMapHeadersListValues(headerList, valuesList);
        recordList.add(recordMap);

        } catch (NotFoundException exception) {
            exception.printStackTrace();
            logger.error("NotFoundException in extractPartyDetails: {}", exception.getMessage());
            throw exception;
        } catch (Exception exception) {
            exception.printStackTrace();
            logger.error("Unexpected error in extractPartyDetails: {}", exception.getMessage(), exception);
            throw new NotFoundException("An unexpected error occurred.");
        }
        logger.debug("extractPartyDetails method completed.");
        return recordList;
    }


    public List<Map<String, List<String>>> extractDocketPanelDetails(){
        logger.debug("Starting extractDocketPanelDetails method.");
        List<Map<String, List<String>>> recordList = new ArrayList<>();
        try {
        List<String> headerList = extractTagElementsTexts(dockletPanelHeaders, "th");
        List<List<String>> valuesList = extractTagElementsTextsWithTrows(dockletPanelValues, "td");
            if (headerList.isEmpty() || valuesList.isEmpty()) {
                logger.warn("Headers or values list is empty.");
                throw new NotFoundException("Headers or values list is empty.");
            }

        Map<String, List<String>> recordMap= createMapHeadersListValues(headerList, valuesList);
        recordList.add(recordMap);

        } catch (NotFoundException exception) {
            exception.printStackTrace();
            logger.error("NotFoundException in extractDocketPanelDetails: {}", exception.getMessage());
            throw exception;
        } catch (Exception exception) {
            exception.printStackTrace();
            logger.error("Unexpected error in extractDocketPanelDetails: {}", exception.getMessage(), exception);
            throw new NotFoundException("An unexpected error occurred.");
        }
        logger.debug("extractDocketPanelDetails method completed.");
        return recordList;
    }


    public List<Map<String, List<String>>> extractAssignmentHistoryPanelDetails(){
        logger.debug("Starting extractAssignmentHistoryPanelDetails method.");

        List<Map<String, List<String>>> recordList = new ArrayList<>();
        try {
        waitForElementToBeClickable(toggleAssignmentHistoryPanel);
        toggleAssignmentHistoryPanel.click();

        List<String> headerList = extractTagElementsTexts(assignmentHistoryHeaders, "th");
        List<List<String>> valuesList = extractTagElementsTextsWithTrows(assignmentHistoryValues, "td");
            if (headerList.isEmpty() || valuesList.isEmpty()) {
                logger.warn("Headers or values list is empty.");
                throw new NotFoundException("Headers or values list is empty.");
            }

        Map<String, List<String>> recordMap= createMapHeadersListValues(headerList, valuesList);
        recordList.add(recordMap);
        } catch (NotFoundException exception) {
            exception.printStackTrace();
            logger.error("NotFoundException in extractAssignmentHistoryPanelDetails: {}", exception.getMessage());
            throw exception;
        } catch (Exception exception) {
            exception.printStackTrace();
            logger.error("Unexpected error in extractAssignmentHistoryPanelDetails: {}", exception.getMessage(), exception);
            throw new NotFoundException("An unexpected error occurred.");
        }

        logger.debug("extractAssignmentHistoryPanelDetails method completed.");
        return recordList;
    }


    public List<Map<String, List<String>>> extractEventPanelDetails(){
        logger.debug("Starting extractEventPanelDetails method.");
        List<Map<String, List<String>>> recordList = new ArrayList<>();
        try {
        waitForElementToBeClickable(toggleEventPanel);
        toggleEventPanel.click();

        List<String> headerList = extractTagElementsTexts(eventPanelHeaders, "th");
        List<List<String>> valuesList = extractTagElementsTextsWithTrows(eventPanelValues, "td");
            if (headerList.isEmpty() || valuesList.isEmpty()) {
                logger.warn("Headers or values list is empty.");
                throw new NotFoundException("Headers or values list is empty.");
            }

        Map<String, List<String>> recordMap= createMapHeadersListValues(headerList, valuesList);
        recordList.add(recordMap);
        } catch (NotFoundException exception) {
            exception.printStackTrace();
            logger.error("NotFoundException in extractEventPanelDetails: {}", exception.getMessage());
            throw exception;
        } catch (Exception exception) {
            exception.printStackTrace();
            logger.error("Unexpected error in extractEventPanelDetails: {}", exception.getMessage(), exception);
            throw new NotFoundException("An unexpected error occurred.");
        }

        logger.debug("extractEventPanelDetails method completed.");
        return recordList;

    }


    public List<Map<String, List<String>>> extractSentencesPanelDetails(){
        logger.debug("Starting extractSentencesPanelDetails method.");
        List<Map<String, List<String>>> recordList = new ArrayList<>();
        try {
        waitForElementToBeClickable(toggleSentencesPanel);
        toggleSentencesPanel.click();

        String sentencesPaneltext = sentencesPanel.getText();
            if (sentencesPaneltext.trim().isEmpty()) {
                logger.warn("Sentences panel text is empty.");
                throw new NotFoundException("Sentences panel text is empty.");
            }

        List<String> headerList = new ArrayList<>();
        headerList.add(sentencesPaneltext);
        List<List<String>> valuesList = extractTagElementsTextsWithTrows(sentencesPanelValues, "td");
            if (valuesList.isEmpty()) {
                logger.warn("Sentences panel values are empty.");
                throw new NotFoundException("Sentences panel values are empty.");
            }

        Map<String, List<String>> recordMap= createMapHeadersListValues(headerList, valuesList);
        recordList.add(recordMap);
        } catch (NotFoundException e) {
            logger.error("NotFoundException in extractSentencesPanelDetails: {}", e.getMessage());
            throw e;
        } catch (Exception exception) {
            exception.printStackTrace();
            logger.error("Unexpected error in extractSentencesPanelDetails: {}", exception.getMessage(), exception);
            throw new NotFoundException("An unexpected error occurred.");
        }

        logger.debug("extractSentencesPanelDetails method completed.");
        return recordList;
    }


    public List<Map<String, List<String>>>  extractFinancialSummaryPanelDetails(){
        logger.debug("Starting extractFinancialSummaryPanelDetails method.");
        List<Map<String, List<String>>> recordList = new ArrayList<>();
        try {
        waitForElementToBeClickable(toggleFinancialSummaryPanel);
        toggleFinancialSummaryPanel.click();

        List<String> headerList = extractTagElementsTexts(financialSummaryPanelHeaders, "td");
        List<List<String>> valuesList = extractTagElementsTextsWithTrows(financialSummaryPanelValues, "td");
            if (headerList.isEmpty() || valuesList.isEmpty()) {
                logger.warn("Financial summary panel headers or values are empty.");
                throw new NotFoundException("Financial summary panel headers or values are empty.");
            }
        Map<String, List<String>> finSummaryMap = new LinkedHashMap<>();
        List<String> valueList = new ArrayList<>();
        for (List<String> list : valuesList ){
            valueList.addAll(list);
        }
        finSummaryMap.put(headerList.get(0), valueList);

        List<String> headerInfoList = extractTagElementsTexts(financialSummaryPanelInfoHeaders, "th");
        List<List<String>> valuesInfoList = extractTagElementsTextsWithTrows(financialSummaryPanelInfoValues, "td");
            if (headerInfoList.isEmpty() || valuesInfoList.isEmpty()) {
                logger.warn("Financial summary info headers or values are empty.");
                throw new NotFoundException("Financial summary info headers or values are empty.");
            }

        Map<String, List<String>> recordInfoMap= createMapHeadersListValues(headerInfoList, valuesInfoList);

        recordList.add(finSummaryMap);
        recordList.add(recordInfoMap);
        } catch (NotFoundException e) {
            logger.error("NotFoundException in extractFinancialSummaryPanelDetails: {}", e.getMessage());
            throw e;
        } catch (Exception exception) {
            exception.printStackTrace();
            logger.error("Unexpected error in extractFinancialSummaryPanelDetails: {}", exception.getMessage(), exception);
            throw new NotFoundException("An unexpected error occurred.");
        }

        return recordList;
    }


    public List<Map<String, List<String>>>  extractReopenHistoryPanelDetails(){
        logger.debug("Starting extractReopenHistoryPanelDetails method.");
        List<Map<String, List<String>>> recordList = new ArrayList<>();

        try {
        waitForElementToBeClickable(toggleReopenPanel);
        toggleReopenPanel.click();

        List<String> headerList = extractTagElementsTexts(reopenHistoryPanelHeaders, "th");
        List<List<String>> valuesList = extractTagElementsTextsWithTrows(reopenHistoryPanelValues, "td");
            if (headerList.isEmpty() || valuesList.isEmpty()) {
                logger.warn("Reopen history panel headers or values are empty.");
                throw new NotFoundException("Reopen history panel headers or values are empty.");
            }

        Map<String, List<String>> recordMap= createMapHeadersListValues(headerList, valuesList);

        recordList.add(recordMap);

        } catch (NotFoundException e) {
            logger.error("NotFoundException in extractReopenHistoryPanelDetails: {}", e.getMessage());
            throw e;
        } catch (Exception exception) {
            exception.printStackTrace();
            logger.error("Unexpected error in extractReopenHistoryPanelDetails: {}", exception.getMessage(), exception);
            throw new NotFoundException("An unexpected error occurred.");
        }

        return recordList;
    }


    public List<String> extractTagElementsTexts(WebElement element, String tag){
        try {
        waitForElementToBeVisible(element);
        List<WebElement> cells = element.findElements(By.tagName(tag));
        List<String>texts = Util.getTextNoBlank(cells);
        return texts;
        } catch (Exception exception) {
            exception.printStackTrace();
            logger.error("Error extracting tag elements texts for tag '{}' in element '{}': {}", tag, element, exception.getMessage(), exception);
            return Collections.emptyList();
        }
    }


    public List<List<String>> extractTagElementsTextsWithTrows(WebElement element, String tag){
        List<List<String>>valuesList = new ArrayList<>();
        try {
            waitForElementToBeVisible(element);
            List<WebElement> valuesTR = element.findElements(By.tagName("tr"));
            for (WebElement tr : valuesTR){
                List<WebElement> values = tr.findElements(By.tagName(tag));
                List<String>valuesTexts = Util.getTextNoBlank(values);
                valuesList.add(valuesTexts);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            logger.error("Error extracting tag elements texts with rows for tag '{}' in element '{}': {}", tag, element, exception.getMessage(), exception);
        }
        return valuesList;
    }


    private String getUCN(String cellValue) {
        if (cellValue == null || cellValue.isEmpty()) {
            logger.warn("getUCN called with null or empty value");
            return "Empty cellContent";
        }
        String[] cellContent = cellValue.split("\n");
        if(cellContent.length > 0){
            return cellContent[1];
        }  else {
        logger.warn("getUCN: No newline found in cellValue, returning default message");
        return "Empty cellContent";
        }
    }


    private String extractTextUCN(String value) {
        if (value == null || value.length() <= 2) {
            logger.warn("extractTextUCN called with invalid value: {}", value);
            return "Invalid UCN";
        }
       return value.substring(1, value.length()-1);
    }
}
