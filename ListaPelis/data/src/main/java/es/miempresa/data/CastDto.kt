package es.miempresa.data

import com.google.gson.annotations.SerializedName

data class CastDto(
    @SerializedName("know_for_department") val role:String,
    @SerializedName("name") val name:String
) {
}