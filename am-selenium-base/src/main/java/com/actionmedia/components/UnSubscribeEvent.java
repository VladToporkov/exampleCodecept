package com.actionmedia.components;

import java.util.Date;

/**
 * User: n.tyukavkin
 * Date: 17.02.14
 * Time: 16:00
 */
public class UnSubscribeEvent {

    String userToken;
    String themeId;
    int pubId;
    Date unSubscribeDate;

    public UnSubscribeEvent(String userToken, String themeId, int pubId, Date unSubscribeDate) {
        this.userToken = userToken;
        this.themeId = themeId;
        this.pubId = pubId;
        this.unSubscribeDate = unSubscribeDate;
    }

    public String getUserToken() {
        return userToken;
    }

    public String getThemeId() {
        return themeId;
    }

    public int getPubId() {
        return pubId;
    }

    public Date getUnSubscribeDate() {
        return unSubscribeDate;
    }
}
