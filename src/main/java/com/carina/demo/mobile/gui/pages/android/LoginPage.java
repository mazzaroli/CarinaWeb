package com.carina.demo.mobile.gui.pages.android;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.carina.demo.mobile.gui.pages.common.ShopPageBase;
import com.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase implements IMobileUtils {

    @FindBy(xpath = "//*[@content-desc='test-Username']")
    private ExtendedWebElement nameInputField;

    @FindBy(xpath = "//*[@content-desc='test-Password']")
    private ExtendedWebElement passwordInputField;

    @FindBy(xpath = "//*[@content-desc='test-LOGIN']")
    private ExtendedWebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeName(String name) {
        nameInputField.type(name);
        hideKeyboard();
    }

    @Override
    public void typePassword(String password) {
        passwordInputField.type(password);
    }


    @Override
    public ShopPageBase clickLoginBtn() {
        loginBtn.click();
        return initPage(getDriver(), ShopPageBase.class);
    }

    @Override
    public ShopPageBase login() {
        String username = "standard_user";
        String password = "secret_sauce";
        typeName(username);
        typePassword(password);
        return clickLoginBtn();
    }
}