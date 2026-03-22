package guru.qa.tests;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class WebSteps {

  @Step("Open main page")
  public void openMainPage() {
    open("https://github.com");
  }

  @Step("Search repo by name '{0}'")
  public void searchRepo(String repo) {
    $(".search-input").click();
    $("#query-builder-test").sendKeys(repo);//".QueryBuilder-InputWrapper"
    $("#query-builder-test").submit();//press Enter
  }

  @Step("Click on repo link in search results {0}teamcity")
  public void clickOnRepoLink(String repo) {
    $(linkText(repo + "teamcity")).click();
  }

  @Step("Open Issues tab")
  public void openIssueTab() {
    $("#issues-tab").click();
  }

  @Step("Check that issue with name '{0}' exists")
  public void checkIssueExist(String issueName) {
    $(withText(issueName)).should(Condition.exist);
  }

  @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
  public byte[] takeScreenshot() {
    return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
  }
}
