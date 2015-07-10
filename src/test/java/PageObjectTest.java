import com.codeborne.selenide.testng.ScreenShooter;
import core.TestBase;
import helpers.ScreenShotListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.TablePage;

import java.util.Arrays;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.CollectionCondition.texts;

@Listeners(ScreenShotListener.class)
public class PageObjectTest extends TestBase{
    private TablePage tablePage;

    @BeforeMethod
    public void setup() {
        tablePage = open("/tables", TablePage.class);
    }

    @Test
    public void tableTest() {
        System.out.println(tablePage.table.toString());
        System.out.println(tablePage.columnHeaders.toString());
        for(TablePage.UserInfo user : tablePage.userInfoList) {
            System.out.println(user.firstName.toString());
        }
    }

    @Test
    public void sortByLastNameTest() {
        for(int i = 1; i <= tablePage.columnHeaders.size(); i++) {
            String[] texts = tablePage.getColumn(i).getTexts();
            Arrays.sort(texts);
            tablePage.sort(i - 1);
            tablePage.getColumn(i).shouldHave(texts(texts));
        }
    }
}
