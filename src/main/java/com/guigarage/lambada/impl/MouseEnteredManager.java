package com.guigarage.lambada.impl;

import com.guigarage.lambada.api.EventHandlerManager;
import com.guigarage.lambada.api.FunctionalEventHandler;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEnteredManager extends EventHandlerManager<MouseEvent, FunctionalEventHandler<? super MouseEvent>, MouseListener, Component> {

    public MouseEnteredManager() {
        super(l -> new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
              l.accept(e);
            }
        }, (c, l) -> c.addMouseListener(l), (c, l) -> c.removeMouseListener(l));
    }
}

