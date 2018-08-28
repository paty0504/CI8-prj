package game.ball;

import base.Attribute;
import base.GameObject;
import base.GameObjectManager;
import game.car.Car;
import physic.BoxCollider;
import game.car.Car2;

public class BallRightBox implements Attribute<Ball> {
    public BoxCollider boxCollider = new BoxCollider(20, 40);
    @Override
    public void run(Ball gameObject) {
        this.boxCollider.position.set(gameObject.position.x + 60, gameObject.position.y + 20 );
        for(GameObject gameObject2 : GameObjectManager.instance.list) {
            if (gameObject2.boxCollider != null) {
                if (this.boxCollider.checkCollision(gameObject2.boxCollider)) {
                    gameObject.velocity.set(gameObject.velocity.x , gameObject.velocity.y );
                    if (gameObject2 instanceof Car2) {
                        gameObject.velocity.addUp(((Car2) gameObject2).velocity).multiply((float)0.8);
                    }
                    break;
                }
            }
        }


    }
}
