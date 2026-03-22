package guru.qa.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {

  @Test
  public void testIssueSearch(){
    SelenideLogger.addListener("allure", new AllureSelenide());

    open("https://github.com");
    $(".search-input").click();
    $("#query-builder-test").sendKeys("ma1m2/");//".QueryBuilder-InputWrapper"
    $("#query-builder-test").submit();//press Enter
    $(linkText("ma1m2/teamcity")).click();
    $("#issues-tab").click();
    $(withText("Major problem in profile")).should(Condition.exist);

  }
}
