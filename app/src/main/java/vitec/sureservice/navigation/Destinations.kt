package vitec.sureservice.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavArgs
import androidx.navigation.NavType
import androidx.navigation.navArgument

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
    object BookAnAppointment: Destinations("bookAnAppointment/{technicianId}", emptyList()){
        fun createRoute(technicianId: Int) = "bookAnAppointment/$technicianId"
    }
    object DetailBookAnAppointment: Destinations("detailBookAnAppointment/{date}/{technicianName}/{technicianLastName}/{technicianDistrict}/{serviceRequestId}", emptyList()){
        fun createRoute(date: String,
                        technicianName: String,
                        technicianLastName: String,
                        technicianDistrict: String,
                        serviceRequestId: Int) = "detailBookAnAppointment/$date/$technicianName/$technicianLastName/$technicianDistrict/$serviceRequestId"
    }
    
    object SettingChangeInformation: Destinations("settings_change_information", emptyList())

}
