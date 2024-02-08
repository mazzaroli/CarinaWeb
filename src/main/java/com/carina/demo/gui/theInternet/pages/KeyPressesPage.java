package com.carina.demo.gui.theInternet.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class KeyPressesPage extends AbstractPage {
    @FindBy(xpath = "//*[@id='target']")
    private ExtendedWebElement inputField;

    @FindBy(xpath = "//*[@id='result']")
    private ExtendedWebElement resultField;

    public KeyPressesPage(WebDriver driver) {
        super(driver);
    }

    public void typeKey(String key) {
        inputField.type(key);
    }

    public boolean compareWithInput(String expectedKey) {
        String actualKey = resultField.getText().trim().replace("You entered: ","");
        return actualKey.equals(expectedKey);
    }
}
