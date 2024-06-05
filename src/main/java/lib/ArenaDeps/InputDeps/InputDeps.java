package lib.ArenaDeps.InputDeps;

import javafx.scene.input.InputEvent;
import lib.GameObject.SnakeHeadObject;

/**
 * {@link InputDeps}, this interface is used to define the behavior of
 * {@link SnakeHeadObject} when recieving inputs
 */
public interface InputDeps<T extends Number> {

    /**
     * {@link #update(InputEvent, SnakeHeadObject)}, an overridable method that
     * defines the behavior of the snake on each inputs recieved from the arena
     * 
     * @param detlaT {@link InputEvent}
     * @param snake  {@link SnakeHeadObject}, the snake affected by the update
     */
    public void update(InputEvent ev, SnakeHeadObject<T> snake);
}
