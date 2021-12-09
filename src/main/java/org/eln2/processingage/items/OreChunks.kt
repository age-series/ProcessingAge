package org.eln2.processingage.items

import net.minecraft.client.color.item.ItemColor
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.minecraftforge.client.event.ColorHandlerEvent
import net.minecraftforge.event.RegistryEvent
import org.eln2.processingage.materials.oreInformation
import thedarkcolour.kotlinforforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.forge.addGenericListener

val oreChunksList = mutableMapOf<String, OreChunk>()

fun registerOreChunks() {
    MOD_BUS.addGenericListener({ event: RegistryEvent.Register<Item> -> registerOreChunkItems(event) })
    MOD_BUS.addListener { event: ColorHandlerEvent.Item -> registerOreChunkColorRenders(event) }
}

fun registerOreChunkItems(event: RegistryEvent.Register<Item>) {
    oreInformation.map { it.name + "_ore_chunk" }.forEach {
        val oc = OreChunk(it, 3145631, 16746075)
        oc.setRegistryName("processingage", it)
        event.registry.register(oc)
        oreChunksList[it] = oc
    }
}

fun registerOreChunkColorRenders(event: ColorHandlerEvent.Item) {
    oreChunksList.forEach{
        event.itemColors.register(it.value, it.value)
    }
}

val oreChunkTab = object: CreativeModeTab("Processing_Age_Ore_Chunks") {
    override fun makeIcon(): ItemStack {
        return ItemStack(Items.BRICKS)
    }
}

class OreChunk(
    private val name: String,
    private val rockColor: Int,
    private val oreColor: Int
    ): Item(Properties().tab(oreChunkTab)), ItemColor {

    override fun getColor(p0: ItemStack, p1: Int) = if (p1 == 0) rockColor else oreColor
    override fun getDescriptionId() = "item.processingage.$name"
}
