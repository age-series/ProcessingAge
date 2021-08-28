package org.eln2.processingage

import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.item.Item
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.KDeferredRegister

object ModBlocks {
    val BLOCKS = KDeferredRegister(ForgeRegistries.BLOCKS, ProcessingAge.MODID)
    val ITEMS = KDeferredRegister(ForgeRegistries.ITEMS, ProcessingAge.MODID)

    val ORE_BLOCK by BLOCKS.registerObject("ore_block") {
        Block(AbstractBlock.Properties.of(Material.STONE))
    }

    val ORE_CHUNK by ITEMS.registerObject("ore_chunk") {
        Item(Item.Properties())
    }
}
