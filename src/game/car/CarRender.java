package game.car;

import base.Vector2D;
import renderer.LineRenderer;
import renderer.PolygonRenderer;
import renderer.RectangleRenderer;
import renderer.Renderer;

import java.awt.*;

class CarRender implements Renderer {
    PolygonRenderer body;
    LineRenderer arrow;
    Car car;
    RectangleRenderer bodyBox;

    public CarRender(Car car) {
        this.car = car;
        body = new PolygonRenderer(Color.RED,
                car.anchorPoint1,
                car.anchorPoint2,
                car.anchorPoint3,
                car.anchorPoint3Half,
                car.anchorPoint4);
        arrow = new LineRenderer(Color.WHITE);
        bodyBox = new RectangleRenderer(Color.BLACK, 60, 35);
    }

    @Override
    public void render(Graphics graphics, Vector2D position) {
        body.render(graphics, position);
        Vector2D x = new Vector2D(car.angle.x, car.angle.y).multiply(11f);
        arrow.updateVelocity(x);
        arrow.render(graphics, position);
//        bodyBox.render(graphics, car.boxCollider.position);
    }
}