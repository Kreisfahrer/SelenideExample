import core.TestBase;
import helpers.ScreenShotListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.TablePage;

import java.util.Arrays;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.open;

@Listeners(ScreenShotListener.class)
public class PageObjectTest extends TestBase {
    private TablePage tablePage;

    @BeforeMethod
    public void setup() {
        tablePage = open("/tables", TablePage.class);
    }

    @Test
    public void sortByLastNameTest() {
        TablePage.Header lastName = TablePage.Header.lastName;
        String[] texts = tablePage.getColumn(lastName).getTexts();
        tablePage.sort(lastName);
        Arrays.sort(texts);
        tablePage.getColumn(lastName).shouldHave(texts(texts));
    }

    @Test
    public void sortByFirstNameTest() {
        TablePage.Header firstName = TablePage.Header.firstName;
        String[] texts = tablePage.getColumn(firstName).getTexts();
        tablePage.sort(firstName);
        Arrays.sort(texts);
        tablePage.getColumn(firstName).shouldHave(texts(texts));
    }

    @Test
    public void sortByEmailTest() {
        TablePage.Header email = TablePage.Header.email;
        String[] texts = tablePage.getColumn(email).getTexts();
        tablePage.sort(email);
        Arrays.sort(texts);
        tablePage.getColumn(email).shouldHave(texts(texts));
    }

    @Test
    public void sortByWebSiteTest() {
        TablePage.Header website = TablePage.Header.website;
        String[] texts = tablePage.getColumn(website).getTexts();
        tablePage.sort(website);
        Arrays.sort(texts);
        tablePage.getColumn(website).shouldHave(texts(texts));
    }
}
