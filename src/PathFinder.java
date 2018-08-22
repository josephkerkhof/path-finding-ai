import javax.swing.*;

class PathFinder extends JFrame {
    static Dot[] dots;

    public static void main(String[] args) throws InterruptedException{
        int numberOfDots = 500;
        int numberOfDirections = 400;

        Worker w = new Worker(dots, numberOfDots, numberOfDirections);
    }
}