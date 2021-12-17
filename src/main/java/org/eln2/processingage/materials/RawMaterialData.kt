package org.eln2.processingage.materials

data class RawMaterialData(
    val name: String,
    val color: Int,
    val specificGravity: Double,
    val chemicalFormula: String? = null,
    val meltingPoint: Double? = null,
    val freezingPoint: Double? = null,
)
