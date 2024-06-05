package lib.GameObject;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import lib.Maths.Operations;
import lib.Maths.Rect2;
import lib.Maths.Vector2;

/**
 * {@link SnakeCellObject}, this class is used to represent the cell of a
 * {@link SnakeHeadObject}
 */
public class SnakeCellObject<T extends Number> extends RenderedObject<T> {
    public T radius; // the radius of the cell

    /**
     * {@link #SnakeCellObject(Color, Vector2, Number)}, construct a new
     * {@link SnakeCellObject} with the parameters
     * 
     * @param c      a {@link Color}, the color of the cell
     * @param pos    a {@link Vector2}, the position of the cell
     * @param c_size a {@link Number}, the radius of the cell
     * @return a new instance of {@link SnakeCellObject}
     */
    public SnakeCellObject(Color c, Vector2<T> pos, T c_size) {
        super();
        radius = c_size;
        Circle shape = new Circle();
        shape.setRadius(radius.doubleValue());
        shape.setFill(c);
        setPosition(pos);
        setDrawShape(shape);
    }

    @Override
    public Rect2<T> getBounds() {
        return new Rect2<T>(
                new Vector2<T>(getPosition().x, getPosition().y),
                new Vector2<T>(Operations.add(getPosition().x, radius),
                        Operations.add(getPosition().y, radius)));
    }
}
