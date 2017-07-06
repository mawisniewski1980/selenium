package demoqa;

import enums.PageUrls.PageUrl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import testobject.TestObject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DemoqaAccordionTest extends TestObject {

  // private final Logger LOG = LoggerFactory.getLogger(DemoqaAboutUsTest.class);

  private DemoqaAccordion demoqaAccordion;
  private DemoqaPageMenu demoqaMenu;
  private DemoqaCommonElements commonElements;

  @Before
  public void setUrl() {
    setUrl(PageUrl.DEMOQA);
    demoqaAccordion = new DemoqaAccordion(driver);
    commonElements = new DemoqaCommonElements(driver);
    demoqaMenu = new DemoqaPageMenu(driver);
    demoqaMenu.accordionLinkClick();
  }

  @Test
  public void checkPageTitle() {
    assertEquals("Check Accordion page title:", "Accordion | Demoqa", utils.getTitle());
  }

  @Test
  public void checkEntryTitle() {
   assertEquals("Check Accordion entry title:", "Accordion", commonElements.getEntryTitle());
  }

  @Test
  public void checkIfSection1IsExpandedAfterClickInDefaultFunctionalityTab(){
    commonElements.tabsLinkClick("Default functionality");
    assertTrue("Check If Section1 is expanded after click in Default functionality tab", demoqaAccordion.clickDefFuncSection("Section 1").checkIfDefFuncSectionIsExpanded("Section 1"));
  }

  @Test
  public void checkIfSection2IsExpandedAfterClickInDefaultFunctionalityTab(){
    commonElements.tabsLinkClick("Default functionality");
    assertTrue("Check If Section2 is expanded after click in Default functionality tab", demoqaAccordion.clickDefFuncSection("Section 2").checkIfDefFuncSectionIsExpanded("Section 2"));
  }

  @Test
  public void checkIfSection3IsExpandedAfterClickInDefaultFunctionalityTab(){
    commonElements.tabsLinkClick("Default functionality");
    assertTrue("Check If Section3 is expanded after click in Default functionality tab", demoqaAccordion.clickDefFuncSection("Section 3").checkIfDefFuncSectionIsExpanded("Section 3"));
  }

  @Test
  public void checkIfSection4IsExpandedAfterClickInDefaultFunctionalityTab(){
    commonElements.tabsLinkClick("Default functionality");
    assertTrue("Check If Section4 is expanded after click in Default functionality tab", demoqaAccordion.clickDefFuncSection("Section 4").checkIfDefFuncSectionIsExpanded("Section 4"));
  }

  @Test
  public void checkIfOnlyOneSectionIsEnabledInDefaultFunctionalityTab() {
    commonElements.tabsLinkClick("Default functionality");
    demoqaAccordion.clickDefFuncSection("Section 2").clickDefFuncSection("Section 4");
    assertTrue("Check If Section4 is expanded after click in Default functionality tab", demoqaAccordion.checkIfDefFuncSectionIsExpanded("Section 4"));
    assertFalse("Check If Section1 is not expanded after click on Section4 in Default functionality tab", demoqaAccordion.checkIfDefFuncSectionIsExpanded("Section 1"));
    assertFalse("Check If Section2 is not expanded after click on Section4 in Default functionality tab", demoqaAccordion.checkIfDefFuncSectionIsExpanded("Section 2"));
    assertFalse("Check If Section3 is not expanded after click on Section4 in Default functionality tab", demoqaAccordion.checkIfDefFuncSectionIsExpanded("Section 3"));
  }

  @Test
  public void checkTextInSection1AfterClickInDefaultFunctionalityTab(){
    commonElements.tabsLinkClick("Default functionality");
    assertEquals("Check text in Section 1 in Default functionality tab","Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer\n" +
           "ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit\n" +
           "amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut\n" +
           "odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.",demoqaAccordion.clickDefFuncSection("Section 1").getDefFuncSectionText("Section 1"));
  }

  @Test
  public void checkTextInSection2AfterClickInDefaultFunctionalityTab(){
    commonElements.tabsLinkClick("Default functionality");
    assertEquals("Check text in Section 2 in Default functionality tab","Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet\n" +
            "purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor\n" +
            "velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In\n" +
            "suscipit faucibus urna.",demoqaAccordion.clickDefFuncSection("Section 2").getDefFuncSectionText("Section 2"));
  }

  @Test
  public void checkTextInSection3AfterClickInDefaultFunctionalityTab(){
    commonElements.tabsLinkClick("Default functionality");
    assertEquals("Check text in Section 3 in Default functionality tab","Nam enim risus, molestie et, porta ac, aliquam ac, risus. Quisque lobortis.\n" +
            "Phasellus pellentesque purus in massa. Aenean in pede. Phasellus ac libero\n" +
            "ac tellus pellentesque semper. Sed ac felis. Sed commodo, magna quis\n" +
            "lacinia ornare, quam ante aliquam nisi, eu iaculis leo purus venenatis dui.",demoqaAccordion.clickDefFuncSection("Section 3").getDefFuncSectionText("Section 3"));
  }

  @Test
  public void checkTextInSection4AfterClickInDefaultFunctionalityTab(){
    commonElements.tabsLinkClick("Default functionality");
    assertEquals("Check text in Section 4 in Default functionality tab","Cras dictum. Pellentesque habitant morbi tristique senectus et netus\n" +
            "et malesuada fames ac turpis egestas. Vestibulum ante ipsum primis in\n" +
            "faucibus orci luctus et ultrices posuere cubilia Curae; Aenean lacinia\n" +
            "mauris vel est.",demoqaAccordion.clickDefFuncSection("Section 4").getDefFuncSectionText("Section 4"));
  }

  @Test
  public void checkIfIconsAreVisibleByDefaultInCustomizeIconsTab() {
    commonElements.tabsLinkClick("Customize icons");
    assertTrue("Check if icon is visible by default in Customize icons tab in Section 1", demoqaAccordion.checkIfIcoIsVisibleOnCustIcoTab("Section 1"));
    assertTrue("Check if icon is visible by default in Customize icons tab in Section 2", demoqaAccordion.checkIfIcoIsVisibleOnCustIcoTab("Section 2"));
    assertTrue("Check if icon is visible by default in Customize icons tab in Section 3", demoqaAccordion.checkIfIcoIsVisibleOnCustIcoTab("Section 3"));
    assertTrue("Check if icon is visible by default in Customize icons tab in Section 4", demoqaAccordion.checkIfIcoIsVisibleOnCustIcoTab("Section 4"));
  }

  @Test
  public void checkIfIconsAreNotVisibleAfterClickOnButtonInCustomizeIconsTab() {
    commonElements.tabsLinkClick("Customize icons");
    demoqaAccordion.clickCustIcoToggleButton();
    assertFalse("Check if icon is not visible after click button in Customize icons tab in Section 1", demoqaAccordion.checkIfIcoIsVisibleOnCustIcoTab("Section 1"));
    assertFalse("Check if icon is not visible after click button in Customize icons tab in Section 2", demoqaAccordion.checkIfIcoIsVisibleOnCustIcoTab("Section 2"));
    assertFalse("Check if icon is not visible after click button in Customize icons tab in Section 3", demoqaAccordion.checkIfIcoIsVisibleOnCustIcoTab("Section 3"));
    assertFalse("Check if icon is not visible after click button in Customize icons tab in Section 4", demoqaAccordion.checkIfIcoIsVisibleOnCustIcoTab("Section 4"));
  }

  @Test
  public void checkIfSection1IsExpandedAfterClickInCustomizeIconsTab(){
    commonElements.tabsLinkClick("Customize icons");
    assertTrue("Check If Section1 is expanded after click in Customize icons tab", demoqaAccordion.clickCustIcoSection("Section 1").checkIfCustIcoSectionIsExpanded("Section 1"));
  }

  @Test
  public void checkIfSection2IsExpandedAfterClickInCustomizeIconsTab(){
    commonElements.tabsLinkClick("Customize icons");
    assertTrue("Check If Section2 is expanded after click in Customize icons tab", demoqaAccordion.clickCustIcoSection("Section 2").checkIfCustIcoSectionIsExpanded("Section 2"));
  }

  @Test
  public void checkIfSection3IsExpandedAfterClickInCustomizeIconsTab(){
    commonElements.tabsLinkClick("Customize icons");
    assertTrue("Check If Section3 is expanded after click in Customize icons tab", demoqaAccordion.clickCustIcoSection("Section 3").checkIfCustIcoSectionIsExpanded("Section 3"));
  }

  @Test
  public void checkIfSection4IsExpandedAfterClickInCustomizeIconsTab(){
    commonElements.tabsLinkClick("Customize icons");
    assertTrue("Check If Section4 is expanded after click in Customize icons tab", demoqaAccordion.clickCustIcoSection("Section 4").checkIfCustIcoSectionIsExpanded("Section 4"));
  }

  @Test
  public void checkIfOnlyOneSectionIsEnabledInCustomizeIconsTab() {
    commonElements.tabsLinkClick("Customize icons");
    demoqaAccordion.clickCustIcoSection("Section 2").clickCustIcoSection("Section 3");
    assertTrue("Check If Section4 is expanded after click in Customize icons tab", demoqaAccordion.checkIfCustIcoSectionIsExpanded("Section 3"));
    assertFalse("Check If Section1 is not expanded after click on Section4 in Customize icons tab", demoqaAccordion.checkIfCustIcoSectionIsExpanded("Section 1"));
    assertFalse("Check If Section2 is not expanded after click on Section4 in Customize icons tab", demoqaAccordion.checkIfCustIcoSectionIsExpanded("Section 2"));
    assertFalse("Check If Section3 is not expanded after click on Section4 in Customize icons tab", demoqaAccordion.checkIfCustIcoSectionIsExpanded("Section 4"));
  }

  @Test
  public void checkTextInSection1AfterClickInCustomizeIconsTab(){
    commonElements.tabsLinkClick("Customize icons");
    assertEquals("Check text in Section 1 in Customize icons tab","Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.",
            demoqaAccordion.clickCustIcoSection("Section 1").getCustIcoSectionText("Section 1"));
  }

  @Test
  public void checkTextInSection2AfterClickInCustomizeIconsTab(){
    commonElements.tabsLinkClick("Customize icons");
    assertEquals("Check text in Section 2 in Customize icons tab","Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In suscipit faucibus urna.",
            demoqaAccordion.clickCustIcoSection("Section 2").getCustIcoSectionText("Section 2"));
  }

  @Test
  public void checkTextInSection3AfterClickInCustomizeIconsTab(){
    commonElements.tabsLinkClick("Customize icons");
    assertEquals("Check text in Section 3 in Customize icons tab","Nam enim risus, molestie et, porta ac, aliquam ac, risus. Quisque lobortis. Phasellus pellentesque purus in massa. Aenean in pede. Phasellus ac libero ac tellus pellentesque semper. Sed ac felis. Sed commodo, magna quis lacinia ornare, quam ante aliquam nisi, eu iaculis leo purus venenatis dui.",
            demoqaAccordion.clickCustIcoSection("Section 3").getCustIcoSectionText("Section 3"));
  }

  @Test
  public void checkTextInSection4AfterClickInCustomizeIconsTab(){
    commonElements.tabsLinkClick("Customize icons");
    assertEquals("Check text in Section 4 in Customize icons tab","Cras dictum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aenean lacinia mauris vel est.",
            demoqaAccordion.clickCustIcoSection("Section 4").getCustIcoSectionText("Section 4"));
  }

  @Test
  public void checkTextInSection1AfterClickInFillSpaceTab(){
    commonElements.tabsLinkClick("Fill Space");
    assertEquals("Check text in Section 1 in Customize icons tab","Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.",
            demoqaAccordion.clickFillSpaceSection("Section 1").getFillSpaceSectionText("Section 1"));
  }

  @Test
  public void checkTextInSection2AfterClickInFillSpaceTab(){
    commonElements.tabsLinkClick("Fill Space");
    assertEquals("Check text in Section 2 in Customize icons tab","Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In suscipit faucibus urna.",
            demoqaAccordion.clickFillSpaceSection("Section 2").getFillSpaceSectionText("Section 2"));
  }

  @Test
  public void checkTextInSection3AfterClickInFillSpaceTab(){
    commonElements.tabsLinkClick("Fill Space");
    assertEquals("Check text in Section 3 in Customize icons tab","Nam enim risus, molestie et, porta ac, aliquam ac, risus. Quisque lobortis. Phasellus pellentesque purus in massa. Aenean in pede. Phasellus ac libero ac tellus pellentesque semper. Sed ac felis. Sed commodo, magna quis lacinia ornare, quam ante aliquam nisi, eu iaculis leo purus venenatis dui.",
            demoqaAccordion.clickFillSpaceSection("Section 3").getFillSpaceSectionText("Section 3"));
  }

  @Test
  public void checkTextInSection4AfterClickInFillSpaceTab(){
    commonElements.tabsLinkClick("Fill Space");
    assertEquals("Check text in Section 4 in Customize icons tab","Cras dictum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aenean lacinia mauris vel est.",
            demoqaAccordion.clickFillSpaceSection("Section 4").getFillSpaceSectionText("Section 4"));
  }
}
