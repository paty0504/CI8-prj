package game.car;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.background.Ground;
import physic.BoxCollider;

public class CarBox {
    public Vector2D tempPosition = new Vector2D();
    public BoxCollider boxCollider;

    public CarBox(BoxCollider boxCollider) {
        this.boxCollider = boxCollider;
    }

    public boolean checkGroundCollision(Vector2D vector2D) {
        return (boxCollider.checkCollision(GameObjectManager.instance.searchGround().boxCollider));
    }

    public boolean checkCollision(Vector2D vector2D) {
        for (GameObject gameObject : GameObjectManager.instance.list) {
            if (gameObject.getClass() != Ground.class
                    && gameObject.getClass() != Car.class) {
                if (boxCollider.checkCollision(gameObject.boxCollider)) {
                    return true;
                }
            }
        }
        return false;
    }
}
