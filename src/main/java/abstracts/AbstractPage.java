package abstracts;

import factories.SimplePageFactory;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractPage {

  private static final Logger LOG = LoggerFactory.getLogger(AbstractPage.class);

  protected SimplePageFactory pageFactory;

  public AbstractPage(SimplePageFactory pageFactory) {
    this.pageFactory = pageFactory;
    PageFactory.initElements(new AjaxElementLocatorFactory(this.pageFactory.getDriver(), 30), this);
  }

  protected SimplePageFactory factory() {
    return pageFactory;
  }


}
