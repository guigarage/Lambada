package com.guigarage.lambada.impl;

import com.guigarage.lambada.api.EventHandlerManager;
import com.guigarage.lambada.api.FunctionalEventHandler;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class AncestorAddedManager extends EventHandlerManager<AncestorEvent, FunctionalEventHandler<? super AncestorEvent>, AncestorListener, JComponent> {

    public AncestorAddedManager() {
        super(l -> new AncestorListener() {

            @Override
            public void ancestorAdded(AncestorEvent event) {
                l.accept(event);
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {

            }

            @Override
            public void ancestorMoved(AncestorEvent event) {

            }
        }, (c, l) -> c.addAncestorListener(l), (c, l) -> c.removeAncestorListener(l));
    }
}

