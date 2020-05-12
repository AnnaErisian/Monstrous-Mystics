package blue.thejester.monstrousmystics.entity.tier2;

import blue.thejester.monstrousmystics.MonstrousMystics;
import blue.thejester.monstrousmystics.client.render.RenderIceSpirit;
import blue.thejester.monstrousmystics.client.render.RenderWindScouredSpirit;
import blue.thejester.monstrousmystics.entity.EntityJesterMob;
import blue.thejester.monstrousmystics.entity.ai.AnimatedSpellAIFactory;
import blue.thejester.monstrousmystics.entity.ai.EntityAIStrafe;
import electroblob.wizardry.registry.Spells;
import electroblob.wizardry.registry.WizardryItems;
import electroblob.wizardry.registry.WizardryPotions;
import electroblob.wizardry.util.MagicDamage;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class EntityWindScouredSpirit extends EntityJesterMob {
    private static final ResourceLocation LOOT_TABLE = new ResourceLocation(MonstrousMystics.MODID, "entities/wind_scoured_spirit");
    private static final String NAME = "wind_scoured_spirit";
    private static final int TORNADO_MAX_COOLDOWN = 300;
    private int attackTimer;
    private int tornadoCooldown = 0;

    public static final Animation SHOOT_ANIMATION = Animation.create(11);
    public static final Animation SHOOT_ANIMATION_LONG = Animation.create(22);
    public static final Animation SHOOT_ANIMATION_TORNADO = Animation.create(30);
    public static final Animation DETONATE_ANIMATION = Animation.create(30);
    private static final Animation[] ANIMATIONS = {SHOOT_ANIMATION, SHOOT_ANIMATION_LONG, SHOOT_ANIMATION_TORNADO, DETONATE_ANIMATION};

    public EntityWindScouredSpirit(World worldIn) {
        super(worldIn);
        this.setSize(0.6f, 1.75f);
        this.experienceValue = 6;
    }

    @Override
    public boolean isEntityInvulnerable(DamageSource source) {
        return super.isEntityInvulnerable(source) || source.getTrueSource() == this;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(MonstrousMystics.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, EntityWindScouredSpirit.class, NAME, id,
                MonstrousMystics.instance, 64, 3, true,
                0xbfbcac, 0xc1bda8);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(EntityWindScouredSpirit.class, RenderWindScouredSpirit.FACTORY);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, AnimatedSpellAIFactory.cooldownSpell(this, 3, 15, 0, SHOOT_ANIMATION_TORNADO, 10, Spells.tornado));
        this.tasks.addTask(2, AnimatedSpellAIFactory.farRepeatingAttackSpell(this, 5, SHOOT_ANIMATION_LONG, 10, Spells.dart)); //if we're distant shoot at them
        this.tasks.addTask(3, AnimatedSpellAIFactory.closeRepeatingAttackSpell(this, 2, DETONATE_ANIMATION, 7, Spells.detonate)); //if we're close enough explode them
        this.tasks.addTask(4, AnimatedSpellAIFactory.closeRepeatingAttackSpell(this, 5, SHOOT_ANIMATION, 10, Spells.dart));
        this.tasks.addTask(4, new EntityAIStrafe(this, 1.0D,15.0F));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<EntityPlayer>(this, EntityPlayer.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityVillager.class, false));
    }

    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData priordata) {
        IEntityLivingData livingdata = super.onInitialSpawn(difficulty, priordata);
        setEquipmentBasedOnDifficulty(difficulty);
        return livingdata;
    }

    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
        //do not call super - mm creatures should not be armored
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if(this.attackTimer > 0) {
            this.attackTimer--;
        }
        if(this.tornadoCooldown > 0) {
            this.tornadoCooldown--;
        }
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(26.0);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.276D);

    }

    @Override
    protected ResourceLocation getLootTable() {
        return LOOT_TABLE;
    }

    @Override
    public float getEyeHeight() {
        return 1.54f;
    }

    public int beginCooldown(int i) {
        if(i == 0) {
            tornadoCooldown = TORNADO_MAX_COOLDOWN;
            return tornadoCooldown;
        } else {
            return 0;
        }
    }

    public int getCooldown(int i) {
        if(i == 0) {
            return tornadoCooldown;
        } else {
            return 0;
        }
    }

    @Override
    public Animation[] getAnimations() {
        return ANIMATIONS;
    }
}
