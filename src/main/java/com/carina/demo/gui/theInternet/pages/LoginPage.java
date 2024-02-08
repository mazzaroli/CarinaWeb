package com.carina.demo.gui.theInternet.pages;

import com.carina.demo.gui.theInternet.components.LoginForm;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    @FindBy(xpath = "//div[contains(text(),'Your username is invalid!')]")
    private ExtendedWebElement errorUsername;
    @FindBy(xpath = "//div[contains(text(),'Your password is invalid!')]")
    private ExtendedWebElement errorPassword;

    @FindBy(xpath = "//*[@id='login']")
    private LoginForm loginForm;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginForm getLoginForm() {
        return loginForm;
    }
}