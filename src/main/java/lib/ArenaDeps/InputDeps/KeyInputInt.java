package lib.ArenaDeps.InputDeps;

import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import lib.GameObject.SnakeHeadObject;

public class KeyInputInt<T extends Number> implements InputDeps<T> {

    @SuppressWarnings("unchecked")
    @Override
    public void update(InputEvent ev, SnakeHeadObject<T> snake) {
        if (ev instanceof MouseEvent) {
        } else {
            KeyCode code = ((KeyEvent) ev).getCode();
            if (code == snake.controls[0]) {
                snake.direction.x = (T) (Integer) 0;
                snake.direction.y = (T) (Integer) (-1);
            }
            if (code == snake.controls[3]) {
                snake.direction.x = (T) (Integer) (-1);
                snake.direction.y = (T) (Integer) 0;
            }
            if (code == snake.controls[2]) {
                snake.direction.x = (T) (Integer) 0;
                snake.direction.y = (T) (Integer) (1);
            }
            if (code == snake.controls[1]) {
                snake.direction.x = (T) (Integer) (1);
                snake.direction.y = (T) (Integer) 0;
            }
        }
    }
}
