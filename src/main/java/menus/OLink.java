package menus;

import org.fest.assertions.api.Fail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OLink extends OButton {

	//private static final Logger LOG = LoggerFactory.getLogger(Link.class.getName());

	public OLink(WebDriver driver, WebElement webElement) {
		super(driver, webElement);
	}
	
	@Override
	protected WebElement setCheckedWebElement(WebElement webElement) {

		if (webElement.getTagName().equalsIgnoreCase("A")) {
			//LOG.info("WebElement has an attribute = A");
			return webElement;
			
		} else if (webElement.getTagName().equalsIgnoreCase("LI")) {
			//LOG.info("WebElement has an attribute = LI");
			return webElement;
		} else if (webElement.getTagName().equalsIgnoreCase("INPUT")) {
			//LOG.info("WebElement has an attribute = INPUT");
			return webElement;
		}

		Fail.fail("WebElement has not require attribute");
		return null;
	}
	
}
