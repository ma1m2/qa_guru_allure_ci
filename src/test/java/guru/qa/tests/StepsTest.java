package guru.qa.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest {

  private static final String REPO = "ma1m2/";
  private static final String ISSUE_NAME = "Major problem in profile";

  @Test
  public void testLambdaStep() {
    SelenideLogger.addListener("allure", new AllureSelenide());

    step("Open main page", () -> {
      open("https://github.com");
    });
    step("Search repo by name " + REPO, () -> {
      $(".search-input").click();
      $("#query-builder-test").sendKeys(REPO);//".QueryBuilder-InputWrapper"
      $("#query-builder-test").submit();//press Enter
    });
    step("Click on repo link in search results " + REPO + "teamcity", () -> {
      $(linkText(REPO + "teamcity")).click();
    });
    step("Open Issues tab", () -> {
      $("#issues-tab").click();
    });
    step("Check that issue with name " + ISSUE_NAME + " exists", () -> {
      $(withText(ISSUE_NAME)).should(Condition.exist);
    });
  }

  @Test
  public void testAnnotatedStep(){
    SelenideLogger.addListener("allure", new AllureSelenide());
    WebSteps steps = new WebSteps();

    steps.openMainPage();
    steps.searchRepo(REPO);
    steps.clickOnRepoLink(REPO);
    steps.openIssueTab();
    steps.checkIssueExist(ISSUE_NAME);
  }

}
