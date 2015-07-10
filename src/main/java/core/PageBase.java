package core;

import helpers.Waiter;

import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.core.Is.is;

public class PageBase {

    protected static void shouldAppear(String title) {
        Waiter.waitForPageToLoad();
        //assumeThat($("title").innerText(), is(title));
    }
}
