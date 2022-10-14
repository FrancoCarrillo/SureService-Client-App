package vitec.sureservice.navigation

import androidx.navigation.NamedNavArgument

sealed class Destinations(
    val route: String,
    val arguments: List<NamedNavArgument>
){

    object Login: Destinations("login", emptyList())
    object Signup: Destinations("signup", emptyList())
    object Home: Destinations("home", emptyList())
    object Service: Destinations("service", emptyList())
    object Reservation: Destinations("reservation", emptyList())
    object Settings: Destinations("settings", emptyList())
    object Logout: Destinations("logout", emptyList())
    object TechnicianProfile: Destinations("technicianProfile/{technicianId}", emptyList()){
        fun createRoute(technicianId: Int) = "technicianProfile/$technicianId"
    }
}