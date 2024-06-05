package lib.Maths;

/**
 * {@link Vector2}, this class is used to represent a Vector2D.
 */
public class Vector2<T extends Number> {

    public T x; // The x component of the vector.
    public T y; // The y component of the vector.

    /**
     * Vector2, constructs a new Vector2
     * 
     * @return new instance of Vector2
     */
    public Vector2() {
        this.x = null;
        this.y = null;
    }

    /**
     * Vector2, constructs a new Vector2 with the specified numbers.
     * 
     * @param x a number
     * @param y a number
     * @return a new instance of Vector2
     */
    public Vector2(T x, T y) {
        this.x = x;
        this.y = y;
    }

    /**
     * equals, returns if the calling Vector2 is equal to the specified Vector2
     * (structural equality)
     * 
     * @param other a Vector2
     * @return the equality between the calling Vector2 and other (structural
     *         equality)
     */
    public boolean equals(Vector2<T> other) {
        return (this.x == other.x && this.y == other.y);
    }

    /**
     * distanceTo, return the distance between the calling Vector2 and the specified
     * Vector2
     * 
     * @param other a Vector2
     * @return the distance between the calling Vector2 and the specified Vector2
     */
    public double distanceTo(Vector2<T> other) {
        T v0 = Operations.sub(other.x, x);
        T v1 = Operations.sub(other.y, y);
        return Math.sqrt((Operations.add(Operations.mult(v0, v0), Operations.mult(v1,
                v1))).doubleValue());
    }

    /**
     * duplicate, return a new instance of Vector2 with the same field
     * values as the calling Vector2
     * 
     * @return a duplicate of the calling Vector2
     */
    public Vector2<T> duplicate() {
        return new Vector2<T>(this.x, this.y);
    }

    /**
     * normalized, return a normalized version of the calling Vector2
     * 
     * @return a normalized version of the calling Vector2
     */
    public Vector2<T> normalized() {
        Vector2<T> vec = duplicate();
        vec.normalize();
        return vec;
    }

    /**
     * flipped, returns a new instance of Vector2 with opposite field values as the
     * calling Vector2
     * 
     * @return a flipped version of the calling Vector2
     */
    public Vector2<T> flipped() {
        return new Vector2<T>(Operations.opposite(this.x), Operations.opposite(this.y));
    }

    /**
     * normalize, normalize the calling Vector2
     */
    @SuppressWarnings("unchecked")
    public void normalize() {
        double x = this.x.doubleValue();
        double y = this.y.doubleValue();
        double l = x * x + y * y;
        if (l != 0) {
            l = Math.sqrt(l);
            this.x = (T) (Double) (x / l);
            this.y = (T) (Double) (y / l);
        }
    }

    /**
     * {@link #plus}, returns a new Vector2 representing the addition of the calling
     * Vector2 and the specified Vector2
     * 
     * @param other a Vector2
     * @return the addition of the calling Vector2 and other
     */
    public Vector2<T> plus(Vector2<T> other) {
        return new Vector2<T>(Operations.add(this.x, other.x), Operations.add(this.y, other.y));
    }

    /**
     * {@link #minus}, returns a new Vector2 representing the subtraction of the
     * calling Vector2 and the specified Vector2
     * 
     * @param other a Vector2
     * @return the subtraction of the calling Vector2 and other
     */
    public Vector2<T> minus(Vector2<T> other) {
        return new Vector2<T>(Operations.sub(this.x, other.x), Operations.sub(this.y, other.y));
    }

    /**
     * {@link #multiply}, returns a new Vector2 representing the multiplication of
     * the calling Vector2 and the specified Vector2
     * 
     * @param other a Vector2
     * @return the multiplication of the calling Vector2 and other
     */
    public Vector2<T> multiply(Vector2<T> other) {
        return new Vector2<T>(Operations.mult(this.x, other.x), Operations.mult(this.y, other.y));
    }

    /**
     * {@link #multiply}, returns a new Vector2 representing the multiplication of
     * the calling Vector2 and the specified number
     * 
     * @param other a number
     * @return the multiplication of the calling Vector2 and other
     */
    public Vector2<T> multiply(T other) {
        return new Vector2<T>(Operations.mult(this.x, other), Operations.mult(this.y, other));
    }

    // Returns a string representation of the vector.
    public String toString() {
        return "(" + x + "," + y + ")";
    }

}
