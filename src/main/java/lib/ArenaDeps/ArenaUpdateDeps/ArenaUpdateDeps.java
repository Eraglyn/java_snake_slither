package lib.ArenaDeps.ArenaUpdateDeps;

import lib.Arena.Arena;

/**
 * {@link ArenaUpdateDeps}, this interface is used to define the behavior of
 * {@link Arena} when recieving specific update request
 */
public interface ArenaUpdateDeps<T extends Number> {
    /**
     * {@link #updateDraw(double, Arena)}, an overridable method that defines the
     * visual updates
     * 
     * @param detlaT {@link Double}, the time elapsed between the last call
     *               of update to compensate framerate irregularity
     * @param arena  {@link Arena}, the arena where the update takes place
     */
    public void updateDraw(double deltaT, Arena<T> arena);

    /**
     * {@link #updateDraw(double, Arena)}, an overridable method that defines the
     * physical updates
     * 
     * @param detlaT {@link Double}, the time elapsed between the last call
     *               of update to compensate framerate irregularity
     * @param arena  {@link Arena}, the arena where the update takes place
     */
    public void updatePhysics(double deltaT, Arena<T> arena);
}
