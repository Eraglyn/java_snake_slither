package lib.ArenaDeps.InputDeps;

import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import lib.GameObject.SnakeHeadObject;

public class KeyInputDouble implements InputDeps<Double> {

    @Override
    public void update(InputEvent ev, SnakeHeadObject<Double> snake) {
        if (ev instanceof MouseEvent) {
        } else {
            KeyCode code = ((KeyEvent) ev).getCode();
            if (code == KeyCode.UP) {
                snake.cursor_pos.y += -20.0;
            }
            if (code == KeyCode.LEFT) {
                snake.cursor_pos.x += -20.0;
            }
            if (code == KeyCode.DOWN) {
                snake.cursor_pos.y += 20.0;
            }
            if (code == KeyCode.RIGHT) {
                snake.cursor_pos.x += 20.0;
            }
            if (code == KeyCode.SPACE) {
                snake.speed = 5.0;
            }
        }
    }
}
