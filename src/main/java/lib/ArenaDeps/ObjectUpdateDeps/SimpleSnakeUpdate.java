package lib.ArenaDeps.ObjectUpdateDeps;

import lib.GameObject.FoodObject;
import lib.GameObject.RenderedObject;
import lib.GameObject.SnakeCellObject;
import lib.GameObject.SnakeHeadObject;
import lib.Maths.Operations;
import lib.Maths.Rect2;
import lib.Maths.Vector2;

/**
 * {@link SimpleSnakeUpdate}, this class is used to represent the implementation
 * of {@link SnakeUpdateDeps} to match with the snake physics
 */
public class SimpleSnakeUpdate implements SnakeUpdateDeps<Integer> {

    /**
     * {@link #aimToCursor(SnakeHeadObject)}, angle the direction of the snake to
     * the cursor of the snake.
     * 
     * @param snake a {@link SnakeHeadObject}, the snake to update
     */
    private void aimToCursor(SnakeHeadObject<Integer> snake) {
        Vector2<Integer> new_dir = new Vector2<Integer>(snake.cursor_pos.x -
                snake.body.get(0).getPosition().x,
                snake.cursor_pos.y - snake.body.get(0).getPosition().y);
        Vector2<Integer> alt = null;
        if (Math.abs(new_dir.x) > Math.abs(new_dir.y)) {
            if (new_dir.x > 0) {
                new_dir = new Vector2<Integer>(1, 0);
                if (new_dir.y > 0) {
                    alt = new Vector2<Integer>(0, 1);
                } else {
                    alt = new Vector2<Integer>(0, -1);
                }

            } else {
                new_dir = new Vector2<Integer>(-1, 0);
                if (new_dir.y > 0) {
                    alt = new Vector2<Integer>(0, 1);
                } else {
                    alt = new Vector2<Integer>(0, -1);
                }
            }
        } else {
            if (new_dir.y > 0) {
                new_dir = new Vector2<Integer>(0, 1);
                if (new_dir.x > 0) {
                    alt = new Vector2<Integer>(1, 0);
                } else {
                    alt = new Vector2<Integer>(-1, 0);
                }
            } else {
                new_dir = new Vector2<Integer>(0, -1);
                if (new_dir.x > 0) {
                    alt = new Vector2<Integer>(1, 0);
                } else {
                    alt = new Vector2<Integer>(-1, 0);
                }
            }
        }
        if (new_dir.equals(snake.direction.flipped())) {
            System.out.println("cas");
            new_dir = alt;
        }
        snake.direction = new Vector2<Integer>(new_dir.x,
                new_dir.y);
        // System.out.println(snake.direction);
        // snake.direction.normalize();
    }

    @Override
    public void update(double detlaT, SnakeHeadObject<Integer> snake) {
        if (!snake.dead) {
            // HEAD MOVEMENT
            if (snake.cursor_pos != null)
                aimToCursor(snake);
            // System.out.println(snake.body.get(0).getPosition());
            Vector2<Integer> old_pos = snake.body.get(0).getPosition().duplicate();
            // direction * speed
            Vector2<Integer> new_pos = old_pos
                    .plus(new Vector2<Integer>(Operations.mult(snake.direction.x, snake.speed),
                            Operations.mult(snake.direction.y, snake.speed)))
                    .duplicate();

            Rect2<Integer> arena_bounds = snake.game_arena.getBounds();

            Rect2<Integer> new_head_bounds = new Rect2<Integer>(new_pos,
                    new Vector2<Integer>(Operations.add(new_pos.x, snake.cell_size),
                            Operations.add(new_pos.y, snake.cell_size)));
            // COLLISION CONDITIONS

            for (RenderedObject<Integer> obj : snake.game_arena.getChildList()) {
                if (obj instanceof FoodObject) {
                    if (new_head_bounds.contains(obj.getPosition())) {
                        snake.game_arena.removeChild(obj);
                        snake.game_arena.generate_food();
                        snake.addToBody(new SnakeCellObject<Integer>(snake.cell_color, snake.init_pos,
                                snake.cell_size));
                        break;
                    }
                }
                if (obj instanceof SnakeCellObject) {
                    // dying procedure
                    if (new_head_bounds.contains(obj.getBounds())) {
                        snake.dies();
                        break;
                    }
                }
            }

            // OUT OF THE MAP CONDITIONS
            if (!arena_bounds.contains(new_pos)) {
                snake.dies();
            }

            // DO HEAD MOVE

            snake.body.get(0).setPosition(new_pos);

            // MOVE THE REST OF THE BODY

            for (int i = 1; i < snake.body.size(); i++) {
                new_pos = old_pos.duplicate();
                old_pos = snake.body.get(i).getPosition().duplicate();
                snake.body.get(i).setPosition(new_pos);
            }
        } else {

        }
    }
}
