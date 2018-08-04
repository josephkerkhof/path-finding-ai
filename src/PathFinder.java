import java.awt.Dimension;
import java.awt.Point;
import javax.swing.*;

class PathFinder {
    static JFrame frame = new JFrame("PathFindingAI");

    public static void main(String[] args) throws InterruptedException {
        displayWindow();
        Dot dot = new Dot(frame);
        dot.drawDot();
        while(true){
            dot.moveDot();
            Thread.sleep(100);
        }
    }

    private static void displayWindow() {
        // Create and set up the window.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 800));

        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}