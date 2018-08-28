package game.car;
import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import renderer.LineRenderer;
import renderer.PolygonRenderer;
import renderer.Renderer;

import java.awt.*;
public class Car2 extends GameObject{
    public Vector2D velocity;
    public Vector2D angle;
    public Car2Box car2Box = new Car2Box(this.position);
    public Vector2D anchorPoint1 = new Vector2D(60,0);
    public Vector2D anchorPoint2 = new Vector2D(15,0);
    public Vector2D anchorPoint3 = new Vector2D(0,15);
    public Vector2D anchorPoint3Half = new Vector2D(0,35);
    public Vector2D anchorPoint4 = new Vector2D(60,35);
    public Car2(Vector2D position) {
        this.velocity = new Vector2D();
        this.angle = new Vector2D(-1,0);
        this.renderer = new Car2Render(this);
        this.position.set(position);
        this.attributes.add(new Car2Move());

        this.boxCollider = new BoxCollider(60, 35);
        this.boxCollider.position.set(this.position);
    }

    public boolean moveable(Vector2D vector2D) {
        return (car2Box.checkCollision(vector2D));
    }

    public boolean isOnGround(Vector2D vector2D) {
        return (car2Box.checkGroundCollision(vector2D));
    }

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position.subtract(30, 15));

//        if (this.velocity.length() >= 3.0)
//            this.velocity.set(this.velocity.normalized().multiply(3));
    }
}
