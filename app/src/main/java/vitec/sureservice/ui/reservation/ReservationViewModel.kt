package vitec.sureservice.ui.reservation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import vitec.sureservice.data.remote.ApiClient

class ReservationViewModel(application: Application): AndroidViewModel(application) {
    val reservationInterface = ApiClient.build()



}