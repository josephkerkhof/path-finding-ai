import java.awt.Dimension;

import javax.swing.*;

class PathFinder {
    public static void main(String[] args) {
        // schedule this for the event dispatch thread (edt)
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                displayWindow();
            }
        });
    }

    private static void displayWindow() {
        // Create and set up the window.
        JFrame frame = new JFrame("PathFindingAI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 800));

        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}