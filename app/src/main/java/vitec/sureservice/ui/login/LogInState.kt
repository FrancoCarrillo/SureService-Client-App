package vitec.sureservice.ui.login

import androidx.annotation.StringRes

data class LogInState(
    val username: String = "",
    val password: String = "",
    val successLogIn: Boolean = false,
    @StringRes val errorMessage: Int? = null
)
