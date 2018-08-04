import javax.swing.*;
import java.awt.*;

class Dot {
    private JFrame frame;
    private int positionX, positionY, velocityX, velocityY, accelerationX, accelerationY;
    private Color dotColor;
    private Painter painter;

    Dot(JFrame frame) {
        this.frame = frame;
        this.positionX = frame.getWidth() / 2;
        this.positionY = frame.getHeight() / 2;
        this.velocityX = 0;
        this.velocityY = 0;
        this.accelerationX = 0;
        this.accelerationY = 0;
        this.dotColor = Color.black;
        painter = new Painter();
    }

    // Begin Getters
    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getVelocityX() {
        return velocityX;
    }

    public int getVelocityY() {
        return velocityY;
    }

    public int getAccelerationX() {
        return accelerationX;
    }

    public int getAccelerationY() {
        return accelerationY;
    }
    // End Getters

    // Begin Setters
    public void setPositionX(int position) {
        this.positionX = position;
    }

    public void setPositionY(int position) {
        this.positionY = position;
    }

    public void setVelocityX(int velocity) {
        this.velocityX = velocity;
    }

    public void setVelocityY(int velocity) {
        this.velocityY = velocity;
    }

    public void setAccelerationX(int acceleration) {
        this.accelerationX = acceleration;
    }

    public void setAccelerationY(int acceleration) {
        this.accelerationY = acceleration;
    }
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