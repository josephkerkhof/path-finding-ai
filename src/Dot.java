import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

class Dot {
    private Pair<Integer, Integer> position, velocity, acceleration;
    private Brain brain;
    private boolean isDead;

    Dot(int numberOfDirections, int windowWidth, int windowHeight) {
        this.position = new Pair<>(windowWidth / 2, windowHeight / 2);
        this.velocity = new Pair<>(0, 0);
        this.acceleration = new Pair<>(0, 0);
        isDead = false;
        this.brain = new Brain(numberOfDirections);
    }

    // Begin Getters
    public int getPositionX() {
        return position.x();
    }

    public int getPositionY() {
        return position.y();
    }

    public Pair getPosition() { return position; }

    private int getVelocityX() {
        return velocity.x();
    }

    private int getVelocityY() {
        return velocity.y();
    }

    public Pair getVelocity() { return velocity; }

    public int getAccelerationX() {
        return acceleration.x();
    }

    public int getAccelerationY() {
        return acceleration.y();
    }

    public Pair getAcceleration() { return acceleration; }
    // End Getters

    // Begin Setters
    private void setPositionX(int position) {
        this.position.setX(position);
    }

    private void setPositionY(int position) {
        this.position.setY(position);
    }

    public void setPosition(Pair position) { this.position = position; }

    private void setVelocityX(int velocity) {
        this.velocity.setX(velocity);
    }

    private void setVelocityY(int velocity) {
        this.velocity.setY(velocity);
    }

    public void setVelocity(Pair velocity) { this.velocity = velocity; }

    public void setAccelerationX(int acceleration) {
        this.acceleration.setX(acceleration);
    }

    public void setAccelerationY(int acceleration) {
        this.acceleration.setY(acceleration);
    }

    public void setAcceleration(Pair acceleration) { this.acceleration = acceleration; }
    // End Setters

    // Method for drawing the dot
    public void drawDot(Graphics g) {
        g.setColor(Color.black);
        g.fillOval(getPositionX(), getPositionY(), 5, 5);
        g.drawOval(getPositionX(), getPositionY(), 5, 5);
    }
}