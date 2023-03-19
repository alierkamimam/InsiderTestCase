package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtils;

public class HomePage extends BasePage {

    @FindBy(xpath = "(//a[@id='mega-menu-1'])[1]")
    private WebElement platform_Button;

    @FindBy(xpath = "(//a[@id='mega-menu-1'])[2]")
    private WebElement Industries_Button;

    @FindBy(xpath = "(//a[@id='mega-menu-1'])[3]")
    private WebElement UseCases_Button;

    @FindBy(xpath = "(//a[@id='mega-menu-1'])[4]")
    private WebElement Resources_Button;

    @FindBy(xpath = "(//a[@id='mega-menu-1'])[5]")
    private WebElement Blog_Button;

    @FindBy(xpath = "(//a[@id='mega-menu-1'])[6]")
    private WebElement More_Button;

    @FindBy(xpath = "//span[.='Product Demo Hub']")
    private WebElement productDemoHub_Button;

    @FindBy(xpath = "//h5[.='Careers']")
    private WebElement Careers_Button;

    @FindBy(xpath = "(//h1[@data-animate='fade-in'])[1]")
    private WebElement homePageMessage;

    @FindBy(xpath = "//a[@id='wt-cli-accept-all-btn']")
    private WebElement cookies;






    public void clickMoreButtonAndClickCareersButton(){
        More_Button.click();
        BrowserUtils.wait(2);
        Careers_Button.click();
    }
    public String getMessage(){
      return  homePageMessage.getText();

    }
    public void acceptCookies(){
        cookies.click();
    }
}
