package org.example.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelectCountryPage extends AbstractPage{

    private final Logger logger = LoggerFactory.getLogger(SelectCountryPage.class);
    public SelectCountryPage(WebDriver driver) {
        super(driver);
    }

    private static final String DROPDOWN_MENU = "div#form\\:county\n";
    private static final String CALHOUN_OPTION = "li[data-label=\"BRADFORD COUNTY CLERK OF COURT\"]\n";
    private static final String GO_BUTTON = "span.ui-button-text.ui-c";
    @FindBy(how = How.CSS, using = DROPDOWN_MENU)
    public WebElement dropdownMenu;
    @FindBy(how = How.CSS, using = CALHOUN_OPTION)
    public WebElement calhounOption;
    @FindBy(how = How.CSS, using = GO_BUTTON)
    public WebElement goButton;

    public void selectCountry() {
        logger.info("Selecting country from the dropdown...");
        try {
            dropdownMenu.click();
            waitForElementToBeClickable(calhounOption);
            calhounOption.click();
            goButton.click();
        } catch (Exception exception) {
            exception.printStackTrace();
            logger.error("Error while selecting country: {}", exception.getMessage(), exception);
        }
    }
}
