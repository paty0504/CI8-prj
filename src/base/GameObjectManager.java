package base;

//import physic.BoxCollider;

import game.background.Ground;
import game.ball.Ball;
import physic.BoxCollider;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameObjectManager {

    static public GameObjectManager instance = new GameObjectManager();

    public List<GameObject> list;
    private List<GameObject> tempList;

    private GameObjectManager() {
        this.list = new ArrayList<>();
        this.tempList = new ArrayList<>();
    }

    public void add(GameObject gameObject) {
        this.tempList.add(gameObject);
    }

    public GameObject searchGround() {
        for (GameObject gameObject : this.list) {
            if (gameObject.getClass() == Ground.class) {
                return gameObject;
            }
        }
        return null;
    }

//    public <T extends GameObject> T checkCollision(BoxCollider boxCollider) {
//        return (T) this.list
//                .stream()
//                .filter(gameObject -> {
//                    BoxCollider other = ((T) gameObject).getBoxCollider();
//                    return boxCollider.checkCollision(other);
//                })
//                .findFirst()
//                .orElse(null);
//    }

    public void runAll() {
        this.list.stream().forEach(gameObject -> gameObject.run());
        this.list.addAll(tempList);
        this.tempList.clear();
    }

    public void renderAll(Graphics graphics) {
        this.list.stream().forEach(gameObject -> gameObject.render(graphics));
    }
}
