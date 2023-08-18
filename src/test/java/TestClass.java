import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class TestClass {
    WebDriver driver;

    public TestClass() {
        System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver_win32_113_version\\chromedriver.exe");
        ChromeOptions chromeOpt = new ChromeOptions();
        chromeOpt.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOpt);
    }

    @Test(priority = 0)
    public void Test_01() throws InterruptedException {
        driver.navigate().to("https://www.prothomalo.com/");
        System.out.println("test 1 is : " + driver.getTitle());
    }

    @Test(priority = 1)
    public void Test_02() throws InterruptedException {
        driver.navigate().to("https://www.prothomalo.com/");
        System.out.println("test 2 is : " + driver.getTitle());
    }

    @Test(priority = 2)
    public void Test_03() throws InterruptedException {
        driver.navigate().to("https://www.prothomalo.com/");
        System.out.println("test 3 is : " + driver.getTitle());
    }
}
