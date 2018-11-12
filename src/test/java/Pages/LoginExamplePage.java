package Pages;

import Steps.Base.BaseUtil;
import Pages.Utils.ExplicitWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginExamplePage extends ExplicitWaits {

    WebDriver driver;

    public LoginExamplePage(BaseUtil base){
        //Initialize the page object
        PageFactory.initElements(base.driver, this);
        driver = base.driver;
    }

    @FindBy(xpath = "//div[contains(text(),'Login')]")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;

    public void iPressLoginButton(){
        waitForElementIsClickable(driver, loginButton);
        loginButton.click();
    }

    public void iEnterEmail(String email){
        waitForVisibility(driver, emailInput);
        emailInput.sendKeys(email);
    }

    public void iEnterPassword(String password){
        waitForVisibility(driver, passwordInput);
        passwordInput.sendKeys(password);
    }
}
