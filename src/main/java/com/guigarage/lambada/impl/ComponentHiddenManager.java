package com.guigarage.lambada.impl;

import com.guigarage.lambada.api.EventHandlerManager;
import com.guigarage.lambada.api.FunctionalEventHandler;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class ComponentHiddenManager extends EventHandlerManager<ComponentEvent, FunctionalEventHandler<? super ComponentEvent>, ComponentListener, Component> {

    public ComponentHiddenManager() {
        super(l -> new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
                l.accept(e);
            }
        }, (c, l) -> c.addComponentListener(l), (c, l) -> c.removeComponentListener(l));
    }
}


