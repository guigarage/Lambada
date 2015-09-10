package com.guigarage.lambada.api;

import java.awt.*;
import java.util.EventListener;
import java.util.WeakHashMap;

public class EventHandlerManager<U, T extends FunctionalEventHandler<? super U>, S extends EventListener, C extends Component> {

    private WeakHashMap<T, S> mapping;

    private WeakHashMap<C, T> componentStore;

    private EventListenerFactory<U, S> listenerFactory;

    private EventHandlerConsumer<S, C> addListenerFunction;

    private EventHandlerConsumer<S, C> removeListenerFunction;

    public EventHandlerManager(EventListenerFactory<U, S> listenerFactory, EventHandlerConsumer<S, C> addListenerFunction, EventHandlerConsumer<S, C> removeListenerFunction) {
        this.listenerFactory = listenerFactory;
        this.addListenerFunction = addListenerFunction;
        this.removeListenerFunction = removeListenerFunction;
        this.mapping = new WeakHashMap<>();
        this.componentStore = new WeakHashMap<>();
    }

    public void setEventHandler(final C c, final T listener) {
        T functionalListener = componentStore.remove(c);
        if (functionalListener != null) {
            S swingListener = mapping.get(functionalListener);
            removeListenerFunction.apply(c, swingListener);
        }
        if(listener != null) {
            componentStore.put(c, listener);
            S swingListener = mapping.get(listener);
            if (swingListener == null) {
                swingListener = listenerFactory.apply(e -> fire(c, e));
                mapping.put(listener, swingListener);
            }
            addListenerFunction.apply(c, swingListener);
        }
    }

    private void fire(C c, U event) {
        T handler = componentStore.get(c);
        if(handler != null) {
            handler.onEvent(event);
        }
    }

    public FunctionalEventHandler<? super U> getEventHandler(final Component c) {
        return componentStore.get(c);
    }
}
