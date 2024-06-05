package lib;

import javafx.animation.AnimationTimer;
import javafx.stage.Stage;
import lib.Arena.Arena;

/**
 * Engine, it is the class of the game engine.
 * It is responsible of the update of the game, by default the framerate is
 * 60fps, but it changeable with the field FRAMERATE
 * There can only be one instance of Engine at a given time, thanks to the
 * Singleton design pattern. It is initialized in the
 * {@link Main}
 * class.
 */
public class Engine {
    // class parameters
    private Arena<? extends Number> currentScene; // the current game scene
    private final Stage gameStage; // the stage of the game
    private static Engine singleton = null; // singleton instance of the engine

    /**
     * the framerate of the game, divide by numbers of frame you want per seconds,
     * but javafx tries to cap at 60fps by default so above might not work on every
     * device, this time is in nanoseconds.
     */
    private static long FRAMERATE = 1_000_000_000 / 40; // here 40 update per seconds.

    public Arena<? extends Number> getCurrentScene() {
        return currentScene;
    }

    /**
     * Initialize the engine by the given stage and canvas size. If the engine is
     * already initialized, return the singleton instance, otherwise create a new
     * instance
     */
    public static Engine initialize(Stage stage, Arena<? extends Number> scene) {
        if (singleton == null) {
            singleton = new Engine(stage, scene);
        }
        return singleton;
    }

    /** Returns the singleton instance of the engine */
    public static Engine getSingleton() {
        return singleton;
    }

    /**
     * Constructor of the engine by the given stage and canvas size
     */
    private Engine(Stage stage, Arena<? extends Number> mainScene) {
        // set the stage of the game
        gameStage = stage;
        currentScene = mainScene;
        gameStage.setScene(currentScene.getScene());
    }

    /**
     * Start the game loop
     */

    public void start() {
        this.gameStage.show(); // show the stage of the game

        // Create a new AnimationTimer to run the game loop
        AnimationTimer timer = new AnimationTimer() {
            long last = 0; // the time of the last frame

            // Called every frame to update the game
            @Override
            public void handle(long now) {
                if (last == 0) {
                    last = now;
                    return;
                }

                // if the difference between the current frame and the last updated frame is
                // higher than FRAMERATE, then update the physics
                if (now - last >= FRAMERATE) {
                    currentScene.onUpdatePhysics(1);
                    last = now;
                }

                // update the visuals whenever it is possible
                currentScene.onUpdateDraw(1);
            }
        };
        timer.start(); // start the game loop
    }

}
