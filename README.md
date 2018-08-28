# Dot Path Finding AI

A simple path finding artificial intelligence with a genetic algorithm. Each generation improves on the last generation by taking best and mutating it a little for the following generation.

## Preview

![Path-finding Genetic Algorithm on generation 5](https://i.imgur.com/7JuCqIH.png)

## Fitness function

```java
public void calculateFitness(Pair<Integer, Integer> goalPosition){
    if(goalReached){
        fitness = 1.0 / 16.0 + 10000.0 / Math.pow(brainStep, 2);
    } else {
        double distanceToGoal = calcDistanceToGoal(goalPosition);
        fitness = 1.0 / Math.pow(distanceToGoal, 2);
    }
    if(fitness == Double.POSITIVE_INFINITY) {
        fitness = 1;
    }
}
```
