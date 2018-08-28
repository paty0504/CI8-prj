package game.car;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.background.Ground;
import physic.BoxCollider;

public class Car2Box {
    public Vector2D tempPosition = new Vector2D();
    public Vector2D baseposition;
    public BoxCollider boxColliderB = new BoxCollider(60, 35);

    public Car2Box(Vector2D vector2D) {
        this.baseposition = vector2D;
        this.boxColliderB.position.set(this.baseposition);
    }

    public boolean checkGroundCollision(Vector2D vector2D) {
        boxColliderB.position.set(vector2D);
        return (boxColliderB.checkCollision(GameObjectManager.instance.searchGround().boxCollider));
    }

    public boolean checkCollision(Vector2D vector2D) {
        for (GameObject gameObject : GameObjectManager.instance.list) {
            if (gameObject.getClass() != Ground.class
                    && gameObject.getClass() != Car2.class) {
                if (boxColliderB.checkCollision(gameObject.boxCollider)) {
                    return true;
                }
            }
        }
        return false;
    }
}
