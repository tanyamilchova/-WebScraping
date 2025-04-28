package org.example.page;

import org.example.service.TestDataReader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class SearchPage extends AbstractPage{
    private final Logger logger = LoggerFactory.getLogger(SearchPage.class);

    private static final String LAST_NAME = TestDataReader.getTestData("search-name");
    private static final String LAST_NAME_CONTAINER = "//input[@name='form:search_tab:lastname']";
    private static final String COURT_TYPE1 = "//li[text()='Appeal from County Court (AP)']";
    private static final String COURT_TYPE2 = "//li[text()='County Ordinance (CO)']";
    private static final String COURT_TYPE3 = "//li[text()='Traffic Infraction (TR)']";
    private static final String SEARCH_BUTTON = "//button[.//span[text()='Reset']]/preceding-sibling::button[.//span[text()='Search']]";
    private static final String I_FRAME = "//iframe[contains(@src, 'challenge-platform')]";


    @FindBy(how = How.XPATH, using = LAST_NAME_CONTAINER)
    public WebElement lastNameContainer;
    @FindBy(how = How.XPATH, using = COURT_TYPE1)
    public WebElement courtType1;
    @FindBy(how = How.XPATH, using = COURT_TYPE2)
    public WebElement courtType2;
    @FindBy(how = How.XPATH, using = COURT_TYPE3)
    public WebElement courtType3;
    @FindBy(how = How.XPATH, using = I_FRAME)
    public WebElement iFrame;

    @FindBy(how = How.XPATH, using = SEARCH_BUTTON)
    public WebElement searchButton;


    public SearchPage(WebDriver driver) {
        super(driver);
    }
    public void search(){
        logger.info("Starting the search process...");
        try {
        waitForElementToBeVisible(lastNameContainer);
        lastNameContainer.sendKeys(LAST_NAME);
        courtType1.click();
        courtType2.click();
        courtType3.click();
        waitForCaptchaToBeResolved();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchButton);
        waitForElementToBeClickable(searchButton);
        searchButton.click();
    } catch (Exception exception) {
            exception.printStackTrace();
            logger.error("Error occurred during search: {}", exception.getMessage(), exception);
    }
    }

    private void waitForCaptchaToBeResolved() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.invisibilityOf(iFrame));
    }
}
