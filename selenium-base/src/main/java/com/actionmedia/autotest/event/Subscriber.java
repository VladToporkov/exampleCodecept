package com.actionmedia.autotest.event;

public interface Subscriber<MsgType> {
    void notify(MsgType message);

    void notifyWithoutScreen(MsgType message);
}
