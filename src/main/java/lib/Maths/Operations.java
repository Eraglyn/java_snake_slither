package lib.Maths;

import java.util.Random;

/**
 * Operations, this class is used to apply mathematical operations on generic
 * types (T extends Number)
 */
public class Operations {

    /**
     * random, it returns a random number between 0 and e1 with the type of e1
     * 
     * @param <T> the number type
     * @param e1  bound of the random generation
     * @return a random number between 0 and e1
     */
    @SuppressWarnings("unchecked")
    public static <T extends Number> T random(T e1) {
        Random r = new Random();
        if (e1 instanceof Integer) {
            return (T) Integer.valueOf(r.nextInt(e1.intValue()));
        } else if (e1 instanceof Double) {
            return (T) Double.valueOf(r.nextDouble(e1.doubleValue()));
        } else if (e1 instanceof Float) {
            return (T) Float.valueOf(r.nextFloat(e1.floatValue()));
        } else if (e1 instanceof Long) {
            return (T) Long.valueOf(r.nextLong(e1.longValue()));
        } else {
            throw new UnsupportedOperationException("Unsupported number type");
        }
    }

    /**
     * opposite, it returns the opposite of e1
     * 
     * @param <T> the number type
     * @param e1  a number
     * @return the opposite of e1 (ex: opposite(1.9) = -1.9)
     */
    @SuppressWarnings("unchecked")
    public static <T extends Number> T opposite(T e1) {
        if (e1 instanceof Integer) {
            return (T) Integer.valueOf(-e1.intValue());
        } else if (e1 instanceof Double) {
            return (T) Double.valueOf(-e1.doubleValue());
        } else if (e1 instanceof Float) {
            return (T) Float.valueOf(-e1.floatValue());
        } else if (e1 instanceof Long) {
            return (T) Long.valueOf(-e1.longValue());
        } else {
            throw new UnsupportedOperationException("Unsupported number type");
        }
    }

    /**
     * lessEqual, it returns the comparison of e1 and e1 (e1 <= e2)
     * 
     * @param <T> the number type
     * @param e1  a number
     * @param e2  a number
     * @return e1 <= e2
     */
    public static <T extends Number> boolean lessEqual(T e1, T e2) {
        if (e1 instanceof Integer && e2 instanceof Integer) {
            return (e1.intValue() <= e2.intValue());
        } else if (e1 instanceof Double && e2 instanceof Double) {
            return (e1.doubleValue() <= e2.doubleValue());
        } else if (e1 instanceof Float && e2 instanceof Float) {
            return (e1.floatValue() <= e2.floatValue());
        } else if (e1 instanceof Long && e2 instanceof Long) {
            return (e1.longValue() <= e2.longValue());
        } else {
            throw new UnsupportedOperationException("Unsupported number type");
        }
    }

    /**
     * greaterEqual, it returns the comparison of e1 and e1 (e1 >= e2)
     * 
     * @param <T> the number type
     * @param e1  a number
     * @param e2  a number
     * @return e1 >= e2
     */
    public static <T extends Number> boolean greaterEqual(T e1, T e2) {
        if (e1 instanceof Integer && e2 instanceof Integer) {
            return (e1.intValue() >= e2.intValue());
        } else if (e1 instanceof Double && e2 instanceof Double) {
            return (e1.doubleValue() >= e2.doubleValue());
        } else if (e1 instanceof Float && e2 instanceof Float) {
            return (e1.floatValue() >= e2.floatValue());
        } else if (e1 instanceof Long && e2 instanceof Long) {
            return (e1.longValue() >= e2.longValue());
        } else {
            throw new UnsupportedOperationException("Unsupported number type");
        }
    }

    /**
     * less, it returns the comparison of e1 and e1 (e1 < e2)
     * 
     * @param <T> the number type
     * @param e1  a number
     * @param e2  a number
     * @return e1 < e2
     */
    public static <T extends Number> boolean less(T e1, T e2) {
        if (e1 instanceof Integer && e2 instanceof Integer) {
            return (e1.intValue() < e2.intValue());
        } else if (e1 instanceof Double && e2 instanceof Double) {
            return (e1.doubleValue() < e2.doubleValue());
        } else if (e1 instanceof Float && e2 instanceof Float) {
            return (e1.floatValue() < e2.floatValue());
        } else if (e1 instanceof Long && e2 instanceof Long) {
            return (e1.longValue() < e2.longValue());
        } else {
            throw new UnsupportedOperationException("Unsupported number type");
        }
    }

    /**
     * greater, it returns the comparison of e1 and e1 (e1 > e2)
     * 
     * @param <T> the number type
     * @param e1  a number
     * @param e2  a number
     * @return e1 > e2
     */
    public static <T extends Number> boolean greater(T e1, T e2) {
        if (e1 instanceof Integer && e2 instanceof Integer) {
            return (e1.intValue() > e2.intValue());
        } else if (e1 instanceof Double && e2 instanceof Double) {
            return (e1.doubleValue() > e2.doubleValue());
        } else if (e1 instanceof Float && e2 instanceof Float) {
            return (e1.floatValue() > e2.floatValue());
        } else if (e1 instanceof Long && e2 instanceof Long) {
            return (e1.longValue() > e2.longValue());
        } else {
            throw new UnsupportedOperationException("Unsupported number type");
        }
    }

    /**
     * add, it returns the addition of e1 and e2 (e1 + e2)
     * 
     * @param <T> the number type
     * @param e1  a number
     * @param e2  a number
     * @return e1 + e2
     */
    @SuppressWarnings("unchecked")
    public static <T extends Number> T add(T e1, T e2) {
        if (e1 instanceof Integer && e2 instanceof Integer) {
            return (T) Integer.valueOf(e1.intValue() + e2.intValue());
        } else if (e1 instanceof Double && e2 instanceof Double) {
            return (T) Double.valueOf(e1.doubleValue() + e2.doubleValue());
        } else if (e1 instanceof Float && e2 instanceof Float) {
            return (T) Float.valueOf(e1.floatValue() + e2.floatValue());
        } else if (e1 instanceof Long && e2 instanceof Long) {
            return (T) Long.valueOf(e1.longValue() + e2.longValue());
        } else {
            throw new UnsupportedOperationException("Unsupported number type");
        }
    }

    /**
     * sub, it returns the subtraction of e1 and e2 (e1 - e2)
     * 
     * @param <T> the number type
     * @param e1  a number
     * @param e2  a number
     * @return e1 - e2
     */
    @SuppressWarnings("unchecked")
    public static <T extends Number> T sub(T e1, T e2) {
        if (e1 instanceof Integer && e2 instanceof Integer) {
            return (T) Integer.valueOf(e1.intValue() - e2.intValue());
        } else if (e1 instanceof Double && e2 instanceof Double) {
            return (T) Double.valueOf(e1.doubleValue() - e2.doubleValue());
        } else if (e1 instanceof Float && e2 instanceof Float) {
            return (T) Float.valueOf(e1.floatValue() - e2.floatValue());
        } else if (e1 instanceof Long && e2 instanceof Long) {
            return (T) Long.valueOf(e1.longValue() - e2.longValue());
        } else {
            throw new UnsupportedOperationException("Unsupported number type");
        }
    }

    /**
     * mult, it returns the multiplication of e1 and e2 (e1 * e2)
     * 
     * @param <T> the number type
     * @param e1  a number
     * @param e2  a number
     * @return e1 + e2
     */
    @SuppressWarnings("unchecked")
    public static <T extends Number> T mult(T e1, T e2) {
        if (e1 instanceof Integer && e2 instanceof Integer) {
            return (T) Integer.valueOf(e1.intValue() * e2.intValue());
        } else if (e1 instanceof Double && e2 instanceof Double) {
            return (T) Double.valueOf(e1.doubleValue() * e2.doubleValue());
        } else if (e1 instanceof Float && e2 instanceof Float) {
            return (T) Float.valueOf(e1.floatValue() * e2.floatValue());
        } else if (e1 instanceof Long && e2 instanceof Long) {
            return (T) Long.valueOf(e1.longValue() * e2.longValue());
        } else {
            throw new UnsupportedOperationException("Unsupported number type");
        }
    }

    /**
     * div, it returns the division of e1 and e2 (e1 / e2)
     * 
     * @param <T> the number type
     * @param e1  a number
     * @param e2  a number
     * @return e1 / e2
     */
    @SuppressWarnings("unchecked")
    public static <T extends Number> T div(T e1, T e2) {
        if (e1 instanceof Integer && e2 instanceof Integer) {
            return (T) Integer.valueOf(e1.intValue() / e2.intValue());
        } else if (e1 instanceof Double && e2 instanceof Double) {
            return (T) Double.valueOf(e1.doubleValue() / e2.doubleValue());
        } else if (e1 instanceof Float && e2 instanceof Float) {
            return (T) Float.valueOf(e1.floatValue() / e2.floatValue());
        } else if (e1 instanceof Long && e2 instanceof Long) {
            return (T) Long.valueOf(e1.longValue() / e2.longValue());
        } else {
            throw new UnsupportedOperationException("Unsupported number type");
        }
    }
}
