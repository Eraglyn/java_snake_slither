package lib.ArenaDeps.BotDeps;

import lib.GameObject.SnakeHeadObject;

/**
 * {@link SnakeBotDeps}, this interface is used to define the strategy of the
 * bot
 */
public interface SnakeBotDeps<T extends Number> {
    /**
     * {@link #botStrategy(SnakeHeadObject)}, an overridable method that defines the
     * strategy of the bot
     * 
     * @param snake {@link SnakeHeadObject}, the snake affected by the strategy
     */
    public void botStrategy(SnakeHeadObject<T> snake);
}
