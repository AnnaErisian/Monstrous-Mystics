package blue.thejester.monstrousmystics.entity.ai;

import blue.thejester.monstrousmystics.entity.EntityJesterMob;
import electroblob.wizardry.spell.Spell;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.minecraft.potion.Potion;

public class AnimatedSpellAIFactory {
    public static EntityAiSpellBase base(EntityJesterMob creature, float minDistance, float maxDistance, Animation animation, int firingFrame, int cooldownIndex, boolean targeted, boolean repeating, Potion potion, EntityJesterMob.WeightedSpell... spells) {
        return new EntityAiSpellBase(creature, minDistance, maxDistance, animation, firingFrame, cooldownIndex, targeted, repeating, potion, spells);
    }

    public static EntityAiSpellBase farRepeatingAttackSpell(EntityJesterMob creature, float minDistance, Animation animation, int firingFrame, Spell spell) {
        return base(creature, minDistance, Integer.MAX_VALUE, animation, firingFrame, -1, true, true, null, EntityJesterMob.sp(1, spell));
    }

    public static EntityAiSpellBase cooldownSpell(EntityJesterMob creature, float minDistance, float maxDistance, int cooldownIndex, Animation animation, int firingFrame, Spell spell) {
        return base(creature, minDistance, maxDistance, animation, firingFrame, cooldownIndex, true, true, null, EntityJesterMob.sp(1, spell));
    }

    public static EntityAiSpellBase closeRepeatingAttackSpell(EntityJesterMob creature, float maxDistance, Animation animation, int firingFrame, Spell spell) {
        return base(creature, 0, maxDistance, animation, firingFrame, -1, true, true, null, EntityJesterMob.sp(1, spell));
    }

    public static EntityAiSpellBase repeatingAttackSpell(EntityJesterMob creature, Animation animation, int firingFrame, Spell spell) {
        return base(creature, 0, Integer.MAX_VALUE, animation, firingFrame, -1, true, true, null, EntityJesterMob.sp(1, spell));
    }

    public static EntityAiSpellBase repeatingHalfHealthAttackSpell(EntityJesterMob creature, Animation animation, int firingFrame, Spell spell) {
        return new EntityAIBelowHalfSpell(creature, 0, Integer.MAX_VALUE, animation, firingFrame, -1, true, true, null, EntityJesterMob.sp(1, spell));
    }

    public static EntityAiSpellBase statusUpkeepSpell(EntityJesterMob creature, Animation animation, int firingFrame, Potion potion, Spell spell) {
        return base(creature, 0, Integer.MAX_VALUE, animation, firingFrame, -1, false, false, potion, EntityJesterMob.sp(1, spell));
    }
}
