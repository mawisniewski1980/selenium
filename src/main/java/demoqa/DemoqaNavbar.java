package demoqa;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demoqablog.DemoqaBlog;
import demoqacontact.DemoqaContact;
import menus.OLink;
import pageobject.PageObject;

public class DemoqaNavbar extends PageObject{
	
	public static final Logger LOG = LoggerFactory.getLogger(DemoqaNavbar.class);

	public DemoqaNavbar(WebDriver driver) {
		super(driver);
	}

	private final String homeLinkCss = "#menu-item-38";
	@FindBy(css = homeLinkCss)
	private WebElement homeLink;
	
	private final String aboutUsLinkCss = "#menu-item-158";
	@FindBy(css = aboutUsLinkCss)
	private WebElement aboutUsLink;
	
	private final String servicesLinkCss = "#menu-item-155";
	@FindBy(css = servicesLinkCss)
	private WebElement servicesLink;
	
	private final String demoLinkCss = "#menu-item-66";
	@FindBy(css = demoLinkCss)
	private WebElement demoLink;
	
	private final String demoLinksListCss = ".dropdown-menu li";
	@FindBy(css = demoLinksListCss)
	private List<WebElement> demoLinksList;
	
	private final String draggableLinkCss = "#menu-item-73";
	@FindBy(css = draggableLinkCss)
	private WebElement draggableLink;
	
	private final String tabsLinkCss = "#menu-item-153";
	@FindBy(css = tabsLinkCss)
	private WebElement tabsLink;
	
	private final String blogLinkCss = "#menu-item-65";
	@FindBy(css = blogLinkCss)
	private WebElement blogLink;
	
	private final String contactLinkCss = "#menu-item-64";
	@FindBy(css = contactLinkCss)
	private WebElement contactLink;
	
	
	
	
	public DemoqaHome homeLinkClick(){
		new OLink(driver,homeLink).click();
		return new DemoqaHome(driver);
	}
	
	public DemoqaAboutUs aboutUsLinkClick(){
		new OLink(driver,aboutUsLink).click();
		return new DemoqaAboutUs(driver);
	}
	
	public DemoqaServices servicesLinkClick(){
		new OLink(driver,servicesLink).click();
		return new DemoqaServices(driver);
	}
	
	private void demoLinkClick(){
		new OLink(driver,demoLink).click();
		utils.waitForVisibilityOfElements(demoLinksList);
	}
	
	public DemoqaDraggable draggableLinkClick(){
		demoLinkClick();
		new OLink(driver,draggableLink).click();
		return new DemoqaDraggable(driver);
	}
	
	public DemoqaTabs tabsLinkClick(){
		demoLinkClick();
		new OLink(driver,tabsLink).click();
		return new DemoqaTabs(driver);
	}
	
	public DemoqaBlog blogLinkClick(){
		new OLink(driver,blogLink).click();
		return new DemoqaBlog(driver);
	}
	
	public DemoqaContact contactLinkClick(){
		new OLink(driver,contactLink).click();
		return new DemoqaContact(driver);
	}
}
