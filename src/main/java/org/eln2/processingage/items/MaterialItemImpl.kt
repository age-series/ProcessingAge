package org.eln2.processingage.items

import net.minecraft.world.item.CreativeModeTab

class MaterialItemImpl(tab: CreativeModeTab, val type: String): AbstractMaterialItem(tab) {
    override fun getMaterialType(): String {
        return type
    }
}
