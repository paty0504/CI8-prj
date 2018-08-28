package game.ball;

import base.Attribute;
import base.GameObject;
import base.GameObjectManager;
import physic.BoxCollider;

public class BallUpBox implements Attribute<Ball> {
    public BoxCollider boxCollider = new BoxCollider(40, 20);
    @Override
    public void run(Ball gameObject) {
        this.boxCollider.position.set(gameObject.position.x + 20, gameObject.position.y);
        for(GameObject gameObject1 : GameObjectManager.instance.list) {
            if (gameObject1.boxCollider != null) {
                if (this.boxCollider.checkCollision(gameObject1.boxCollider)) {
                    gameObject.velocity.set(gameObject.velocity.x, Math.abs(gameObject.velocity.y)).multiply(0.8f);
                    break;
                }
            }
        }

    }
}