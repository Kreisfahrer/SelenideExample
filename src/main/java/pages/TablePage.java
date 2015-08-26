package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class TablePage {
    @FindBy(id = "table2")
    public SelenideElement table;

    @FindBy(css = "#table2 tbody tr")
    public List<UserInfo> userInfoList;

    @FindBy(css = "#table2 th")
    public ElementsCollection columnHeaders;

    public void sort(Header headerName) {
        columnHeaders.get(headerName.index - 1).click();
    }

    public void delete(String email) {
        getUser(email).delete();
    }

    public void edit(String email) {
        getUser(email).edit();
    }

    public ElementsCollection getColumn(Header headerName) { // starting with 1
        return $$(String.format("#table2 tr td:nth-child(%d)", headerName.index));
    }
    
    private UserInfo getUser(String userEmail) {
        UserInfo neededUser = null;
        for (UserInfo user : userInfoList) {
            if (user.email.text().equals(userEmail)) {
                neededUser = user;
                break;
            }
        }
        return neededUser;
    }
    
    public enum Header {
        lastName(1), firstName(2), email(3), due(4), website(5), action(6);

        private int index;

         Header(int i) {
             index = i;
         }
    }

    public static class UserInfo extends ElementsContainer {
        @FindBy(className = "first-name")
        public SelenideElement firstName;
        @FindBy(className = "last-name")
        public SelenideElement lastName;
        @FindBy(className = "email")
        public SelenideElement email;
        @FindBy(className = "dues")
        public SelenideElement due;
        @FindBy(className = "web-site")
        public SelenideElement site;
        @FindBy(css = "a[href='#edit']")
        public SelenideElement edit;
        @FindBy(css = "a[href='#delete']")
        public SelenideElement delete;

        public void delete() {
            delete.click();
        }

        public void edit() {
            edit.click();
        }
    }
}


