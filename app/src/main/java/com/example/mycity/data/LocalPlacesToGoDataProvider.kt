package com.example.mycity.data

import com.example.mycity.model.Category
import com.example.mycity.R
import com.example.mycity.model.Recommendation
import com.example.mycity.model.RecommendationDetails

object LocalPlacesToGoDataProvider {


    fun getCategoryData(): List<Category> {
        return listOf(
            Category(1, R.string.category_coffee, R.drawable.icon_coffee_category),
            Category(2, R.string.category_restaurants, R.drawable.icon_restaurant_category),
            Category(3, R.string.category_kid_friendly_places, R.drawable.icon_kid_friendly_place__categorywebp),
            Category(4, R.string.category_parks, R.drawable.icon_park_category),
            Category(5, R.string.category_shopping_centers, R.drawable.icon_shopping_center_category)
        )
    }

    fun getRecommendationData(): List<Recommendation> {
        return listOf(
            // Coffee Recommendations
            Recommendation(1, 1, R.string.coffee_recommendation1, R.drawable.coffee_recommendation1),
            Recommendation(2, 1, R.string.coffee_recommendation2, R.drawable.coffee_recommendation2),
            Recommendation(3, 1, R.string.coffee_recommendation3, R.drawable.coffee_recommendation3),
            Recommendation(4, 1, R.string.coffee_recommendation4, R.drawable.coffee_recommendation4),
            Recommendation(5, 1, R.string.coffee_recommendation5, R.drawable.coffee_recommendation5),

            // Restaurant Recommendations
            Recommendation(6, 2, R.string.restaurant_recommendation1, R.drawable.restaurant_recommendation1),
            Recommendation(7, 2, R.string.restaurant_recommendation2, R.drawable.restaurant_recommendation2),
            Recommendation(8, 2, R.string.restaurant_recommendation3, R.drawable.restaurant_recommendation3),
            Recommendation(9, 2, R.string.restaurant_recommendation4, R.drawable.restaurant_recommendation4),
            Recommendation(10, 2, R.string.restaurant_recommendation5, R.drawable.restaurant_recommendation5),

            // Kid-Friendly Places Recommendations
            Recommendation(11, 3, R.string.kid_friendly_recommendation1, R.drawable.kid_friendly_recommendation1),
            Recommendation(12, 3, R.string.kid_friendly_recommendation2, R.drawable.kid_friendly_recommendation2),
            Recommendation(13, 3, R.string.kid_friendly_recommendation3, R.drawable.kid_friendly_recommendation3),
            Recommendation(14, 3, R.string.kid_friendly_recommendation4, R.drawable.kid_friendly_recommendation4),
            Recommendation(15, 3, R.string.kid_friendly_recommendation5, R.drawable.kid_friendly_recommendation5),

            // Park Recommendations
            Recommendation(16, 4, R.string.park_recommendation1, R.drawable.park_recommendation1),
            Recommendation(17, 4, R.string.park_recommendation2, R.drawable.park_recommendation2),
            Recommendation(18, 4, R.string.park_recommendation3, R.drawable.park_recommendation3),
            Recommendation(19, 4, R.string.park_recommendation4, R.drawable.park_recommendation4),
            Recommendation(20, 4, R.string.park_recommendation5, R.drawable.park_recommendation5),

            // Shopping Center Recommendations
            Recommendation(21, 5, R.string.shopping_center_recommendation1, R.drawable.shopping_center_recommendation1),
            Recommendation(22, 5, R.string.shopping_center_recommendation2, R.drawable.shopping_center_recommendation2),
            Recommendation(23, 5, R.string.shopping_center_recommendation3, R.drawable.shopping_center_recommendation3),
            Recommendation(24, 5, R.string.shopping_center_recommendation4, R.drawable.shopping_center_recommendation4),
            Recommendation(25, 5, R.string.shopping_center_recommendation5, R.drawable.shopping_center_recommendation5)
        )
    }

    fun getRecommendationDetailsData(): List<RecommendationDetails> {
        return listOf(
            // Coffee shops
            RecommendationDetails(
                id = 1,
                name = R.string.coffee_recommendation1,
                description = R.string.coffee_place_description1,
                whyVisitDescription = R.string.coffee_place_description_why1,
                proTipDescription = R.string.coffee_place_description_pro_tip1,
                image = R.drawable.coffee_recommendation1
            ),
            RecommendationDetails(
                id = 2,
                name = R.string.coffee_recommendation2,
                description = R.string.coffee_place_description2,
                whyVisitDescription = R.string.coffee_place_description_why2,
                proTipDescription = R.string.coffee_place_description_pro_tip2,
                image = R.drawable.coffee_recommendation2
            ),
            RecommendationDetails(
                id = 3,
                name = R.string.coffee_recommendation3,
                description = R.string.coffee_place_description3,
                whyVisitDescription = R.string.coffee_place_description_why3,
                proTipDescription = R.string.coffee_place_description_pro_tip3,
                image = R.drawable.coffee_recommendation3
            ),
            RecommendationDetails(
                id = 4,
                name = R.string.coffee_recommendation4,
                description = R.string.coffee_place_description4,
                whyVisitDescription = R.string.coffee_place_description_why4,
                proTipDescription = R.string.coffee_place_description_pro_tip4,
                image = R.drawable.coffee_recommendation4
            ),
            RecommendationDetails(
                id = 5,
                name = R.string.coffee_recommendation5,
                description = R.string.coffee_place_description5,
                whyVisitDescription = R.string.coffee_place_description_why5,
                proTipDescription = R.string.coffee_place_description_pro_tip5,
                image = R.drawable.coffee_recommendation5
            ),
            // Restaurants
            RecommendationDetails(
                id = 6,
                name = R.string.restaurant_recommendation1,
                description = R.string.restaurant_place_description1,
                whyVisitDescription = R.string.restaurant_place_description_why1,
                proTipDescription = R.string.restaurant_place_description_pro_tip1,
                image = R.drawable.restaurant_recommendation1
            ),
            RecommendationDetails(
                id = 7,
                name = R.string.restaurant_recommendation2,
                description = R.string.restaurant_place_description2,
                whyVisitDescription = R.string.restaurant_place_description_why2,
                proTipDescription = R.string.restaurant_place_description_pro_tip2,
                image = R.drawable.restaurant_recommendation2
            ),
            RecommendationDetails(
                id = 8,
                name = R.string.restaurant_recommendation3,
                description = R.string.restaurant_place_description3,
                whyVisitDescription = R.string.restaurant_place_description_why3,
                proTipDescription = R.string.restaurant_place_description_pro_tip3,
                image = R.drawable.restaurant_recommendation3
            ),
            RecommendationDetails(
                id = 9,
                name = R.string.restaurant_recommendation4,
                description = R.string.restaurant_place_description4,
                whyVisitDescription = R.string.restaurant_place_description_why4,
                proTipDescription = R.string.restaurant_place_description_pro_tip4,
                image = R.drawable.restaurant_recommendation4
            ),
            RecommendationDetails(
                id = 10,
                name = R.string.restaurant_recommendation5,
                description = R.string.restaurant_place_description5,
                whyVisitDescription = R.string.restaurant_place_description_why5,
                proTipDescription = R.string.restaurant_place_description_pro_tip5,
                image = R.drawable.restaurant_recommendation5
            ),
            // Kid-friendly places
            RecommendationDetails(
                id = 11,
                name = R.string.kid_friendly_recommendation1,
                description = R.string.kid_friendly_place_description1,
                whyVisitDescription = R.string.kid_friendly_place_description_why1,
                proTipDescription = R.string.kid_friendly_place_description_pro_tip1,
                image = R.drawable.kid_friendly_recommendation1
            ),
            RecommendationDetails(
                id = 12,
                name = R.string.kid_friendly_recommendation2,
                description = R.string.kid_friendly_place_description2,
                whyVisitDescription = R.string.kid_friendly_place_description_why2,
                proTipDescription = R.string.kid_friendly_place_description_pro_tip2,
                image = R.drawable.kid_friendly_recommendation2
            ),
            RecommendationDetails(
                id = 13,
                name = R.string.kid_friendly_recommendation3,
                description = R.string.kid_friendly_place_description3,
                whyVisitDescription = R.string.kid_friendly_place_description_why3,
                proTipDescription = R.string.kid_friendly_place_description_pro_tip3,
                image = R.drawable.kid_friendly_recommendation3
            ),
            RecommendationDetails(
                id = 14,
                name = R.string.kid_friendly_recommendation4,
                description = R.string.kid_friendly_place_description4,
                whyVisitDescription = R.string.kid_friendly_place_description_why4,
                proTipDescription = R.string.kid_friendly_place_description_pro_tip4,
                image = R.drawable.kid_friendly_recommendation4
            ),
            RecommendationDetails(
                id = 15,
                name = R.string.kid_friendly_recommendation5,
                description = R.string.kid_friendly_place_description5,
                whyVisitDescription = R.string.kid_friendly_place_description_why5,
                proTipDescription = R.string.kid_friendly_place_description_pro_tip5,
                image = R.drawable.kid_friendly_recommendation5
            ),
            // Parks
            RecommendationDetails(
                id = 16,
                name = R.string.park_recommendation1,
                description = R.string.park_place_description1,
                whyVisitDescription = R.string.park_place_description_why1,
                proTipDescription = R.string.park_place_description_pro_tip1,
                image = R.drawable.park_recommendation1
            ),
            RecommendationDetails(
                id = 17,
                name = R.string.park_recommendation2,
                description = R.string.park_place_description2,
                whyVisitDescription = R.string.park_place_description_why2,
                proTipDescription = R.string.park_place_description_pro_tip2,
                image = R.drawable.park_recommendation2
            ),
            RecommendationDetails(
                id = 18,
                name = R.string.park_recommendation3,
                description = R.string.park_place_description3,
                whyVisitDescription = R.string.park_place_description_why3,
                proTipDescription = R.string.park_place_description_pro_tip3,
                image = R.drawable.park_recommendation3
            ),
            RecommendationDetails(
                id = 19,
                name = R.string.park_recommendation4,
                description = R.string.park_place_description4,
                whyVisitDescription = R.string.park_place_description_why4,
                proTipDescription = R.string.park_place_description_pro_tip4,
                image = R.drawable.park_recommendation4
            ),
            RecommendationDetails(
                id = 20,
                name = R.string.park_recommendation5,
                description = R.string.park_place_description5,
                whyVisitDescription = R.string.park_place_description_why5,
                proTipDescription = R.string.park_place_description_pro_tip5,
                image = R.drawable.park_recommendation5
            ),
            // Shopping centers
            RecommendationDetails(
                id = 21,
                name = R.string.shopping_center_recommendation1,
                description = R.string.shopping_center_place_description1,
                whyVisitDescription = R.string.shopping_center_place_description_why1,
                proTipDescription = R.string.shopping_center_place_description_pro_tip1,
                image = R.drawable.shopping_center_recommendation1
            ),
            RecommendationDetails(
                id = 22,
                name = R.string.shopping_center_recommendation2,
                description = R.string.shopping_center_place_description2,
                whyVisitDescription = R.string.shopping_center_place_description_why2,
                proTipDescription = R.string.shopping_center_place_description_pro_tip2,
                image = R.drawable.shopping_center_recommendation2
            ),
            RecommendationDetails(
                id = 23,
                name = R.string.shopping_center_recommendation3,
                description = R.string.shopping_center_place_description3,
                whyVisitDescription = R.string.shopping_center_place_description_why3,
                proTipDescription = R.string.shopping_center_place_description_pro_tip3,
                image = R.drawable.shopping_center_recommendation3
            ),
            RecommendationDetails(
                id = 24,
                name = R.string.shopping_center_recommendation4,
                description = R.string.shopping_center_place_description4,
                whyVisitDescription = R.string.shopping_center_place_description_why4,
                proTipDescription = R.string.shopping_center_place_description_pro_tip4,
                image = R.drawable.shopping_center_recommendation4
            ),
            RecommendationDetails(
                id = 25,
                name = R.string.shopping_center_recommendation5,
                description = R.string.shopping_center_place_description5,
                whyVisitDescription = R.string.shopping_center_place_description_why5,
                proTipDescription = R.string.shopping_center_place_description_pro_tip5,
                image = R.drawable.shopping_center_recommendation5
            )
        )
    }

}