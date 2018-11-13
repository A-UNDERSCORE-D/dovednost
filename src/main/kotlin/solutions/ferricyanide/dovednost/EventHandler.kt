package solutions.ferricyanide.dovednost

import net.minecraft.entity.SharedMonsterAttributes
import net.minecraft.entity.ai.attributes.AttributeModifier
import net.minecraft.entity.player.EntityPlayerMP
import net.minecraftforge.event.entity.living.LivingAttackEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

@Mod.EventBusSubscriber
object EventHandler {
    @SubscribeEvent
    @JvmStatic
    fun onLivingAttack(event: LivingAttackEvent) {
        val player = event.source.entity as? EntityPlayerMP ?: return
        val playerData = player.entityData
        Dovednost.logger.info("Got damage event from a player: ${player.displayNameString}: ${event.entity} for ${event.amount}")

        if (!playerData.hasKey(Globals.strengthKeyName)) {
            playerData.setDouble(Globals.strengthKeyName, 0.toDouble())
        }

        val newDamage = playerData.getDouble(Globals.strengthKeyName) + 1
        playerData.setDouble(Globals.strengthKeyName, newDamage)

        val damageAttr = player.attributeMap.getAttributeInstance(SharedMonsterAttributes.ATTACK_DAMAGE)
        val modifier = AttributeModifier(Globals.strengthModifierUUID, Globals.strengthModifierName, newDamage, 0)
        if (damageAttr.hasModifier(modifier)) {
            damageAttr.removeModifier(Globals.strengthModifierUUID)
        }
        damageAttr.applyModifier(modifier)
        Dovednost.logger.info("Set player additional damage $newDamage")
    }
}
