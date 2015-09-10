package com.guigarage.lambada.api;

import java.awt.*;
import java.util.EventListener;

@FunctionalInterface
public interface EventHandlerConsumer<T extends EventListener, C extends Component> {

    void apply(C component, T listener);

}
