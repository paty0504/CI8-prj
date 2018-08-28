package game.background;

import base.GameObject;
import physic.BoxCollider;
import renderer.RectangleRenderer;

import java.awt.*;

public class Background extends GameObject  {

    public Background() {
        this.renderer = new RectangleRenderer(Color.CYAN, 1600, 550);
        this.boxCollider = new BoxCollider(0,0);
    }
}
