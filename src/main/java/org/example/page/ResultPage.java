package org.example.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResultPage extends AbstractPage{
    private final Logger logger = LoggerFactory.getLogger(ResultPage.class);

    private static final String VIEW_SEELECTION = "//span[text()='view selection']";

    @FindBy(how = How.XPATH, using = VIEW_SEELECTION)
    public WebElement viewSelectionButton;

    public ResultPage(WebDriver driver) {
        super(driver);
    }
    public void viewSelection(){
        logger.info("Attempting to click on viewSelectionButton.");
        try{
        waitForElementToBeClickable(viewSelectionButton);
        viewSelectionButton.click();
        } catch (Exception exception) {
            exception.printStackTrace();
            logger.error("Error while clicking viewSelectionButton: {}", exception.getMessage(), exception);
        }
    }
}
