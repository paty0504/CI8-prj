package game.ball;

import base.Vector2D;
import renderer.RectangleRenderer;
import renderer.Renderer;

import java.awt.*;

public class BallRender implements Renderer {
    RectangleRenderer BallDownBox;
    RectangleRenderer BallUpBox;
    RectangleRenderer BallLeftBox;
    RectangleRenderer BallRightBox;

    @Override
    public void render(Graphics graphics, Vector2D position) {

    }
}