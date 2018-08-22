import java.awt.*;
import javax.swing.*;

class Worker extends JFrame {
    static Dot[] dots;

    Worker(Dot[] dots, int numberOfDots, int numberOfDirections) throws InterruptedException {
        this.dots = makeDots(numberOfDots, numberOfDirections);

        this.setPreferredSize(new Dimension(800, 800));
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        animateDots(numberOfDots, numberOfDirections);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Draws all the dots
        for (Dot dot : dots) {
            dot.drawDot(g);
        }
    }

    public static Dot[] makeDots(int numberOfDots, int numberOfDirections) {
        Dot[] dots = new Dot[numberOfDots];

        for (int i = 0; i < numberOfDots; i++) {
            dots[i] = new Dot(numberOfDirections, 800, 800);
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
            Thread.sleep(100);
        }
    }
}