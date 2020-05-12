package blue.thejester.monstrousmystics.entity.ai;

import electroblob.wizardry.event.SpellCastEvent;
import electroblob.wizardry.packet.PacketNPCCastSpell;
import electroblob.wizardry.packet.WizardryPacketHandler;
import electroblob.wizardry.spell.Spell;
import electroblob.wizardry.util.SpellModifiers;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.util.EnumHand;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class EntityAIAttackMeleeWithSwitchSpell extends EntityAIAttackMelee {
    private Spell spell;

    public EntityAIAttackMeleeWithSwitchSpell(EntityCreature creature, double speedIn, Spell spell) {
        super(creature, speedIn, false);
        this.spell = spell;
    }

    public void startExecuting() {
        super.startExecuting();
        if(this.attackTick < 1) {
            attemptCastSpell();
        }
    }

    private void attemptCastSpell() {
        SpellModifiers modifiers = new SpellModifiers();

        // If anything stops the spell working at this point, nothing else happens.
        if(MinecraftForge.EVENT_BUS.post(new SpellCastEvent.Pre(SpellCastEvent.Source.NPC, spell, attacker, modifiers))){
            return;
        }

        //prevents swing on cast
        boolean wasSwinging = attacker.isSwingInProgress;
        attacker.isSwingInProgress = true;

        EntityLivingBase target = this.attacker.getAttackTarget();

        if(spell.cast(attacker.world, attacker, EnumHand.MAIN_HAND, 0, target, modifiers)){
            MinecraftForge.EVENT_BUS.post(new SpellCastEvent.Post(SpellCastEvent.Source.NPC, spell, attacker, modifiers));


            if(spell.requiresPacket()){
                // Sends a packet to all players in dimension to tell them to spawn particles.
                IMessage msg = new PacketNPCCastSpell.Message(attacker.getEntityId(), target == null ? -1 : target.getEntityId(),
                        EnumHand.MAIN_HAND, spell, modifiers);
                WizardryPacketHandler.net.sendToDimension(msg, attacker.world.provider.getDimension());
            }
        }
        attacker.isSwingInProgress = wasSwinging;
    }
}
