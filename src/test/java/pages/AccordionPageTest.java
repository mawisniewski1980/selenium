package pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import abstracts.AbstractTest;

import static org.assertj.core.api.Assertions.*;

public class AccordionPageTest extends AbstractTest {

    private static final Logger LOG = LoggerFactory.getLogger(AccordionPageTest.class);
    private AccordionPage accordionPage = factory.getAccordionPage();

    @BeforeMethod
    public void beforeMethod() {
        LOG.info("@BeforeMethod: before method...");
        navigation.accordionLinkClick();
    }

    @Test
    public void checkPageTitle() {
        assertThat("Accordion – ToolsQA – Demo Website to Practice Automation").isEqualTo(accordionPage.getTitle());
    }

    @Test
    public void checkEntryTitle() {
        assertThat("Accordion").isEqualTo(accordionPage.getEntryTitle());
    }

    @Test
    public void checkIfSectionOneIsSelectedAndExpanded() {
        assertThat(accordionPage.isSectionExpanded("Section 1")).isTrue();
        assertThat(accordionPage.isSectionSelected("Section 1")).isTrue();
    }

    @AfterMethod
    public void afterMethod() {
        LOG.info("@AfterMethod: after method...");
    }
}
