package vitec.sureservice.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "client")
data class Client (

    @PrimaryKey
    var id: Long,

    @ColumnInfo
    var username: String
)