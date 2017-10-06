package com.actionmedia.autotest.event;

import java.util.Collection;

import static com.google.common.collect.Lists.newArrayList;

public abstract class Event<MsgType> {
    private Collection<Subscriber<MsgType>> subscribers = newArrayList();

    public void fire(final MsgType message) {
        for (final Subscriber<MsgType> each : subscribers) {
            each.notify(message);
        }
    }

    public void fireWithoutScreen(final MsgType message) {
        for (final Subscriber<MsgType> each : subscribers) {
            each.notifyWithoutScreen(message);
        }
    }

    public void subscribe(final Subscriber<MsgType> subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribeAll() {
        subscribers.clear();
    }

}
