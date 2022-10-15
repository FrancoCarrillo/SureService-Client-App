package vitec.sureservice.ui.service

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import vitec.sureservice.data.model.Technician
import vitec.sureservice.data.remote.ApiClient

class ServiceViewModel: ViewModel() {

    private val technicianInterface = ApiClient.buildTechnician()

    private var _technicians = MutableLiveData<List<Technician>>()
    val technicians get() = _technicians

    private var _technician = MutableLiveData<Technician>()
    val technician get() = _technician

    fun getAllTechnicians() {
        viewModelScope.launch {
            try {
                val getAllTechnicians = technicianInterface?.getAllTechnicians()
                getAllTechnicians?.enqueue(object: Callback<List<Technician>> {
                    override fun onResponse(
                        call: Call<List<Technician>>,
                        response: Response<List<Technician>>
                    ) { technicians.postValue(response.body()!!) }

                    override fun onFailure(call: Call<List<Technician>>, t: Throwable) {
                        Log.d("Fail", t.toString())
                    }
                })
            }
            catch (e: Exception) {
                Log.e("Error retrieve technic.", e.toString())
            }
        }
    }

    fun getATechnicianById(id: Int) {
        viewModelScope.launch {
            try {
                val getATechnicianById = technicianInterface?.getTechnicianById(id)
                getATechnicianById?.enqueue(object: Callback<Technician> {
                    override fun onResponse(
                        call: Call<Technician>,
                        response: Response<Technician>
                    ) { technician.postValue(response.body()!!) }

                    override fun onFailure(call: Call<Technician>, t: Throwable) {
                        Log.d("Fail", t.toString())
                    }
                })

            }
            catch (e: Exception) {
                Log.e("Error get a technic.", e.toString())
            }
        }
    }

}