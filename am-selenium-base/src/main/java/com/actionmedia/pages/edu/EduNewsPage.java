package com.actionmedia.pages.edu;

import com.actionmedia.pages.helpers.NewsPageHelper;
import com.actionmedia.pages.interfaces.INewsPage;
import org.springframework.stereotype.Component;

/**
 * Created by Pavel on 11/07/16.
 */
@Component
public class EduNewsPage extends EduBasePage<EduNewsPage> implements INewsPage {

    public EduNewsPage checkNewsIsPresent() {
        getHelper(NewsPageHelper.class).checkNewsIsPresent();
        return this;
    }
}
