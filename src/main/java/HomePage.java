import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    public static String baseUrl = "http://newtours.demoaut.com/index.php";
    public static String welcomePageTitle = "Welcome: Mercury Tours";
    private WebDriver homeDriver;

    private WebElement inputUser;
    private WebElement inputPassword;
    private WebElement loginButton;

    HomePage(WebDriver driver) {
        this.homeDriver = driver;
    }

    public void open() {
        homeDriver.navigate().to("http://newtours.demoaut.com");
        inputUser = homeDriver.findElement(By.cssSelector("input[name=userName]"));
        inputPassword = homeDriver.findElement(By.cssSelector("input[name=password]"));
        loginButton = homeDriver.findElement(By.cssSelector("input[value=Login]"));
    }

    public void login(String name, String password) {
        this.inputUser.sendKeys(name);
        this.inputPassword.sendKeys(password);
        this.loginButton.click();
    }

    public void findFlight() {
        homeDriver.findElement(By.cssSelector("a[href*=mercuryreservation]")).click();
    }
}
