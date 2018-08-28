package game.background;

import base.GameObject;
import base.Vector2D;
//import physic.BoxCollider;
import physic.BoxCollider;
import renderer.RectangleRenderer;

import java.awt.*;

public class Obstacle extends GameObject  {
    public int width;
    public int height;


    public Obstacle(Vector2D vector2D, int width, int height) {
        this.position.set(vector2D);
        this.width = width;
        this.height = height;
        this.renderer = new RectangleRenderer(Color.GRAY, this.width, this.height);
        this.hitBoxRenderer = new RectangleRenderer(Color.GREEN, this.width, this.height);
        this.boxCollider = new BoxCollider(this.width, this.height);
        this.boxCollider.position.set(this.position);

    }
}
