package com.example.topicsapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic (
    @StringRes val stringResourceId: Int,
    val number: Int,
    @DrawableRes val imageResourceId: Int,
)