package com.luaramartins.hexagonapp.presentation

import android.content.Intent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.luaramartins.hexagonapp.R
import com.luaramartins.hexagonapp.presentation.navigation.ItemsMenu
import com.luaramartins.hexagonapp.presentation.navigation.NavigationHost
import com.luaramartins.hexagonapp.ui.theme.SUPER_PADDING
import com.luaramartins.hexagonapp.ui.theme.ZERO_DP
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    val navigationItem = listOf(
        ItemsMenu.Screen1,
        ItemsMenu.Screen2,
        ItemsMenu.Screen3
    )

    androidx.compose.material.Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = { BottomNavigation(navController = navController, menuItems = navigationItem) },
        floatingActionButton = { Fab(scope, scaffoldState) },
        isFloatingActionButtonDocked = true
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            NavigationHost(navController = navController)
        }
    }
}

@Composable
fun currentRoute(navController: NavController): String? {
    val start by navController.currentBackStackEntryAsState()
    return start?.destination?.route
}

@Composable
fun BottomNavigation(
    navController: NavController,
    menuItems: List<ItemsMenu>
) {
    BottomAppBar(
        modifier = Modifier.height(80.dp),
        backgroundColor = colorResource(id = R.color.colorBackgroundPrimary),
        elevation = ZERO_DP,
        cutoutShape = MaterialTheme.shapes.small.copy(
            CornerSize(percent = 50)
        )
    ) {
        androidx.compose.material.BottomNavigation(
            backgroundColor = colorResource(id = R.color.colorBackgroundPrimary),
            elevation = ZERO_DP,
            modifier = Modifier.padding(ZERO_DP, ZERO_DP, SUPER_PADDING, ZERO_DP)
        ) {
            val currentRoute = currentRoute(navController = navController)
            menuItems.forEach { item ->

                BottomNavigationItem(
                    selected = currentRoute == item.ruta,
                    onClick = {
                        navController.navigate(item.ruta)
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = item.title,
                            tint = colorResource(id = R.color.colorWhite)
                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            color = colorResource(id = R.color.colorWhite)
                        )
                    },
                    alwaysShowLabel = false
                )
            }
        }
    }

}

@Composable
fun Fab(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState
) {
    val context = LocalContext.current
    FloatingActionButton(
        containerColor = colorResource(id = R.color.colorBackgroundSecond),
        onClick = {
            val intent = Intent(context, AddPersonActivity::class.java)
            context.startActivity(intent)
        },
        shape = androidx.compose.foundation.shape.CircleShape
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_add),
            contentDescription = "Adicione um novo usuário",
            tint = colorResource(id = R.color.colorTextSecondary)
        )
    }
}