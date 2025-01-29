package com.example.mycity.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

// Define routes for the screens
object CityRoutes {
    const val CATEGORY_LIST = "category_list"
    const val RECOMMENDATION_LIST = "recommendation_list"
    const val RECOMMENDATION_DETAILS = "recommendation_details/{recommendationId}"
    const val RECOMMENDATION_DETAILS_BASE = "recommendation_details"
}

@Composable
fun CityApp(
    windowSize: WindowWidthSizeClass,
    viewModel: CityViewModel = viewModel()
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = CityRoutes.CATEGORY_LIST
    ) {
        addCategoryListScreen(navController, windowSize, viewModel)
        addRecommendationListScreen(navController, windowSize, viewModel)
//        addRecommendationDetailsScreen(navController, windowSize, viewModel)
    }
}

/**
 * Adds the category list screen to the navigation graph.
 */
fun NavGraphBuilder.addCategoryListScreen(
    navController: NavController,
    windowSize: WindowWidthSizeClass,
    viewModel: CityViewModel
) {
    composable(CityRoutes.CATEGORY_LIST) {
        CategoryList(
            viewModel = viewModel,
            windowSize = windowSize,
            onClick = { selectedCategory ->
                viewModel.updateCurrentCategory(selectedCategory)
                navController.navigate(CityRoutes.RECOMMENDATION_LIST)
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

/**
 * Adds the recommendation list screen to the navigation graph.
 */
fun NavGraphBuilder.addRecommendationListScreen(
    navController: NavController,
    windowSize: WindowWidthSizeClass,
    viewModel: CityViewModel
) {
    composable(CityRoutes.RECOMMENDATION_LIST) {
        Scaffold(
            topBar = {
                CityAppBar(
                    onBackButtonClick = { navController.navigateUp() },
                    titlePage = "Recommendations",
                    isShowingListPage = false
                )
            }
        ) { innerPadding ->
            RecommendationList(
                recommendations = viewModel.uiState.collectAsState().value.recommendationList,
                windowSize = windowSize,
                onClick = { selectedRecommendation ->
                    viewModel.updateCurrentRecommendation(selectedRecommendation)
                    navController.navigate("${CityRoutes.RECOMMENDATION_DETAILS}/${selectedRecommendation.id}")
                },
                categoryId = viewModel.uiState.collectAsState().value.selectedCategoryId,
                modifier = Modifier.padding(innerPadding)
            )
        }

    }
}

/**
 * Adds the details screen to the navigation graph.
 */
//fun NavGraphBuilder.addRecommendationDetailsScreen(
//    navController: NavController,
//    windowSize: WindowWidthSizeClass,
//    viewModel: CityViewModel
//) {
//    composable(
//        route = CityRoutes.RECOMMENDATION_DETAILS,
//        arguments = listOf(navArgument("recommendationId") { type = NavType.IntType })
//    ) { backStackEntry ->
//        // Retrieve the recommendationId from the arguments
//        val recommendationId = backStackEntry.arguments?.getInt("recommendationId")
//
//        // Find the details for the given recommendationId
//        val recommendationDetails = recommendationId?.let { id ->
//            viewModel.uiState.collectAsState().value.deta.find { it.id == id }
//        }
//
//        // Ensure recommendationDetails is of the correct type and pass it to the view
//        recommendationDetails?.let { details ->
//            RecommendationDetailsView(
//                detail = details,  // `details` is now of type `RecommendationDetails`
//                windowSize = windowSize
//            )
//        } ?: run {
//            // Handle the null case (e.g., show an error or navigate back)
//            Text("Recommendation details not found")
//        }
//    }
//}