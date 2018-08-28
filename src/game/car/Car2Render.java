package game.car;

import base.Vector2D;
import renderer.LineRenderer;
import renderer.PolygonRenderer;
import renderer.RectangleRenderer;
import renderer.Renderer;

import java.awt.*;

class Car2Render implements Renderer {
    PolygonRenderer body;
    LineRenderer arrow;
    Car2 car2;
    RectangleRenderer bodyBox;

    public Car2Render(Car2 car2) {
        this.car2 = car2;
        body = new PolygonRenderer(Color.BLUE,
                car2.anchorPoint1,
                car2.anchorPoint2,
                car2.anchorPoint3,
                car2.anchorPoint3Half,
                car2.anchorPoint4);
        arrow = new LineRenderer(Color.WHITE);
        bodyBox = new RectangleRenderer(Color.BLACK, 60, 35);
    }

    @Override
    public void render(Graphics graphics, Vector2D position) {
        body.render(graphics, position);
        Vector2D x = new Vector2D(car2.angle.x, car2.angle.y).multiply(11f);
        arrow.updateVelocity(x);
        arrow.render(graphics, position);
//        bodyBox.render(graphics, car2.boxCollider.position);
    }
}