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

    @FindBy(css = "#table2 tr td:nth-child(1)")
    public List<SelenideElement> lastNameColumn;

    public void sort(String columnName) {
        for(SelenideElement header : columnHeaders) {
            if (header.getText().equals(columnName)) {
                header.click();
                break;
            }
        }
    }

    public void sort(int columnNum) {
        columnHeaders.get(columnNum).click();
    }

    public void delete(String email) {
        for (UserInfo user : userInfoList) {
            if (user.email.text().equals(email)) {
                user.delete();
                break;
            }
        }
    }

    public void edit(String email) {
        for (UserInfo user : userInfoList) {
            if (user.email.text().equals(email)) {
                user.edit();
                break;
            }
        }
    }

    public ElementsCollection getColumn(int columnNum) {
        return $$(String.format("#table2 tr td:nth-child(%s)", columnNum));
    }

    public String [] getTexts(List<SelenideElement> elements) {
        String [] texts = new String [elements.size()];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = elements.get(i).getText();
        }
        return texts;
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


