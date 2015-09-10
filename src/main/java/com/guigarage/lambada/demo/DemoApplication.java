package com.guigarage.lambada.demo;

import com.guigarage.lambada.Lambada;

import javax.swing.*;
import java.awt.*;

public class DemoApplication extends JFrame {

    public DemoApplication() throws HeadlessException {
        JButton button = new JButton("Click me!");
        getContentPane().add(button);

        Lambada.setOnMouseClicked(button, e -> System.out.println("TADA"));
        System.out.println("Normal: " + Lambada.getOnMouseClicked(button));

        Lambada.setOnMouseClicked(button, e -> System.out.println("DONE"));
        System.out.println("Normal: " + Lambada.getOnMouseClicked(button));
        setVisible(true);
    }

    public static void main(String... args) {
        SwingUtilities.invokeLater(() -> new DemoApplication());
    }

}
