package demoqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.PageObject;

public class DemoqaFramesAndWindows extends PageObject {

  // private static final Logger LOG = LoggerFactory.getLogger(DemoqaFramesAndWindows.class.getName());

  public DemoqaFramesAndWindows(WebDriver driver) {
    super(driver);
  }

  private final String newBrowserTabLinkCss = "#tabs-1 a";
  @FindBy(css = newBrowserTabLinkCss)
  private WebElement newBrowserTabLink;

  private final String openSeparateWindowLinkCss = "#tabs-2 a";
  @FindBy(css = openSeparateWindowLinkCss)
  private WebElement openSeparateWindowLink;

  private final String framsetWindowLinkCss = "#tabs-3 a";
  @FindBy(css = framsetWindowLinkCss)
  private WebElement framsetWindowLink;

  public DemoqaFramesAndWindows newBrowserTabLinkClick() {
    utils.linkClick(newBrowserTabLink);
    return this;
  }

  public DemoqaFramesAndWindows openSeparateWindowLinkClick() {
    utils.linkClick(openSeparateWindowLink);
    return this;
  }

  public DemoqaFramesAndWindows framsetWindowLinkClick() {
    utils.linkClick(framsetWindowLink);
    return this;
  }

}
