package com.actionmedia.pages.go;

import com.actionmedia.pages.helpers.NewsPageHelper;
import com.actionmedia.pages.interfaces.INewsPage;
import org.springframework.stereotype.Component;

/**
 * Created by Pavel on 11/07/16.
 */
@Component
public class GoNewsPage extends GoBasePage<GoNewsPage> implements INewsPage {

    public GoNewsPage checkNewsIsPresent() {
        getHelper(NewsPageHelper.class).checkNewsIsPresent();
        return this;
    }
}

