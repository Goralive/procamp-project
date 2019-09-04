package junk;

import com.trello.api.TrelloRestClient;
import com.trello.api.models.Card;
import com.trello.ui.core.BrowserFactory;
import org.testng.annotations.Test;

import java.io.IOException;

public class TryApit extends BrowserFactory {

    TrelloRestClient client = new TrelloRestClient();


    @Test
    public void callIt() throws IOException, InterruptedException {
        Card card = new Card();
        card.name = "My New CARD 2";
        Card createdCard = client.cardsService.createCard("5d0003dfa2305c4a000a6238", card).execute().body();
        client.cardsService.deleteCard(createdCard.id).execute();
        driver().get("https://trello.com/java439/boards");
        Thread.sleep(5000);

    }

}