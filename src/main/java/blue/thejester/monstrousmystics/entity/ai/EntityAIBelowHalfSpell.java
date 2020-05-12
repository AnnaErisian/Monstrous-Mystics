package blue.thejester.monstrousmystics.entity.ai;

import blue.thejester.monstrousmystics.entity.EntityJesterMob;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.minecraft.potion.Potion;

public class EntityAIBelowHalfSpell extends EntityAiSpellBase {
    public EntityAIBelowHalfSpell(EntityJesterMob creature, float minDistance, float maxDistance, Animation animation, int firingFrame, int cooldownIndex, boolean targeted, boolean repeating, Potion potion, EntityJesterMob.WeightedSpell... spells) {
        super(creature, minDistance, maxDistance, animation, firingFrame, cooldownIndex, targeted, repeating, potion, spells);
    }

    @Override
    public boolean shouldAnimate() {
        return super.shouldAnimate() && ((attacker.getHealth() * 2) <= attacker.getMaxHealth());
    }
}
