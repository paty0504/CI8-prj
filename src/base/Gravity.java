package base;

public class Gravity {
    public Vector2D vectorG;

    static public Gravity gravity = new Gravity(new Vector2D(0, (float) 0.08));

    public Gravity(Vector2D vector2D) {
        this.vectorG = vector2D;
    }
}