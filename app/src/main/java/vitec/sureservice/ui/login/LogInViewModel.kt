package vitec.sureservice.ui.login

import android.app.Application
import kotlinx.coroutines.launch
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

    var clients = emptyList<Client>()

    var client = Client()

    init {
        getAllClients()
    }

    fun getAllClients() {
        clients = clientDao.getAllClients()

        if(clients.isNotEmpty()){
            state.value.successLogIn = true
            client.id = clients[0].id
            client.username = clients[0].username
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
            client.id = 1
            client.username = username
            insertClient(client)
            state.value = state.value.copy(successLogIn = true)
        }
    }

    fun hideErrorDialog() {
        state.value = state.value.copy(
            errorMessage = null
        )
    }


}