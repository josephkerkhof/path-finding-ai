import javax.swing.*;
import java.awt.*;

class Dot {
    private JFrame frame;
    private Pair<Integer, Integer> position, velocity, acceleration;
    private Color dotColor;
    private Painter painter;

    Dot(JFrame frame) {
        this.frame = frame;
        this.position = new Pair<>(frame.getWidth() / 2, frame.getHeight() / 2);
        this.velocity = new Pair<>(0, 0);
        this.acceleration = new Pair<>(0, 0);
        this.dotColor = Color.black;
        painter = new Painter();
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
        this.velocity.setY(velocity);
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

    public void drawDot() {
        frame.getContentPane().add(painter);
    }

    public void moveDot(int accelerationX, int accelerationY){
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
            if(newVelocityX >=5) {
                newVelocityX = 5;
            }

            if(newVelocityY >=5) {
                newVelocityY = 5;
            }

            setVelocityX(newVelocityX);
            setVelocityY(newVelocityY);

            int newPositionX = getPositionX() + newVelocityX;
            int newPositionY = getPositionY() + newVelocityY;
            setPositionX(newPositionX);
            setPositionY(newPositionY);

            repaint();
        }
    }
}