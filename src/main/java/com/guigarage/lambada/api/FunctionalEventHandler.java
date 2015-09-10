package com.guigarage.lambada.api;

import java.util.EventListener;

@FunctionalInterface
public interface FunctionalEventHandler<T> extends EventListener {

    void onEvent(T event);

}

