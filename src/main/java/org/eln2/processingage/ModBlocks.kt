package org.eln2.processingage

import net.minecraft.client.color.item.ItemColor
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.minecraftforge.client.event.ColorHandlerEvent
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.eventbus.api.SubscribeEvent

val oreChunkTab = object: CreativeModeTab("Processing Age Ore Chunks") {
    override fun makeIcon(): ItemStack {
        return ItemStack(Items.BRICKS)
    }
}

/*
val ORE_BLOCK by BLOCKS.registerObject("ore_block") {
        Block(BlockBehaviour.Properties.of(Material.STONE))
    }
 */

fun registerModItems(event: RegistryEvent.Register<Item>) {
    (oreInformation.map { it.name + "_ore_chunk" } + "ore_chunk_1").forEach {
        val oc = OreChunk(it, 0xFF, 0x11)
        oc.setRegistryName("processingage", it)
        event.registry.register(oc)
    }
}

class OreChunk(private val name: String, private val rockColor: Int, private val oreColor: Int): Item(Properties()), ItemColor {
    override fun getColor(p0: ItemStack, p1: Int): Int {
        return if (p1 == 0) rockColor else oreColor
    }

    override fun getDescriptionId(): String {
        return "item.processingage.$name"
    }

    @SubscribeEvent
    fun registerItemColors(event: ColorHandlerEvent.Item) {
        event.itemColors.register(this, this)
    }
}
