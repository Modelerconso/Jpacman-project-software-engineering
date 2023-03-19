package nl.tudelft.jpacman.ui;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.game.Game;


public class ShowScoreBoard extends JFrame {
    private static final int ROWS_PER_PAGE = 10;
    private int currentPage = 1;
    private JPanel mainPanel;
    private JTable scoreTable;
    private JButton prevButton;
    private JButton nextButton;
    private JButton menuButton;
    private JButton restartButton;

    public ShowScoreBoard(Game game) {

        // Create the label with the text "Score Board"
        JLabel scoreBoardLabel = new JLabel("Score Board", SwingConstants.CENTER);
        scoreBoardLabel.setFont(new Font("SansSerif", Font.BOLD, 24));

        // create table model with 4 columns: Rank, Name, Time, Score
        DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Rank", "Name", "Time", "Score"},0);
        scoreTable = new JTable(tableModel);

        // set up buttons
        prevButton = new JButton("Prev");
        nextButton = new JButton("Next");
        menuButton = new JButton("Menu");
        restartButton = new JButton("Restart");

        // add button listeners
        prevButton.addActionListener(e -> {
            if (currentPage > 1) {
                currentPage--;
                updateTable();
            }
        });
        nextButton.addActionListener(e -> {
            if (currentPage < getTotalPages()) {
                currentPage++;
                updateTable();
            }
        });
        menuButton.addActionListener(e -> {
            MenuUI menuUI = new MenuUI();
            menuUI.start();
            dispose();

        });
        restartButton.addActionListener(e -> {
            String PlayerUsername = game.getPlayers().get(0).getName();
            Launcher.launchers.launch(PlayerUsername);
            dispose();

        });

        // create a penel to hold button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(menuButton);
        buttonPanel.add(restartButton);

        // Create the main panel to hold the components
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(scoreBoardLabel, BorderLayout.NORTH);
        mainPanel.add(scoreTable.getTableHeader());
        mainPanel.add(scoreTable, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // set up frame
        add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);

        // Center the frame on the screen
        //setLocationRelativeTo(null);

        // update table with initial data
        updateTable();
    }

    // helper method to update the table with current page of data
    private void updateTable() {
        DefaultTableModel tableModel = (DefaultTableModel) scoreTable.getModel();
        tableModel.setRowCount(0); // clear existing rows

        tableModel.addRow(new Object[] {"Rank","Name","Time","Score"});
        // add 10 rows of data starting at the current page index
        int startIndex = (currentPage - 1) * ROWS_PER_PAGE;
        int endIndex = Math.min(startIndex + ROWS_PER_PAGE, getData().length);
        for (int i = startIndex; i < endIndex; i++) {
            Object[] row = getData()[i];
            tableModel.addRow(row);
        }
    }

    // helper method to get total number of pages based on data size and rows per page
    private int getTotalPages() {
        return (int) Math.ceil((double) getData().length / ROWS_PER_PAGE);
    }

    // helper method to generate sample data for testing purposes
    private Object[][] getData() {
        return new Object[][]{
            {1, "John", "1:23", 100},
            {2, "Jane", "2:45", 90},
            {3, "Bob", "3:10", 80},
            {4, "Alice", "4:15", 70},
            {5, "Tom", "5:20", 60},
            {6, "Sue", "6:30", 50},
            {7, "Tim", "7:40", 40},
            {8, "Kate", "8:50", 30},
            {9, "Dave", "9:55", 20},
            {10, "Lisa", "10:10", 10},
            {11, "John", "1:23", 100},
            {12, "Jane", "2:45", 90},
            {13, "Bob", "3:10", 80},
            {14, "Alice", "4:15", 70},
            {15, "Tom", "5:20", 60},
            {16, "Sue", "6:30", 50},
            {17, "Tim", "7:40", 40},
            {18, "Kate", "8:50", 30},
            {19, "Dave", "9:55", 20},
            {20, "Lisa", "10:10", 10}
        };
    }
}
