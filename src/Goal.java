import java.awt.*;

public class Goal {
    private int windowWidth, windowHeight;

    Goal(int windowWidth, int windowHeight){
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
    }

    // Method for drawing the dot
    public void drawGoal(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(windowWidth/2, 25, 10, 10);
        g.drawOval(windowWidth/2, 25, 10, 10);
    }
}
