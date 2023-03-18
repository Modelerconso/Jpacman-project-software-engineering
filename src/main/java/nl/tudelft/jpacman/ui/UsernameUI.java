package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.Launcher;

import javax.swing.*;
import java.awt.*;

public class UsernameUI extends JFrame{
    private JPanel usernameUI;
    public UsernameUI() {

        usernameUI = new JPanel();

        // User name Label
        JLabel usernameLabel = new JLabel("Username", JLabel.CENTER);
        usernameLabel.setBounds(100,50, 200,100);

        // Text Label
        JTextField textLabel = new JTextField();
        textLabel.setBounds(100,125, 200,50);

        // Button Label
        JButton enterButton = new JButton("Enter");
        enterButton.setBounds(150,200, 100,50);

        // Action after click "Enter"
        enterButton.addActionListener(e -> {

            // String Text "Username"
            String username = textLabel.getText();

            // Check Text "empty"
            if (!username.isEmpty()){
                Launcher launchers = new Launcher();
                launchers.launch();
                dispose();
            }
        });
        usernameUI.setLayout(new GridLayout(4,1));
        usernameUI.add(usernameLabel);
        usernameUI.add(textLabel);
        usernameUI.add(enterButton);
        setSize(400,400);
        add(usernameUI);
    }
    public void start() {
        setVisible(true);
    }
}
