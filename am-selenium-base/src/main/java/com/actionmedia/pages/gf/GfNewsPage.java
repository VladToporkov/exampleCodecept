package com.actionmedia.pages.gf;

import com.actionmedia.pages.helpers.NewsPageHelper;
import com.actionmedia.pages.interfaces.INewsPage;
import org.springframework.stereotype.Component;

/**
 * Created by Pavel on 12/04/16.
 */
@Component
public class GfNewsPage extends GFBasePage<GfNewsPage> implements INewsPage {

    public GfNewsPage checkNewsIsPresent() {
        getHelper(NewsPageHelper.class).checkNewsIsPresent();
        return this;
    }
}
