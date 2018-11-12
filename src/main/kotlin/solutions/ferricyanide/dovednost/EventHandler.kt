package solutions.ferricyanide.dovednost

import net.minecraft.entity.SharedMonsterAttributes
import net.minecraft.entity.ai.attributes.AttributeModifier
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.TickEvent

@Mod.EventBusSubscriber
object EventHandler {
    @SubscribeEvent
    @JvmStatic
    fun onPlayerTick(event: TickEvent.PlayerTickEvent) {
        if (event.side.isClient) {
            return // We don't want to do anything on the client
        }

        val player = event.player
        val modifier = AttributeModifier(Globals.strengthModifierUUID, Globals.strengthModifierName, 100000000.toDouble(), 0)
        val attribute = player.attributeMap.getAttributeInstance(SharedMonsterAttributes.ATTACK_DAMAGE)
        if (!attribute.hasModifier(modifier)) {
            attribute.applyModifier(modifier)
        }
    }
}
