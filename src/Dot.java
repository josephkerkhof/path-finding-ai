import java.awt.*;

class Dot {
    private Pair<Integer, Integer> position, velocity, acceleration;
    private Brain brain;
    public boolean isDead;
    private int brainStep;
    private int windowWidth, windowHeight;

    Dot(int numberOfDirections, int windowWidth, int windowHeight) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.position = new Pair<>(windowWidth / 2, windowHeight);
        this.velocity = new Pair<>(0, 0);
        this.acceleration = new Pair<>(0, 0);
        isDead = false;
        this.brain = new Brain(numberOfDirections);
        this.brainStep = 0;
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

    private int limitVelocity(int velocity) {
        int limit = 10;

        if(velocity >= limit) {
            velocity = limit;
        } else if (velocity <= -limit) {
            velocity = -limit;
        }
        return velocity;
    }

    public void move(){
        if(isDead){ return; }

        int movementX = brain.directions[brainStep].x();
        int movementY = brain.directions[brainStep].y();

        int newVelocityX = getVelocityX() + movementX;
        int newVelocityY = getVelocityY() + movementY;

        // limiting the velocity to 5
        newVelocityX = limitVelocity(newVelocityX);
        newVelocityY = limitVelocity(newVelocityY);

        setVelocityX(newVelocityX);
        setVelocityY(newVelocityY);

        int newPositionX = getPositionX() + newVelocityX;
        int newPositionY = getPositionY() + newVelocityY;

        setPositionX(newPositionX);
        setPositionY(newPositionY);

        brainStep++;
    }

    public boolean isOutsideOfBounds() {
        int lowerX = 0;
        int upperX = windowWidth;
        int lowerY = 0;
        int upperY = windowHeight;
        int currentX = getPositionX();
        int currentY = getPositionY();

        if(currentX <= lowerX || currentX >= upperX || currentY <= lowerY || currentY >= upperY) {
            return true;
        }

        return false;
    }

    public boolean isOnLastMove() {
        if(brainStep == brain.directions.length - 1) {
            return true;
        }
        return false;
    }

    // Method for drawing the dot
    public void drawDot(Graphics g) {
        g.setColor(Color.black);
        g.fillOval(getPositionX(), getPositionY(), 5, 5);
        g.drawOval(getPositionX(), getPositionY(), 5, 5);
    }
}