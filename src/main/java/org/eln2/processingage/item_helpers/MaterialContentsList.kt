package org.eln2.processingage.item_helpers

import net.minecraft.nbt.CompoundTag

data class MaterialContentsList(val contents: MutableList<MaterialContents>) {
    companion object {
        const val MaterialContentsKeyPrefix = "material_"
        fun fromTag(nbt: CompoundTag): MaterialContentsList {
            val list: List<MaterialContents> =
                nbt.allKeys.filter { it.startsWith(MaterialContentsKeyPrefix) }.mapNotNull {
                    val tag = nbt[it] as CompoundTag
                    if ("material" in tag.allKeys && "kilograms" in tag.allKeys) {
                        val materialName: String = tag.getString("material")
                        val kilograms: Double = tag.getDouble("kilograms")
                        MaterialContents(materialName, kilograms)
                    } else {
                        null
                    }
                }
            return MaterialContentsList(list.toMutableList())
        }
    }

    fun fromTag(nbt: CompoundTag) {
        contents.clear()
        contents.addAll(Companion.fromTag(nbt).contents)
    }

    fun toTag(): CompoundTag {
        val tag = CompoundTag()
        this.contents.forEach {
            val thisTag = CompoundTag()
            thisTag.putString("material", it.material)
            thisTag.putDouble("kilograms", it.kilograms)
            tag.put("$MaterialContentsKeyPrefix${it.material}", thisTag)
        }
        return tag
    }

    override fun toString(): String {
        return this.contents.joinToString ("\n") {
            "${it.material}: ${it.kilograms}kg"
        }
    }
}
