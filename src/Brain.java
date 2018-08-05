import java.util.Random;

public class Brain {
    public Pair<Integer, Integer>[] directions;
    Random random = new Random();
    int max = 5;
    int min = -5;

    Brain(int numberOfDirections) {
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
}
