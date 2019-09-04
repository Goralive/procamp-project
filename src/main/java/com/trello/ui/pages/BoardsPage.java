package com.trello.ui.pages;

import com.trello.api.TrelloRestClient;
import com.trello.ui.core.BrowserFactory;
import com.trello.ui.core.Element;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

import static com.trello.ui.core.Constants.*;


public class BoardsPage extends BrowserFactory {

    private static final String PATH = "java439/boards";

    public Element boardTileElem = new Element(By.cssSelector(".board-tile"),"Board tile");

    @Step
    public void open() throws IOException {
        trelloApiLogin();
        driver().get(URL + PATH);
    }

    @Step
    public boolean isOpened(String urlName) {
        return boardByUrlName(urlName).isElementPresent() && driver().getCurrentUrl().contains(PATH);

    }

    @Step
    public Element boardByUrlName(String urlName) {
        return new Element(By.cssSelector(".board-tile[href*='" + urlName + "']"), urlName.toLowerCase());
    }

    @Step
    public boolean waitUntilBoardTileClickable () {
      return boardTileElem.isElementPresent();
    }

    @Step
    public void openBoard(String urlName) {
        boardByUrlName(urlName).click();
    }
}
