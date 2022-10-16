package vitec.sureservice.ui.bookAnAppointment

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import vitec.sureservice.data.model.ServiceRequest
import vitec.sureservice.data.remote.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import vitec.sureservice.data.local.SureServiceDatabase
import vitec.sureservice.data.model.Client

class ServiceRequestViewModel(application: Application): AndroidViewModel(application) {

    private val serviceRequestInterface = ApiClient.buildServiceRequest()
    val clientDao = SureServiceDatabase.getInstance(application).clientDao()

    private var _serviceRequest = MutableLiveData<ServiceRequest>()
    val serviceRequest get() = _serviceRequest

    private var serviceRequestDto: ServiceRequestDto = ServiceRequestDto()

    fun createServiceRequestDto(detail: String)
    {
        serviceRequestDto = ServiceRequestDto(detail, 0.0, 0.0, 0)
    }

    fun postServiceRequest(technicianId: Int) {
        viewModelScope.launch {
            try {
                val postServiceRequest = serviceRequestInterface.postServiceRequest(clientDao.getAllClients()[0].id.toInt(), technicianId, serviceRequestDto)
                postServiceRequest.enqueue(object: Callback<ServiceRequest>{
                    override fun onResponse(
                        call: Call<ServiceRequest>,
                        response: Response<ServiceRequest>
                    ) {
                        if (response.code() == 200){ serviceRequest.postValue(response.body()!!)
                        }

                        if (response.code() == 400) {
                            Log.println(Log.WARN, "Create Service Request", response.body()!!.toString())
                        }
                    }

                    override fun onFailure(call: Call<ServiceRequest>, t: Throwable) {
                        Log.d("Fail", t.toString())
                    }
                })
            }
            catch (e: Exception) {
                Log.e("Error", e.toString())
            }
        }
    }

}