package blue.thejester.monstrousmystics.entity.tier2;

import blue.thejester.monstrousmystics.MonstrousMystics;
import blue.thejester.monstrousmystics.client.render.RenderFrostSpirit;
import blue.thejester.monstrousmystics.entity.EntityJesterMob;
import blue.thejester.monstrousmystics.entity.ai.AnimatedSpellAIFactory;
import blue.thejester.monstrousmystics.entity.ai.EntityAIStrafe;
import electroblob.wizardry.registry.Spells;
import electroblob.wizardry.registry.WizardryItems;
import electroblob.wizardry.registry.WizardryPotions;
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
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class EntityFrostSpirit extends EntityJesterMob {
    private static final ResourceLocation LOOT_TABLE = new ResourceLocation(MonstrousMystics.MODID, "entities/frost_spirit");
    private static final String NAME = "frost_spirit";
    private int attackTimer;
    private static final int HAILSTORM_MAX_COOLDOWN = 250;
    private int hailstormCooldown = 0;

    public static final Animation SHOOT_ANIMATION = Animation.create(11);
    public static final Animation SHOOT_ANIMATION_LONG = Animation.create(22);
    public static final Animation SHOOT_ANIMATION_HAILSTORM = Animation.create(22);
    private static final Animation[] ANIMATIONS = {SHOOT_ANIMATION, SHOOT_ANIMATION_LONG, SHOOT_ANIMATION_HAILSTORM};

    public EntityFrostSpirit(World worldIn) {
        super(worldIn);
        this.setSize(0.6f, 1.75f);
        this.experienceValue = 6;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(MonstrousMystics.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, EntityFrostSpirit.class, NAME, id,
                MonstrousMystics.instance, 64, 3, true,
                0x6fc6ce, 0x00ffe9);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(EntityFrostSpirit.class, RenderFrostSpirit.FACTORY);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, AnimatedSpellAIFactory.cooldownSpell(this, 3, 20, 0, SHOOT_ANIMATION_HAILSTORM, 10, Spells.hailstorm));
        this.tasks.addTask(1, AnimatedSpellAIFactory.statusUpkeepSpell(this, SHOOT_ANIMATION_LONG, 10, WizardryPotions.ice_shroud, Spells.ice_shroud)); //TODO real animation
        this.tasks.addTask(1, AnimatedSpellAIFactory.farRepeatingAttackSpell(this, 5, SHOOT_ANIMATION_LONG, 10, Spells.ice_shard)); //if we're distant shoot at them
        this.tasks.addTask(3, new EntityAIAttackMelee(this, 1.0D, false));
        this.tasks.addTask(4, AnimatedSpellAIFactory.repeatingAttackSpell(this, SHOOT_ANIMATION, 10, Spells.ice_shard)); //if we're close and can't reach also shoot, but faster
        this.tasks.addTask(4, new EntityAIStrafe(this, 1.0D,15.0F));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
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
        //But they always come with a frost axe
        ItemStack sword = new ItemStack(WizardryItems.frost_axe);
        sword.setItemDamage(20);
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, sword);
//        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_AXE));
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if(this.attackTimer > 0) {
            this.attackTimer--;
        }
        if(this.hailstormCooldown > 0) {
            this.hailstormCooldown--;
        }
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(24.0);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23D);

    }

    @Override
    protected ResourceLocation getLootTable() {
        return LOOT_TABLE;
    }

    @Override
    public float getEyeHeight() {
        return 1.54f;
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        if(this.attackTimer < 1) {
            this.attackTimer = 12;
            this.playSound(SoundEvents.ENTITY_PLAYER_ATTACK_STRONG, 1.0f, 0.8f);
            boolean successMagic = entityIn.attackEntityFrom(DamageSource.causeIndirectMagicDamage(this, this), 2f);
            boolean successMelee = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), 6f);
            return successMagic || successMelee;
        }
        return false;
    }

    public int beginCooldown(int i) {
        if(i == 0) {
            hailstormCooldown = HAILSTORM_MAX_COOLDOWN;
            return hailstormCooldown;
        } else {
            return 0;
        }
    }

    public int getCooldown(int i) {
        if(i == 0) {
            return hailstormCooldown;
        } else {
            return 0;
        }
    }

    @Override
    public Animation[] getAnimations() {
        return ANIMATIONS;
    }
}
