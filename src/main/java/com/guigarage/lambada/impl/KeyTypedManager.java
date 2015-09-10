package com.guigarage.lambada.impl;

import com.guigarage.lambada.api.EventHandlerManager;
import com.guigarage.lambada.api.FunctionalEventHandler;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyTypedManager extends EventHandlerManager<KeyEvent, FunctionalEventHandler<? super KeyEvent>, KeyListener, Component> {

    public KeyTypedManager() {
        super(l -> new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                l.accept(e);
            }
        }, (c, l) -> c.addKeyListener(l), (c, l) -> c.removeKeyListener(l));
    }
}