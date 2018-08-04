public class Pair<X,Y> {

    private X x;
    private Y y;

    public Pair(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    public X x() {
        return x;
    }

    public Y y() {
        return y;
    }

    public void setX (X newX) {
        this.x = newX;
    }

    public void setY (Y newY) {
        this.y = newY;
    }
}
