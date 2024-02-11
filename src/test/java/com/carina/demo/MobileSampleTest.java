package com.carina.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.carina.demo.mobile.gui.pages.common.ShopPageBase;
import com.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;

public class MobileSampleTest implements IAbstractTest, IMobileUtils {

    @Test()
    @MethodOwner(owner = "carlitos")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testLoginUser() {
        String username = "standard_user";
        String password = "secret_sauce";
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.typeName(username);
        loginPage.typePassword(password);
        ShopPageBase shopPageBase = loginPage.clickLoginBtn();
        Assert.assertTrue(shopPageBase.isPageOpened(), "Swag Labs shop page isn't opened");
    }

    @Test()
    @MethodOwner(owner = "carlitos")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testAddToCart() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        ShopPageBase shopPage = loginPage.login();
        shopPage.clickAddToCartBtn();
        Assert.assertTrue(shopPage.isCartNotEmpty(), "Cart didn't add the product");
        shopPage.clickRemoveBtn();
        Assert.assertFalse(shopPage.isCartNotEmpty(), "Cart didn't delete the product");
    }
}
