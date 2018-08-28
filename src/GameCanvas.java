import base.GameObjectManager;
import base.Vector2D;
import game.background.Background;
import game.background.Ground;
import game.background.Obstacle;
import game.ball.Ball;
import game.car.Car;
import game.car.Car2;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {
    private BufferedImage backBuffered;
    private Graphics graphics;
    private Ball ball;
    private Car car;
    private Car2 car2;

    public GameCanvas() {
        this.setSize(1600, 525);
        this.setupElements();
        this.setupBackBuffered();
        this.setVisible(true);
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1600, 525, BufferedImage.TYPE_INT_ARGB);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setupElements() {
        GameObjectManager.instance.add(new Background());
        GameObjectManager.instance.add(new Ground());
        GameObjectManager.instance.add(new Obstacle(new Vector2D(), 1600, 25));
        GameObjectManager.instance.add(new Obstacle(new Vector2D(), 100, 250));
        GameObjectManager.instance.add(new Obstacle(new Vector2D( 1265, 0), 100, 250));
        GameObjectManager.instance.add(new Car2(new Vector2D(1000, 350 )));
        GameObjectManager.instance.add(new Car(new Vector2D(200, 350)));

        this.ball = new Ball(new Vector2D(750, 200), new Vector2D(3,3));

    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        GameObjectManager.instance.renderAll(this.graphics);
        this.ball.render(this.graphics);
        this.repaint();
    }

    public void runAll() {
        GameObjectManager.instance.runAll();
        this.ball.run();
    }
}