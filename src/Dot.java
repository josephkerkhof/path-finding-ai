import javax.swing.*;
import java.awt.*;

class Dot {
    private int positionX, positionY, velocityX, velocityY, accelerationX, accelerationY;
    private Color dotColor;
    int canvasWidth = 800, canvasHeight = 800;

    Dot() {
        this.positionX = canvasWidth / 2;
        this.positionY = canvasHeight / 2;
        this.velocityX = 0;
        this.velocityY = 0;
        this.accelerationX = 0;
        this.accelerationY = 0;
        this.dotColor = Color.black;
    }

    public int getPositionX(){
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

    public void drawDot(JFrame frame) {
        frame.getContentPane().add(new Component());
    }

    private class Component extends JComponent{
        public void paint(Graphics g){
            g.setColor(dotColor);
            g.fillOval(getPositionX(), getPositionY(), 5, 5);
            g.drawOval(getPositionX(), getPositionY(), 5, 5);
        }
    }
}