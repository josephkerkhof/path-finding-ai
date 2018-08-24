import java.awt.*;
import java.util.Random;
import javax.swing.*;

class Worker extends JFrame {
    static Dot[] dots;
    static Goal goal;
    private static int windowWidth, windowHeight, numberOfDots, numberOfDirections;
    private int generation;

    Worker(int numberOfDots, int numberOfDirections, int windowWidth, int windowHeight) throws InterruptedException {
        // Setting the window width and height
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;

        // Setting the number of dots and directions
        this.numberOfDots = numberOfDots;
        this.numberOfDirections = numberOfDirections;

        // Setting the initial generation
        this.generation = 1;

        // Make the dots
        this.dots = makeDots(numberOfDots, numberOfDirections);

        // Make the goal
        this.goal = new Goal(windowWidth, windowHeight);

        // Create and show the window
        this.setPreferredSize(new Dimension(windowWidth, windowHeight));
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        runGeneticAlgorithm();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Draw the generation counter text
        g.drawString("Generation: " + this.generation, 50, 50);

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
            if(dots[i].isOutsideOfBounds() || dots[i].isOnLastMove()) {
                dots[i].isDead = true;
            }
            if(dots[i].didReachGoal(goal)) {
                dots[i].goalReached = true;
            }
        }
    }

    public void animateDots(int numberOfDots, int numberOfDirections) throws InterruptedException {
        for (int i = 0; i < numberOfDirections; i++) {
            if(checkIfAllDotsAreDead()) { break; } // if all the dots are dead, stop animating
            moveDots(numberOfDots);
            repaint();
            Thread.sleep(150);
        }
    }

    private boolean checkIfAllDotsAreDead() {
        for(Dot dot : dots) {
            if(!dot.isDead) {
                return false;
            }
        }
        return true;
    }

    public void determineDotsFitness() {
        for(Dot dot : dots) {
            dot.calculateFitness(goal.position);
        }
    }

    // Returns the index of the best dot from the current generation
    public int findFittestDot() {
        int bestDotIndex = -1;
        double bestDotFitness = Double.MAX_VALUE;
        for(int i=0; i<dots.length; i++) {
            if(dots[i].fitness < bestDotFitness) {
                bestDotFitness = dots[i].fitness;
                bestDotIndex = i;
            }
        }
        return bestDotIndex;
    }

    public void runGeneticAlgorithm() throws InterruptedException {
//        determineDotsFitness();
//        int fittestDot = findFittestDot();

        while(true) {
            // Animate the dots
            animateDots(numberOfDots, numberOfDirections);
            natualSelection();
            mutateDemBabies();
        }
    }

    public void natualSelection() {
        Dot[] newDots = new Dot[dots.length];
        for(int i=0; i<newDots.length; i++) {
            // select parent based on fitness
            Dot parent = selectParent();
            // get baby from parent
            newDots[i] = parent.gimmeBaby();
        }

        // Replace old dots with the new dots
        System.arraycopy(newDots, 0, this.dots, 0, newDots.length);
        this.generation++;
    }

    public Dot selectParent() {
        double fitnessSum = calcFitnessSum();
        double runningSum = 0;
        Random random = new Random();
        double rand = 0 + (fitnessSum - 0) * random.nextDouble();

        for(Dot dot : dots) {
            runningSum += dot.fitness;
            if(runningSum > rand) {
                return dot;
            }
        }

        // Should never get here
        return null;
    }

    public double calcFitnessSum() {
        double fitnessSum = 0;
        determineDotsFitness(); // calculate the dots fitness

        for(Dot dot : dots) {
            fitnessSum += dot.fitness;
        }
        return fitnessSum;
    }

    public void mutateDemBabies() {
        for(Dot dot : dots) {
            dot.brain.mutate();
        }
    }
}