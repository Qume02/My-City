package com.example.mycity.ui

import androidx.lifecycle.ViewModel
import com.example.mycity.data.LocalPlacesToGoDataProvider
import com.example.mycity.model.Category
import com.example.mycity.model.Recommendation
import com.example.mycity.model.RecommendationDetails
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

/**
 * View Model for My City app
 */
class CityViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        CityUiState(
            categoryList = LocalPlacesToGoDataProvider.getCategoryData(),
            recommendationList = LocalPlacesToGoDataProvider.getRecommendationData(),
            currentRecommendationDetails = null
        )
    )
    val uiState: StateFlow<CityUiState> = _uiState

    /**
     * Updates the current category and filters recommendations based on the selected category.
     * @param selectedCategory The category that is selected by the user.
     */
    fun updateCurrentCategory(selectedCategory: Category) {
        val filteredRecommendations = LocalPlacesToGoDataProvider.getRecommendationData()
            .filter { it.categoryId == selectedCategory.id }

        _uiState.update { currentState ->
            currentState.copy(
                selectedCategoryId = selectedCategory.id,
                recommendationList = filteredRecommendations
            )
        }
    }

    /**
     * Updates the current recommendation and filters details based on the selected recommendation.
     * @param selectedRecommendation The recommendation that is selected by the user.
     */
    fun updateCurrentRecommendation(selectedRecommendation: Recommendation) {
        val details = LocalPlacesToGoDataProvider.getRecommendationDetailsData()
            .find { it.id == selectedRecommendation.id }

        _uiState.update { currentState ->
            currentState.copy(
                isShowingListPage = false,
                currentRecommendationDetails = details
            )
        }
    }
    /**
     * Navigates from category page to recommendation page.
     */
    fun navigateToRecommendationPage() {
        _uiState.update { currentState ->
            currentState.copy(isShowingListPage = false)
        }
    }
    /**
     * Navigates from recommendation page to details page.
     */
    fun navigateToRecommendationDetailsPage() {
        _uiState.update { currentState ->
            currentState.copy(isShowingListPage = false)
        }
    }

    /**
     * Navigates back to category page.
     */
    fun navigateBackToCategories() {
        _uiState.update { currentState ->
            currentState.copy(
                isShowingListPage = true
            )
        }
    }

    /**
     * Navigates back to recommendation page.
     */
    fun navigateBackToRecommendations() {
        _uiState.update { currentState ->
            currentState.copy(
                isShowingListPage = false,
                currentRecommendationDetails = null
            )
        }
    }
}

data class CityUiState(
    val categoryList: List<Category> = emptyList(),
    val recommendationList: List<Recommendation> = emptyList(),
    val currentRecommendationDetails: RecommendationDetails? = null,
    val selectedCategoryId: Int = -1,
    val isShowingListPage: Boolean = true
)