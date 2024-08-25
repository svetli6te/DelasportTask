package com.luckybandit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    public WebDriver driver;

    private By smallLoginButton = By.xpath("//*[contains(text(), 'Log In')]");
    private By usernameField = By.id("login_form[username]");
    private By passwordField = By.id("login-modal-password-input");
    private By bigLoginButton = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void clickSmallLoginButton() {
        driver.findElement(smallLoginButton).click();
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickBigLoginButton() {
        driver.findElement(bigLoginButton).click();
    }
}
