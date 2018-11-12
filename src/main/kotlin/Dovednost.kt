package solutions.ferricyanide.dovednost

import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.SidedProxy
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import org.apache.logging.log4j.Logger

@Mod(
        modid = Dovednost.MOD_ID,
        version = Dovednost.MOD_VERSION,
        name = Dovednost.MOD_NAME,
        modLanguageAdapter = "net.shadowfacts.forgelin.KotlinAdapter",
        useMetadata = true
)
@Suppress("MemberVisibilityCanBePrivate")
object Dovednost {
    const val MOD_NAME = "dovednost"
    const val MOD_ID = "dovednost"
    const val MOD_VERSION = "@VERSION@"

    @SidedProxy(clientSide = "solutions.ferricyanide.dovednost.ClientProxy", serverSide = "solutions.ferricyanide.dovednost.ServerProxy")
    lateinit var proxy: CommonProxy
    lateinit var logger: Logger

    @Mod.EventHandler
    fun preInit(event: FMLPreInitializationEvent) {
        logger = event.modLog
        logger.info("Hello Minecraft! Ready to learn some skills?")
        proxy.preInit(event)
    }

    @Mod.EventHandler
    fun init(event: FMLInitializationEvent) {
        proxy.init(event)
    }

    @Mod.EventHandler
    fun postInit(event: FMLPostInitializationEvent) {
        proxy.postInit(event)
    }

}
