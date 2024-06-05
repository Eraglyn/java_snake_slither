package lib.GameObject;

import lib.Arena.Arena;
import lib.Maths.Rect2;
import lib.Maths.Vector2;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * {@link RenderedObject}, this class is used to represent the visual object
 * in the game, it extends {@link GameObject}.
 */
public class RenderedObject<T extends Number> extends GameObject<T> {

    private Vector2<T> position; // position of the object
    private boolean visible; // whether the object is visible
    private Shape drawShape; // the shape of the object

    /**
     * {@link #RenderedObject()}, constructs a new RenderedObject and set the fields
     * to null
     * 
     * @return a new instance of {@link RenderedObject}
     */
    public RenderedObject() {
        super();
        visible = true; // set the visibility of the object to true
        drawShape = null; // set the shape of the object to null
    }

    /**
     * {@link #getPosition()}, return the position field
     * 
     * @return a {@link Vector2}, the position field
     */
    public Vector2<T> getPosition() {
        return position;
    }

    /**
     * {@link #getBounds()}, an overridable method to return the collider of the
     * calling object
     * 
     * @return a {@link Rect2}, the collider of the calling object
     */
    public Rect2<T> getBounds() {
        return null;
    }

    /**
     * {@link #getVisible()}, return the visible field
     * 
     * @return a boolean, the visible field
     */
    public boolean getVisible() {
        return visible;
    }

    /**
     * {@link #setPosition(newPos)}, set the position field to the parameter
     * 
     * @param newPos a {@link Vector2}, the new position of the calling object
     */
    public void setPosition(Vector2<T> newPos) {
        position = newPos.duplicate();
        updateDrawShape(); // update the shape of the object
    }

    /**
     * {@link #setPositionX(x)}, set the x field of the position field to the
     * parameter
     * 
     * @param x a number, the new x field of position
     */
    public void setPositionX(T x) {
        position.x = x;
        updateDrawShape();
    }

    /**
     * {@link #setPositionY(y)}, set the y field of the position field to the
     * parameter
     * 
     * @param y a number, the new y field of position
     */
    public void setPositionY(T y) {
        position.y = y;
        updateDrawShape();
    }

    /**
     * {@link #setVisible(enabled)}, set the visible field to the parameter
     * 
     * @param enabled a boolean
     */
    public void setVisible(boolean enabled) {
        visible = enabled;
        updateDrawShape();
    }

    /**
     * {@link #setDrawShape(Shape)}, set the drawShape field to the parameter
     * 
     * @param newShape a {@link Shape}, the new shape of the calling object
     */
    public void setDrawShape(Shape newShape) {
        if (getArena() != null && drawShape != null) {
            getArena().getCanvas().getChildren().remove(drawShape); // remove the old shape from the canvas
        }
        drawShape = newShape;
        if (getArena() != null && drawShape != null) {
            getArena().getCanvas().getChildren().add(drawShape); // add the new shape to the canvas
        }
        updateDrawShape();
    }

    /**
     * {@link #updateDrawShape()}, update the position of the drawShape to the
     * position of the calling object
     */
    public void updateDrawShape() {
        if (drawShape != null) {
            drawShape.setVisible(visible); // set the visibility of the shape

            // Check if the shape is a rectangle
            if (drawShape instanceof Rectangle) {
                ((Rectangle) drawShape).setX(position.x.doubleValue()); // set the x position of the shape
                ((Rectangle) drawShape).setY(position.y.doubleValue()); // set the y position of the shape

                // Check if the shape is a circle
            } else if (drawShape instanceof Circle) {
                ((Circle) drawShape).setCenterX(position.x.doubleValue()); // set the x position of the shape
                ((Circle) drawShape).setCenterY(position.y.doubleValue()); // set the y position of the shape
            }
        }
    }

    @Override
    public void onEnterScene(Arena<T> scene) {
        super.onEnterScene(scene);
        if (drawShape != null) {
            scene.getCanvas().getChildren().add(drawShape); // add the new shape to the canvas
        } else {
            System.out.println("caca");
        }
    }

    @Override
    public void onUpdate(double deltaT) {
        super.onUpdate(deltaT); // call the onUpdate method of the GameObject class
    }

    @Override
    public void onExitScene(Arena<T> scene) {
        super.onExitScene(scene);
        if (drawShape != null) {
            scene.getCanvas().getChildren().remove(drawShape); // remove the old shape from the canvas
        }
    }
}
