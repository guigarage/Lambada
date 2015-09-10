package com.guigarage.lambada.impl;

import com.guigarage.lambada.api.EventHandlerManager;
import com.guigarage.lambada.api.FunctionalEventHandler;

import java.awt.*;
import java.awt.event.*;

/**
 * Created by hendrikebbers on 24.08.15.
 */
public class FocusLostManager extends EventHandlerManager<FocusEvent, FunctionalEventHandler<? super FocusEvent>, FocusListener, Component> {

    public FocusLostManager() {
        super(l -> new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                l.accept(e);
            }
        }, (c, l) -> c.addFocusListener(l), (c, l) -> c.removeFocusListener(l));
    }
}

