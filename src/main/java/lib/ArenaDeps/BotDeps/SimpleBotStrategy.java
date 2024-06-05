package lib.ArenaDeps.BotDeps;

import java.util.ArrayList;

import lib.GameObject.FoodObject;
import lib.GameObject.RenderedObject;
import lib.GameObject.SnakeHeadObject;
import lib.Maths.Vector2;

public class SimpleBotStrategy<T extends Number> implements SnakeBotDeps<T> {

    @Override
    public void botStrategy(SnakeHeadObject<T> snake) {
        if (!snake.getArena().getChildList().isEmpty()) {
            Vector2<T> snake_pos = snake.body.get(0).getPosition();
            ArrayList<RenderedObject<T>> list = snake.getArena().getChildList();
            RenderedObject<T> closest = null;
            for (RenderedObject<T> object : list) {
                if (object instanceof FoodObject) {
                    if (closest == null) {
                        closest = object;
                    } else if (snake_pos.distanceTo(object.getPosition()) < snake_pos
                            .distanceTo(closest.getPosition())) {
                        closest = object;
                    }
                }
            }
            snake.cursor_pos = closest.getPosition();
        }
    }
}
