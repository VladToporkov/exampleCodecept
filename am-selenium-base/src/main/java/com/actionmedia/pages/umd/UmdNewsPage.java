package com.actionmedia.pages.umd;

import com.actionmedia.pages.helpers.NewsPageHelper;
import com.actionmedia.pages.interfaces.INewsPage;
import org.springframework.stereotype.Component;

/**
 * Created by Pavel on 11/07/16.
 */
@Component
public class UmdNewsPage extends UmdBasePage<UmdNewsPage> implements INewsPage {

    public UmdNewsPage checkNewsIsPresent() {
        getHelper(NewsPageHelper.class).checkNewsIsPresent();
        return this;
    }
}

