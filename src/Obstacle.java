import java.awt.*;

public class Obstacle {
    public int obstacleX, obstacleY, width, height;

    Obstacle(int obstacleX, int obstacleY, int width, int height) {
        this.obstacleX = obstacleX;
        this.obstacleY = obstacleY;
        this.width = width;
        this.height = height;
    }

    // Method for drawing the dot
    public void drawObstacles(Graphics g) {
        g.setColor(Color.blue);
        g.drawRect(obstacleX, obstacleY, width, height);
        g.fillRect(obstacleX, obstacleY, width, height);
    }
}
