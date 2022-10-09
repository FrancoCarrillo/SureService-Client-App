package vitec.sureservice.ui.login

import android.app.Application
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel
import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import vitec.sureservice.R
import vitec.sureservice.data.local.SureServiceDatabase
import vitec.sureservice.data.model.Client

class LogInViewModel(application: Application): AndroidViewModel(application) {

    val state: MutableState<LogInState> = mutableStateOf(LogInState())
    val clientDao = SureServiceDatabase.getInstance(application).clientDao()

    var client = emptyList<Client>()

    init {
        getAllClients()
    }

    fun getAllClients() {
        client = clientDao.getAllClients()

        if(client.isNotEmpty()){
            state.value.successLogIn = true
            state.value.username = client[0].username
            state.value.password = "password"
        }
    }

    fun insertClient(client: Client) {
        clientDao.insertClient(client)
    }

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