package test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import config.Code;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Configuration.holdBrowserOpen;
import static com.codeborne.selenide.Selenide.*;

public class Dolphin extends Code {
    @BeforeClass
    public void config() {
        setConfigsChrome();
//    setConfigsFirefox();
    }

    @Test
    public void dolphinTest() throws InterruptedException {
        open("https://www.booking.com/");
        SelenideElement searchField = $("[type=\"search\"]");
        searchField.sendKeys("BArcelona, Catalonia, Spain");
        Thread.sleep(500);
        $("[data-component=\"search/dates/date-field-select\"]").click();
        SelenideElement set31oktiabria = $("[data-date=\"2020-10-31\"]");
        set31oktiabria.click();
        SelenideElement set7Noibria = $("[data-date=\"2020-11-07\"]");
        set7Noibria.click();
        $("[class=\"bui-calendar\"]").is(Condition.disappears);
        searchField.pressEnter();
        $("[id=\"frm\"]").shouldHave(Condition.text("суббота, 31 октября 2020")).shouldHave(Condition.text("суббота, 7 ноября 2020")).shouldHave(Condition.text("7 ночей"));
        $x("//select[@id='group_adults']").click();
        $x("//body/div[@id='bodyconstraint']/div[@id='bodyconstraint-inner']/div[@id='searchresultsTmpl']/div[@id='basiclayout']/div[@id='left']/div[@id='left_col_wrapper']/div[1]/form[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/select[1]/option[1]").click();
        $("[type=\"submit\"]").click();
        $("[id=\"frm\"]").shouldHave(Condition.text("суббота, 31 октября 2020"))
                .shouldHave(Condition.text("суббота, 7 ноября 2020"))
                .shouldHave(Condition.text("7 ночей"))
                .shouldHave(Condition.text("1 взрослый"));
        SelenideElement select = $("[class=\"c-autocomplete__input sb-searchbox__input sb-destination__input\"]");
        select.getText().contentEquals("Барселона");
        SelenideElement sele = $x("//body/div[@id='bodyconstraint']/div[@id='bodyconstraint-inner']/div[@id='subheader-wrap']/nav[@id='breadcrumb']/ol[1]");
        sele.shouldHave(Condition.text("Главная"))
                .shouldHave(Condition.text("Испания"))
                .shouldHave(Condition.text("Каталония"))
                .shouldHave(Condition.text("Барселона"))
                .shouldHave(Condition.text("Результаты поиска"));


      SelenideElement first =  $("[class=\"sr_header \"]");
      String firstList = first.getText();
        $("[data-value=\"203\"]").click();
        SelenideElement second =  $("[class=\"sr_header \"]");
        String secondtList = first.getText();
        if (!firstList.equals(secondtList)){
            System.out.println("All ok");
        }
        $x("//body/div[@id='bodyconstraint']/div[@id='bodyconstraint-inner']/div[@id='searchresultsTmpl']/div[@id='basiclayout']/div[@id='right']/div[@id='ajaxsrwrap']/div[@id='search_results_table']/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]").click();
        switchTo().window(1);
        $("[class=\"bui-button__text\"]").click();
    }

    @AfterClass
    public void podojdi() {
        holdBrowserOpen = true;
    }
}
