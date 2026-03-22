package guru.qa.tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

  @Test
  @Feature("Issue in repo")
  @Story("Create Issue")
  @Owner("Sveta")
  @Severity(SeverityLevel.BLOCKER)
  @Link(value = "Testing", url = "https://github.com")
  @DisplayName("Create Issue for authorised user")
  public void testStaticLabels() {
  }

  @Test
  public void testDynamicLabels() {
    Allure.getLifecycle().updateTestCase(t -> t.setName("Create Issue for authorised user"));
    Allure.feature("Issue in repo");
    Allure.story("Create Issue");
    Allure.label("owner", "Sveta");
    Allure.label("severity", SeverityLevel.CRITICAL.value());
    Allure.link("Testing", "https://github.com");
  }

}
