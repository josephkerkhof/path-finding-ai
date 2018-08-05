import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

class Dot {
    private JFrame frame;
    private Pair<Integer, Integer> position, velocity, acceleration;
    private Color dotColor;
    private Painter painter;
    private Brain brain;
    private boolean isDead;

    /**
     * @param frame The canvas for our dots
     */
    Dot(@NotNull JFrame frame) throws InterruptedException {
        this.frame = frame;
        this.position = new Pair<>(frame.getWidth() / 2, frame.getHeight() / 2);
        this.velocity = new Pair<>(0, 0);
        this.acceleration = new Pair<>(0, 0);
        this.dotColor = Color.black;
        painter = new Painter();
        isDead = false;

        drawDot();

        brain = new Brain(400);
        for(int i=0; i<brain.directions.length; i++){
            if(isDead) { break; }
            moveDot(brain.directions[i].x(), brain.directions[i].y());
            Thread.sleep(100);
        }
    }

    // Begin Getters
    public int getPositionX() {
        return position.x();
    }

    public int getPositionY() {
        return position.y();
    }

    public Pair getPosition() { return position; }

    public int getVelocityX() {
        return velocity.x();
    }

    public int getVelocityY() {
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
    public void setPositionX(int position) {
        this.position.setX(position);
    }

    public void setPositionY(int position) {
        this.position.setY(position);
    }

    public void setPosition(Pair position) { this.position = position; }

    public void setVelocityX(int velocity) {
        this.velocity.setX(velocity);
    }

    public void setVelocityY(int velocity) {
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

    private void drawDot() {
        frame.getContentPane().add(painter);
    }

    private void moveDot(int accelerationX, int accelerationY){
        painter.move(accelerationX, accelerationY);
    }

    private class Painter extends JPanel {
        public void paint(Graphics g) {
            g.setColor(dotColor);
            g.fillOval(getPositionX(), getPositionY(), 5, 5);
            g.drawOval(getPositionX(), getPositionY(), 5, 5);
        }

        public void move(int accelerationX, int accelerationY) {
            int newVelocityX = getVelocityX() + accelerationX;
            int newVelocityY = getVelocityY() + accelerationY;

            // limiting the velocity to 5
            newVelocityX = limitVelocity(newVelocityX);
            newVelocityY = limitVelocity(newVelocityY);

            setVelocityX(newVelocityX);
            setVelocityY(newVelocityY);

            int newPositionX = getPositionX() + newVelocityX;
            int newPositionY = getPositionY() + newVelocityY;

            setPositionX(newPositionX);
            setPositionY(newPositionY);

            repaint();

            if(isOutsideOfBounds()) {
                isDead = true;
            }
        }

        private int limitVelocity(int velocity) {
            int limit = 10;

            if(velocity >= limit) {
                velocity = limit;
            } else if (velocity <= -limit) {
                velocity = -limit;
            }
            return velocity;
        }

        private boolean isOutsideOfBounds() {
            int lowerX = 0;
            int upperX = frame.getWidth();
            int lowerY = 0;
            int upperY = frame.getHeight();
            int currentX = getPositionX();
            int currentY = getPositionY();

            if(currentX <= lowerX || currentX >= upperX || currentY <= lowerY || currentY >= upperY) {
                return true;
            }

            return false;
        }
    }
}