package org.eln2.processingage

import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.client.renderer.color.IItemColor
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.text.ITextComponent
import net.minecraftforge.client.event.ColorHandlerEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.KDeferredRegister

object ModBlocks {
    val BLOCKS = KDeferredRegister(ForgeRegistries.BLOCKS, ProcessingAge.MODID)
    val ITEMS = KDeferredRegister(ForgeRegistries.ITEMS, ProcessingAge.MODID)

    val ORE_BLOCK by BLOCKS.registerObject("ore_block") {
        Block(AbstractBlock.Properties.of(Material.STONE))
    }


    val oreChunkList = mutableListOf("fake_ore")

    init {
        oreChunkList.forEach {
            ITEMS.registerObject(it) {
                OreChunk(it, 0xFF, 0x11)
            }
        }
    }
}

class OreChunk(private val name: String, private val rockColor: Int, private val oreColor: Int): Item(Properties()), IItemColor {
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
