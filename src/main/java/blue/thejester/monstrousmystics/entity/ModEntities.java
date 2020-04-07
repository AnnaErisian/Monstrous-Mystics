package blue.thejester.monstrousmystics.entity;

import blue.thejester.monstrousmystics.entity.tier1.EntitySpirit;

public class ModEntities {
    public static void registerEntities() {
        int id = 1;
        EntitySpirit.registerSelf(id++);
    }

    public static void registerRenderers() {
        EntitySpirit.registerOwnRenderer();
    }
}
