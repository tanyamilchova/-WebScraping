package org.example.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OnlineCourtRecordsSearchPage extends AbstractPage{
    private final Logger logger = LoggerFactory.getLogger(OnlineCourtRecordsSearchPage.class);

    private static final String PUBLIC_BUTTON = "#j_idt47\\:j_idt50";
    @FindBy(how = How.CSS, using = PUBLIC_BUTTON)
    public WebElement publicButton;

    public OnlineCourtRecordsSearchPage(WebDriver driver) {
        super(driver);
    }

    public void selectAccessOption(){
        try {
        logger.info("Attempting to select the access option.");
        waitForElementToBeVisible(publicButton);
        publicButton.click();
    }  catch (Exception exception) {
            exception.printStackTrace();
            logger.error("Error while selecting the access option: {}", exception.getMessage());
        }
    }
}
