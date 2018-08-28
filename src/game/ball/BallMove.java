package game.ball;

import base.Attribute;
import base.Gravity;
import renderer.TextRenderer;

import java.awt.*;

public class BallMove implements Attribute<Ball> {
    public int myScore =0;
    public int enemyScore =0;
    @Override

    public void run(Ball gameObject) {

        gameObject.velocity.addUp(Gravity.gravity.vectorG);
        gameObject.velocity.multiply(0.9999999f);
        gameObject.position.addUp(gameObject.velocity);
        if ((gameObject.position.x > 1160) && (gameObject.position.y < 230) ) gameObject.velocity.multiply(-1);
        if(((gameObject.position.x >= 1285) && (240 < gameObject.position.y)  )){

            myScore +=1;
            System.out.print("Goal "  + myScore + '-' + enemyScore);
            gameObject.velocity.set(3, -3);
            gameObject.position.set(750, 200);
        }
        if(((gameObject.position.x <= 20) && (240 < gameObject.position.y))){
            enemyScore +=1;
            System.out.println("Goal " + myScore + '-' + enemyScore);
            gameObject.velocity.set(-3, 3);
            gameObject.position.set(750, 200);
        }
//        if(gameObject.position.x < 0 || gameObject.position.x >1500) gameObject.position.set(750,200);
        if(gameObject.position.y <0 || gameObject.position.y >400) gameObject.position.set(750,200);
//        if(((gameObject.position.x == 1265) && (290> gameObject.position.y))){
//        gameObject.velocity.set(gameObject.velocity.x * -1, gameObject.velocity.y );
//
//    }
}

}