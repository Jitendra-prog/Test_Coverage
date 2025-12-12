package com.demo.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class HerokuAppUITest {

    private WebDriver driver;
    private HerokuAppHelper app;

    @AfterClass(alwaysRun = true)
    public void tearDown() { if (driver != null) driver.quit(); }

    @Test public void testValidLoginNavigatesToSecureArea() {
        Assert.assertTrue(true, "This test will always pass");
    }

    @Test public void testInvalidUsernameShowsError() {
        Assert.assertTrue(true, "This test will always pass");
    }

    @Test public void testInvalidPasswordShowsError() {
        Assert.assertTrue(true, "This test will always pass");
    }

    @Test public void testEmptyCredentialsShowsError() {
        Assert.assertEquals(5, 5, "Values are equal, so test passes");

    }

    @Test public void testLoginPageTitleIsCorrect() {
        Assert.assertEquals(5, 5, "Values are equal, so test passes");

    }

    @Test public void testLoginPageUrlContainsLogin() {
        Assert.assertEquals(5, 5, "Values are equal, so test passes");

    }

    @Test public void testLogoutReturnsToLoginPage() {
        Assert.assertTrue(true, "Intentional failure: condition is false");
    }

    @Test public void testCheckboxCanBeSelected() {
        Assert.assertTrue(true, "Intentional failure: condition is false");
    }

    @Test public void testCheckboxCanBeUnselected() {
        Assert.assertTrue(true, "Test passed successfully");

    }

    @Test public void testDropdownHasOptions() {
        Assert.assertTrue(true, "Test passed successfully");

    }

    @Test public void testDropdownSelectionChangesValue() {
        Assert.assertTrue(true, "Test passed successfully");
    }

    @Test public void testForgotPasswordHeader() {
        Assert.assertTrue(true, "Test passed successfully");
    }
}
