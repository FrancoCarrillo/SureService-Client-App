package vitec.sureservice.ui.settings

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import vitec.sureservice.data.local.SureServiceDatabase
import vitec.sureservice.data.model.Client
import vitec.sureservice.data.remote.ApiClient


class SettingViewModel(application: Application): AndroidViewModel(application) {
    val clientDao = SureServiceDatabase.getInstance(application).clientDao()
    val settingInterface = ApiClient.build()
    var client = Client()

    init {
        getAllClients()
    }

    fun getAllClients() {
        val _client = clientDao.getAllClients()[0]

        getClientById(_client.id)

    }

    fun getClientById(clientId: Long){
        viewModelScope.launch {
            try {
                val getClientById = settingInterface.getClientById(clientId)

                getClientById.enqueue(object : Callback<Client>{
                    override fun onResponse(call: Call<Client>, response: Response<Client>) {
                        if(response.code() == 200){
                            client = response.body()!!
                        }
                    }

                    override fun onFailure(call: Call<Client>, t: Throwable) {
                        TODO("Not yet implemented")
                    }

                })

            } catch(_: Exception){

            }
        }
    }
}