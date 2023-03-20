package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtils;

public class HomePage extends BasePage {

    @FindBy(xpath = "(//a[@id='mega-menu-1'])[1]")
    private WebElement platform_Button;

    @FindBy(xpath = "(//a[@id='mega-menu-1'])[2]")
    private WebElement industries_Button;

    @FindBy(xpath = "(//a[@id='mega-menu-1'])[3]")
    private WebElement useCases_Button;

    @FindBy(xpath = "(//a[@id='mega-menu-1'])[4]")
    private WebElement resources_Button;

    @FindBy(xpath = "(//a[@id='mega-menu-1'])[5]")
    private WebElement blog_Button;

    @FindBy(xpath = "(//a[@id='mega-menu-1'])[6]")
    private WebElement more_Button;

    @FindBy(xpath = "//span[.='Product Demo Hub']")
    private WebElement productDemoHub_Button;

    @FindBy(xpath = "//h5[.='Careers']")
    private WebElement careers_Button;

    @FindBy(xpath = "(//h1[@data-animate='fade-in'])[1]")
    private WebElement homePageMessage;

    @FindBy(xpath = "//a[@id='wt-cli-accept-all-btn']")
    private WebElement cookies;






    public void clickMoreButtonAndClickCareersButton(){
        more_Button.click();
        BrowserUtils.wait(2);
        careers_Button.click();
    }
    public String getMessage(){
      return  homePageMessage.getText();

    }
    public void acceptCookies(){
        cookies.click();
    }
}
