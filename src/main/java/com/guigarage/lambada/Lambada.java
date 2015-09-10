package com.guigarage.lambada;

import com.guigarage.lambada.api.FunctionalEventHandler;
import com.guigarage.lambada.impl.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class Lambada {

    private final static MouseClickedManager mouseClickedManager = new MouseClickedManager();

    private final static MouseEnteredManager mouseEnteredManager = new MouseEnteredManager();

    private final static MouseExitedManager mouseExitedManager = new MouseExitedManager();

    private final static MousePressedManager mousePressedManager = new MousePressedManager();

    private final static MouseReleasedManager mouseReleasedManager = new MouseReleasedManager();

    private final static FocusGainedManager focusGainedManager = new FocusGainedManager();

    private final static FocusLostManager focusLostManager = new FocusLostManager();

    private final static KeyPressedManager keyPressedManager = new KeyPressedManager();

    private final static KeyReleasedManager keyReleasedManager = new KeyReleasedManager();

    private final static KeyTypedManager keyTypedManager = new KeyTypedManager();

    private final static MouseDraggedManager mouseDraggedManager = new MouseDraggedManager();

    private final static MouseMovedManager mouseMovedManager = new MouseMovedManager();

    private final static MouseWheelMovedManager mouseWheelMovedManager = new MouseWheelMovedManager();

    private static boolean checkEDT = true;

    /**
     * This methods throws a runtime exception if it is not called from the EDT
     *
     * @throws RuntimeException exception
     */
    public static void check() throws RuntimeException {
        if (checkEDT) {
            if (!SwingUtilities.isEventDispatchThread()) {
                throw new RuntimeException("All listeners must be added from EDT!");
            }
        }
    }

    /**
     * Returns true if EDT checking is active. In this case each method of this class will
     * throw an exception if it's not called from the EDT.
     *
     * @return true if EDT checking is active
     */
    public static boolean isCheckEDT() {
        return checkEDT;
    }

    /**
     * Active or deactive the EDT checking. Each method of this class will throw an exception
     * if it's not called from the EDT and checkEDT is true.
     * @param checkEDT
     */
    public static void setCheckEDT(boolean checkEDT) {
        Lambada.checkEDT = checkEDT;
    }

    /**
     * Add a mouse wheel moved handler to the given {@link java.awt.Component}.
     * @param component the component
     * @param handler the handler
     */
    public static void setOnMouseWheelMoved(final Component component, final FunctionalEventHandler<? super MouseWheelEvent> handler) {
        check();
        mouseWheelMovedManager.setEventHandler(component, handler);
    }

    /**
     * Returns the mouse wheel moved handler that is added to the component or null if no handler is registered.
     * @param component the component
     * @return the registered handler or null
     */
    public static FunctionalEventHandler<? super MouseWheelEvent> getOnMouseWheelMoved(final Component component) {
        check();
        return mouseWheelMovedManager.getEventHandler(component);
    }

    public static void setOnMouseMoved(final Component component, final FunctionalEventHandler<? super MouseEvent> handler) {
        check();
        mouseMovedManager.setEventHandler(component, handler);
    }

    public static FunctionalEventHandler<? super MouseEvent> getOnMouseMoved(final Component component) {
        check();
        return mouseMovedManager.getEventHandler(component);
    }

    public static void setOnMouseDragged(final Component component, final FunctionalEventHandler<? super MouseEvent> handler) {
        check();
        mouseDraggedManager.setEventHandler(component, handler);
    }

    public static FunctionalEventHandler<? super MouseEvent> getOnMouseDragged(final Component component) {
        check();
        return mouseDraggedManager.getEventHandler(component);
    }

    public static void setOnKeyPressed(final Component component, final FunctionalEventHandler<? super KeyEvent> handler) {
        check();
        keyPressedManager.setEventHandler(component, handler);
    }

    public static FunctionalEventHandler<? super KeyEvent> getOnKeyPressed(final Component component) {
        check();
        return keyPressedManager.getEventHandler(component);
    }

    public static void setOnKeyReleased(final Component component, final FunctionalEventHandler<? super KeyEvent> handler) {
        check();
        keyReleasedManager.setEventHandler(component, handler);
    }

    public static FunctionalEventHandler<? super KeyEvent> getOnKeyReleased(final Component component) {
        check();
        return keyReleasedManager.getEventHandler(component);
    }

    public static void setOnKeyTyped(final Component component, final FunctionalEventHandler<? super KeyEvent> handler) {
        check();
        keyTypedManager.setEventHandler(component, handler);
    }

    public static FunctionalEventHandler<? super KeyEvent> getOnKeyTyped(final Component component) {
        check();
        return keyTypedManager.getEventHandler(component);
    }

    public static void setOnMouseClicked(final Component component, final FunctionalEventHandler<? super MouseEvent> handler) {
        check();
        mouseClickedManager.setEventHandler(component, handler);
    }

    public static FunctionalEventHandler<? super MouseEvent> getOnMouseClicked(final Component component) {
        check();
        return mouseClickedManager.getEventHandler(component);
    }

    public static void setOnMouseEntered(final Component component, final FunctionalEventHandler<? super MouseEvent> handler) {
        check();
        mouseEnteredManager.setEventHandler(component, handler);
    }

    public static FunctionalEventHandler<? super MouseEvent> getOnMouseEntered(final Component component) {
        check();
        return mouseEnteredManager.getEventHandler(component);
    }

    public static void setOnMouseExited(final Component component, final FunctionalEventHandler<? super MouseEvent> handler) {
        check();
        mouseExitedManager.setEventHandler(component, handler);
    }

    public static FunctionalEventHandler<? super MouseEvent> getOnMouseExited(final Component component) {
        check();
        return mouseExitedManager.getEventHandler(component);
    }

    public static void setOnMousePressed(final Component component, final FunctionalEventHandler<? super MouseEvent> handler) {
        check();
        mousePressedManager.setEventHandler(component, handler);
    }

    public static FunctionalEventHandler<? super MouseEvent> getOnMousePressed(final Component component) {
        check();
        return mousePressedManager.getEventHandler(component);
    }

    public static void setOnMouseReleased(final Component component, final FunctionalEventHandler<? super MouseEvent> handler) {
        check();
        mouseReleasedManager.setEventHandler(component, handler);
    }

    public static FunctionalEventHandler<? super MouseEvent> getOnMouseReleased(final Component component) {
        check();
        return mouseReleasedManager.getEventHandler(component);
    }

    public static void setOnFocusLost(final Component component, final FunctionalEventHandler<? super FocusEvent> handler) {
        check();
        focusLostManager.setEventHandler(component, handler);
    }

    public static FunctionalEventHandler<? super FocusEvent> getOnFocusLost(final Component component) {
        check();
        return focusLostManager.getEventHandler(component);
    }

    public static void setOnFocusGained(final Component component, final FunctionalEventHandler<? super FocusEvent> handler) {
        check();
        focusGainedManager.setEventHandler(component, handler);
    }

    public static FunctionalEventHandler<? super FocusEvent> getOnFocusGained(final Component component) {
        check();
        return focusGainedManager.getEventHandler(component);
    }

}
