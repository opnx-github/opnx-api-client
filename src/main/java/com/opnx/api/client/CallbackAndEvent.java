package com.opnx.api.client;

import java.util.Map;

public class CallbackAndEvent<T> {
    private ApiCallback<T> callback;
    private Class<T> eventClass ;

    public ApiCallback getCallback() {
        return callback;
    }

    public void setCallback(ApiCallback<T> callback) {
        this.callback = callback;
    }

    public Class getEventClass() {
        return eventClass;
    }

    public void setEventClass(Class<T> eventClass, Map<String, CallbackAndEvent> callbackAndEventMap) {
        this.eventClass = eventClass;
        callbackAndEventMap.put(eventClass.getName(),this);
    }
}
