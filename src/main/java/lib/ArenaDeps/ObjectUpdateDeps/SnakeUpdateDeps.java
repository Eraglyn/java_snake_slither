package lib.ArenaDeps.ObjectUpdateDeps;

import lib.GameObject.SnakeHeadObject;

/**
 * {@link SnakeUpdateDeps}, this interface is used to define the behavior of
 * {@link SnakeHeadObject} when recieving a request of update
 */
public interface SnakeUpdateDeps<T extends Number> {

    /**
     * {@link #update(double, SnakeHeadObject)}, an overridable method that defines
     * the behavior of the snake on each update of the physics
     * 
     * @param detlaT {@link Double}, the time elapsed between the last call
     *               of update to compensate framerate irregularity
     * @param snake  {@link SnakeHeadObject}, the snake affected by the update
     */
    public void update(double detlaT, SnakeHeadObject<T> snake);
}
