package game.car;

import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import renderer.LineRenderer;
import renderer.PolygonRenderer;
import renderer.Renderer;

import java.awt.*;

public class Car extends GameObject  {

    public Vector2D velocity;
    public Vector2D angle;
    public CarBox carBox;
    public Vector2D anchorPoint1 = new Vector2D(0,0);
    public Vector2D anchorPoint2 = new Vector2D(45,0);
    public Vector2D anchorPoint3 = new Vector2D(60,15);
    public Vector2D anchorPoint3Half = new Vector2D(60,35);
    public Vector2D anchorPoint4 = new Vector2D(0,35);

    public Car(Vector2D position) {
        this.velocity = new Vector2D();
        this.angle = new Vector2D(1,0);
        this.renderer = new CarRender(this);
        this.position.set(position);
        this.attributes.add(new CarMove());

        this.boxCollider = new BoxCollider(60, 35);
        this.boxCollider.position.set(this.position);
        this.carBox = new CarBox(this.boxCollider);
    }

    public boolean moveable(Vector2D vector2D) {
        return (carBox.checkCollision(vector2D));
    }

    public boolean isOnGround(Vector2D vector2D) {
        return (carBox.checkGroundCollision(vector2D));
    }

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position.subtract(30, 15));

//        if (this.velocity.length() >= 3.0)
//            this.velocity.set(this.velocity.normalized().multiply(3));
    }
}


