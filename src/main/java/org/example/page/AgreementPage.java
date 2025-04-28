package org.example.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class AgreementPage extends AbstractPage{

    private static final String AGREE_BUTTON = "j_idt42:j_idt44";
    @FindBy(how = How.ID, using = AGREE_BUTTON)
    public WebElement agreeButton;

    public AgreementPage(WebDriver driver) {
        super(driver);
    }

    public void acceprAgreement(){
        waitForElementToBeClickable(agreeButton);
        agreeButton.click();
    }
}
