package com.guigarage.lambada.impl;

import com.guigarage.lambada.api.EventHandlerManager;
import com.guigarage.lambada.api.FunctionalEventHandler;

import java.awt.*;
import java.awt.event.*;

public class ComponentMovedManager extends EventHandlerManager<ComponentEvent, FunctionalEventHandler<? super ComponentEvent>, ComponentListener, Component> {

    public ComponentMovedManager() {
        super(l -> new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                l.accept(e);
            }
        }, (c, l) -> c.addComponentListener(l), (c, l) -> c.removeComponentListener(l));
    }
}


