package com.trello.ui.core;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.trello.ui.core.BrowserFactory.*;

public class Element {

    private By by;
    private String name;


    public Element(By by, String name) {
        this.by = by;
        this.name = name;
    }

    public Element(By by) {
        this(by, "");
    }

    public WebElement find() {
        return getWebDriverWait(10).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void click() {
        find().click();
    }

    public void type(String text) {
        find().clear();
        find().sendKeys(text);
    }

    public boolean isElementPresent() {
        try {
            getWebDriverWait(10).until(ExpectedConditions.presenceOfElementLocated(by));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isElementClickable(){
        try {
            getWebDriverWait(10).until(ExpectedConditions.elementToBeClickable(by));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
