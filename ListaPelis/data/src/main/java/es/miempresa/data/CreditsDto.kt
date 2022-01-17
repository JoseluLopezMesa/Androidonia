package es.miempresa.data

import com.google.gson.annotations.SerializedName
import retrofit2.http.Query

class CreditsDto(@SerializedName("cast") val cast:List<CastDto>) {
}