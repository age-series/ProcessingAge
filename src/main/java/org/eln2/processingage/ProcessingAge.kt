package org.eln2.processingage

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.server.FMLServerAboutToStartEvent
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.forge.FORGE_BUS
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(ProcessingAge.MODID)
object ProcessingAge {
    const val MODID: String = "processingage"
    val LOGGER: Logger = LogManager.getLogger()

    init {
        MOD_BUS.addListener(::onClientSetup)
        FORGE_BUS.addListener(::onServerAboutToStart)

        ModBlocks.BLOCKS.register(MOD_BUS)
        ModBlocks.ITEMS.register(MOD_BUS)

        MinecraftForge.EVENT_BUS.register(this)
    }

    private fun onClientSetup(event: FMLClientSetupEvent) {
        LOGGER.log(Level.INFO, "Initializing client...")
    }

    private fun onServerAboutToStart(event: FMLServerAboutToStartEvent) {
        LOGGER.log(Level.INFO, "Server starting...")
    }
}
