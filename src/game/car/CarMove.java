package game.car;

import base.Attribute;
import base.GameObject;
import base.Gravity;
import base.Vector2D;
import input.KeyboardInput;

public class CarMove implements Attribute<Car> {

    private Vector2D velocity = new Vector2D(0.1f, 0);
    private double angle = 2.0;

    private void backToScreen(Vector2D position) {
        if (position.x > 1230) position.set(1230, position.y);
        if (position.x < 140) position.set(140, position.y);
        if(position.y < 50) position.set(position.x, 50);
    }

    @Override
    public void run(Car gameObject) {

        if (gameObject.moveable(gameObject.position)) {
            gameObject.velocity.set(new Vector2D());
        }

        gameObject.velocity.addUp(Gravity.gravity.vectorG);


        if (KeyboardInput.instance.isD) {

                    gameObject.velocity.set((float) 5, 0);

        }

        if (KeyboardInput.instance.isA) {

                    gameObject.velocity.set((float) -5 ,0 );

        }

        if (KeyboardInput.instance.isW) {
            gameObject.velocity.set(0, (float) -5);


        }

        if (KeyboardInput.instance.isS) {
            gameObject.velocity.set(0, (float) 7);
        }

        if (KeyboardInput.instance.isSpace) {
//            gameObject.angle.multiply(1.001f);
//            gameObject.velocity.set((float)1,(float) -1 ).multiply(3.0000f);
            gameObject.velocity.multiply(3.001f);
        }

        if (gameObject.isOnGround(gameObject.position)) {
            gameObject.velocity.subtract(Gravity.gravity.vectorG);
            gameObject.position.set(gameObject.position.x, 425);
        }

        if (gameObject.velocity.length() > 10) {
            gameObject.velocity.set(gameObject.velocity.normalized().multiply(10));
        }
        gameObject.position.addUp(gameObject.velocity);

//        gameObject.velocity.set(velocity.rotate(gameObject.angle));
        this.backToScreen(gameObject.position);
    }
}
