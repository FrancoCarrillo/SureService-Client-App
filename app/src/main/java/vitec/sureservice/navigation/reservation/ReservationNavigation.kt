package vitec.sureservice.navigation.reservation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import vitec.sureservice.navigation.Destinations
import vitec.sureservice.ui.login.LogInViewModel
import vitec.sureservice.ui.reservation.*

@ExperimentalAnimationApi
@Composable
fun ReservationNavigation(navControllerFather: NavHostController, navController: NavHostController) {

    BoxWithConstraints {
        AnimatedNavHost(
            navController = navController,
            startDestination = Destinations.Reservation.route
        ){
            addReservation(navController, navControllerFather)
            addRequestAccept(navController)
            addPayment(navController)
            addPaymentSuccess(navController)
            addPaymentFailed(navController)

        }
    }
}


@ExperimentalAnimationApi
fun NavGraphBuilder.addReservation(
    navController: NavHostController,
    navControllerFather: NavHostController
){
    composable(
        route = Destinations.Reservation.route
    ){
        val loginViewModel: LogInViewModel = hiltViewModel()

        Reservation(
            {
                loginViewModel.clientDao.deleteClient(loginViewModel.client)
                navControllerFather.navigate(Destinations.Login.route){
                    popUpTo(Destinations.Home.route){
                        inclusive = true
                    }
                }
            },
            {
                navController.navigate(Destinations.RequestAccept.route)
            } )
    }
}


@ExperimentalAnimationApi
fun NavGraphBuilder.addRequestAccept(navController: NavHostController){
    composable(
        route = Destinations.RequestAccept.route
    ){
        RequestAccept() {
            navController.navigate(Destinations.Payment.route)
        }
    }
}




@ExperimentalAnimationApi
fun NavGraphBuilder.addPayment(navController: NavHostController){
    composable(
        route = Destinations.Payment.route
    ){
        Payment() {
            navController.navigate(Destinations.PaymentSuccess.route)
        }
    }
}

@ExperimentalAnimationApi
fun NavGraphBuilder.addPaymentSuccess(navController: NavHostController){
    composable(
        route = Destinations.PaymentSuccess.route
    ){
        PaymentSuccess() {
            navController.navigate(Destinations.PaymentFailed.route)
        }
    }
}

@ExperimentalAnimationApi
fun NavGraphBuilder.addPaymentFailed(navController: NavHostController){
    composable(
        route = Destinations.PaymentFailed.route
    ){
        PaymentFailed() {
            navController.navigate(Destinations.Reservation.route)
        }
    }
}