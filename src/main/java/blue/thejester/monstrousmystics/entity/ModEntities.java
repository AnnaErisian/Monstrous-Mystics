package blue.thejester.monstrousmystics.entity;

import blue.thejester.monstrousmystics.entity.tier1.EntitySpirit;
import blue.thejester.monstrousmystics.entity.tier2.*;

public class ModEntities {
    public static void registerEntities() {
        int id = 1;
        EntitySpirit.registerSelf(id++);
        EntityImp.registerSelf(id++);
        EntityIceSpirit.registerSelf(id++);
        EntityWindScouredSpirit.registerSelf(id++);
        EntitySparkSkeleton.registerSelf(id++);
        EntityDevil.registerSelf(id++);
        EntityBlackBlaze.registerSelf(id++);
        EntityFrostSpirit.registerSelf(id++);
        EntityRoaringSpirit.registerSelf(id++);
        EntityEndergeist.registerSelf(id++);
    }

    public static void registerRenderers() {
        EntitySpirit.registerOwnRenderer();
        EntityImp.registerOwnRenderer();
        EntityIceSpirit.registerOwnRenderer();
        EntityWindScouredSpirit.registerOwnRenderer();
        EntitySparkSkeleton.registerOwnRenderer();
        EntityDevil.registerOwnRenderer();
        EntityBlackBlaze.registerOwnRenderer();
        EntityFrostSpirit.registerOwnRenderer();
        EntityRoaringSpirit.registerOwnRenderer();
        EntityEndergeist
                .registerOwnRenderer();
    }
}
