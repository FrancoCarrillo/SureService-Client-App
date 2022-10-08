package vitec.sureservice.ui.signup

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import vitec.sureservice.R

class SignUpViewModel: ViewModel() {
    val state: MutableState<SignUpState> = mutableStateOf(SignUpState())

    fun signup(
        email: String,
        password: String,
        username: String,
        name: String,
        lastName: String,
        telephoneNumber: String,
        dni: String,
        confirmPassword: String
    ) {
        val errorMessage = if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){ R.string.error_not_a_valid_email
        } else if(!Patterns.PHONE.matcher(telephoneNumber).matches()) {
            R.string.error_not_a_valid_phone_number
        } else if(password != confirmPassword) {
            R.string.error_incorrectly_repeated_password
        } else if(dni.length != 8){
            R.string.error_incorrectly_dni
        } else null

        errorMessage?.let {
            state.value = state.value.copy(errorMessage = errorMessage)
            return
        }
    }

    fun hideErrorDialog() {
        state.value = state.value.copy(
            errorMessage = null
        )
    }
}