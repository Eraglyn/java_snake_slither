package lib.GameObject;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import lib.Maths.Operations;
import lib.Maths.Rect2;
import lib.Maths.Vector2;

/**
 * {@link FoodObject}, this class is used to represent the food in the game, it
 * extends {@link RenderedObject}.
 */
public class FoodObject<T extends Number> extends RenderedObject<T> {
    public Vector2<T> init_pos; // initial position of food
    public T radius; // radius of food

    /**
     * {@link #FoodObject(Number, Vector2, Color)}, constructs a new FoodObject with
     * the specified parameters
     * 
     * @param rad    a number, the radius of the food
     * @param init_p a {@link Vector2}, the initial position of the food
     * @param c      a {@link Color}, the color of the food
     */
    public FoodObject(T rad, Vector2<T> init_p, Color c) {
        super();
        init_pos = init_p;
        radius = rad;
        Circle shape = new Circle();
        shape.setRadius(radius.doubleValue());
        shape.setCenterX(init_pos.x.doubleValue());
        shape.setCenterY(init_pos.y.doubleValue());
        shape.setFill(c);
        setPosition(new Vector2<T>(init_pos.x, init_pos.y));
        setDrawShape(shape);
    }

    /**
     * {@link #getBounds()}, returns a {@link Rect2} representing the collider of
     * the calling object.
     * 
     * @return a new {@link Rect2}, the collider of the calling object
     */
    @Override
    public Rect2<T> getBounds() {
        return new Rect2<T>(
                new Vector2<T>(Operations.sub(getPosition().x, radius),
                        Operations.sub(getPosition().y, radius)),
                new Vector2<T>(Operations.add(getPosition().x, radius),
                        Operations.add(getPosition().y, radius)));
    }
}
