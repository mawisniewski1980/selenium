package demoqa;

import enums.DemoqaEnums;
import enums.PageUrls;
import org.junit.Before;
import org.junit.Test;
import testobject.TestObject;

import static org.junit.Assert.assertEquals;

public class DemoqaSliderTest extends TestObject {



    private DemoqaSlider demoqaSlider;
    private DemoqaCommonElements commonElements;

    @Before
    public void setUrl() {
        setUrl(PageUrls.PageUrl.DEMOQA);
        demoqaSlider = new DemoqaSlider(driver);
        commonElements = new DemoqaCommonElements(driver);
        commonElements.demoqaMenu.sliderLinkClick();
    }

    @Test
    public void checkPageTitle() {
        assertEquals("Check Slider page title:", "Slider | Demoqa", demoqaSlider.getTitle());
    }

    @Test
    public void checkEntryTitle() {
        assertEquals("Check Slider entry title:", "Slider", commonElements.getEntryTitle());
    }

    @Test
    public void checkDefaultRange() {
        assertEquals("Check if default range is set to 2: ", 2, demoqaSlider.getRangeAmount());
    }

    @Test
    public void setRangeToTen() {
        demoqaSlider.setSliderHandle(DemoqaEnums.DemoqaSliderValue.TEN);
        assertEquals("Check if range in input field is 10", 10, demoqaSlider.getRangeAmount());
    }

    @Test
    public void setRangeToNine() {
        demoqaSlider.setSliderHandle(DemoqaEnums.DemoqaSliderValue.NINE);
        assertEquals("Check if range in input field is 9", 9, demoqaSlider.getRangeAmount());
    }

    @Test
    public void setRangeToEight() {
        demoqaSlider.setSliderHandle(DemoqaEnums.DemoqaSliderValue.EIGHT);
        assertEquals("Check if range in input field is 8", 8, demoqaSlider.getRangeAmount());
    }

    @Test
    public void setRangeToSeven() {
        demoqaSlider.setSliderHandle(DemoqaEnums.DemoqaSliderValue.SEVEN);
        assertEquals("Check if range in input field is 7", 7, demoqaSlider.getRangeAmount());
    }

    @Test
    public void setRangeToSix() {
        demoqaSlider.setSliderHandle(DemoqaEnums.DemoqaSliderValue.SIX);
        assertEquals("Check if range in input field is 6", 6, demoqaSlider.getRangeAmount());
    }

    @Test
    public void setRangeToFive() {
        demoqaSlider.setSliderHandle(DemoqaEnums.DemoqaSliderValue.FIVE);
        assertEquals("Check if range in input field is 5", 5, demoqaSlider.getRangeAmount());
    }

    @Test
    public void setRangeToFour() {
        demoqaSlider.setSliderHandle(DemoqaEnums.DemoqaSliderValue.FOUR);
        assertEquals("Check if range in input field is 4", 4, demoqaSlider.getRangeAmount());
    }

    @Test
    public void setRangeToThree() {
        demoqaSlider.setSliderHandle(DemoqaEnums.DemoqaSliderValue.THREE);
        assertEquals("Check if range in input field is 3", 3, demoqaSlider.getRangeAmount());
    }

    @Test
    public void setRangeToTwo() {
        demoqaSlider.setSliderHandle(DemoqaEnums.DemoqaSliderValue.TWO);
        assertEquals("Check if range in input field is 2", 2, demoqaSlider.getRangeAmount());
    }

    @Test
    public void setRangeToOne() {
        demoqaSlider.setSliderHandle(DemoqaEnums.DemoqaSliderValue.ONE);
        assertEquals("Check if range in input field is 1", 1, demoqaSlider.getRangeAmount());
    }
}
