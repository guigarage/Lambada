package com.guigarage.lambada.impl;

import com.guigarage.lambada.api.EventHandlerManager;
import com.guigarage.lambada.api.FunctionalEventHandler;

import java.awt.*;
import java.awt.event.*;

public class KeyPressedManager extends EventHandlerManager<KeyEvent, FunctionalEventHandler<? super KeyEvent>, KeyListener, Component> {

    public KeyPressedManager() {
        super(l -> new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                l.accept(e);
            }
        }, (c, l) -> c.addKeyListener(l), (c, l) -> c.removeKeyListener(l));
    }
}
