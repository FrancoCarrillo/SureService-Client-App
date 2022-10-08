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
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import vitec.sureservice.ui.home.Home
import vitec.sureservice.ui.login.LogIn
import vitec.sureservice.ui.login.LogInViewModel
import vitec.sureservice.ui.signup.SignUp
import vitec.sureservice.ui.signup.SignUpViewModel


@ExperimentalAnimationApi
@Composable
fun Navigation() {
    val navController = rememberAnimatedNavController()

    BoxWithConstraints {
        AnimatedNavHost(
            navController = navController,
            startDestination = Destinations.Login.route
        ){
            addLogin(navController)

            addSignUp(navController)

            addHome()
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
        val username = viewModel.state.value.username
        val password = viewModel.state.value.password

        if(viewModel.state.value.successLogIn){
            LaunchedEffect(key1 = Unit){
                navController.navigate(
                    Destinations.Home.route + "/$username" + "/$password"
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

        SignUp(
            state = viewModel.state.value,
            onSignUp = viewModel::signup,
            onLogIn = {
                navController.navigate(Destinations.Login.route)
            },
            onDismissDialog = viewModel::hideErrorDialog
        )
    }
}

@ExperimentalAnimationApi
fun NavGraphBuilder.addHome() {
    composable(
        route = Destinations.Home.route + "/{username}" + "/{password}",
        arguments = Destinations.Home.arguments
    ){ backStackEntry ->

        val username = backStackEntry.arguments?.getString("username") ?: ""
        val password = backStackEntry.arguments?.getString("password") ?: ""

        Home(username, password)
    }
}