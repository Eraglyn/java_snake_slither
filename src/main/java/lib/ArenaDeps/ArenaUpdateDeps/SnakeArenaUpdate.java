package lib.ArenaDeps.ArenaUpdateDeps;

import lib.Arena.Arena;
import lib.GameObject.RenderedObject;

public class SnakeArenaUpdate implements ArenaUpdateDeps<Integer> {
    private int count;

    @Override
    public void updateDraw(double deltaT, Arena<Integer> arena) {
        count++;
        if (count == 20) {
            for (int i = arena.getChildList().size() - 1; i >= 0; i--) {

                RenderedObject<Integer> obj = arena.getChildList().get(i);

                obj.onUpdate(deltaT);
            }
            count = 0;
        }
    }

    @Override
    public void updatePhysics(double deltaT, Arena<Integer> arena) {
        count++;
        if (count == 20) {
            for (int i = arena.getChildList().size() - 1; i >= 0; i--) {

                RenderedObject<Integer> obj = arena.getChildList().get(i);

                obj.onUpdate(deltaT);
            }
            count = 0;
        }
    }
}
