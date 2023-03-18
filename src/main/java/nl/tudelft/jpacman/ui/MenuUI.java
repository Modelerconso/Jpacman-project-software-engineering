package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.Launcher;

import javax.swing.*;
import java.awt.*;

public class MenuUI extends JFrame {
    private JPanel menuUI;

    private boolean canOnline;
    public MenuUI() {
        menuUI = new JPanel();
        JLabel menuLabel = new JLabel("Menu", JLabel.CENTER);
        JButton onlineButton = new JButton("Online");
        JButton offlineButton = new JButton("Offline");
        offlineButton.addActionListener(e -> {
            dispose();
        });
        JButton exitButton = new JButton("exit");
        menuUI.setLayout(new GridLayout(4,1));
        menuUI.add(menuLabel);
        menuUI.add(onlineButton);
        menuUI.add(offlineButton);
        menuUI.add(exitButton);
        setSize(200,500);
        add(menuUI);
    }

    public void start() {
       setVisible(true);
    }
}
