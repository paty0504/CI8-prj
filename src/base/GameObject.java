package base;

import physic.BoxCollider;
import renderer.Renderer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class GameObject {
    public Vector2D position;
    public Renderer renderer;
    public Renderer hitBoxRenderer;
    public List<Attribute> attributes;
    public Vector2D hitBoxPosition;
    public BoxCollider boxCollider;

    public GameObject() {
        this.position = new Vector2D();
        this.attributes = new ArrayList<>();
    }

    public void run() {
        this.attributes.forEach(attribute -> attribute.run(this));
    }

    public void render(Graphics graphics) {
        if (this.renderer!= null) {
            this.renderer.render(graphics, this.position);
        }
        if (this.hitBoxRenderer!= null) {
            if (this.hitBoxPosition != null) {
                this.hitBoxRenderer.render(graphics, this.hitBoxPosition);
            } else {
                this.hitBoxRenderer.render(graphics, this.position);
            }
        }
    }


}
