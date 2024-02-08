package com.carina.demo.gui.theInternet.pages;

import com.carina.demo.enums.AvailablePages;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickFormAuthentication() {
        clickLink(AvailablePages.LOGIN.getXpath());
        return new LoginPage(getDriver());
    }

    public DropdownPage clickDropdown() {
        clickLink(AvailablePages.DROPDOWN.getXpath());
        return new DropdownPage(getDriver());
    }

    public KeyPressesPage clickKeyPresses() {
        clickLink(AvailablePages.KEY_PRESSES.getXpath());
        return new KeyPressesPage(getDriver());
    }

    public void clickLink(String xpath) {
        ExtendedWebElement element = findExtendedWebElement(By.xpath(xpath));
        element.click();
    }
}
