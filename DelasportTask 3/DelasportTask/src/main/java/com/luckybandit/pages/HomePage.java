package com.luckybandit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    public WebDriver driver;

    private final By balanceHeader = By.xpath("//*[@class=\"user-balance-item-amount\"]");

    private final By closeModalButton = By.xpath("//*[@id=\"sportsbookModal\"]//button");
    //private By closeModalButton = By.xpath("//*[@id=\"sportsbookModal\"]//span");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void closeModalIfPresent() {
        try {
            WebElement closeButton = driver.findElement(closeModalButton);
            if (closeButton.isDisplayed()) {
                closeButton.click();
            }
        } catch (Exception е) {
            // Do nothing...
        }
    }

    public String getDisplayedBalance() {
        return driver.findElement(balanceHeader).getText().replace("Balance: ", "");
    }
}

