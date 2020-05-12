package blue.thejester.monstrousmystics.entity.tier2;

import blue.thejester.monstrousmystics.MonstrousMystics;
import blue.thejester.monstrousmystics.client.render.RenderDevil;
import blue.thejester.monstrousmystics.client.render.RenderImp;
import blue.thejester.monstrousmystics.entity.EntityJesterMob;
import blue.thejester.monstrousmystics.entity.ai.AnimatedSpellAIFactory;
import blue.thejester.monstrousmystics.entity.ai.EntityAIAttackMeleeWithSwitchSpell;
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
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class EntityDevil extends EntityJesterMob {
    private static final ResourceLocation LOOT_TABLE = new ResourceLocation(MonstrousMystics.MODID, "entities/devil");
    private static final String NAME = "devil";
    private int attackTimer;

    public static final Animation SHOOT_ANIMATION = Animation.create(11);
    public static final Animation SHOOT_ANIMATION_LONG = Animation.create(22);
    public static final Animation FIRERING_ANIMATION = Animation.create(22);
    private static final Animation[] ANIMATIONS = {SHOOT_ANIMATION, SHOOT_ANIMATION_LONG, FIRERING_ANIMATION};

    public EntityDevil(World worldIn) {
        super(worldIn);
        this.setSize(0.6f, 1.75f);
        this.setPathPriority(PathNodeType.DANGER_FIRE, 0.0F);
        this.setPathPriority(PathNodeType.DAMAGE_FIRE, 0.0F);
        this.isImmuneToFire = true;
        this.experienceValue = 6;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(MonstrousMystics.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, EntityDevil.class, NAME, id,
                MonstrousMystics.instance, 64, 3, true,
                0xb23737, 0xba6d6d);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(EntityDevil.class, RenderDevil.FACTORY);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, AnimatedSpellAIFactory.statusUpkeepSpell(this, SHOOT_ANIMATION_LONG, 10, WizardryPotions.fireskin, Spells.fireskin)); //TODO real animation
        this.tasks.addTask(1, AnimatedSpellAIFactory.farRepeatingAttackSpell(this, 5, SHOOT_ANIMATION_LONG, 10, Spells.firebolt)); //if we're distant shoot at them
        this.tasks.addTask(3, AnimatedSpellAIFactory.closeRepeatingAttackSpell(this, 3, FIRERING_ANIMATION, 7, Spells.ring_of_fire)); //if we're close enough explode them
        this.tasks.addTask(3, new EntityAIAttackMeleeWithSwitchSpell(this, 1, Spells.smoke_bomb));
        this.tasks.addTask(4, AnimatedSpellAIFactory.repeatingAttackSpell(this, SHOOT_ANIMATION, 10, Spells.firebolt)); //if we're close and can't reach also shoot, but faster
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
        //do not call super - devils should not be armored
        //But they always come with a flame axe
        ItemStack sword = new ItemStack(WizardryItems.flaming_axe);
        sword.setItemDamage(20);
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, sword);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if(this.attackTimer > 0) {
            this.attackTimer--;
        }
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.253D);

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
            if(successMagic || successMelee) {
                entityIn.setFire(4);
            }
            return successMagic || successMelee;
        }
        return false;
    }

    @Override
    public Animation[] getAnimations() {
        return ANIMATIONS;
    }
}
