package org.eln2.processingage.items

import net.minecraft.core.NonNullList
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.TextComponent
import net.minecraft.network.chat.TranslatableComponent
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.InteractionResultHolder
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level
import org.eln2.processingage.ProcessingAge
import org.eln2.processingage.item_helpers.MaterialContents
import org.eln2.processingage.item_helpers.MaterialContentsList
import org.eln2.processingage.materials.materialDatabase
import thedarkcolour.kotlinforforge.forge.DIST

abstract class AbstractMaterialItem(tab: CreativeModeTab): Item(Properties().stacksTo(1).tab(tab)) {

    abstract fun getMaterialType(): String

    override fun getName(stack: ItemStack): Component {
        val stackTag = stack.tag
        val mc = if (stackTag != null) {
            MaterialContentsList.fromTag(stackTag)
        } else { MaterialContentsList(mutableListOf()) }
        mc.contents.sortBy {it.molar}
        return if (mc.contents.size != 0) {
            TranslatableComponent("${mc.contents.first().material}_${getMaterialType()}")
        } else {
            TranslatableComponent("Empty_${getMaterialType()}")
        }
    }

    override fun use(level: Level, player: Player, hand: InteractionHand): InteractionResultHolder<ItemStack> {
        val heldItem = player.inventory.getSelected()
        if (DIST.isClient) {
            val heldItemTag = heldItem.tag
            if (heldItemTag != null) {
                val contents = MaterialContentsList.fromTag(heldItemTag)
                player.displayClientMessage(TextComponent(contents.toString()), false)
                ProcessingAge.LOGGER.info(contents)
            }
        }
        return InteractionResultHolder(InteractionResult.PASS, heldItem)
    }

    override fun fillItemCategory(tab: CreativeModeTab, subItems: NonNullList<ItemStack>) {
        super.fillItemCategory(tab, subItems)
        if (tab in this.creativeTabs) {
            materialDatabase.forEach {
                val raw = MaterialContentsList(mutableListOf(MaterialContents(it.name, 1.0)))
                val stack = ItemStack(this, 1)
                stack.tag = raw.toTag()
                subItems.add(stack)
            }
        }
    }
}
