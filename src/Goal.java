import java.awt.*;

public class Goal {
    public Pair<Integer, Integer> position;

    Goal(int windowWidth, int windowHeight){
        this.position = new Pair<>(windowWidth / 2, 25);
    }

    // Method for drawing the dot
    public void drawGoal(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(position.x(), position.y(), 10, 10);
        g.drawOval(position.x(), position.y(), 10, 10);
    }
}
