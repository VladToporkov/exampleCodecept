package com.actionmedia.pages.klpu;

import com.actionmedia.pages.helpers.NewsPageHelper;
import com.actionmedia.pages.interfaces.INewsPage;
import org.springframework.stereotype.Component;

/**
 * Created by Pavel on 11/07/16.
 */
@Component
public class KlpuNewsPage extends KlpuBasePage<KlpuNewsPage> implements INewsPage {

    public KlpuNewsPage checkNewsIsPresent() {
        getHelper(NewsPageHelper.class).checkNewsIsPresent();
        return this;
    }
}

