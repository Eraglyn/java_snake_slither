package lib.Arena;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import lib.ArenaDeps.ArenaUpdateDeps.SlitherArenaUpdate;
import lib.ArenaDeps.ArenaUpdateDeps.SnakeArenaUpdate;
import lib.ArenaDeps.InputDeps.KeyInputInt;
import lib.ArenaDeps.InputDeps.MouseInput;
import lib.ArenaDeps.ObjectUpdateDeps.SimpleSnakeUpdate;
import lib.ArenaDeps.ObjectUpdateDeps.SlitherSnakeUpdate;
import lib.GameObject.FoodGenerator;
import lib.Maths.Rect2;
import lib.Maths.Vector2;

/** {@link ArenaBUilder}, this class is used to create instances of games */
public class ArenaBuilder {
    public enum Preset {
        SNAKE,
        SLITHERIO,
    }

    private Preset gamePreset;

    public ArenaBuilder() {
        gamePreset = Preset.SLITHERIO;
    }

    // SETTERS

    public void setGamePreset(Preset p) {
        gamePreset = p;
    }

    public Arena<? extends Number> build() {
        Arena<? extends Number> arena = null;
        if (gamePreset == Preset.SNAKE) {
            // CREATE SNAKE GAME PRESET
            arena = new Arena<Integer>(new Pane(),
                    new Rect2<Integer>(new Vector2<Integer>(0, 0), new Vector2<Integer>(800, 600)), 50, 50, 25, 25,
                    new Vector2<Integer>(25, 25), new Vector2<Integer>(225, 225), new Vector2<Integer>(1, 0),
                    new SnakeArenaUpdate(), new KeyInputInt<Integer>(),
                    new SimpleSnakeUpdate(), new FoodGenerator<Integer>(null, 25, Color.RED), 1);
            return arena;
        } else if (gamePreset == Preset.SLITHERIO) {
            // CREATE SLITHERIO GAME PRESET
            arena = new Arena<Double>(new Pane(),
                    new Rect2<Double>(new Vector2<Double>(0.0, 0.0), new Vector2<Double>(800.0, 600.0)), 1.0, 4.0, 10.0,
                    10.0,
                    new Vector2<Double>(0.0, 0.0), new Vector2<Double>(200.0, 200.0), new Vector2<Double>(1.0, 1.0),
                    new SlitherArenaUpdate(),
                    new MouseInput(),
                    new SlitherSnakeUpdate(), new FoodGenerator<Double>(null, 8.0, Color.RED), 30);
            return arena;
        } else {
        }
        return arena;
    }
}
