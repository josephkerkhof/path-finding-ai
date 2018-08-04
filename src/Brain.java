import java.util.Random;

public class Brain {
    public Pair<Integer, Integer>[] directions;

    Brain(int numberOfDirections) {
        directions = new Pair[numberOfDirections];

        Random random = new Random();
        int max = 5;
        int min = -5;

        for(int i=0; i<numberOfDirections; i++) {
            int nextAccelerationX = random.nextInt((max - min) + 1) + min;
            int nextAccelerationY = random.nextInt((max - min) + 1) + min;
            Pair<Integer, Integer> temp = new Pair(nextAccelerationX, nextAccelerationY);
            directions[i] = temp;
        }
    }
}
