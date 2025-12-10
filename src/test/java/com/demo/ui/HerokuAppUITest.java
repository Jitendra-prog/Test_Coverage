package com.demo.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class HerokuAppUITest {

    private WebDriver driver;
    private HerokuAppHelper app;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        app = new HerokuAppHelper(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() { if (driver != null) driver.quit(); }

    @Test public void testValidLoginNavigatesToSecureArea() {
        app.login("tomsmith", "SuperSecretPassword!");
        Assert.assertTrue(app.isOnSecureArea());
        Assert.assertTrue(app.getFlashMessage().contains("You logged into a secure area"));
    }

    @Test public void testInvalidUsernameShowsError() {
        app.login("invalidUser", "SuperSecretPassword!");
        Assert.assertTrue(app.getFlashMessage().contains("Your username is invalid!"));
    }

    @Test public void testInvalidPasswordShowsError() {
        app.login("tomsmith", "WrongPassword");
        Assert.assertTrue(app.getFlashMessage().contains("Your password is invalid!"));
    }

    @Test public void testEmptyCredentialsShowsError() {
        app.login("", "");
        Assert.assertTrue(app.getFlashMessage().toLowerCase().contains("invalid"));
    }

    @Test public void testLoginPageTitleIsCorrect() {
        app.openLoginPage();
        Assert.assertEquals(app.getPageTitle(), "The Internet");
    }

    @Test public void testLoginPageUrlContainsLogin() {
        app.openLoginPage();
        Assert.assertTrue(app.getCurrentUrl().contains("/login"));
    }

    @Test public void testLogoutReturnsToLoginPage() {
        app.login("tomsmith", "SuperSecretPassword!");
        Assert.assertTrue(app.isOnSecureArea());
        app.logout();
        Assert.assertTrue(app.getCurrentUrl().contains("/login"));
    }

    @Test public void testCheckboxCanBeSelected() {
        app.openCheckboxesPage();
        if (!app.isFirstCheckboxSelected()) app.toggleFirstCheckbox();
        Assert.assertTrue(app.isFirstCheckboxSelected());
    }

    @Test public void testCheckboxCanBeUnselected() {
        app.openCheckboxesPage();
        if (app.isFirstCheckboxSelected()) app.toggleFirstCheckbox();
        Assert.assertFalse(app.isFirstCheckboxSelected());
    }

    @Test public void testDropdownHasOptions() {
        app.openDropdownPage();
        Assert.assertTrue(app.getDropdownOptionsCount() >= 2);
    }

    @Test public void testDropdownSelectionChangesValue() {
        app.openDropdownPage();
        app.selectDropdownOptionByValue("2");
        Assert.assertTrue(app.getSelectedDropdownText().contains("Option 2"));
    }

    @Test public void testForgotPasswordHeader() {
        app.openForgotPasswordPage();
        Assert.assertEquals(app.getForgotPasswordHeader().trim(), "Forgot Password");
    }
}
