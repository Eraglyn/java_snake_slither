package lib.ArenaDeps.InputDeps;

import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import lib.GameObject.SnakeHeadObject;

public class MouseInput implements InputDeps<Double> {

    @Override
    public void update(InputEvent ev, SnakeHeadObject<Double> snake) {
        if (ev instanceof MouseEvent) {
            MouseEvent evm = (MouseEvent) ev;
            snake.cursor_pos.x = evm.getSceneX();
            snake.cursor_pos.y = evm.getSceneY();
        } else {
            if (((KeyEvent) ev).getCode() == snake.controls[4]
                    && ev.getEventType().getName().equals("KEY_PRESSED")) {
                snake.speed = 10.0;
            } else if (ev.getEventType().getName().equals("KEY_RELEASED")) {
                snake.speed = snake.init_speed;
            }
        }
    }
}
