package com.carina.demo;

import com.carina.demo.gui.theInternet.components.LoginForm;
import com.carina.demo.gui.theInternet.pages.*;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WebTheInternetTest implements IAbstractTest {
    HomePage homePage = new HomePage(getDriver());

    @BeforeMethod
    public void homePageSetUp() {
        homePage.open();
    }

    @Test(dataProvider = "Creds")
    public void loginTest(String user, String password){
        LoginPage loginPage = homePage.clickFormAuthentication();
        LoginForm loginForm = loginPage.getLoginForm();
        loginForm.typeUsername(user);
        loginForm.typePassword(password);
        SecureAreaPage secureAreaPage = loginForm.clickLoginBtn();

        Assert.assertTrue(secureAreaPage.getAlertText().contains("You logged into a secure area!"), "Alert text is incorrect");
    }

    @Test(dataProvider = "Opts")
    public void testSelectOption(String option) {
        DropdownPage dropdownPage = homePage.clickDropdown();

        dropdownPage.selectFromDropdown(option);
        var selectedOptions = dropdownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option), "Option not selected");
    }


    @Test
    public void testKeyPressed() {
        KeyPressesPage keyPressesPage = homePage.clickKeyPresses();

        String key = "A";
        keyPressesPage.typeKey(key.toUpperCase());

        boolean keyMatch = keyPressesPage.compareWithInput(key);
        Assert.assertTrue(keyMatch, "La tecla no es");
    }

    @DataProvider(parallel = false, name = "Creds")
    public static Object[][] credentials()
    {
        return new Object[][] {
                { "tomsmith", "SuperSecretPassword!"},
                { "Carlitos", "CannotEnterHere"}
        };
    }

    @DataProvider(parallel = false, name = "Opts")
    public static Object[][] options()
    {
        return new Object[][] {
                { "Option 1"},
                { "Option 2"}
        };
    }
}
