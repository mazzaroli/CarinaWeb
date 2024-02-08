package com.carina.demo.gui.theInternet.components;

import com.carina.demo.gui.theInternet.pages.SecureAreaPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends AbstractUIObject {
    @FindBy(xpath = "//input[@id = 'username']")
    private ExtendedWebElement usernameInputField;
    @FindBy(xpath = "//input[@id = 'password']")
    private ExtendedWebElement passwordInputField;
    @FindBy(xpath = "//button/i[contains(text(), ' Login')]")
    private ExtendedWebElement loginButton;

    public LoginForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void typeUsername(String username) {
        usernameInputField.type(username);
    }

    public void typePassword(String password) {
        passwordInputField.type(password);
    }

    public SecureAreaPage clickLoginBtn() {
        loginButton.click();
        return new SecureAreaPage(getDriver());
    }
}
