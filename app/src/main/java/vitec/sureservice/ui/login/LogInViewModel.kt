package vitec.sureservice.ui.login

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel
import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import vitec.sureservice.R

class LogInViewModel: ViewModel() {

    val state: MutableState<LogInState> = mutableStateOf(LogInState())

    fun login(username: String, password: String) {

        val errorMessage = if(username != "marco" || password != "password"){
            R.string.error_invalid_credentials
        } else null

        errorMessage?.let {
            state.value = state.value.copy(errorMessage = it)
            return
        }

        viewModelScope.launch {
            state.value = state.value.copy(username = username, password = password)
            state.value = state.value.copy(successLogIn = true)
        }
    }

    fun hideErrorDialog() {
        state.value = state.value.copy(
            errorMessage = null
        )
    }

}