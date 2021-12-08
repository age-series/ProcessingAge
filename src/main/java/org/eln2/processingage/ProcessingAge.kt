package org.eln2.processingage

import net.minecraft.world.item.Item
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.Mod
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.forge.addGenericListener

@Mod(ProcessingAge.MODID)
object ProcessingAge {
    const val MODID: String = "processingage"
    val LOGGER: Logger = LogManager.getLogger()

    init {
        MOD_BUS.addGenericListener({ event: RegistryEvent.Register<Item> -> registerModItems(event) })
        MOD_BUS.register(this)
    }
}
