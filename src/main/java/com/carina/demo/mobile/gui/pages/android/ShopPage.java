package com.carina.demo.mobile.gui.pages.android;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.carina.demo.mobile.gui.pages.common.ShopPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = ShopPageBase.class)
public class ShopPage extends ShopPageBase {

    @FindBy(xpath = "//*[@text='PRODUCTS']")
    private ExtendedWebElement webViewContent;

    @FindBy(xpath = "//*[@content-desc='test-Cart']")
    private ExtendedWebElement cartEmpty;

    @FindBy(xpath = "//*[@text='1']")
    private ExtendedWebElement cartCount;

    @FindBy(xpath = "//*[@text='ADD TO CART'][1]")
    private ExtendedWebElement addToCartBtn;

    @FindBy(xpath = "//*[@text='REMOVE'][1]")
    private ExtendedWebElement removeBtn;


    public ShopPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickAddToCartBtn() {
        addToCartBtn.click();
    }

    @Override
    public void clickRemoveBtn() {
        removeBtn.click();
    }

    @Override
    public boolean isPageOpened() {
        return webViewContent.isElementPresent();
    }

    @Override
    public boolean isCartNotEmpty () {
        return cartCount.isElementPresent();
    }
}
