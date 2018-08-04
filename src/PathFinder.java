import java.awt.Dimension;
import java.util.Random;
import javax.swing.*;

class PathFinder {
    static JFrame frame = new JFrame("PathFindingAI");

    public static void main(String[] args) throws InterruptedException {
        displayWindow();
        Dot dot = new Dot(frame);
        dot.drawDot();
        Random random = new Random();

        while(true){
            int max = 5;
            int min = -5;
            int nextAccelerationX = random.nextInt((max - min) + 1) + min;
            int nextAccelerationY = random.nextInt((max - min) + 1) + min;

            dot.moveDot(nextAccelerationX, nextAccelerationY);
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