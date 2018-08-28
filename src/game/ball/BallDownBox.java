package game.ball;

import base.Attribute;
import base.GameObject;
import base.GameObjectManager;
import base.Gravity;
import physic.BoxCollider;
import renderer.RectangleRenderer;

import java.awt.*;

public class BallDownBox implements Attribute<Ball> {
    public BoxCollider boxCollider = new BoxCollider(40, 20);

    @Override
    public void run(Ball gameObject) {
        this.boxCollider.position.set(gameObject.position.x + 20, gameObject.position.y + 60);
        for(GameObject gameObject1 : GameObjectManager.instance.list) {
            if (gameObject1.boxCollider != null) {
                if (this.boxCollider.checkCollision(gameObject1.boxCollider)) {
                    gameObject.velocity.set(gameObject.velocity.x, Math.abs(gameObject.velocity.y) * -1);
                    if (Math.abs(gameObject.velocity.y) < Gravity.gravity.vectorG.y) {
                        gameObject.position.y = 370;
                        gameObject.velocity.subtract(Gravity.gravity.vectorG);
                    }
                    break;
                }
            }
        }
    }
}