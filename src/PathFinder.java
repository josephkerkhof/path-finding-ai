import javax.swing.*;

class PathFinder extends JFrame {
    public static void main(String[] args) throws InterruptedException{
        int numberOfDots = 500;
        int numberOfDirections = 40;
        int windowWidth = 800;
        int windowHeight = 800;

        Worker w = new Worker(numberOfDots, numberOfDirections, windowWidth, windowHeight);
    }
}