import java.util.Random;

public class Brain {
    public Pair<Integer, Integer>[] directions;
    private Random random = new Random();
    private int max = 5;
    private int min = -5;
    private int numberOfDirections;

    Brain(int numberOfDirections) {
        this.numberOfDirections = numberOfDirections;
        directions = new Pair[numberOfDirections];

        for(int i=0; i<numberOfDirections; i++) {
            int nextAccelerationX = getNextRandom();
            int nextAccelerationY = getNextRandom();

            Pair<Integer, Integer> temp = new Pair(nextAccelerationX, nextAccelerationY);
            directions[i] = temp;
        }
    }

    private int getNextRandom() {
        return random.nextInt((max - min) + 1) + min;
    }

    public Brain clone() {
        Brain clonedBrain = new Brain(numberOfDirections);
        System.arraycopy(directions, 0, clonedBrain.directions, 0, directions.length);
        return clonedBrain;
    }

    public void mutate() {
        double mutationRate = 0.01;
        for(int i=0; i<numberOfDirections; i++) {
            double rand = random.nextDouble();
            if(rand < mutationRate) {
                Pair newDirection = new Pair<>(getNextRandom(), getNextRandom());
                this.directions[i] = newDirection;
            }
        }
    }
}
