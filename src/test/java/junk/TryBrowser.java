package junk;

import com.trello.ui.core.BrowserFactory;
import com.trello.ui.pages.BoardsPage;
import org.testng.annotations.Test;

import java.io.IOException;

public class TryBrowser extends BrowserFactory {

    @Test
    public void openClose() throws InterruptedException, IOException {
        BoardsPage boardsPage = new BoardsPage();
        boardsPage.open();

    }
}
