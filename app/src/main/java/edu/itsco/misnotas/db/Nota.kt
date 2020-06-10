package edu.itsco.misnotas.db
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "tabla_notas")
data class Nota(@PrimaryKey(autoGenerate = true) var id:Int=0,
                @ColumnInfo(name="titulo")val titulo: String,
                @ColumnInfo(name="descripcion") val descripcion: String): Parcelable