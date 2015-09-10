package com.guigarage.lambada.impl;

import com.guigarage.lambada.api.EventHandlerManager;
import com.guigarage.lambada.api.FunctionalEventHandler;

import java.awt.*;
import java.awt.event.*;

/**
 * Created by hendrikebbers on 28.08.15.
 */
public class MouseWheelMovedManager extends EventHandlerManager<MouseWheelEvent, FunctionalEventHandler<? super MouseWheelEvent>, MouseWheelListener, Component> {

    public MouseWheelMovedManager() {
        super(l -> new MouseAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                l.accept(e);
            }
        }, (c, l) -> c.addMouseWheelListener(l), (c, l) -> c.removeMouseWheelListener(l));
    }
}
