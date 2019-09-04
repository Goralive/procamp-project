package regression;

import com.trello.ui.core.BrowserFactory;
import com.trello.ui.pages.BoardsPage;
import com.trello.ui.pages.LoginPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;



@Epic("Regression")
@Feature("Positive login test")
public class LoginTest extends BrowserFactory {

    LoginPage loginPage = new LoginPage();
    BoardsPage boardsPage = new BoardsPage();

    @Story("Enter with valid user")
    @Test
    public void login() {
        loginPage.open();
        loginPage.login("L3438@yandex.ru", "QAZxsw123");
        loginPage.isOpened();
    }

    @Test
    public void boardsIsPresent() {
        loginPage.open();
        loginPage.login("L3438@yandex.ru", "QAZxsw123");
        Assert.assertTrue(boardsPage.isOpened("igore4ek"));
    }
}
