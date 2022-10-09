package vitec.sureservice.ui.signup

import android.app.Application
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import vitec.sureservice.R
import vitec.sureservice.data.local.SureServiceDatabase
import vitec.sureservice.data.model.Client

class SignUpViewModel(application: Application): AndroidViewModel(application) {
    val state: MutableState<SignUpState> = mutableStateOf(SignUpState())
    val clientDao = SureServiceDatabase.getInstance(application).clientDao()


    fun insertClient(client: Client) {
        clientDao.insertClient(client)
    }


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
        val errorMessage = if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            R.string.error_not_a_valid_email
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

        viewModelScope.launch {
            val client = Client(2, username)
            insertClient(client)
            state.value = state.value.copy(successSignUp = true)
        }
    }

    fun hideErrorDialog() {
        state.value = state.value.copy(
            errorMessage = null
        )
    }
}