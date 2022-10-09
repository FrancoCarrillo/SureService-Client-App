package vitec.sureservice.ui.login

import androidx.annotation.StringRes

data class LogInState(
    var username: String = "",
    var password: String = "",
    var successLogIn: Boolean = false,
    @StringRes val errorMessage: Int? = null
)
