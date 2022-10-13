package vitec.sureservice.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import vitec.sureservice.ui.MainScreen
import vitec.sureservice.ui.login.LogIn
import vitec.sureservice.ui.login.LogInViewModel
import vitec.sureservice.ui.reservation.Reservation
import vitec.sureservice.ui.service.Service
import vitec.sureservice.ui.settings.Settings
import vitec.sureservice.ui.signup.SignUp
import vitec.sureservice.ui.signup.SignUpViewModel


@ExperimentalAnimationApi
@Composable
fun Navigation(navControllerFather: NavHostController, startDestination: String, navController: NavHostController) {

    BoxWithConstraints {
        AnimatedNavHost(
            navController = navController,
            startDestination = startDestination
        ){
            addLogin(navController)
            addSignUp(navController)
            addHome(navControllerFather)
            addService()
            addReservation()
            addSettings(navControllerFather)
        }
    }
}


@ExperimentalAnimationApi
fun NavGraphBuilder.addLogin(
    navController: NavHostController
){
    composable(
        route = Destinations.Login.route,
    ){
        val viewModel: LogInViewModel = hiltViewModel()

        if(viewModel.state.value.successLogIn){
            LaunchedEffect(key1 = Unit){
                navController.navigate(
                    Destinations.Home.route
                ){
                    popUpTo(Destinations.Login.route){
                        inclusive = true
                    }
                }
            }
        } else {
            LogIn(
                state = viewModel.state.value,
                onLogIn = viewModel::login,
                onNavigateToRegister = {
                    navController.navigate(Destinations.Signup.route)
                    {
                        popUpTo(Destinations.Login.route)
                    }
                },
                onDismissDialog = viewModel::hideErrorDialog
            )
        }
    }
}

@ExperimentalAnimationApi
fun NavGraphBuilder.addSignUp(
    navController: NavHostController
){
    composable(
        route = Destinations.Signup.route,
    ){
        val viewModel: SignUpViewModel = hiltViewModel()

        if(viewModel.state.value.successSignUp){
            LaunchedEffect(key1 = Unit){
                navController.navigate(
                    Destinations.Home.route
                ){
                    popUpTo(Destinations.Login.route){
                        inclusive = true
                    }
                }
            }
        } else {
            SignUp(
                state = viewModel.state.value,
                onSignUp = viewModel::signup,
                onLogIn = {
                    navController.navigate(Destinations.Login.route){
                        popUpTo(Destinations.Signup.route){
                            inclusive = true
                        }
                    }
                },
                onDismissDialog = viewModel::hideErrorDialog
            )
        }

    }
}

@ExperimentalAnimationApi
fun NavGraphBuilder.addHome(navControllerFather: NavHostController) {
    composable(
        route = Destinations.Home.route,
        arguments = Destinations.Home.arguments
    ){
        MainScreen(navControllerFather)
    }
}

@ExperimentalAnimationApi
fun NavGraphBuilder.addService() {
    composable(
        route = Destinations.Service.route,
        arguments = Destinations.Service.arguments
    ){
        Service()
    }
}

@ExperimentalAnimationApi
fun NavGraphBuilder.addReservation() {
    composable(
        route = Destinations.Reservation.route,
        arguments = Destinations.Reservation.arguments
    ){
        Reservation()
    }
}

@ExperimentalAnimationApi
fun NavGraphBuilder.addSettings(navControllerFather: NavHostController) {
    composable(
        route = Destinations.Settings.route,
        arguments = Destinations.Settings.arguments
    ){
        val loginViewModel: LogInViewModel = hiltViewModel()
        Settings{
            loginViewModel.clientDao.deleteClient(loginViewModel.client)
            navControllerFather.navigate(Destinations.Login.route){
                popUpTo(Destinations.Home.route){
                    inclusive = true
                }
            }
        }
    }
}