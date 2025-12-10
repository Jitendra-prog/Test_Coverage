package com.demo.ui;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class HerokuAppHelper {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final String BASE_URL = "https://the-internet.herokuapp.com";

    public HerokuAppHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openHomePage() { driver.get(BASE_URL); }
    public void openLoginPage() { driver.get(BASE_URL + "/login"); }
    public void openCheckboxesPage() { driver.get(BASE_URL + "/checkboxes"); }
    public void openDropdownPage() { driver.get(BASE_URL + "/dropdown"); }
    public void openForgotPasswordPage() { driver.get(BASE_URL + "/forgot_password"); }

    public void login(String username, String password) {
        openLoginPage();
        WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        WebElement pass = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));

        user.clear(); user.sendKeys(username);
        pass.clear(); pass.sendKeys(password);
        loginBtn.click();
    }

    public String getFlashMessage() {
        WebElement flash = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        return flash.getText();
    }

    public boolean isOnSecureArea() { return driver.getCurrentUrl().contains("/secure"); }

    public void logout() {
        WebElement logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[href='/logout']")));
        logoutBtn.click();
    }

    public String getPageTitle() { return driver.getTitle(); }
    public String getCurrentUrl() { return driver.getCurrentUrl(); }

    public boolean isFirstCheckboxSelected() {
        WebElement cb = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("#checkboxes input:nth-of-type(1)")));
        return cb.isSelected();
    }

    public void toggleFirstCheckbox() {
        WebElement cb = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("#checkboxes input:nth-of-type(1)")));
        cb.click();
    }

    public int getDropdownOptionsCount() {
        WebElement dropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("dropdown")));
        return dropdown.findElements(By.tagName("option")).size();
    }

    public void selectDropdownOptionByValue(String value) {
        WebElement dropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("dropdown")));
        dropdown.findElement(By.cssSelector("option[value='" + value + "']")).click();
    }

    public String getSelectedDropdownText() {
        WebElement dropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("dropdown")));
        for (WebElement option : dropdown.findElements(By.tagName("option"))) {
            if (option.isSelected()) return option.getText();
        }
        return "";
    }

    public String getForgotPasswordHeader() {
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));
        return header.getText();
    }
}
