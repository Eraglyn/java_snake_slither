package lib.ArenaDeps.ArenaUpdateDeps;

import lib.Arena.Arena;
import lib.GameObject.RenderedObject;

public class SlitherArenaUpdate implements ArenaUpdateDeps<Double> {

    // called 60 times per second with AnimationLoop
    @Override
    public void updateDraw(double deltaT, Arena<Double> arena) {
        for (int i = arena.getChildList().size() - 1; i >= 0; i--) {

            RenderedObject<Double> obj = arena.getChildList().get(i);
            obj.updateDrawShape();
        }
    }

    @Override
    public void updatePhysics(double deltaT, Arena<Double> arena) {
        for (int i = arena.getChildList().size() - 1; i >= 0; i--) {

            RenderedObject<Double> obj = arena.getChildList().get(i);
            obj.onUpdate(deltaT);
        }
    }
}
