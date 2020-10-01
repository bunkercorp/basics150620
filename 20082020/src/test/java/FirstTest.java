import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;


public class FirstTest {

    enum Verb{
      GET,
      POST;
    };

    public static void main(String[] arg) throws InterruptedException {
    //    String adresOfDriver = "C:\\Users\\Пиня\\Desktop\\20082020\\bin\\chromedriver85.exe";
//        String driver = "webdriver.chrome.driver";
//        String link = "https://jira.ithillel.com/secure/RapidBoard.jspa?rapidView=3&projectKey=AQ&view=planning&selectedIssue=AQ-7&issueLimit=100";
//
//        System.setProperty(driver, adresOfDriver);
//        WebDriver browser = new ChromeDriver();
//        browser.get(link);
//
//        WebElement username = browser.findElement(By.id("login-form-username"));
//        WebElement pass = browser.findElement(By.id("login-form-password"));
//        WebElement button = browser.findElement(By.id("login-form-submit"));
//
//        username.sendKeys("petrovodessa1936");
//        pass.sendKeys("Test1234");
//        button.click();
//        browser.get("https://jira.ithillel.com/browse/AQ-7");
//        if((browser.findElement(By.id("assignee-val")).getText()) == "\n" +
//                "    Не назначен"){
//            System.out.println("Ne naznachen");
//        }
//        WebElement assignTOMe = browser.findElement(By.id("assign-to-me"));
//        assignTOMe.click();
//        List<WebElement> listOfFlag = browser.findElements(By.className("lozenge"));
//        for (WebElement flag:listOfFlag) {
//            System.out.println(flag.getText());
//        }; 1-ая практика доделать
//        String adresOfDriver = "C:\\Users\\Пиня\\Desktop\\20082020\\bin\\chromedriver85.exe";
//        String driver = "webdriver.chrome.driver";
//        String link = "https://jira.ithillel.com/secure/RapidBoard.jspa?rapidView=3&projectKey=AQ&view=planning&selectedIssue=AQ-7&issueLimit=100";
//
//        System.setProperty(driver, adresOfDriver);
//        WebDriver browser = new ChromeDriver();
//        browser.get(link);
//
//        WebElement username = browser.findElement(By.id("login-form-username"));
//        WebElement pass = browser.findElement(By.id("login-form-password"));
//        WebElement button = browser.findElement(By.id("login-form-submit"));
//
//        username.sendKeys("petrovodessa1936");
//        pass.sendKeys("Test1234");
//        button.click();
//        browser.get("https://jira.ithillel.com/browse/AQ-7");
//        WebElement edit = browser.findElement(By.id("type-val"));
//        edit.click();
//        edit.sendKeys(" ");2-aya prkatika

//        browser.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//        edit.click();


        //        browser.close();

            //System.out.println(flags);
    //    WebElement listOfFlags = browser.findElement(By.className("labels-wrap value editable-field inactive"));
//        String adresOfDriver = "C:\\Users\\Пиня\\Desktop\\20082020\\bin\\chromedriver85.exe";
//        String driver = "webdriver.chrome.driver";
//        String link = "https://jira.ithillel.com/secure/RapidBoard.jspa?rapidView=3&projectKey=AQ&view=planning&selectedIssue=AQ-7&issueLimit=100";
//
//        System.setProperty(driver, adresOfDriver);
//        WebDriver browser = new ChromeDriver();
//        browser.get(link);
//
//        WebElement username = browser.findElement(By.id("login-form-username"));
//        WebElement pass = browser.findElement(By.id("login-form-password"));
//        WebElement button = browser.findElement(By.id("login-form-submit"));
//
//        username.sendKeys("petrovodessa1936");
//        pass.sendKeys("Test1234");
//        button.click();
//        button = browser.findElement(By.className("aui-dropdown2-trigger"));
//        button.click();
//        List <WebElement> buttons = browser.findElements(By.className("nav-link-label"));
//        buttons.get(1).click();
//        WebElement loginOs = browser.findElement(By.id("os_username"));
//        WebElement passOS = browser.findElement(By.id("os_password"));
//        WebElement buttonOS = browser.findElement(By.id("loginButton"));
//        loginOs.sendKeys("petrovodessa1936");
//        passOS.sendKeys("Test1234");
//        buttonOS.click();
//        buttonOS = browser.findElement(By.id("user-menu-link"));
//        buttonOS.click();
//        buttonOS = browser.findElement(By.id("view-user-profile-link"));
//        buttonOS.click();
//        buttonOS = browser.findElement(By.xpath("//a[@href = '/users/editmyprofile.action']"));
//        buttonOS.click();
//        WebElement phone = browser.findElement(By.id("userparam-phone"));
//        WebElement im = browser.findElement(By.id("userparam-im"));
//        WebElement website = browser.findElement(By.id("userparam-website"));
//        WebElement personalInformation = browser.findElement(By.id("personalInformation"));
//        WebElement position = browser.findElement(By.id("userparam-position"));
//        WebElement department = browser.findElement(By.id("userparam-department"));
//        WebElement location = browser.findElement(By.id("userparam-location"));
//        ArrayList <WebElement> fields = new ArrayList<WebElement>();
//        fields.add(phone);
//        fields.add(im);
//        fields.add(website);
//        fields.add(personalInformation);
//        fields.add(position);
//        fields.add(department);
//        fields.add(location);
//        for(WebElement field : fields){
//            field.clear();
//        }
//        phone.sendKeys("0635248530");
//        im.sendKeys("testIM");
//        website.sendKeys("www.pinyacryptology.ru");
//        personalInformation.sendKeys("Test description");
//        position.sendKeys("TestPosition");
//        department.sendKeys("TestDepartment");
//        location.sendKeys("TestLocation");
//        buttonOS = browser.findElement(By.id("confirm"));
//        ArrayList <String> textsExpected = new ArrayList<String>();
//        textsExpected.add("0635248530");
//        textsExpected.add("testIM");
//        textsExpected.add("www.pinyacryptology.ru");
//        textsExpected.add("Test description");
//        textsExpected.add("TestPosition");
//        textsExpected.add("TestDepartment");
//        textsExpected.add("TestLocation");
//        buttonOS.click();
//        WebElement phoneCheck = browser.findElement(By.id("userparam-phone"));
//        WebElement imCheck = browser.findElement(By.id("userparam-im"));
//        WebElement websiteCheck = browser.findElement(By.className("external-link"));
//        WebElement personalInformationCheck = browser.findElement(By.id("profile-about-me-content")).findElement(By.xpath("//p"));
//        WebElement positionCheck = browser.findElement(By.id("userparam-position"));
//        WebElement departmentCheck = browser.findElement(By.id("userparam-department"));
//        WebElement locationCheck = browser.findElement(By.id("userparam-location"));
//        ArrayList <WebElement> fieldsCheck = new ArrayList<WebElement>();
//        fieldsCheck.add(phoneCheck);
//        fieldsCheck.add(imCheck);
//        fieldsCheck.add(websiteCheck);
//        fieldsCheck.add(personalInformationCheck);
//        fieldsCheck.add(positionCheck);
//        fieldsCheck.add(departmentCheck);
//        fieldsCheck.add(locationCheck);
//        ArrayList <String> texts = new ArrayList<String>();
//        for(int i = 0 ; i <= fieldsCheck.size() ; i++){
////            textsExpected.get(i).
//        };3-ая практика


    }
}

