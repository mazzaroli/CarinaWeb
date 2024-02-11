package com.carina.demo.mobile.gui.pages.common;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class ShopPageBase extends AbstractPage {

    public ShopPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickAddToCartBtn();

    public abstract void clickRemoveBtn();

    public abstract boolean isCartNotEmpty();
}
