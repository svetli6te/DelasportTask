package com.luckybandit.tests;

import com.luckybandit.base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.luckybandit.pages.HomePage;
import com.luckybandit.pages.LoginPage;
import com.luckybandit.utils.ApiHelper;

public class BalanceVerificationTest extends BaseTest {

    @Test
    public void verifyBalance() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.clickSmallLoginButton();
        loginPage.enterUsername("tu_svetla");
        loginPage.enterPassword("Pass112#");
        loginPage.clickBigLoginButton();
        homePage.closeModalIfPresent();
        String displayedBalance = homePage.getDisplayedBalance();
        String apiBalance = ApiHelper.getMemberBalance();

        Assertions.assertEquals(displayedBalance, apiBalance, "The UI balance does not match the API");
    }
}
