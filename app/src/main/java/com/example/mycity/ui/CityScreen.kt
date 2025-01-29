package com.example.mycity.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mycity.R
import com.example.mycity.data.LocalPlacesToGoDataProvider
import com.example.mycity.model.Category
import com.example.mycity.model.Recommendation
import com.example.mycity.model.RecommendationDetails


@Composable
fun CityScreen(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    val viewModel: CityViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    // Determine the title of the page
    val titlePage = when {
        uiState.isShowingListPage -> stringResource(R.string.app_name)
        uiState.currentRecommendationDetails == null -> stringResource(
            R.string.recommendations
        )
        else -> stringResource(R.string.recommendations_details)
    }

    Scaffold(
        topBar = {
            CityAppBar(
                isShowingListPage = uiState.isShowingListPage,
                titlePage = titlePage,
                onBackButtonClick = {
                    if (uiState.currentRecommendationDetails != null) {
                        viewModel.navigateBackToRecommendations()
                    } else {
                        viewModel.navigateBackToCategories()
                    }
                }
            )
        }
    ) { innerPadding ->
            when {
                uiState.isShowingListPage -> {
                    // First screen: Category List
                    CategoryList(
                        viewModel = viewModel,
                        windowSize = windowSize,
                        onClick = { selectedCategory ->
                            viewModel.updateCurrentCategory(selectedCategory)
                            viewModel.navigateToRecommendationPage()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(innerPadding)
                    )
                }

                uiState.currentRecommendationDetails == null -> {
                    // Second screen: Recommendation List
                    RecommendationList(
                        recommendations = uiState.recommendationList,
                        windowSize = windowSize,
                        onClick = { selectedRecommendation ->
                            viewModel.updateCurrentRecommendation(selectedRecommendation)
                            viewModel.navigateToRecommendationDetailsPage()
                        },
                        categoryId = uiState.selectedCategoryId,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(innerPadding)
                    )
                }

                else -> {
                    // Third screen: Recommendation Details
                    uiState.currentRecommendationDetails?.let {
                        RecommendationDetailsView(
                            detail = it,
                            windowSize = windowSize,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(innerPadding)
                        )
                    }
                }
            }
        }
}

/**
 * Composable that displays the topBar and displays back button if back navigation is possible.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityAppBar(
    onBackButtonClick: () -> Unit,
    titlePage: String,
    isShowingListPage: Boolean,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                text = titlePage,
                style = MaterialTheme.typography.headlineSmall
            )
        },
        navigationIcon = {
            if (!isShowingListPage) {
                IconButton(onClick = onBackButtonClick) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            }
        }
    )
}

/**
 * Composable that displays a list of the categories.
 */
@Composable
fun CategoryList(
//    categories: List<Category>,
    viewModel: CityViewModel,
    windowSize: WindowWidthSizeClass,
    onClick: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()

    // Determine horizontal padding based on the window size
    val horizontalPadding = calculateHorizontalPadding(windowSize = windowSize)
    LazyColumn(
        modifier = modifier.padding(
            horizontal = horizontalPadding,
            vertical = dimensionResource(R.dimen.padding_medium)
        )
    ) {
        items(uiState.categoryList) { category ->
            CategoryListItem(
                category = category,
                onItemClick = onClick
            )
        }
    }
}

/**
 * Composable that displays a list of recommendations.
 */
@Composable
fun RecommendationList(
    recommendations: List<Recommendation>,
    windowSize: WindowWidthSizeClass,
    onClick: (Recommendation) -> Unit,
    categoryId: Int,
    modifier: Modifier = Modifier
) {
    val filterRecommendations = recommendations.filter { it.categoryId == categoryId }

    val horizontalPadding = calculateHorizontalPadding(windowSize = windowSize)
    LazyColumn(
            modifier = modifier.padding(
                horizontal = horizontalPadding,
                vertical = dimensionResource(R.dimen.padding_medium)
            )
        ) {
            items(filterRecommendations, key = { recommendation -> recommendation.id }) {recommendation ->
                RecommendationListItem(
                    recommendation = recommendation,
                    onItemClick = onClick
                )
            }
        }
}

/**
 * Composable that displays a page with details of some place.
 */
@Composable
fun RecommendationDetailsView(
    detail: RecommendationDetails,
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    val horizontalPadding = calculateHorizontalPadding(windowSize = windowSize)
    
    Card(
        modifier = modifier
            .padding(
                horizontal = horizontalPadding,
                vertical = dimensionResource(R.dimen.padding_small)
            )
    ) {
        Column {
            Image(
                painter = painterResource(detail.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(R.dimen.image_height)),
//                    .size(
//                        width = dimensionResource(R.dimen.image_width),
//                        height = dimensionResource(R.dimen.image_height)
//                    ),
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = dimensionResource(R.dimen.padding_medium)
                    ),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(detail.name),
                    style = MaterialTheme.typography.displayLarge,
                    modifier = Modifier
                        .padding(
                            start = dimensionResource(R.dimen.padding_medium),
                            end = dimensionResource(R.dimen.padding_medium)
                        )
                )
            }
            DetailSection(title = R.string.description, content = detail.description)
            DetailSection(title = R.string.why_visit, content = detail.whyVisitDescription)
            DetailSection(title = R.string.pro_tip, content = detail.proTipDescription)
            Spacer(modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_medium)))
        }
    }
}

/**
 * Composable to display part of the text in the display page (title - bold, content - just text).
 *
 */
@Composable
fun DetailSection(@StringRes title: Int, content: Int) {
    Column(
        modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.padding_medium))
    ) {
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(
                vertical = dimensionResource(R.dimen.padding_small)
            )
        )
        Text(
            text = stringResource(content),
            style = MaterialTheme.typography.bodyLarge
        )

    }
}

/**
 * Composable that displays a card of the categories.
 */
@Composable
fun CategoryListItem(
    category: Category,
    onItemClick: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = dimensionResource(R.dimen.padding_medium))
            .clickable {
                onItemClick(category)
            }
        ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            CategoryListImageItem(category = category)
            Text(
                text = stringResource(category.name),
                style = MaterialTheme.typography.displayLarge,
                modifier = modifier
                    .padding(
                        start = dimensionResource(R.dimen.padding_medium)
                    )
                )
        }
    }
}

/**
 * Composable that displays an image of the category card.
 */
@Composable
fun CategoryListImageItem(category: Category, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(category.icon),
        contentDescription = null,
        modifier = modifier.size(dimensionResource(R.dimen.icon_size)),
        contentScale = ContentScale.Crop
    )
}

/**
 * Composable that displays a card of the recommendation.
 */
@Composable
fun RecommendationListItem(
    recommendation: Recommendation,
    onItemClick: (Recommendation) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = dimensionResource(R.dimen.padding_medium))
            .clickable {
                onItemClick(recommendation)
            }
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RecommendationListImageItem(recommendation = recommendation)
            Text(
                text = stringResource(recommendation.name),
                style = MaterialTheme.typography.displayLarge,
                modifier = Modifier
                    .padding(
                        start = dimensionResource(R.dimen.padding_medium)
                    )
            )
        }
    }
}

/**
 * Composable that displays the image in the recommendation card.
 */
@Composable
fun RecommendationListImageItem(recommendation: Recommendation, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(recommendation.image),
        contentDescription = null,
        modifier = modifier.size(dimensionResource(R.dimen.icon_size)),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun calculateHorizontalPadding(windowSize: WindowWidthSizeClass): Dp {
    return when (windowSize) {
        WindowWidthSizeClass.Compact -> dimensionResource(R.dimen.padding_small)
        WindowWidthSizeClass.Medium -> dimensionResource(R.dimen.padding_small)
        WindowWidthSizeClass.Expanded -> dimensionResource(R.dimen.padding_small_expanded)
        else -> dimensionResource(R.dimen.padding_medium)
    }
}

@Preview(showBackground = true)
@Composable
fun RecommendationListCoffeePreview() {
    RecommendationList(
        recommendations = LocalPlacesToGoDataProvider.getRecommendationData(),
        windowSize = WindowWidthSizeClass.Compact,
        onClick = {},
        categoryId = 1
    )
}

@Preview(showBackground = true)
@Composable
fun RecommendationDetailsPreview() {
    RecommendationDetailsView(
        detail = LocalPlacesToGoDataProvider.getRecommendationDetailsData()[1],
        windowSize = WindowWidthSizeClass.Compact
    )
}