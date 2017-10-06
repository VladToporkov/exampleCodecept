package com.actionmedia.pages.cult;

import com.actionmedia.pages.helpers.NewsPageHelper;
import com.actionmedia.pages.interfaces.INewsPage;
import org.springframework.stereotype.Component;

/**
 * Created by n.tyukavkin on 21.08.2016.
 */
@Component
public class CultNewsPage extends CultBasePage<CultNewsPage> implements INewsPage {

    public CultNewsPage checkNewsIsPresent() {
        getHelper(NewsPageHelper.class).checkNewsIsPresent();
        return this;
    }
}
