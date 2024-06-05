package lib.GameObject;

import javafx.scene.paint.Color;
import lib.Arena.Arena;
import lib.Maths.Operations;
import lib.Maths.Vector2;

/**
 * {@link FoodGenerator}, this class is used to handle the random generation of
 * food
 */
public class FoodGenerator<T extends Number> {
    public Arena<T> game_arena; // the arena where we want to create food
    public T radius; // data for food
    public Color color; // data for food

    /**
     * {@link #FoodGenerator(scene, rad ,c)}, constructs a new {@link FoodGenerator}
     * 
     * @param scene an {@link Arena} where the food will be generated
     * @param rad   a number, the radius of the food that will be generated
     * @param c     a {@link Color}, the color of the food that will be generated
     * @return a new instance of {@link FoodGenerator}
     */
    public FoodGenerator(Arena<T> scene, T rad, Color c) {
        game_arena = scene;
        radius = rad;
        color = c;
    }

    /**
     * {@link #getRandomFoodPosition()}, returns a new possible position for a new
     * food
     * 
     * @return a new {@link Vector2} of the possible position
     */
    public Vector2<T> getRandomFoodPosition() {
        T new_x = Operations.random(Operations.sub(game_arena.getWidth(), game_arena.getFoodRadius()));
        T new_y = Operations.random(Operations.sub(game_arena.getHeight(), game_arena.getFoodRadius()));
        new_x = Operations
                .add(Operations.mult(Operations.div(new_x, game_arena.getUnitSize()), game_arena.getUnitSize()),
                        game_arena.getFoodRadius());
        new_y = Operations.add(
                Operations.mult(Operations.div(new_y, game_arena.getUnitSize()), game_arena.getUnitSize()),
                game_arena.getFoodRadius());
        Vector2<T> new_pos = new Vector2<T>(new_x, new_y);
        for (RenderedObject<T> object : game_arena.getChildList()) {
            if (!(object instanceof SnakeHeadObject)) {
                if (object.getBounds().contains(new_pos)) {
                    return getRandomFoodPosition();
                }
            }
        }
        return new_pos;
    }

    /**
     * {@link #create()}, add a new {@link FoodObject} to the {@link Arena}
     */
    public void create() {
        Vector2<T> new_pos = getRandomFoodPosition();
        game_arena.addChild(new FoodObject<T>(radius, new_pos, color));
    }
}
