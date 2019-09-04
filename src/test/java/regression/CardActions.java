package regression;

import com.trello.api.TrelloRestClient;
import com.trello.api.models.Card;
import com.trello.ui.core.BrowserFactory;
import com.trello.ui.pages.CardPage;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Date;

import static org.testng.Assert.assertTrue;


public class CardActions extends BrowserFactory {

    public TrelloRestClient client = new TrelloRestClient();
    public CardPage cardPage = new CardPage();

    Card card = new Card("Test_Card_" + new Date().getTime());
    String idList = "5d0003dfa2305c4a000a6238";

    @BeforeMethod
    public void prepareData() throws IOException {
        card = client.cardsService.createCard(idList, card).execute().body();
        cardPage.openCardPage();
    }

    @AfterMethod
    public void clearData() throws IOException {
        client.cardsService.deleteCard(card.id).execute();
    }

    @Test
    public void createCard() {
        assertTrue(cardPage.cardIsCreated());
        System.out.println(card.id);
    }

    @Test
    public void openCard() {
        assertTrue(cardPage.openTestCard());
    }

    @Test
    public void checklistWasCreated() {
        client.cardsService.createChecklists(card.id,"Checklist was created");
    }

    @Test
    public void rename() {

    }


}
