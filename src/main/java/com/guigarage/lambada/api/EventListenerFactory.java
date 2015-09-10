package com.guigarage.lambada.api;

import java.util.EventListener;
import java.util.function.Consumer;
import java.util.function.Function;

@FunctionalInterface
public interface EventListenerFactory<U, T extends EventListener> extends Function<Consumer<U>, T> {
}
