package com.actionmedia.components;

import java.util.Date;

public class EventTask {

    private int id;
    private String eventTypeId;
    private String userToken;
    private Date date;
    private int pubId;
    private String crmCard;
    private String themeId;
    private int letterNumberInTheme;
    private String parameters;

    public EventTask(int id,
                     String eventTypeId,
                     String userToken,
                     Date date,
                     int pubId,
                     String crmCard,
                     String themeId,
                     int letterNumberInTheme,
                     String parameters) {
        this.id = id;
        this.eventTypeId = eventTypeId;
        this.userToken = userToken;
        this.date = date;
        this.pubId = pubId;
        this.crmCard = crmCard;
        this.themeId = themeId;
        this.letterNumberInTheme = letterNumberInTheme;
        this.parameters = parameters;
    }

    public int getId() {
        return id;
    }

    public String getEventTypeId() {
        return eventTypeId;
    }

    public String getUserToken() {
        return userToken;
    }

    public Date getDate() {
        return date;
    }

    public int getPubId() {
        return pubId;
    }

    public String getCrmCard() {
        return crmCard;
    }

    public String getThemeId() {
        return themeId;
    }

    public int getLetterNumberInTheme() {
        return letterNumberInTheme;
    }

    public String getParameters() {
        return parameters;
    }
}
