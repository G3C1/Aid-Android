package com.g3c1.oasis_android.feature_menu.presentation.menu.navigation

sealed class Screen(val route: String) {
    object MenuScreen: Screen("menu_screen")
    object DetailScreen: Screen("detail_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}