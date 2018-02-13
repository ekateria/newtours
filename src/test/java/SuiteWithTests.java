import org.junit.*;

import org.hamcrest.Matchers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SuiteWithTests {
    private static WebDriver driver;
    private String signOnPageUrl = "http://newtours.demoaut.com/mercurysignon.php";
    private String validName = "katok";
    private String validPassword = "katok";

    @Before
    public void setUp() {
        System.out.println("*******************");
        System.out.println("Launching chrome browser");
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if(driver!=null) {
            System.out.println("Closing chrome browser");
            driver.quit();
        }
    }

    // function to verify if the title of the current page is as expected
    private void verifyPageTitle(String titleExpected) {
        Assert.assertThat("Actual page title is not correct.",
                driver.getTitle().toLowerCase(),
                Matchers.equalTo(titleExpected.toLowerCase()));
    }

    // function to verify if the current page URL is as expected
    private void verifyPageUrl(String urlExpected) {
        Assert.assertThat("Actual page URL is not correct.",
                driver.getCurrentUrl(),
                Matchers.containsString(urlExpected));
    }

    @Test
    public void testHomePageTitle() {
        // given
        HomePage homePage = new HomePage(driver);

        // act
        homePage.open();

        //assert
        verifyPageTitle(HomePage.welcomePageTitle.toLowerCase());
    }

    @Test
    public void testLogInAsInvalidUser() {
        // given
        HomePage homePage = new HomePage(driver);
        homePage.open();

        // act
        homePage.login("xxx", "xxx");

        //assert
        verifyPageTitle("Sign-on: Mercury Tours".toLowerCase());
        verifyPageUrl(signOnPageUrl);
    }

    @Test
    public void testLogInAsValidUser() {
        // given
        HomePage homePage = new HomePage(driver);
        homePage.open();

        // act
        homePage.login(validName, validPassword);

        //assert
        verifyPageTitle(FindFlightPage.flightPageTitle);
        verifyPageUrl(FindFlightPage.flightSearchUrl);
    }

    @Test
    public void testNonLogedUserOpensFlightFinderPage() {
        // given
        HomePage homePage = new HomePage(driver);
        homePage.open();

        // act
        homePage.findFlight();

        //assert
        verifyPageTitle(HomePage.welcomePageTitle.toLowerCase());
        verifyPageUrl(HomePage.baseUrl);
    }

    @Test
    public void testLogedUserOpensFlightFinderPage() {
        // given
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.login(validName, validPassword);

        // act
        homePage.findFlight();

        // assert
        verifyPageUrl(FindFlightPage.flightSearchUrl);
        verifyPageTitle(FindFlightPage.flightPageTitle.toLowerCase());
        // assert that the current page has expected components
        FindFlightPage flightPage = new FindFlightPage(driver);
    }
}