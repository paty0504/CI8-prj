package game.ball;

import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import renderer.CircleRenderer;
import renderer.RectangleRenderer;

import java.awt.*;

public class Ball extends GameObject  {
    public Vector2D velocity = new Vector2D();

    public Ball(Vector2D position, Vector2D velocity) {
        this.position.set(position);
        this.velocity.set(velocity);
        this.renderer = new CircleRenderer(Color.YELLOW,80, 80);
        this.attributes.add(new BallDownBox());
        this.attributes.add(new BallUpBox());
        this.attributes.add(new BallLeftBox());
        this.attributes.add(new BallRightBox());
        this.attributes.add(new BallMove());
    }

    @Override
    public void run() {
        super.run();
    }
}
