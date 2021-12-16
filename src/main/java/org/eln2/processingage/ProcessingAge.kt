package org.eln2.processingage

import net.minecraftforge.fml.common.Mod
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.eln2.processingage.items.registerOreChunks
import org.eln2.processingage.items.registerRawMaterials
import thedarkcolour.kotlinforforge.forge.FORGE_BUS
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(ProcessingAge.MODID)
object ProcessingAge {
    const val MODID: String = "processingage"
    val LOGGER: Logger = LogManager.getLogger()

    init {
        // Items
        registerOreChunks()
        registerRawMaterials()

        // Blocks
        // TODO: add ore blocks

        // Machines
        // TODO: add machines

        MOD_BUS.register(this)

        FORGE_BUS
    }
}
