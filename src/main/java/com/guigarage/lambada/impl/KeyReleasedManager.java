package com.guigarage.lambada.impl;

import com.guigarage.lambada.api.EventHandlerManager;
import com.guigarage.lambada.api.FunctionalEventHandler;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by hendrikebbers on 28.08.15.
 */
public class KeyReleasedManager extends EventHandlerManager<KeyEvent, FunctionalEventHandler<? super KeyEvent>, KeyListener, Component> {

    public KeyReleasedManager() {
        super(l -> new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                l.accept(e);
            }
        }, (c, l) -> c.addKeyListener(l), (c, l) -> c.removeKeyListener(l));
    }
}