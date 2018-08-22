import java.awt.*;
import javax.swing.*;

class PathFinder extends JFrame {
    static Dot[] dots;

    PathFinder(Dot[] dots) {
        this.dots = dots;

        this.setPreferredSize(new Dimension(800, 800));
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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

        for(int i=0; i<numberOfDots; i++) {
            dots[i] = new Dot(numberOfDirections, 800, 800);
        }

        return dots;
    }

    public static void main(String[] args) {
        int numberOfDots = 5;
        int numberOfDirections = 400;

        dots = makeDots(numberOfDots, numberOfDirections);

        PathFinder pf = new PathFinder(dots);
    }
}