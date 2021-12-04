package mening.dasturim.medservice.data.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class EnginerItem(
    @DrawableRes
    val img:Int,
    @StringRes
    val enginerName: Int,
    @StringRes
    val enginerCategory: Int,
    val experience: Int,
    val comment: Int,
    @StringRes
    val clinicName: Int,
    val details: Int
)