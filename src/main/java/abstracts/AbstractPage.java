package abstracts;

import factories.MyPageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractPage {

  private static final Logger LOG = LoggerFactory.getLogger(AbstractPage.class);

  private MyPageFactory pageFactory;

  public AbstractPage(MyPageFactory pageFactory, WebDriver driver) {
    this.pageFactory = pageFactory;
    PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
  }

  public MyPageFactory getPageFactory() {
    return pageFactory;
  }
}
