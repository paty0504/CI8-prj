package game.ball;

import base.Attribute;
import base.GameObject;
import base.GameObjectManager;
import game.car.Car;
import physic.BoxCollider;
import game.car.Car2;

public class BallLeftBox implements Attribute<Ball> {
    public BoxCollider boxCollider = new BoxCollider(20, 40);
    @Override
    public void run(Ball gameObject) {
        this.boxCollider.position.set(gameObject.position.x , gameObject.position.y +20);
        for(GameObject gameObject1 : GameObjectManager.instance.list) {
            if (gameObject1.boxCollider != null) {
                if (this.boxCollider.checkCollision(gameObject1.boxCollider)) {
                    gameObject.velocity.set(Math.abs(gameObject.velocity.x), gameObject.velocity.y );
                    if (gameObject1 instanceof  Car) {
                        gameObject.velocity.addUp(((Car) gameObject1).velocity).multiply((float)0.6);
                    }

                    break;
                }
            }
        }

    }
}
