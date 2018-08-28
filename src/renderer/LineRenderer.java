package renderer;

import base.Vector2D;

import java.awt.*;

public class LineRenderer implements Renderer {
    private Color color;
    public Vector2D vector2D;

    public LineRenderer(Color color) {
        this.color = color;
    }

    public void updateVelocity(Vector2D vector2D) {
        this.vector2D = vector2D;
    }

    @Override
    public void render(Graphics graphics, Vector2D position) {
        this.vector2D = position.add(this.vector2D);
        graphics.setColor(this.color);
        graphics.drawLine((int) position.x, (int) position.y, (int) this.vector2D.x, (int) this.vector2D.y);
    }
}
