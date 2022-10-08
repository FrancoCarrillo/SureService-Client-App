package vitec.sureservice.ui.home

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun Home(
    username: String,
    password: String
) {
    Text(text = "Home")
    Text(text = "Username: $username, password: $password")
}