package demoqa;

import enums.PageUrls.PageUrl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import testobject.OTest;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DemoqaResizableTest extends OTest {

  private static final Logger LOG = LogManager.getLogger("DemoqaResizableTest");

  private DemoqaResizable resizable;
  private DemoqaCommonElements commonElements;

  @Before
  public void setUrl() {
    setUrl(PageUrl.DEMOQA);
    resizable = new DemoqaResizable(driver);
    commonElements = new DemoqaCommonElements(driver);
    commonElements.demoqaMenu.resizableLinkClick();
  }

  @Test
  public void checkPageTitle() {
    assertEquals("Check Resizable page title:", "Resizable | Demoqa", utils.getTitle());
  }

  @Test
  public void checkEntryTitle() {
    assertEquals("Check Resizable entry title:", "Resizable", commonElements.getEntryTitle());
  }

  @Test
  public void getDimensions() {

    commonElements.tabsLinkClick("Default functionality");
    System.out.println(resizable.getDefaultFunctionalityResizableDimension());

    commonElements.tabsLinkClick("Animate");
    System.out.println(resizable.getAnimateResizableDimension());

    commonElements.tabsLinkClick("Constrain resize area");
    System.out.println(resizable.getConstrainResizableAreaContainerDimension());
    System.out.println(resizable.getConstrainResizableAreaContainerResizableConstrainDimension());

    commonElements.tabsLinkClick("Helper");
    System.out.println(resizable.getResizableHelperDimension());

    commonElements.tabsLinkClick("Max/Min size");
    System.out.println(resizable.getMinMaxSizeDimension());
  }

  @Test
  public void resizeDefaultFunctionalityBoxByX() {
    commonElements.tabsLinkClick("Default functionality");
    Dimension before = resizable.getDefaultFunctionalityResizableDimension();
    resizable.resizeDefaultFunctionalityByX(200);
    Dimension after = resizable.getDefaultFunctionalityResizableDimension();
    LOG.info("Dimension before: " + before + " and after " + after);
    assertNotEquals(before, after);
  }

  @Test
  public void resizeDefaultFunctionalityBoxByY() {
    commonElements.tabsLinkClick("Default functionality");
    Dimension before = resizable.getDefaultFunctionalityResizableDimension();
    resizable.resizeDefaultFunctionalityByY(200);
    Dimension after = resizable.getDefaultFunctionalityResizableDimension();
    LOG.info("Dimension before: " + before + " and after " + after);
    assertNotEquals(before, after);
  }

  @Test
  public void resizeDefaultFunctionalityBoxByXY() {
    commonElements.tabsLinkClick("Default functionality");
    Dimension before = resizable.getDefaultFunctionalityResizableDimension();
    resizable.resizeDefaultFunctionalityByXY(200, 300);
    Dimension after = resizable.getDefaultFunctionalityResizableDimension();
    LOG.info("Dimension before: " + before + " and after " + after);
    assertNotEquals(before, after);
  }

  @Test
  public void resizeAnimateBoxByX() {
    commonElements.tabsLinkClick("Animate");
    Dimension before = resizable.getAnimateResizableDimension();
    resizable.resizeAnimateByX(200);
    Dimension after = resizable.getAnimateResizableDimension();
    LOG.info("Dimension before: " + before + " and after " + after);
    assertNotEquals(before, after);
  }

  @Test
  public void resizeAnimateBoxByY() {
    commonElements.tabsLinkClick("Animate");
    Dimension before = resizable.getAnimateResizableDimension();
    resizable.resizeAnimateByY(200);
    Dimension after = resizable.getAnimateResizableDimension();
    LOG.info("Dimension before: " + before + " and after " + after);
    assertNotEquals(before, after);
  }

  @Test
  public void resizeAnimateBoxByXY() {
    commonElements.tabsLinkClick("Animate");
    Dimension before = resizable.getAnimateResizableDimension();
    resizable.resizeAnimateByXY(1000, 10000);
    Dimension after = resizable.getAnimateResizableDimension();
    LOG.info("Dimension before: " + before + " and after " + after);
    assertNotEquals(before, after);
  }

  @Test
  public void resizeConstrainBoxByX() {
    commonElements.tabsLinkClick("Constrain resize area");
    Dimension before = resizable.getConstrainResizableAreaContainerResizableConstrainDimension();
    resizable.resizeConstrainByX(-50);
    Dimension after = resizable.getConstrainResizableAreaContainerResizableConstrainDimension();
    LOG.info("Dimension before: " + before + " and after " + after);
    assertNotEquals(before, after);
  }

  @Test
  public void resizeConstrainBoxByY() {
    commonElements.tabsLinkClick("Constrain resize area");
    Dimension before = resizable.getConstrainResizableAreaContainerResizableConstrainDimension();
    resizable.resizeConstrainByY(200);
    Dimension after = resizable.getConstrainResizableAreaContainerResizableConstrainDimension();
    LOG.info("Dimension before: " + before + " and after " + after);
    assertNotEquals(before, after);
  }

  @Test
  public void resizeConstrainBoxByXY() {
    commonElements.tabsLinkClick("Constrain resize area");
    Dimension before = resizable.getConstrainResizableAreaContainerResizableConstrainDimension();
    resizable.resizeConstrainByXY(-50, 100);
    Dimension after = resizable.getConstrainResizableAreaContainerResizableConstrainDimension();
    LOG.info("Dimension before: " + before + " and after " + after);
    assertNotEquals(before, after);
  }

  @Test
  public void resizeHelperBoxByX() {
    commonElements.tabsLinkClick("Helper");
    Dimension before = resizable.getResizableHelperDimension();
    resizable.resizeHelperByX(200);
    Dimension after = resizable.getResizableHelperDimension();
    LOG.info("Dimension before: " + before + " and after " + after);
    assertNotEquals(before, after);
  }

  @Test
  public void resizeHelperBoxByY() {
    commonElements.tabsLinkClick("Helper");
    Dimension before = resizable.getResizableHelperDimension();
    resizable.resizeHelperByY(200);
    Dimension after = resizable.getResizableHelperDimension();
    LOG.info("Dimension before: " + before + " and after " + after);
    assertNotEquals(before, after);
  }

  @Test
  public void resizeHelperBoxByXY() {
    commonElements.tabsLinkClick("Helper");
    Dimension before = resizable.getResizableHelperDimension();
    resizable.resizeHelperByXY(200, 300);
    Dimension after = resizable.getResizableHelperDimension();
    LOG.info("Dimension before: " + before + " and after " + after);
    assertNotEquals(before, after);
  }

  @Test
  public void resizeMinMaxBoxByX() {
    commonElements.tabsLinkClick("Max/Min size");
    Dimension before = resizable.getMinMaxSizeDimension();
    resizable.resizeMinMaxByX(200);
    Dimension after = resizable.getMinMaxSizeDimension();
    LOG.info("Dimension before: " + before + " and after " + after);
    assertNotEquals(before, after);
  }

  @Test
  public void resizeMinMaxBoxByY() {
    commonElements.tabsLinkClick("Max/Min size");
    Dimension before = resizable.getMinMaxSizeDimension();
    resizable.resizeMinMaxByY(200);
    Dimension after = resizable.getMinMaxSizeDimension();
    LOG.info("Dimension before: " + before + " and after " + after);
    assertNotEquals(before, after);
  }

  @Test
  public void resizeMinMaxBoxByXY() {
    commonElements.tabsLinkClick("Max/Min size");
    Dimension before = resizable.getMinMaxSizeDimension();
    resizable.resizeMinMaxByXY(200, 300);
    Dimension after = resizable.getMinMaxSizeDimension();
    LOG.info("Dimension before: " + before + " and after " + after);
    assertNotEquals(before, after);
  }
}
