package lib.GameObject;

import javafx.scene.input.InputEvent;
import lib.Arena.Arena;

/**
 * {@link GameObject}, this class is used to represent an object in the game, it
 * is the Parent of all game objects.
 */
public abstract class GameObject<T extends Number> {
    public Arena<T> game_arena; // the arena where the object is

    /**
     * {@link #setArena(Arena)}, set the game_arena field to the specified parameter
     * 
     * @param arena
     */
    public void setArena(Arena<T> arena) {
        game_arena = arena;
    }

    /**
     * {@link #getArena()}, return the game_arena field
     * 
     * @return an {@link Arena}, the arena of the calling object
     */
    public Arena<T> getArena() {
        return game_arena;
    }

    /**
     * {@link #onUpdate(double)}, an overridable method to update the calling object
     * 
     * @param deltaT a double, the time elapsed between the last call of update to
     *               compensate framerate irregularity
     */
    public void onUpdate(double deltaT) {
    }

    /**
     * {@link #onInput(InputEvent)}, an overridable method to react to
     * {@link InputEvent} from the {@link Arena}
     * 
     * @param ev an {@link InputEvent}, recieved from the arena
     */
    public void onInput(InputEvent ev) {
    }

    /**
     * {@link #onEnterScene(Arena)}, an overridable method called when an object is
     * added to an {@link Arena}
     * 
     * @param scene
     */
    public void onEnterScene(Arena<T> scene) {
    }

    /**
     * {@link #onEnterScene(Arena)}, an overridable method called when an object is
     * removed from an {@link Arena}
     * 
     * @param scene
     */
    public void onExitScene(Arena<T> scene) {
    }
}
