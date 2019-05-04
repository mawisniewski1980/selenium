package pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import abstracts.AbstractTest;

import static org.assertj.core.api.Assertions.*;

public class AccordionPageTest extends AbstractTest {

  private static final Logger LOG = LoggerFactory.getLogger(AccordionPageTest.class);

  @BeforeTest
  public void beforeTest() {
    openUrl();
    factory.navigation().accordionLinkClick();
  }

  @Test
  public void checkPageTitle() {
   assertThat("Accordion – ToolsQA – Demo Website to Practice Automation").isEqualTo(factory.basePage().getTitle());
  }

  @Test
  public void checkEntryTitle() {
    assertThat("Accordion").isEqualTo(factory.basePage().getEntryTitle());
  }
}
