package org.eln2.processingage.items

import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.minecraftforge.event.RegistryEvent
import org.eln2.processingage.ProcessingAge.MODID
import thedarkcolour.kotlinforforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.forge.addGenericListener

fun registerRawMaterials() {
    MOD_BUS.addGenericListener({ event: RegistryEvent.Register<Item> -> registerThem(event) })
}

lateinit var dirtyOreGravelItem: MaterialItemImpl
lateinit var dirtyOreSandItem: MaterialItemImpl
lateinit var cleanOreGravelItem: MaterialItemImpl
lateinit var dirtyOrePowderItem: MaterialItemImpl
lateinit var cleanOreSandItem: MaterialItemImpl
lateinit var cleanOrePowderItem: MaterialItemImpl

val materialItemsTab = object: CreativeModeTab("Processing_Age_Raw_Materials") {
    override fun makeIcon(): ItemStack {
        return ItemStack(Items.BRICKS)
    }
}

fun registerThem(event: RegistryEvent.Register<Item>) {

    run {
        val name = "dirty_ore_gravel"
        dirtyOreGravelItem = MaterialItemImpl(materialItemsTab, name)
        dirtyOreGravelItem.setRegistryName(MODID, name)
        event.registry.register(dirtyOreGravelItem)
    }

    run {
        val name = "dirty_ore_sand"
        dirtyOreSandItem = MaterialItemImpl(materialItemsTab, name)
        dirtyOreSandItem.setRegistryName(MODID, name)
        event.registry.register(dirtyOreSandItem)
    }

    run {
        val name = "clean_ore_gravel"
        cleanOreGravelItem = MaterialItemImpl(materialItemsTab, name)
        cleanOreGravelItem.setRegistryName(MODID, name)
        event.registry.register(cleanOreGravelItem)
    }

    run {
        val name = "dirty_ore_powder"
        dirtyOrePowderItem = MaterialItemImpl(materialItemsTab, name)
        dirtyOrePowderItem.setRegistryName(MODID, name)
        event.registry.register(dirtyOrePowderItem)
    }

    run {
        val name = "clean_ore_sand"
        cleanOreSandItem = MaterialItemImpl(materialItemsTab, name)
        cleanOreSandItem.setRegistryName(MODID, name)
        event.registry.register(cleanOreSandItem)
    }

    run {
        val name = "clean_ore_powder"
        cleanOrePowderItem = MaterialItemImpl(materialItemsTab, name)
        cleanOrePowderItem.setRegistryName(MODID, name)
        event.registry.register(cleanOrePowderItem)
    }
}
