import java.awt.Dimension;
import javax.swing.*;

class PathFinder {
    static JFrame frame = new JFrame("PathFindingAI");

    public static void main(String[] args) throws InterruptedException {
        displayWindow();

        Dot dot = new Dot(frame);
        dot.drawDot();

        Brain brain = new Brain(400);

        for(int i=0; i<brain.directions.length; i++){
            dot.moveDot(brain.directions[i].x(), brain.directions[i].y());
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