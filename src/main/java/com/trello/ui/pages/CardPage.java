package com.trello.ui.pages;

import com.google.gson.Gson;
import com.trello.api.CookieStorage;
import com.trello.ui.core.BrowserFactory;
import com.trello.ui.core.Element;
import io.qameta.allure.Step;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.openqa.selenium.By;

import java.io.IOException;

import static com.trello.ui.core.Constants.*;


public class CardPage extends BrowserFactory {

    private static final String PATH = "b/Iceo5BlK/igore4ek";
    private String testCardUrl;

    public Element testedCardElem = new Element(By.cssSelector("#board a[href*='test']"),"Created card contains 'Test'");
    public Element cardDetailWindowElem = new Element(By.cssSelector(".card-detail-window"),"Card is opened in pop-up window");

    @Step
    public void openCardPage () throws IOException {
        trelloApiLogin();
        driver().get(URL+PATH);
    }

    @Step
    public boolean cardIsCreated() {
        return testedCardElem.isElementClickable();
    }

    @Step
    public boolean openTestCard() {
        testedCardElem.click();
        return cardDetailWindowElem.isElementPresent();
    }

    public void openCreatedTestCard () {

    }
}
