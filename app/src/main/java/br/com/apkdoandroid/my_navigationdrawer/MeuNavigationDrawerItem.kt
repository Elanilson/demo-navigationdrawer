package br.com.apkdoandroid.my_navigationdrawer

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import br.com.apkdoandroid.my_navigationdrawer.R;

sealed class MeuNavigationDrawerItem(
    val type : NavigationDrawerType,
    val badge : Int,
    @StringRes val title : Int,
    @DrawableRes val selectedIcon : Int,
    @DrawableRes val unSelectedIcon : Int
){

    object Home : MeuNavigationDrawerItem(
        type = NavigationDrawerType.HOME,
        badge = 0,
        title = R.string.label_home_navigation_drawer_item,
        selectedIcon = R.drawable.ic_home_fill,
        unSelectedIcon = R.drawable.ic_home_line
    )

    object Search : MeuNavigationDrawerItem(
        type = NavigationDrawerType.SEARCH,
        badge = 0,
        title = R.string.label_search_navigation_drawer_item,
        selectedIcon = R.drawable.ic_search_fill,
        unSelectedIcon = R.drawable.ic_search_line
    )

    object Notification : MeuNavigationDrawerItem(
        type = NavigationDrawerType.NOTIFICATION,
        badge = 10,
        title = R.string.label_notifications_navigation_drawer_item,
        selectedIcon = R.drawable.ic_notification_fill,
        unSelectedIcon = R.drawable.ic_notification_line
    )

    object Order : MeuNavigationDrawerItem(
        type = NavigationDrawerType.ORDER,
        badge = 0,
        title = R.string.label_orders_navigation_drawer_item,
        selectedIcon = R.drawable.ic_shopping_fill,
        unSelectedIcon = R.drawable.ic_shopping_line
    )

    object Favorite : MeuNavigationDrawerItem(
        type = NavigationDrawerType.FAVORITE,
        badge = 0,
        title = R.string.label_favorite_navigation_drawer_item,
        selectedIcon = R.drawable.ic_favorite_fill,
        unSelectedIcon = R.drawable.ic_favorite_line
    )


    enum class NavigationDrawerType {
        HOME,
        SEARCH,
        NOTIFICATION,
        ORDER,
        FAVORITE
    }

    companion object{
        val items = listOf(
            Home,
            Search,
            Notification,
            Order,
            Favorite
        )
    }
}
