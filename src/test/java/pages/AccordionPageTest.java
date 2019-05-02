package pages;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import abstracts.AbstractTest;

import static org.assertj.core.api.Assertions.*;

public class AccordionPageTest extends AbstractTest {

  private AccordionPage accordionPage;

  @BeforeTest
  public void beforeTest() {
    openUrl();
    accordionPage = new AccordionPage(driver);
    navi.accordionLinkClick();
  }

  @Test
  public void checkPageTitle() {
   assertThat("Accordion – ToolsQA – Demo Website to Practice Automation").isEqualTo(accordionPage.utils().getTitle());
  }

}
