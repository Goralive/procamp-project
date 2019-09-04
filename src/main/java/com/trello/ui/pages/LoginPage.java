package com.trello.ui.pages;

import com.trello.ui.core.Constants;
import com.trello.ui.core.Element;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.Assert;


import java.util.Set;

import static com.trello.ui.core.BrowserFactory.*;

public class LoginPage {

    private static final String PATH = "login";

    public Element loginFld = new Element(By.cssSelector("#user"), "Login Field");
    public Element passwordFld = new Element(By.cssSelector("#password"), "Password Field");
    public Element loginBtn = new Element(By.cssSelector("#login"), "Login Button");

    @Step("Open Url")
    public void open() {
        get(Constants.URL + PATH);
        Assert.assertTrue(isOpened(),"Page 'login' [" + PATH + "] not Opened");
    }

    @Step()
    public boolean isOpened() {
        return loginBtn.isElementPresent() && driver().getCurrentUrl().contains(PATH);
    }

    @Step
    public void login(String email, String password) {
        loginFld.type(email);
        passwordFld.type(password);
        loginBtn.click();

    }

}
