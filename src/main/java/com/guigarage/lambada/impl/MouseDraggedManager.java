package com.guigarage.lambada.impl;

import com.guigarage.lambada.api.EventHandlerManager;
import com.guigarage.lambada.api.FunctionalEventHandler;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseDraggedManager extends EventHandlerManager<MouseEvent, FunctionalEventHandler<? super MouseEvent>, MouseMotionListener, Component> {

    public MouseDraggedManager() {
        super(l -> new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                l.accept(e);
            }
        }, (c, l) -> c.addMouseMotionListener(l), (c, l) -> c.removeMouseMotionListener(l));
    }
}

