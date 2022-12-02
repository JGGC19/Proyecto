package mx.tecnm.cdhidalgo.proyecto.DataClass

import android.os.Parcel
import android.os.Parcelable
import mx.tecnm.cdhidalgo.giftstore.DataClass.Usuario

data class Denuncia(
    var delito:String?,
    var ubicacion:String?,
    var descripcion:String?): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(delito)
        parcel.writeString(ubicacion)
        parcel.writeString(descripcion)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Denuncia> {
        override fun createFromParcel(parcel: Parcel): Denuncia {
            return Denuncia(parcel)
        }

        override fun newArray(size: Int): Array<Denuncia?> {
            return arrayOfNulls(size)
        }
    }
}
