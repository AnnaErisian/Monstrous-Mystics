package blue.thejester.monstrousmystics.entity;

import blue.thejester.monstrousmystics.entity.ai.IHasSpellCooldowns;
import com.google.common.collect.Lists;
import electroblob.wizardry.entity.living.ISpellCaster;
import electroblob.wizardry.registry.Spells;
import electroblob.wizardry.spell.Spell;
import electroblob.wizardry.util.SpellModifiers;
import electroblob.wizardry.util.WizardryUtilities;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.List;

public abstract class EntityJesterMob extends EntityMob implements IAnimatedEntity, IHasSpellCooldowns, ISpellCaster {

    private int animationTick = 0;
    private Animation animation = NO_ANIMATION;
    private Spell currentContinuousSpell;
    private int spellCounter;

    public EntityJesterMob(World worldIn) {
        super(worldIn);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (getAnimation() != NO_ANIMATION) {
            animationTick++;
            if (world.isRemote && animationTick >= animation.getDuration()) {
//                setAnimation(NO_ANIMATION);
            }
        }
    }

    @Override
    public int getAnimationTick() {
        return this.animationTick;
    }

    @Override
    public void setAnimationTick(int tick) {
        this.animationTick = tick;
    }

    @Override
    public Animation getAnimation() {
        return this.animation;
    }

    @Override
    public void setAnimation(Animation animation) {
        this.animation = animation;
        setAnimationTick(0);
    }

    public static class WeightedSpell {
        public final int weight;
        public final Spell spell;

        public WeightedSpell(int weight, Spell spell) {
            this.weight = weight;
            this.spell = spell;
        }
    }

    public static WeightedSpell sp(int weight, Spell spell) {
        return new WeightedSpell(weight, spell);
    }

    @Override
    public int beginCooldown(int i) {
        //NO OP
        return 0;
    }

    @Override
    public int getCooldown(int i) {
        //NO OP
        return 0;
    }

    @Nonnull
    @Override
    public List<Spell> getSpells() {
        return Lists.newArrayList();
    }

    @Nonnull
    @Override
    public SpellModifiers getModifiers() {
        return new SpellModifiers();
    }

    @Nonnull
    public Spell getContinuousSpell() {
        return currentContinuousSpell;
    }

    @Override
    public void setContinuousSpell(Spell spell) {
        currentContinuousSpell = spell;
    }

    @Override
    public int getSpellCounter() {
        return spellCounter;
    }

    @Override
    public void setSpellCounter(int count) {
        spellCounter = count;
    }

    @Override
    public int getAimingError(EnumDifficulty difficulty) {
        return WizardryUtilities.getDefaultAimingError(difficulty);
    }
}
