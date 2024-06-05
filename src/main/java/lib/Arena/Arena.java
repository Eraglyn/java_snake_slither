package lib.Arena;

import javafx.scene.Scene;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import lib.ArenaDeps.ArenaUpdateDeps.ArenaUpdateDeps;
import lib.ArenaDeps.BotDeps.SimpleBotStrategy;
import lib.ArenaDeps.InputDeps.InputDeps;
import lib.ArenaDeps.ObjectUpdateDeps.SnakeUpdateDeps;
import lib.GameObject.FoodGenerator;
import lib.GameObject.FoodObject;
import lib.GameObject.GameObject;
import lib.GameObject.RenderedObject;
import lib.GameObject.SnakeCellObject;
import lib.GameObject.SnakeHeadObject;
import lib.Maths.Rect2;
import lib.Maths.Vector2;
import java.util.ArrayList;

/**
 * {@link Arena}, this class is used to represent the scene where the game takes
 * place
 */
public class Arena<T extends Number> {
    // STRUCT
    protected final ArrayList<RenderedObject<T>> childList = new ArrayList<>(); // list of game objects in the scene
    protected final Pane canvas; // the canvas of the scene
    protected final Scene scene; //
    protected Rect2<T> bounds;

    // DEPENDENCIES
    protected ArenaUpdateDeps<T> updateDeps;
    protected FoodGenerator<T> food_gen;

    // GAME DATA
    protected T width, height;
    protected T food_radius;
    protected T unit_size;
    protected T snake_cell_size;

    /**
     * {@link #Arena(Pane, Rect2, Number, Number, Number, Number, Vector2, Vector2, Vector2, ArenaUpdateDeps, InputDeps, SnakeUpdateDeps, FoodGenerator, int)},
     * constructs a new {@link Arena} with the parameters
     * 
     * @param canvas              a {@link Pane}, where to draw the game
     * @param dimensions          a {@link Rect2}, the dimensions of the map
     * @param unit_size           a {@link Number}, the size of one unit in the map
     * @param snake_spd           a {@link Number}, the initial speed for the snakes
     * @param snake_cell_size     a {@link Number}, the initial radius for
     *                            {@link SnakeCellObject}
     * @param food_radius         a {@link Number}, the initial radius for
     *                            {@link FoodObject}
     * @param init_snake_pos1     a {@link Vector2}, the initial position for snake1
     * @param init_snake_pos2     a {@link Vector2}, the initial position for snake2
     * @param init_snake_dir      a {@link Vector2}, the initial direction for both
     *                            snake1 and snake2
     * @param arenaUpdateFunction a {@link ArenaUpdateDeps}, the update
     *                            dependency for the arena
     * @param inputDeps           a {@link InputDeps}, the input dependency for the
     *                            snakes
     * @param snakeUpdateDepsa    a {@link SnakeUpdateDeps}, the update function
     *                            dependencie for the snakes
     * @param food_gen            a {@link FoodGenerator}, the generator of food
     * @param n_food              a {@link Number}, the number of food to have in
     *                            the game
     */
    protected Arena(Pane canvas, Rect2<T> dimensions, T unit_size, T snake_spd, T snake_cell_size, T food_radius,
            Vector2<T> init_snake_pos1, Vector2<T> init_snake_pos2, Vector2<T> init_snake_dir,
            ArenaUpdateDeps<T> arenaUpdateFunction, InputDeps<T> inputDeps, SnakeUpdateDeps<T> snakeUpdateDeps,
            FoodGenerator<T> food_gen, int n_food) {

        // arena setup
        this.canvas = canvas;
        this.scene = new Scene(this.canvas);
        remapInputEvent();
        setBounds(dimensions);
        this.width = dimensions.size.x;
        this.height = dimensions.size.y;
        getCanvas().setMinSize(this.width.doubleValue(), this.height.doubleValue());

        // other setup
        this.unit_size = unit_size;
        this.snake_cell_size = snake_cell_size;
        this.food_radius = food_radius;
        this.updateDeps = arenaUpdateFunction;
        this.food_gen = food_gen;
        this.food_gen.game_arena = this;

        // player controls
        KeyCode[] player1_controls = new KeyCode[5];
        player1_controls[0] = KeyCode.Z;
        player1_controls[1] = KeyCode.D;
        player1_controls[2] = KeyCode.S;
        player1_controls[3] = KeyCode.Q;
        player1_controls[4] = KeyCode.SPACE;

        KeyCode[] player2_controls = new KeyCode[5];
        player2_controls[0] = KeyCode.O;
        player2_controls[1] = KeyCode.M;
        player2_controls[2] = KeyCode.L;
        player2_controls[3] = KeyCode.K;
        player2_controls[4] = KeyCode.N;

        // object creation
        // THIS IS A BOT
        SnakeHeadObject<T> snake = new SnakeHeadObject<T>(init_snake_pos1,
                init_snake_dir.duplicate(), snake_spd, snake_cell_size,
                snakeUpdateDeps,
                inputDeps, null, Color.BLUE, player1_controls);
        addChild(snake);

        // THIS IS A PLAYER
        SnakeHeadObject<T> snake2 = new SnakeHeadObject<T>(init_snake_pos2,
                init_snake_dir.duplicate(), snake_spd, snake_cell_size,
                snakeUpdateDeps,
                inputDeps, null, Color.GREEN, player2_controls);
        addChild(snake2);

        // generating food
        for (int i = 0; i < n_food; i++) {
            generate_food();
        }
    }

    // GETTERS

    /**
     * {@link #getHeight()}, return the height field
     * 
     * @return the height of the arena
     */
    public T getHeight() {
        return height;
    }

    /**
     * {@link #getWidth()}, return the width field
     * 
     * @return the width of the arena
     */
    public T getWidth() {
        return width;
    }

    /**
     * {@link #getFoodRadius()}, return the food_radius field
     * 
     * @return the food_radius of the arena
     */
    public T getFoodRadius() {
        return food_radius;
    }

    /**
     * {@link #getSnakeCellSize()}, return the snake_cell_size field
     * 
     * @return the snake_cell_size of the arena
     */
    public T getSnakeCellSize() {
        return snake_cell_size;
    }

    /**
     * {@link #getChildList()}, return the childList field
     * 
     * @return the childList of the arena
     */
    public ArrayList<RenderedObject<T>> getChildList() {
        return childList;
    }

    /**
     * {@link #getBounds()}, return the bounds field
     * 
     * @return the bounds of the arena
     */
    public Rect2<T> getBounds() {
        return bounds;
    }

    /**
     * {@link #getCanvas()}, return the canvas field
     * 
     * @return the canvas of the arena
     */
    public Pane getCanvas() {
        return canvas;
    }

    /**
     * {@link #getScene()}, return the scene field
     * 
     * @return the scene of the arena
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * {@link #getUnitSize()}, return the unit_size field
     * 
     * @return the unit_size of the arena
     */
    public T getUnitSize() {
        return unit_size;
    }

    // SETTERS

    /**
     * {@link #setBounds(Rect2)}, set the bounds field to the parameter duplicate
     * 
     * @param b a {@link Vector2}, new bounds
     */
    public void setBounds(Rect2<T> b) {
        bounds = b.duplicate();
    }

    // METHODS

    /**
     * {@link #generate_food()}, add one {@link FoodObject} to the calling object
     */
    public void generate_food() {
        food_gen.create();
    }

    /**
     * {@link #addChild(RenderedObject)}, add a new {@link RenderedObject} to the
     * calling object
     * 
     * @param child a {@link RenderedObject}, a new RenderedObject
     */
    public void addChild(RenderedObject<T> child) {
        childList.add(child);
        child.setArena(this);
        child.onEnterScene(this);
    }

    /**
     * {@link #removeChild(RenderedObject)}, remove parameter from the calling
     * object
     * 
     * @param child a {@link RenderedObject}, a new RenderedObject
     */
    public void removeChild(GameObject<T> child) {
        childList.remove(child);
        child.setArena(null);
        child.onExitScene(this);
    }

    /**
     * {@link #onInput(InputEvent)}, call for each object in the childList field
     * their onInput method
     * 
     * @param ev an {@link InputEvent}, the event recieved from a player
     */
    protected void onInput(InputEvent ev) {

        for (int i = childList.size() - 1; i >= 0; i--) {
            RenderedObject<T> obj = childList.get(i);
            obj.onInput(ev);
        }
    }

    /**
     * {@link #onUpdateDraw(double)}, call the updateDraw method of the
     * {@link ArenaUpdateDeps} dependency
     * 
     * @param deltaT {@link Double}, the time elapsed between the last call
     *               of update to compensate framerate irregularity
     */
    public void onUpdateDraw(double deltaT) {
        updateDeps.updateDraw(deltaT, this);
    }

    /**
     * {@link #onUpdateDraw(double)}, call the updatePhysics method of the
     * {@link ArenaUpdateDeps} dependency
     * 
     * @param deltaT {@link Double}, the time elapsed between the last call
     *               of update to compensate framerate irregularity
     */
    public void onUpdatePhysics(double deltaT) {
        updateDeps.updatePhysics(deltaT, this);
    }

    /**
     * {@link #remapInputEvent()}, make the scene field listen to some inputs
     */
    public void remapInputEvent() {
        this.scene.setOnMousePressed(ev -> {
            this.onInput(ev);
        });
        this.scene.setOnMouseMoved(ev -> {
            this.onInput(ev);
        });
        this.scene.setOnKeyPressed(ev -> {
            this.onInput(ev);
        });
        this.scene.setOnKeyReleased(ev -> {
            this.onInput(ev);
        });
        this.scene.setOnKeyTyped(ev -> {
            this.onInput(ev);
        });
    }
}
