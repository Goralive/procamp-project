package regression;

import com.trello.ui.pages.BoardsPage;
import org.testng.annotations.Test;

import java.io.IOException;

public class BoardAction {

    public BoardsPage boardsPage = new BoardsPage();

    String urlName = "igore4ek";


    @Test
    public void openBoard () throws IOException {
        boardsPage.open();
        boardsPage.waitUntilBoardTileClickable();
        boardsPage.openBoard(urlName);
    }
}
