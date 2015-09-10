package com.guigarage.lambada.impl;

import com.guigarage.lambada.api.EventHandlerManager;
import com.guigarage.lambada.api.FunctionalEventHandler;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

/**
 * Created by hendrikebbers on 28.08.15.
 */
public class AncestorRemovedManager extends EventHandlerManager<AncestorEvent, FunctionalEventHandler<? super AncestorEvent>, AncestorListener, JComponent> {

    public AncestorRemovedManager() {
        super(l -> new AncestorListener() {

            @Override
            public void ancestorAdded(AncestorEvent event) {

            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {
                l.accept(event);
            }

            @Override
            public void ancestorMoved(AncestorEvent event) {

            }
        }, (c, l) -> c.addAncestorListener(l), (c, l) -> c.removeAncestorListener(l));
    }
}

