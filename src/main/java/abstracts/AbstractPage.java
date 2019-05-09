package abstracts;

import factories.FactoryPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Utils;

import static selectors.Selectors.ENTRY_TITLE;

public abstract class AbstractPage {

  private static final Logger LOG = LoggerFactory.getLogger(AbstractPage.class);

  protected FactoryPage factory;
  protected Utils utils;

  public AbstractPage(FactoryPage factory) {
    this.factory = factory;
    this.utils = factory.getUtils();
    PageFactory.initElements(new AjaxElementLocatorFactory(this.factory.getDriver(), 30), this);
  }

  @FindBy(css = ENTRY_TITLE)
  private WebElement entryTitle;

  public String getEntryTitle() {
    return utils.getText(entryTitle);
  }

  public String getTitle() {
    LOG.info("Title: {}", factory.getDriver().getTitle());
    return factory.getDriver().getTitle();
  }
}
