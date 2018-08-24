import javax.swing.*;

class PathFinder extends JFrame {
    public static void main(String[] args) throws InterruptedException{
        int numberOfDots = 200;
        int numberOfDirections = 200;
        int windowWidth = 800;
        int windowHeight = 800;

        Worker w = new Worker(numberOfDots, numberOfDirections, windowWidth, windowHeight);
    }
}