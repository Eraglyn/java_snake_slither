package lib.ArenaDeps.ObjectUpdateDeps;

import lib.GameObject.FoodObject;
import lib.GameObject.RenderedObject;
import lib.GameObject.SnakeCellObject;
import lib.GameObject.SnakeHeadObject;
import lib.Maths.Rect2;
import lib.Maths.Vector2;

/**
 * {@link SlitherSnakeUpdate}, this class is used to represent the
 * implementation of {@link SnakeUpdateDeps} to match with the slither.io
 * physics
 */
public class SlitherSnakeUpdate implements SnakeUpdateDeps<Double> {

    /**
     * {@link #aimToCursor(SnakeHeadObject)}, angle the direction of the snake to
     * the cursor of the snake. the function does not aim fully to the cursor but
     * each call angle it to 1/4 of the actual angle needed. It is to make the
     * movement more realistic and more close to the real game of slither.io
     * 
     * @param snake a {@link SnakeHeadObject}, the snake to update
     */
    private void aimToCursor(SnakeHeadObject<Double> snake) {
        Vector2<Double> new_dir = new Vector2<Double>(snake.cursor_pos.x -
                snake.body.get(0).getPosition().x,
                snake.cursor_pos.y - snake.body.get(0).getPosition().y);
        new_dir.normalize();
        snake.direction = new Vector2<Double>(snake.direction.x + (new_dir.x / 4),
                snake.direction.y + (new_dir.y / 4));
        snake.direction.normalize();
    }

    @Override
    public void update(double detlaT, SnakeHeadObject<Double> snake) {
        if (!snake.dead) {
            // HEAD MOVEMENT
            aimToCursor(snake);
            Vector2<Double> old_pos = snake.body.get(0).getPosition().duplicate();
            // direction * speed
            // System.out.println(detlaT);
            Vector2<Double> new_pos = old_pos
                    .plus(new Vector2<Double>(snake.direction.x * snake.speed * detlaT,
                            snake.direction.y * snake.speed * detlaT))
                    .duplicate();

            Rect2<Double> new_head_bounds = new Rect2<Double>(
                    new Vector2<Double>(new_pos.x - snake.getArena().getFoodRadius(),
                            new_pos.y - snake.getArena().getFoodRadius()),
                    new Vector2<Double>(new_pos.x + snake.getArena().getFoodRadius(),
                            new_pos.y + snake.getArena().getFoodRadius()));
            // COLLISION CONDITIONS

            // OUT OF THE MAP CONDITIONS
            for (RenderedObject<Double> obj : snake.game_arena.getChildList()) {
                if (obj instanceof FoodObject) {
                    if (new_head_bounds.contains(obj.getPosition())) {
                        snake.game_arena.removeChild(obj);
                        snake.game_arena.generate_food();
                        snake.addToBody(new SnakeCellObject<Double>(snake.cell_color, snake.init_pos,
                                snake.cell_size));
                        break;
                    }
                }
                if (obj instanceof SnakeCellObject) {
                    // dying procedure
                    if (new_head_bounds.contains(obj.getPosition()) && !snake.body.contains(obj)) {
                        snake.dies();
                        break;
                    }
                }
            }

            // DO HEAD MOVE

            snake.body.get(0).setPosition(new_pos);

            // MOVE THE REST OF THE BODY

            for (int i = 1; i < snake.body.size(); i++) {
                Vector2<Double> new_dir = new Vector2<Double>(new_pos.x -
                        snake.body.get(i).getPosition().x,
                        new_pos.y - snake.body.get(i).getPosition().y);
                new_dir.normalize();
                new_dir = new_dir.flipped();
                new_pos = (old_pos.plus(new_dir.multiply(5.0)));
                old_pos = snake.body.get(i).getPosition().duplicate();
                snake.body.get(i).setPosition(new_pos);
            }
        } else {

        }
    }
}
