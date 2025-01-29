package com.example.mycity.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

// Main category for the first screen (Compact)
data class Category(
    val id: Int,
    @StringRes val name: Int,
    @DrawableRes val icon: Int
)

// Recommendation list item for the second screen (Compact)
data class Recommendation(
    val id: Int,
    val categoryId: Int,
    @StringRes val name: Int,
    @DrawableRes val image: Int
)

// Detailed info for the third screen (Compact)
data class RecommendationDetails(
    val id: Int,
    @StringRes val name: Int,
    @StringRes val whyVisitDescription: Int,
    @StringRes val proTipDescription: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int,
)