package abstracts;

import factories.SimplePageFactory;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Utils;

public abstract class AbstractPage {

  private static final Logger LOG = LoggerFactory.getLogger(AbstractPage.class);

  protected SimplePageFactory factory;
  protected Utils utils;

  public AbstractPage(SimplePageFactory factory) {
    this.factory = factory;
    this.utils = new Utils(this.factory.getDriver());
    PageFactory.initElements(new AjaxElementLocatorFactory(this.factory.getDriver(), 30), this);
  }

}
