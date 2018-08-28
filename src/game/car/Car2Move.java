package game.car;

import base.Attribute;
import base.GameObject;
import base.Gravity;
import base.Vector2D;
import input.KeyboardInput2;

public class Car2Move implements Attribute<Car2> {

    private Vector2D velocity = new Vector2D(0.1f, 0);
    private double angle = 2.0;

    private void backToScreen(Vector2D position) {
        if (position.x > 1230) position.set(1230, position.y);
        if (position.x < 140) position.set(140, position.y);

        if(position.y < 50) position.set(position.x, 50);
    }



    @Override
    public void run(Car2 gameObject) {

            if (gameObject.moveable(gameObject.position)) {
                gameObject.velocity.set(new Vector2D());
            }

            gameObject.velocity.addUp(Gravity.gravity.vectorG);


            if (KeyboardInput2.instance.isRight) {

                        gameObject.velocity.set((float) 5, 0);


            }

            if (KeyboardInput2.instance.isLeft) {

                        gameObject.velocity.set((float) -5 ,0 );


            }

            if (KeyboardInput2.instance.isUp) {
                gameObject.velocity.set(0, (float) -5);
            }

            if (KeyboardInput2.instance.isDown) {
                gameObject.velocity.set(0, (float) 7);
            }

            if (KeyboardInput2.instance.isEnter) {
//                gameObject.angle.multiply(1.001f);
//                gameObject.velocity.addUp(gameObject.angle);
                gameObject.velocity.multiply(3.000f);
            }

            if (gameObject.isOnGround(gameObject.position)) {
                gameObject.velocity.subtract(Gravity.gravity.vectorG);
                gameObject.position.set(gameObject.position.x, 415);
            }

            if (gameObject.velocity.length() > 10) {
                gameObject.velocity.set(gameObject.velocity.normalized().multiply(10));
            }
            gameObject.position.addUp(gameObject.velocity);


            this.backToScreen(gameObject.position);
        }


    }

