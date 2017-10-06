package com.actionmedia.pages.elpu;

import com.actionmedia.pages.helpers.NewsPageHelper;
import com.actionmedia.pages.interfaces.INewsPage;
import org.springframework.stereotype.Component;

/**
 * Created by Pavel on 11/07/16.
 */
@Component
public class ElpuNewsPage extends ElpuBasePage<ElpuNewsPage> implements INewsPage {

    public ElpuNewsPage checkNewsIsPresent() {
        getHelper(NewsPageHelper.class).checkNewsIsPresent();
        return this;
    }
}

