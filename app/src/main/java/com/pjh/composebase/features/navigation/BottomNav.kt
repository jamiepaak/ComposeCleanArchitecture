package com.pjh.composebase.features.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


enum class BottomNav(
    val route: String,
    @DrawableRes val iconId: Int,
    @StringRes val titleTextId: Int
) {

}