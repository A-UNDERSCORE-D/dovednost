package solutions.ferricyanide.dovednost

import java.util.UUID

object Globals {
    const val strengthModifierName = "${Dovednost.MOD_ID}:damage_boost"
    val strengthModifierUUID = UUID.nameUUIDFromBytes(strengthModifierName.toByteArray())!!
}
