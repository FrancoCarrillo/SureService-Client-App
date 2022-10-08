package vitec.sureservice.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Destinations(
    val route: String,
    val arguments: List<NamedNavArgument>
){

    object Login: Destinations("login", emptyList())
    object Signup: Destinations("signup", emptyList())
    object Home: Destinations(
        "home",
        listOf(
            navArgument("username"){ type = NavType.StringType },
            navArgument("password"){ type = NavType.StringType }
        )
    )

}