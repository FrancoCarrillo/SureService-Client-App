package vitec.sureservice.ui.reservation

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime

class ReservationDto (
    val date_of: LocalDateTime
) {
    @RequiresApi(Build.VERSION_CODES.O)
    constructor(): this(LocalDateTime.now())
}