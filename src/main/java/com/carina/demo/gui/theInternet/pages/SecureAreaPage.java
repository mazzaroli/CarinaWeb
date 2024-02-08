package com.carina.demo.gui.theInternet.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SecureAreaPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='flash']")
    private ExtendedWebElement statusAlert;

    public SecureAreaPage(WebDriver driver) {
        super(driver);
    }

    public String getAlertText() {
        return driver.findElement(statusAlert.getBy()).getText();
    }
}
