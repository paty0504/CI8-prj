package game.background;

import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import renderer.RectangleRenderer;

import java.awt.*;

public class Ground extends GameObject  {

    public Ground() {
        this.position.set(new Vector2D(0, 450));
        this.renderer = new RectangleRenderer(Color.GRAY, 1600, 35);
        this.hitBoxRenderer = new RectangleRenderer(Color.green, 1600, 35);
        this.boxCollider = new BoxCollider(1600, 25);
        this.boxCollider.position.set(this.position);
    }
}
