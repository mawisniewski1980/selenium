package demoqa;

import enums.PageUrls.PageUrl;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import testobject.OTest;

import static org.junit.Assert.assertEquals;

public class DemoqaServicesTest extends OTest {

  private final Logger LOG = LoggerFactory.getLogger(DemoqaServicesTest.class);

  private DemoqaServices demoqaServices;
  private DemoqaCommonElements commonElements;

  @Before
  public void setUrl() {
    setUrl(PageUrl.DEMOQA);
    demoqaServices = new DemoqaServices(driver);
    commonElements = new DemoqaCommonElements(driver);
    commonElements.demoqaNavbar.servicesLinkClick();
  }

  @Test
  public void checkTitlePage() {
    assertEquals("Check Services page title:", "Services | Demoqa", utils.getTitle());
  }

  @Test
  public void checkEntryTitle() {
    assertEquals("Check Services entry title:", "Services", commonElements.getEntryTitle());
  }

  @Test
  public void checkTextArticleOnDemoqaServicesPage(){
    String textToCheck = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using ‘lorem ipsum’ is that it " +
            "has a " +
            "more-or-less normal distribution of letters, as opposed to using ‘This here is content’ or ‘Osama Bin Laden wanted dead or alive’, making it look like readable text and there also has been many examples what has happened if someone has forgotten to change the dummy text for the final copywrite text.\n" +
            "In Finland there was couple of years ago this one bookshop banner in public internet with ‘Buying a book is as easy as hitting a child’ text in it.";

    assertEquals("Check whole text on Demoqa Services Page", textToCheck, demoqaServices.getDemoqaServicesText());
  }
}
