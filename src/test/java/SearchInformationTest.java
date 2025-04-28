import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.page.*;
import org.example.service.TestDataReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.example.driver.WebDriverSingleton.getDriver;

public class SearchInformationTest extends AbstractTest{
    private static final Logger logger = LogManager.getLogger(SearchInformationTest.class);
    private final String SELECT_COUNTRY_URL = "select-country-url";
    private SelectCountryPage selectCountryPage;
    private OnlineCourtRecordsSearchPage onlineCourtRecordsSearchPage;
    private AgreementPage agreementPage;
    private SearchPage searchPage;
    private ResultPage resultPage;
    private CaseSummaryPage caseSummaryPage;
    private DetailsPage detailsPage;


    @BeforeMethod
    public void setUpTest() {
        driver = getDriver();
        selectCountryPage = new SelectCountryPage(driver);
        onlineCourtRecordsSearchPage = new OnlineCourtRecordsSearchPage(driver);
        agreementPage = new AgreementPage(driver);
        searchPage = new SearchPage(driver);
        resultPage = new ResultPage(driver);
        caseSummaryPage = new CaseSummaryPage(driver);
        detailsPage = new DetailsPage(driver);

    }

    @Test
    public void scrapInformation(){
        driver.get(TestDataReader.getTestData(SELECT_COUNTRY_URL));
        selectCountryPage.selectCountry();
        onlineCourtRecordsSearchPage.selectAccessOption();
        agreementPage.acceprAgreement();
        searchPage.search();
        resultPage.viewSelection();
        caseSummaryPage.extractTableData();
        detailsPage.extractDetails();
    }
}
