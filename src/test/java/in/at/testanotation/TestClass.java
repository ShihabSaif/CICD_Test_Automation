package in.at.testanotation;

import net.rcarz.jiraclient.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
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
        Assert.assertEquals("dummy text", driver.getTitle());
    }

    @AfterTest
    public void quit(ITestResult result) throws JiraException {
        driver.quit();

        if(result.getStatus() ==ITestResult.FAILURE)
        {
            BasicCredentials cred = new BasicCredentials("shihab_qa", "Sh!@Ud!nP$l2022P$L");
            JiraClient jira = new JiraClient("https://jira.surecashbd.com/secure/Dashboard.jspa", cred);
            Issue issueName = jira.createIssue("TK", "Bug")
                 .field(Field.SUMMARY, result.getMethod().getMethodName() + "is failed due to" + result.getThrowable().toString())
                 .field(Field.DESCRIPTION, "get the description").execute();

            System.out.println("issue created in jira with : " + issueName.getKey());

        }
    }
}
