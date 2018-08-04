import java.util.Vector;

class Dot {
    Vector position;
    Vector velocity;
    Vector acceleration;

    int width, height = 800;

    Dot() {
        position = new Vector<>(width / 2, height / 2);
        velocity = new Vector<>(0, 0);
        acceleration = new Vector<>(0, 0);
    }
}