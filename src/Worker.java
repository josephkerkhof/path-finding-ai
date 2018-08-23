import java.awt.*;
import javax.swing.*;

class Worker extends JFrame {
    static Dot[] dots;
    static Goal goal;
    private static int windowWidth, windowHeight;

    Worker(int numberOfDots, int numberOfDirections, int windowWidth, int windowHeight) throws InterruptedException {
        // Setting the window width and height
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;

        // Make the dots
        this.dots = makeDots(numberOfDots, numberOfDirections);

        // Make the goal
        this.goal = new Goal(windowWidth, windowHeight);

        // Create and show the window
        this.setPreferredSize(new Dimension(800, 800));
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Animate the dots
        animateDots(numberOfDots, numberOfDirections);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Draws the goal
        goal.drawGoal(g);

        // Draws all the dots
        for (Dot dot : dots) {
            dot.drawDot(g);
        }
    }

    public static Dot[] makeDots(int numberOfDots, int numberOfDirections) {
        Dot[] dots = new Dot[numberOfDots];

        for (int i = 0; i < numberOfDots; i++) {
            dots[i] = new Dot(numberOfDirections, windowWidth, windowHeight);
        }

        return dots;
    }

    public void moveDots(int numberOfDots) {
        for (int i = 0; i < numberOfDots; i++) {
            dots[i].move();
            if(dots[i].isOutsideOfBounds()) {
                dots[i].isDead = true;
            }
        }
    }

    public void animateDots(int numberOfDots, int numberOfDirections) throws InterruptedException {
        for (int i = 0; i < numberOfDirections; i++) {
            moveDots(numberOfDots);
            repaint();
            Thread.sleep(150);
        }
    }
}