import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;


public class FirstTest {

    //private WebElement testCurrentUrl;

    @Test
    public void testCurrentUrl() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "D:\\maven\\.idea\\bin\\chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("https://jira.ithillel.com/login.jsp");
        browser.findElement(By.id("login-form-username")).sendKeys("alinayarosh212");
        browser.findElement(By.id("login-form-password")).sendKeys("Nirvana2020");
        browser.findElement(By.id("login-form-submit")).click();
//        browser.get("https://jira.ithillel.com/browse/AQ-3");
//        browser.findElement(By.id("type-val")).click();
//        Actions action = new Actions(browser);
//        WebElement link = browser.findElement(By.id("type-val"));
//        action.doubleClick(link).perform();
//        String test = browser.findElement(By.xpath("//*[@id=\"issuetype-suggestions\"]/div/ul")).getText();
//        System.out.println(test);

        browser.findElement(By.xpath("//*[@id=\"header\"]/nav/div/div[1]/a")).click();
        browser.findElement(By.xpath("//*[@id=\"app-switcher\"]/div/ul/li[2]/a")).click();
        browser.findElement(By.id("os_username")).sendKeys("alinayarosh212");
        browser.findElement(By.id("os_password")).sendKeys("Nirvana2020");
        browser.findElement(By.id("loginButton")).click();
        browser.findElement(By.xpath("//*[@id=\"user-menu-link\"]")).click();
        browser.findElement(By.xpath("//*[@id=\"view-user-profile-link\"]")).click();
        browser.findElement(By.xpath("//*[@id=\"main\"]/div[3]/div[2]/div/div[3]/form[1]/div/ul/li/a")).click();
        WebElement AllClearName = browser.findElement(By.xpath("//*[@type=\"text\"]"));
        WebElement email = browser.findElement(By.id("email"));
        String getValueOfEmail = email.getAttribute("value");
        WebElement name = browser.findElement(By.id("fullName"));
        String getValueOfName = name.getAttribute("value");
        List<WebElement> allFields = AllClearName.findElements(By.xpath("//*[@type=\"text\"]"));
        for (WebElement we: allFields){
            we.clear();
            if (getValueOfEmail.isEmpty()) {
                System.out.println("Input field is empty");
            } else {
                break;
            }
            if (getValueOfName.isEmpty()){
                System.out.println("Input field is empty");
            } else {
                break;
            }
        }
       // List<WebElement> elements =  browser.findElements(By.className("field-group"));
        System.out.println("Test1 number of elements");
//                (By.id("fullName")).
//                findElement(By.id("email")).
//                findElement(By.id("userparam-phone")).
//                findElement(By.id("userparam-im")).
//                findElement(By.id("userparam-website")).
//                findElement(By.id("personalInformation")).
//                findElement(By.id("userparam-position")).
//                findElement(By.id("userparam-location"));


//        for(WebElement  elements : ArrayList ) {
//           clear();
//        }
        System.out.println("test2");
        browser.findElement(By.id("confirm")).click();
}
}



