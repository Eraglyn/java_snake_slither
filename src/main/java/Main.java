import javafx.application.Application;
import javafx.stage.Stage;
import lib.Engine;
import lib.Arena.ArenaBuilder;
import lib.Arena.ArenaBuilder.Preset;

/**
 * Main, the main class of the project.
 * 
 * It extends the {@link Application} class, it is responsible for the frame of
 * the game (called stage here).
 */

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setResizable(false);
        primaryStage.setTitle("Snake");
        // by default the preset of the game is slitherio
        ArenaBuilder builder = new ArenaBuilder();
        // builder.setGamePreset(Preset.SNAKE);
        Engine engine = Engine.initialize(primaryStage, builder.build());
        engine.start(); // show the main stage and start the game loop
    }

    public static void main(String[] args) {
        launch();
    }
}
