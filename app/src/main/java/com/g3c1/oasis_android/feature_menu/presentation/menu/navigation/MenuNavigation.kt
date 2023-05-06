package com.g3c1.oasis_android.feature_menu.presentation.menu.navigation

import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.g3c1.oasis_android.feature_menu.data.dto.MenuDTO
import com.g3c1.oasis_android.feature_menu.presentation.detail.FoodDetailScreen
import com.g3c1.oasis_android.feature_menu.presentation.menu.MenuScreen
import com.g3c1.oasis_android.feature_menu.presentation.vm.MenuViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MenuNavigation(
    viewModel: MenuViewModel,
    menuDataList: List<MenuDTO>,
    bottomSheetScaffoldState: BottomSheetScaffoldState
) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.MenuScreen.route) {
        composable(Screen.MenuScreen.route) {
            MenuScreen(
                navController = navController,
                viewModel = viewModel,
                menuDataList = menuDataList,
                bottomSheetScaffoldState = bottomSheetScaffoldState
            )
        }
        composable(
            route = Screen.DetailScreen.route + "/{menuId}",
            arguments = listOf(
                navArgument("menuId") {
                    type = NavType.IntType
                    nullable = false
                }
            )
        ) { entry ->
            FoodDetailScreen(
                navController = navController,
                viewModel = viewModel,
                menuId = entry.arguments?.getInt("menuId"),
                menuList = menuDataList,
                bottomSheetScaffoldState = bottomSheetScaffoldState
            )
        }
    }
}