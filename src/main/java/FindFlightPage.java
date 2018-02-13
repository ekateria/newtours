import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindFlightPage {
    public static String flightSearchUrl = "http://newtours.demoaut.com/mercuryreservation.php";
    public static String flightPageTitle = "Find a Flight: Mercury Tours:";
    private WebDriver flightDriver;

    private WebElement passCount;
    private WebElement fromPort;
    private WebElement fromMonth;
    private WebElement fromDay;
    private WebElement toPort;
    private WebElement toMonth;
    private WebElement toDay;
    private WebElement economyClass;
    private WebElement businessClass;
    private WebElement firstClass;
    private WebElement airlinePreffered;
    private WebElement continueButton;

    FindFlightPage(WebDriver driver) {
        this.flightDriver = driver;
        this.passCount = flightDriver.findElement(By.cssSelector("select[name=passCount]"));
        this.fromPort = flightDriver.findElement(By.cssSelector("select[name=fromPort]"));
        this.fromMonth = flightDriver.findElement(By.cssSelector("select[name=fromMonth]"));
        this.fromDay = flightDriver.findElement(By.cssSelector("select[name=fromDay]"));
        this.toPort = flightDriver.findElement(By.cssSelector("select[name=toPort]"));
        this.toMonth = flightDriver.findElement(By.cssSelector("select[name=toMonth]"));
        this.toDay = flightDriver.findElement(By.cssSelector("select[name=toDay]"));
        this.economyClass = flightDriver.findElement(By.cssSelector("input[name=servClass][value=Coach]"));
        this.businessClass = flightDriver.findElement(By.cssSelector("input[name=servClass][value=Business]"));
        this.firstClass = flightDriver.findElement(By.cssSelector("input[name=servClass][value=First]"));
        this.airlinePreffered = flightDriver.findElement(By.cssSelector("select[name=airline]"));
        this.continueButton = flightDriver.findElement(By.cssSelector("input[name=findFlights]"));
    }

    public String getPageTitle() {
        return flightDriver.getTitle();
    }

    public String getPageUrl() {
        return flightDriver.getCurrentUrl();
    }

    public void searchFlight(Integer passCount,
                             String fromPort, String fromMonth, String fromDay,
                             String toPort, String toMonth, String toDay,
                             String serviceClass, String airlinePreffered) {
        this.continueButton.click();
    }
}
