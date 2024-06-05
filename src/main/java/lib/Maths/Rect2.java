package lib.Maths;

/**
 * {@link Rect2}, this class is used to represent a Rectangle using
 * {@link Vector2}.
 */
public class Rect2<T extends Number> {
    public Vector2<T> position; // The position of the Rect2.
    public Vector2<T> size; // The size of the Rect2.

    /**
     * Rect2, constructs a new Rect2
     * 
     * @return new instance of Rect2
     */
    public Rect2() {
        this.position = new Vector2<T>();
        this.size = new Vector2<T>();
    }

    /**
     * Rect2, constructs a new Rect2 with the position and size set to the specified
     * Vector2.
     * 
     * @param position a Vector2
     * @param size     a Vector2
     * @return new instance of Rect2
     */
    public Rect2(Vector2<T> position, Vector2<T> size) {
        this.position = position.duplicate();
        this.size = size.duplicate();
    }

    /**
     * Rect2, constructs a new Rect2 with the position set to the specified numbers
     * 
     * @param x      a number
     * @param y      a number
     * @param width  a number
     * @param height a number
     * @return new instance of Rect2
     */
    public Rect2(T x, T y, T width, T height) {
        this.position = new Vector2<T>(x, y);
        this.size = new Vector2<T>(width, height);
    }

    /**
     * contains, returns true if the calling Rect2 contains the specified point.
     * 
     * @param point a Vector2
     * @return if the point is in the calling Rect2
     */
    public boolean contains(Vector2<T> point) {
        return (Operations.greaterEqual(point.x, position.x)
                && Operations.lessEqual(point.x, size.x) &&
                Operations.greaterEqual(point.y, position.y)
                && Operations.lessEqual(point.y, size.y));
    }

    /**
     * contains, returns true if the calling Rect2 contains the specified Rect2.
     * 
     * @param other a Rect2
     * @return if the Rect2 is in the calling Rect2
     */
    public boolean contains(Rect2<T> other) {
        return contains(other.position) && contains(other.size);
    }

    /**
     * duplicate, return a new instance of Rect2 with the same fields values as the
     * calling Rect2
     * 
     * @return a duplicate of the calling Rect2
     */
    public Rect2<T> duplicate() {
        return new Rect2<T>(position.duplicate(), size.duplicate());
    }

    // Returns a string representation of the Rect2.
    public String toString() {
        return "Rect2(" + position.x + ", " + position.y + ", " + size.x + ", " + size.y + ")";
    }

}
