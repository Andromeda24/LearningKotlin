package org.ll.lab4.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class MyItem(
    @field:StringRes //restrict title to get its value ONLY from strings.xml
    @param:StringRes
    val title: Int,
    @field:DrawableRes
    @param:DrawableRes
    val image: Int
)
