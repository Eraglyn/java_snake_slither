package lib.GameObject;

import java.util.ArrayList;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import lib.Arena.Arena;
import lib.ArenaDeps.BotDeps.SnakeBotDeps;
import lib.ArenaDeps.InputDeps.InputDeps;
import lib.ArenaDeps.InputDeps.MouseInput;
import lib.ArenaDeps.ObjectUpdateDeps.SnakeUpdateDeps;
import lib.Maths.Operations;
import lib.Maths.Rect2;
import lib.Maths.Vector2;

/**
 * {@link SnakeHeadObject}, this class is used to represent the snake in the
 * game, this object is not the snake itself but it contains all the logic to
 * make it playable
 */
public class SnakeHeadObject<T extends Number> extends RenderedObject<T> {

    public KeyCode[] controls;
    public ArrayList<SnakeCellObject<T>> body; // all the cells
    public Vector2<T> init_pos; // the initial position
    public Vector2<T> cursor_pos; // the position of the cursor
    public Vector2<T> direction; // the direction of the snake
    public InputDeps<T> inputFunction; // the reaction to inputs
    public SnakeUpdateDeps<T> updateFunction; // the reaction to updates
    public T init_speed; // initial speed of the snake
    public T speed; // the speed of the snake
    public T cell_size; // the radius of a cell
    public Color cell_color; // the color of the cell
    public boolean dead; // the living state of the snake
    public boolean bot; // the player behaviour
    public SnakeBotDeps<T> strategy; // the strategy of the bot (if bot = true)

    /**
     * {@link #SnakeHeadObject(Vector2, Vector2, Number, Number, SnakeUpdateDeps, InputDeps, SnakeBotDeps, Color)},
     * construct a new {@link }
     * 
     * @param init_p    a {@link Vector2}, the initial position of the calling
     *                  object
     * @param init_dira a {@link Vector2}, the initial direction of the calling
     *                  object
     * @param init_sp   a {@link Number}, the initial speed of the calling object
     * @param c_size    a {@link Number}, the radius a the cells
     * @param upd       a {@link SnakeUpdateDeps}, the udpate reaction fonction
     * @param inp       a {@link InputDeps}, the input reaction fonction
     * @param strat     a {@link SnakeBotDeps}, the strategy of the bot, if null
     *                  then it's not a bot
     * @param c         a {@link Color}, the color of the cells
     */
    public SnakeHeadObject(Vector2<T> init_p, Vector2<T> init_dir, T init_sp, T c_size, SnakeUpdateDeps<T> upd,
            InputDeps<T> inp, SnakeBotDeps<T> strat, Color c, KeyCode[] cont) {
        super();
        controls = cont;
        body = new ArrayList<>();
        init_pos = init_p;
        direction = init_dir;
        speed = init_sp;
        init_speed = init_sp;
        cell_size = c_size;
        dead = false;
        updateFunction = upd;
        inputFunction = inp;
        if (inputFunction instanceof MouseInput) {
            cursor_pos = init_pos.duplicate();
        }
        if (strat == null) {
            bot = false;
        } else {
            bot = true;
            strategy = strat;
        }
        cell_color = c;
    }

    public Rect2<T> getBounds() {
        return new Rect2<T>(new Vector2<T>(getPosition().x, getPosition().y),
                new Vector2<T>(Operations.add(getPosition().x, cell_size), Operations.add(getPosition().y, cell_size)));
    }

    @Override
    public void onEnterScene(Arena<T> scene) {
        for (int i = 0; i < 3; i++) {
            addToBody(new SnakeCellObject<T>(cell_color, init_pos, cell_size));
        }
    }

    @Override
    public void onInput(InputEvent event) {
        if (!bot)
            inputFunction.update(event, this);
    }

    @Override
    public void onUpdate(double deltaT) {
        super.onUpdate(deltaT);
        if (bot) {
            strategy.botStrategy(this);
        }
        updateFunction.update(deltaT, this);
    }

    /**
     * {@link #addToBody(SnakeCellObject)}, add the parameter to the body of the
     * calling object
     * 
     * @param cell a {@link SnakeCellObject}, the cell to add
     */
    public void addToBody(SnakeCellObject<T> cell) {
        body.add(cell);
        game_arena.addChild(cell);
    }

    /**
     * {@link #dies()}, the dying procedure of the calling object, it removes all
     * the {@link SnakeCellObject} of the body and replace them with
     * {@link FoodObject} at the same positions
     * 
     */
    public void dies() {
        dead = true;
        for (RenderedObject<T> obj : body) {
            game_arena.addChild(
                    new FoodObject<T>(game_arena.getFoodRadius(),
                            new Vector2<T>(obj.getPosition().x, obj.getPosition().y),
                            Color.RED));
            game_arena.removeChild(obj);
        }
    }
}
