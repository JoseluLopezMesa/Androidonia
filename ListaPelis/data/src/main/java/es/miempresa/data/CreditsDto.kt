package es.miempresa.data

import com.google.gson.annotations.SerializedName

class CreditsDto(@SerializedName("cast") val cast:List<CastDto>) {
}